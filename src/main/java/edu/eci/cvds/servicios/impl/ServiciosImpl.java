package edu.eci.cvds.servicios.impl;



import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.PalabrasClave;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.PalabrasClaveDao;
import edu.eci.cvds.persistencia.PersistenceException;


@Singleton
public class ServiciosImpl implements Servicios {

	@Inject
    private UsuarioDAO usuarioDAO;
	@Inject
	private DaoIniciativa iniciativaDAO;
	@Inject
	private PalabrasClaveDao palabrasClaveDao;
	@Inject
	private IniciativaPalabraDAO iniciativaPalabraDao;

	@Override
    public Usuario consultarUsuario(String email) throws ServiciosException {
        try {
        	Usuario u = usuarioDAO.consultarUsuario(email);
        	if(u!=null) {
        		return usuarioDAO.consultarUsuario(email);
        	}else {
        		throw new ServiciosException("El usuario no existe");
        	}
        } catch (PersistenceException e){
            throw new ServiciosException("Error en usuario");
        }
    }

	/*@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}*/
	
	@Override
	public Boolean validarUsuario(String email, String contrasena) throws ServiciosException {
		boolean esvalido;
		try {
			Usuario usuario = consultarUsuario(email);
			esvalido = usuario.getContrasena().equals(contrasena);
		}catch(ServiciosException e) {
			esvalido=false;
		}
		return esvalido;
	}

	@Override
	public Iniciativa consultarIniciativa(int num) throws ServiciosException {
		try {
            return iniciativaDAO.consultarIniciativa(num);
        } catch (PersistenceException e){
            throw new ServiciosException("La iniciativa no existe");
        }
	}

	@Override
	public void registrarIniciativa(Iniciativa i, String palabrasclave) throws ServiciosException {
		try {
			String p[]=palabrasclave.split(",");	
			List<PalabrasClave> palabras= new ArrayList<PalabrasClave>();			
			for(String s: p) {
				palabras.add(new PalabrasClave(s));
			}
            iniciativaDAO.registrarIniciativa(i);
            registrarPalabras(palabras);
            List<Iniciativa> a=iniciativaDAO.consultarIniciativas();
            int idIniciativa=a.get(a.size()-1).getNum();
            
            for(PalabrasClave pa: palabras) {
            	int idPalabra=palabrasClaveDao.consultarPalabraClave(pa.getDescripcion()).getId();
            	iniciativaPalabraDao.insertarIniciativaPalabra(idIniciativa, idPalabra);
            }
            
        } catch (PersistenceException e){
            throw new ServiciosException("La iniciativa no existe");
        }
	}
	
	
	@Override
	public List<Usuario> consultarUsuarios() throws ServiciosException {
		try {
            return usuarioDAO.consultarUsuarios();
        } catch (PersistenceException e){
            throw new ServiciosException("Error al consultar usuarios");
        }
	}

	@Override
	public List<Iniciativa> consultarIniciativas() throws ServiciosException {
		try {
            return iniciativaDAO.consultarIniciativas();
        } catch (PersistenceException e){
            throw new ServiciosException("Error al consultar iniciativas");
        }
	}
	
	@Override
	public void cambiarRol(int id, String rol) throws ServiciosException {
		try {
            usuarioDAO.cambiarRol(id, rol);
        } catch (PersistenceException e){
            throw new ServiciosException("Error al cambiar el rol de usuario");
        }
	}
	
	@Override
	public void cambiarEstadoIniciativa(int num, String estado) throws ServiciosException {
		try {
			iniciativaDAO.cambiarEstadoIniciativa(num, estado);
        } catch (PersistenceException e){
            throw new ServiciosException("Error al cambiar el estado de la iniciativa");
        }
	}
	
	@Override
	public List<Iniciativa> consultarIniciativaXPalabraClave(String palabras) throws ServiciosException {
		try {
			String p[]=palabras.split(",");	
			List<PalabrasClave> palabrasClave= new ArrayList<PalabrasClave>();			
			for(String s: p) {
				palabrasClave.add(new PalabrasClave(s));
			}
			
			List<Iniciativa> iniciativasBuscadas=new ArrayList<Iniciativa>();
			List<Integer> numeroIniciativas=new ArrayList<Integer>();
			for(PalabrasClave s: palabrasClave) {
				List<Iniciativa> iniciativas=iniciativaDAO.consultarIniciativaXPalabraClave(s.getDescripcion());
				for(Iniciativa i: iniciativas) {
					if(!numeroIniciativas.contains(i.getNum())) {
						iniciativasBuscadas.add(i);
						numeroIniciativas.add(i.getNum());
					}
				}
			}
            return iniciativasBuscadas;
        } catch (PersistenceException e){
            throw new ServiciosException("Error al consultar iniciativa por palabra clave");
        }
	}
	
	@Override
	public void registrarPalabras(List<PalabrasClave> palabras) throws ServiciosException{
		try {
			for(PalabrasClave p: palabras) {
				PalabrasClave a=consultarPalabraClave(p.getDescripcion());
				if(a==null) {
					palabrasClaveDao.insertarPalabraClave(p.getDescripcion());
				}
			}
		}catch(PersistenceException e) {
            throw new ServiciosException("Error al consultar palabra clave");
		}
	}
	
	@Override
	public PalabrasClave consultarPalabraClave(String descripcion) throws ServiciosException{
		try {
			return palabrasClaveDao.consultarPalabraClave(descripcion);
		}catch(PersistenceException e) {
            throw new ServiciosException("Error al consultar palabras");
		}
	
	}
	
	@Override
	public List<PalabrasClave> consultarPalabrasClave() throws ServiciosException{
		try {
			return palabrasClaveDao.consultarPalabrasClave();
		}catch(PersistenceException e) {
            throw new ServiciosException("Error al consultar palabras");
		}
	
	}
	
}
