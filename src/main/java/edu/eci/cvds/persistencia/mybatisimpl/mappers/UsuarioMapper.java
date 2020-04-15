package edu.eci.cvds.persistencia.mybatisimpl.mappers;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Usuario;

public interface UsuarioMapper {
	
    public Usuario consultarUsuario(@Param("email") String correo);
    
    public List<Usuario> consultarUsuarios();
    
    public void cambiarRol(@Param("id") int id,@Param("rol") String rol);
}
