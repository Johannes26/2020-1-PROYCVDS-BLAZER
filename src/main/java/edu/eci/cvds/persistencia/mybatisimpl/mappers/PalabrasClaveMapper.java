package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.PalabrasClave;

public interface PalabrasClaveMapper {
	
	/**
	 * Metodo que consulta todas la palabras claves
	 * @return Lista de palabras clave
	 */
	public List<PalabrasClave> consultarPalabrasClave();
	/**
	 * Metodo que consulta una palabra clave dado su descripcion
	 * @param descripcion Texto que indica la descripcion de la palabra
	 * @return palabra clave
	 */
	public PalabrasClave consultarPalabraClave(@Param("descripcion") String descripcion);
	
	/**
	 * Metodo que inserta la palabra clave
	 * @param descripcion Texto que indica la descripcion de la palabra
	 */
	public void insertarPalabraClave(@Param("descripcion") String descripcion);
}

