package edu.eci.cvds.persistencia.mybatisimpl;

import java.sql.Date;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.IniciativasRelacionadasDAO;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativasRelacionadasMapper;

public class MyBatisIniciativasRelacionadasDAO implements IniciativasRelacionadasDAO{
	@Inject
    private IniciativasRelacionadasMapper IniciativasRelacionadasMapper;
	
	
	@Override
	public void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,
			String descripcion) throws PersistenciaException {
		try {
			IniciativasRelacionadasMapper.insertarIniciativaRelacionada(numIniciativa1, numIniciativa2, descripcion);
		}catch(PersistenceException e) {
            throw new PersistenciaException("Error al insertar las iniciativas relacionadas");
		}
	}

	
}
