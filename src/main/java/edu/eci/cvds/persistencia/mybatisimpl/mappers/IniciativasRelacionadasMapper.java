package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

public interface IniciativasRelacionadasMapper {

	/**
	 * Metodo que inserta la relacion de las inciativas que se relacionan
	 * @param numIniciativa1 iniciativa 1
	 * @param numIniciativa2 inciativa 2
	 * @param descripcion Texto que indica el motivo de la relacion
	 */
	public void insertarIniciativaRelacionada(@Param("numIniciativa1") int numIniciativa1,
											  @Param("numIniciativa2") int numIniciativa2,
											  @Param("descripcion") String descripcion);
}
