package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.Usuario;



public interface UsuarioDAO {
	
	
	/**
	 * Valida si la contrase�a y el usuario coinciden
	 * @param email email de un ususario
	 * @param contrasena contrase�a del ususario
	 * @return boleeano que indica si el usuario esta registrado
	 */
    public Usuario consultarUsuario(String email) throws PersistenceException;
    
    public List<Usuario> consultarUsuarios() throws PersistenceException;
}	