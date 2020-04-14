package edu.eci.cvds.servicios;

import edu.eci.cvds.entidades.Usuario;

public interface IniciativaServicios {

	//public abstract void createUser(Usuario user) throws ServiciosException;
	
	public abstract  Usuario consultarUsuario(String email) throws ServiciosException;
	
	public Boolean validarUsuario(String email, String contrasena) throws ServiciosException;
	
}