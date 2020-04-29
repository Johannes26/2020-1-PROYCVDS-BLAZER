package edu.eci.cvds.persistencia;

import java.sql.Date;

public interface IniciativasRelacionadasDAO {

	public abstract void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,String descripcion) throws PersistenciaException;
}
