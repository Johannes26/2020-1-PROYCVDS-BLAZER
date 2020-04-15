package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Iniciativa;


public interface IniciativaMapper {

	public Iniciativa consultarIniciativa(@Param("num") int identificador);
	
	public void registrarIniciativa(@Param("iniciativa") Iniciativa texto);

}
