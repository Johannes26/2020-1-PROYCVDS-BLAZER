package edu.eci.cvds.persistencia;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Usuario;



public interface UsuarioDAO {
	
	
	/**
	 * Valida si la contrase�a y el usuario coinciden
	 * @param email email de un ususario
	 * @param contrasena contrase�a del ususario
	 * @return boleeano que indica si el usuario esta registrado
	 */
    public Usuario consultarUsuario(String email) throws PersistenciaException;
    /**
     * metodo que consulta todos los usuarios en la base de datos
     * @return lista de usuarios
     */
    public List<Usuario> consultarUsuarios() throws PersistenciaException;
    /**
     * metodo que permite cambiar el rol de un usuario
     * @param id id del usuario
     * @param rol texto del rol nuevo que se le quiere poner
     */
    public void cambiarRol(int id, String rol) throws PersistenciaException;
    
    public Usuario consultarUsuarioXId(int id) throws PersistenciaException;
    
    
    public void registrarUsuario(int id, String nombre,String apellido,String email,int telefono,String tipoUsuario,String contrasena) throws PersistenciaException;
    
    
}	