package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

public interface IniciativasRelacionadasMapper {

	public void insertarIniciativaRelacionada(@Param("numIniciativa1") int numIniciativa1,
											  @Param("numIniciativa2") int numIniciativa2,
											  @Param("descripcion") String descripcion);
}
