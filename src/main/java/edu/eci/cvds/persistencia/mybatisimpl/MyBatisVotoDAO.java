package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;



import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.persistencia.VotoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.VotoMapper;


public class MyBatisVotoDAO implements VotoDAO{
	
	@Inject
    private VotoMapper votoMapper;

	@Override
	public void insertarVoto(Voto voto) throws PersistenciaException {
		try {
			votoMapper.insertarVoto(voto);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al registrar un voto");
		}
	}

	@Override
	public void quitarVoto(Voto voto) throws PersistenciaException {
		try {
			votoMapper.quitarVoto(voto);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al eliminar un voto");
		}	
	}

	@Override
	public int contarVotosIniciativa(int num_iniciativa) throws PersistenciaException {
		try {
			return votoMapper.contarVotosIniciativa(num_iniciativa);
		}catch (PersistenceException e){
			throw new PersistenciaException("Error al contar votos");
		}
	}
	
	
}
