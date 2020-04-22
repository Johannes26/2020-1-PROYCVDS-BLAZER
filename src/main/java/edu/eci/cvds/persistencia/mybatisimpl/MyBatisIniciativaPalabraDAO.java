package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaPalabraMapper;

import javax.persistence.PersistenceException;

public class MyBatisIniciativaPalabraDAO implements IniciativaPalabraDAO {
	@Inject
    private IniciativaPalabraMapper iniciativaPalabraMapper;
	
	public void insertarIniciativaPalabra(int idIniciativa,int idPalabra) throws PersistenceException{
		try {
			iniciativaPalabraMapper.insertarIniciativaPalabra(idIniciativa, idPalabra);
		}catch(PersistenceException e) {

            throw new PersistenceException("Error al insertar relacion");
		}
	};

}
