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
			comentarioMapper. agregarComentario(descripcion,i,u);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al registrar un voto");
		}
	}
	
	@Override
	public List<Comentario> consultarComentarios() {
		return comentarioMapper.consultarComentarios();
	}
	
}

