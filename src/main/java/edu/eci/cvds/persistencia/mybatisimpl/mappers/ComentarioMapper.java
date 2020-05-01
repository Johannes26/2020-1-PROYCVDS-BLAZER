package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

public interface ComentarioMapper {
	
	public List<Comentario> consultarComentarios();

	public void agregarComentario(@Param("descripcion")String descripcion, @Param("iniciativa") Iniciativa i, @Param("usuario") Usuario u);
}
