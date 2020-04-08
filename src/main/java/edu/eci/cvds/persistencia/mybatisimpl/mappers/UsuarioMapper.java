package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Usuario;

public interface UsuarioMapper {
	public Usuario consultarUsuario(@Param("usuario") int id);
}
