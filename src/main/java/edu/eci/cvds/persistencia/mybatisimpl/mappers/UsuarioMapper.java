package edu.eci.cvds.persistencia.mybatisimpl.mappers;



import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Usuario;

public interface UsuarioMapper {
	public Usuario consultarUsuario(@Param("id") int id);
}
