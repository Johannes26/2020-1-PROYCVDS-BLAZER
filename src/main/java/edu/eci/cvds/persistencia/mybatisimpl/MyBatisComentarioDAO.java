package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.persistencia.ComentarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.ComentarioMapper;


public class MyBatisComentarioDAO implements ComentarioDAO{
	
	@Inject
    private ComentarioMapper comentarioMapper;

	@Override
	public void agregarComentario(String descripcion, Iniciativa i, Usuario u) throws PersistenciaException {
		try {
			comentarioMapper.agregarComentario(descripcion,i,u);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al agregar comentario");
		}
	}
	
	@Override
	public List<Comentario> consultarComentarios() throws PersistenciaException {
		try {
			return comentarioMapper.consultarComentarios();
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al consultar todos los comentarios");
		}
		
	}

	@Override
	public List<Comentario> consultarComentariosXIniciativa(int idini) throws PersistenciaException {
		try {
			return comentarioMapper.consultarComentariosXIniciativa(idini);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al consultar comentarios por iniciativa");
		}
	}
	
}

