package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

public interface ComentarioDAO {
	
	public List<Comentario> consultarComentarios() throws PersistenciaException;

	public void agregarComentario(String descripcion, Iniciativa i, Usuario u) throws PersistenciaException;

}