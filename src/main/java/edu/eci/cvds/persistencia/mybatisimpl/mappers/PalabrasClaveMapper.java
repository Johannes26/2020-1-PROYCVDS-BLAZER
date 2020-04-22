package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.PalabrasClave;

public interface PalabrasClaveMapper {

	public List<PalabrasClave> consultarPalabrasClave();

	public PalabrasClave consultarPalabraClave(@Param("descripcion") String descripcion);
	
	public void insertarPalabraClave(@Param("descripcion") String descripcion);
}

