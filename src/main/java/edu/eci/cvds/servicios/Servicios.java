package edu.eci.cvds.servicios;

import edu.eci.cvds.entidades.Usuario;

import java.util.List;

import edu.eci.cvds.entidades.Iniciativa;

public interface Servicios {

	//public abstract void createUser(Usuario user) throws ServiciosException;
	
	public abstract  Usuario consultarUsuario(String email) throws ServiciosException;
	
	public abstract Iniciativa consultarIniciativa(int num) throws ServiciosException;
	
	public abstract void registrarInisiativa(Iniciativa i) throws ServiciosException;
	
	public abstract Boolean validarUsuario(String email, String contrasena) throws ServiciosException;
	
	public abstract List<Usuario> consultarUsuarios() throws ServiciosException;
	
	public abstract List<Iniciativa> consultarIniciativas() throws ServiciosException;
	
	public abstract void cambiarRol(int id, String rol) throws ServiciosException;
	
}