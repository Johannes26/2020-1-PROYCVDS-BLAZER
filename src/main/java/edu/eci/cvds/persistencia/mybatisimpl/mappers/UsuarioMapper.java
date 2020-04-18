package edu.eci.cvds.persistencia.mybatisimpl.mappers;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Usuario;

public interface UsuarioMapper {
	
	/**
	 * metodo que permite consultar el usuario en la base de datos
	 * @param correo correo de un Usuario
	 * @return Usuario de acuerdo al correo
	 */
    public Usuario consultarUsuario(@Param("email") String correo);
    /**
     * metodo que consulta todos los usuarios en la base de datos
     * @return lista de usuarios
     */
    public List<Usuario> consultarUsuarios();
    /**
     * metodo que permite cambiar el rol de un usuario
     * @param id id del usuario
     * @param rol texto del rol nuevo que se le quiere poner
     */
    public void cambiarRol(@Param("id") int id,@Param("rol") String rol);
}
