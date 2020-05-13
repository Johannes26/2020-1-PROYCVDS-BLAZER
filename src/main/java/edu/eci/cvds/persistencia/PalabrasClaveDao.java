package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.PalabrasClave;

public interface PalabrasClaveDao {
	/**
	 * Metodo que consulta todas la palabras claves
	 * @return Lista de palabras clave
	 */
	public List<PalabrasClave> consultarPalabrasClave()throws PersistenciaException;
	/**
	 * Metodo que consulta una palabra clave dado su descripcion
	 * @param descripcion Texto que indica la descripcion de la palabra
	 * @return palabra clave
	 */
	public PalabrasClave consultarPalabraClave(String descripcion) throws PersistenciaException;
	/**
	 * Metodo que inserta la palabra clave
	 * @param descripcion Texto que indica la descripcion de la palabra
	 */
	public void insertarPalabraClave(String descripcion) throws PersistenciaException;
}
