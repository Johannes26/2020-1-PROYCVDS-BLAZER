package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.PalabrasClave;

public interface PalabrasClaveDao {
	
	public List<PalabrasClave> consultarPalabrasClave()throws PersistenciaException;
	
	public PalabrasClave consultarPalabraClave(String descripcion) throws PersistenciaException;
	
	public void insertarPalabraClave(String descripcion) throws PersistenciaException;
}
