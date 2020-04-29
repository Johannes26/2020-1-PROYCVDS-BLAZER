package edu.eci.cvds.servicios.impl;






import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbc.JdbcSQLException;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.PalabrasClave;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.VotoDAO;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.IniciativasRelacionadasDAO;
import edu.eci.cvds.persistencia.PalabrasClaveDao;
import edu.eci.cvds.persistencia.PersistenciaException;


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
	@Inject
	private VotoDAO votoDAO;
	@Inject
	private IniciativasRelacionadasDAO iniciativasRelacionadasDAO;

	@Override
    public Usuario consultarUsuario(String email) throws ServiciosException {
        try {
        	Usuario u = usuarioDAO.consultarUsuario(email);
        	if(u!=null) {
        		return usuarioDAO.consultarUsuario(email);
        	}else {
        		throw new ServiciosException("El usuario no existe");
        	}
        } catch (PersistenciaException e){
            throw new ServiciosException("Error en usuario");
        }
    }

	/*@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}*/
	
	@Override
	public Boolean validarUsuario(String email, String contrasena) throws ServiciosException {
		Usuario usuario = consultarUsuario(email);
		return usuario.getContrasena().equals(contrasena);
		
	}

	@Override
	public Iniciativa consultarIniciativa(int num) throws ServiciosException {
		try {
            return iniciativaDAO.consultarIniciativa(num);
        } catch (PersistenciaException e){
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
            
        } catch (PersistenciaException e){
            throw new ServiciosException("La iniciativa no existe");
        }
	}
	
	
	@Override
	public List<Usuario> consultarUsuarios() throws ServiciosException {
		try {
            return usuarioDAO.consultarUsuarios();
        } catch (PersistenciaException e){
            throw new ServiciosException("Error al consultar usuarios");
        }
	}

	@Override
	public List<Iniciativa> consultarIniciativas() throws ServiciosException {
		try {
            return iniciativaDAO.consultarIniciativas();
        } catch (PersistenciaException e){
            throw new ServiciosException("Error al consultar iniciativas");
        }
	}
	
	@Override
	public void cambiarRol(int id, String rol) throws ServiciosException {
		try {
            usuarioDAO.cambiarRol(id, rol);
        } catch (PersistenciaException e){
            throw new ServiciosException("Error al cambiar el rol de usuario");
        }
	}
	
	@Override
	public void cambiarEstadoIniciativa(int num, String estado) throws ServiciosException {
		try {
			iniciativaDAO.cambiarEstadoIniciativa(num, estado);
        } catch (PersistenciaException e){
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
        } catch (PersistenciaException e){
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
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al consultar palabra clave");
		}
	}
	
	@Override
	public PalabrasClave consultarPalabraClave(String descripcion) throws ServiciosException{
		try {
			return palabrasClaveDao.consultarPalabraClave(descripcion);
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al consultar palabras");
		}
	
	}
	
	@Override
	public List<PalabrasClave> consultarPalabrasClave() throws ServiciosException{
		try {
			return palabrasClaveDao.consultarPalabrasClave();
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al consultar palabras");
		}
	
	}
	
	@Override
	public void insertarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException{
		try {
			Usuario usuario = usuarioDAO.consultarUsuarioXId(id_Usuario);
			Iniciativa iniciativa = iniciativaDAO.consultarIniciativa(num_Iniciativa);
			if(usuario!=null && iniciativa!=null) {
				Voto voto;
				voto = new Voto(id_Usuario,num_Iniciativa);
				votoDAO.insertarVoto(voto);
			}
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al insertar Voto");
		}
	}

	@Override
	public void quitarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException {
		try {
			Usuario usuario = usuarioDAO.consultarUsuarioXId(id_Usuario);
			Iniciativa iniciativa = iniciativaDAO.consultarIniciativa(num_Iniciativa);
			if(usuario!=null && iniciativa!=null) {
				Voto voto;
				voto = new Voto(id_Usuario,num_Iniciativa);
				votoDAO.quitarVoto(voto);
			}
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al eliminar Voto");
		}
		
	}
	
	public int contarVotos(int num_Iniciativa) throws ServiciosException{
		try {
			Iniciativa iniciativa = iniciativaDAO.consultarIniciativa(num_Iniciativa);
			if(iniciativa!=null) {
				return votoDAO.contarVotosIniciativa(num_Iniciativa);
			}else {
				throw new ServiciosException("Iniciativa no existe");
			}
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al contar votos");
		}
	}

	@Override
	public void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,
			String descripcion) throws ServiciosException {
		try {
			iniciativasRelacionadasDAO.insertarIniciativaRelacionada(numIniciativa1, numIniciativa2, descripcion);
		}catch(PersistenciaException e) {
            throw new ServiciosException("Error al insertar las iniciativas relacionadas");
		}
	}
	
	
}
