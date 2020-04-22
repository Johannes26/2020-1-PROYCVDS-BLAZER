package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.PalabrasClave;

public interface PalabrasClaveDao {
	
	public List<PalabrasClave> consultarPalabrasClave()throws PersistenceException;
	
	public PalabrasClave consultarPalabraClave(String descripcion) throws PersistenceException;
	
	public void insertarPalabraClave(String descripcion) throws PersistenceException;
}
