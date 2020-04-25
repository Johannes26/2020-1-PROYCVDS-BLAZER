package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaPalabraMapper;

import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisIniciativaPalabraDAO implements IniciativaPalabraDAO {
	@Inject
    private IniciativaPalabraMapper iniciativaPalabraMapper;
	
	public void insertarIniciativaPalabra(int idIniciativa,int idPalabra) throws PersistenciaException{
		try {
			iniciativaPalabraMapper.insertarIniciativaPalabra(idIniciativa, idPalabra);
		}catch(PersistenceException e) {

            throw new PersistenciaException("Error al insertar relacion");
		}
	};

}
