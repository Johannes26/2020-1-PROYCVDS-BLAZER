package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

public interface ComentarioMapper {
	/**
	 * Consulta todos lo comentarios registrados
	 * @return lista de comentarios
	 **/
	public List<Comentario> consultarComentarios();
	
	/**
	 * Agrega un comentario
	 * @param descripcion descriocion del comentario
	 * @param i iniciativa a la que se le hace el comentario
	 * @param u usuario que hace el comentario
	 **/
	public void agregarComentario(@Param("descripcion")String descripcion, @Param("iniciativa") Iniciativa i, @Param("usuario") Usuario u);
	/**
	 * metodo que consulta los comentarios por una iniciativa
	 * @param idini identificador de la inicativa
	 * @return
	 */
	public List<Comentario> consultarComentariosXIniciativa(@Param("idini") int idini);
}
