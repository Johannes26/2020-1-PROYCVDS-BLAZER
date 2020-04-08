package edu.eci.cvds.servicios;

import edu.eci.cvds.entidades.Usuario;

public interface IniciativaServicios {

	public void createUser(Usuario user) throws ServiciosException;
	
	public Usuario consultarUsuario(int id) throws ServiciosException;

	
}