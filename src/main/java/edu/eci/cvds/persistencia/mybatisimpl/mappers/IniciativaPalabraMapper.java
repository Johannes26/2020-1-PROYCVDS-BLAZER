package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface IniciativaPalabraMapper {
	/**
	 * Metodo que inserta la relacion de la palabras clave de la inciativa
	 * @param id_iniciativa identificacion de la inciativa
	 * @param id_palabra identificaion de la palabra
	 */
	public void insertarIniciativaPalabra(@Param("iniciativa") int id_iniciativa,
										@Param("palabra")int id_palabra);
}
