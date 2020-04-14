package edu.eci.cvds.persistencia;

import edu.eci.cvds.entidades.Usuario;



public interface UsuarioDAO {
	
	
	/**
	 * Valida si la contraseņa y el usuario coinciden
	 * @param email email de un ususario
	 * @param contrasena contraseņa del ususario
	 * @return boleeano que indica si el usuario esta registrado
	 */
    public Usuario consultarUsuario(String email) throws PersistenceException;
    
}	