package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

public interface ComentarioDAO {
	/**
	 * Consulta todos lo comentarios registrados
	 * @return lista de comentarios
	 **/
	public List<Comentario> consultarComentarios() throws PersistenciaException;
	/**
	 * Agrega un comentario
	 * @param descripcion descriocion del comentario
	 * @param i iniciativa a la que se le hace el comentario
	 * @param u usuario que hace el comentario
	 **/
	public void agregarComentario(String descripcion, Iniciativa i, Usuario u) throws PersistenciaException;
	
	/**
	 * metodo que consulta los comentarios por una iniciativa
	 * @param idini identificador de la inicativa
	 * @return
	 */
	public List<Comentario> consultarComentariosXIniciativa(int idini) throws PersistenciaException;
}