package edu.eci.persistence.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.entities.Usuario;

public interface UsuarioMapper {
	public Usuario consultarUsuario(@Param("usuario") int id);
}
