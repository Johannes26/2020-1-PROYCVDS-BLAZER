package edu.eci.cvds.servicios.impl;


import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.PersistenceException;


@Singleton
public class IniciativaServiciosImpl implements IniciativaServicios {

	@Inject
    private UsuarioDAO usuarioDAO;

    public Usuario consultarUsuario(String email) throws ServiciosException {
        try {
            return usuarioDAO.consultarUsuario(email);
        } catch (PersistenceException e){
            throw new ServiciosException("El usuario no existe");
        }
    }

	@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}
}
