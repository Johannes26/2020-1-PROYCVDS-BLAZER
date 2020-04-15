package edu.eci.cvds.servicios.impl;



import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.PersistenceException;


@Singleton
public class IniciativaServiciosImpl implements IniciativaServicios {

	@Inject
    private UsuarioDAO usuarioDAO;
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
		Usuario usuario = consultarUsuario(email);
		 return usuario!=null && usuario.getContrasena().equals(contrasena);
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
	public void registrarInisiativa(Iniciativa i) throws ServiciosException {
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
}
