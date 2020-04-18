package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Iniciativa;



public interface IniciativaMapper {

	public Iniciativa consultarIniciativa(@Param("num") int identificador);
	
	public List<Iniciativa> consultarIniciativas();
	
	public void registrarIniciativa(@Param("iniciativa") Iniciativa texto);
	
	public void cambiarEstadoIniciativa(@Param("num") int identificador, @Param("estado") String estado);
	
	public List<Iniciativa> consultarIniciativaXPalabraClave(@Param("PalabrasClave") String palabra);

}
