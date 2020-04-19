package edu.eci.cvds.servicios.impl;



import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.PersistenceException;


@Singleton
public class ServiciosImpl implements Servicios {

	@Inject
    private UsuarioDAO usuarioDAO;
	@Inject
	private DaoIniciativa iniciativaDAO;

	@Override
    public Usuario consultarUsuario(String email) throws ServiciosException {
        try {
            return usuarioDAO.consultarUsuario(email);
        } catch (PersistenceException e){
            throw new ServiciosException("El usuario no existe");
        }
    }

	/*@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}*/
	
	@Override
	public Boolean validarUsuario(String email, String contrasena) throws ServiciosException {
		boolean esvalido=false;
		Usuario usuario = consultarUsuario(email);
		if(usuario!=null) {
			esvalido = usuario.getContrasena().equals(contrasena);
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
	public void registrarIniciativa(Iniciativa i) throws ServiciosException {
		try {
            iniciativaDAO.registrarIniciativa(i);
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
	public List<Iniciativa> consultarIniciativaXPalabraClave(String PalabrasClave) throws ServiciosException {
		try {
            return iniciativaDAO.consultarIniciativaXPalabraClave(PalabrasClave);
        } catch (PersistenceException e){
            throw new ServiciosException("Error al consultar iniciativa por palabra clave");
        }
	}
}
