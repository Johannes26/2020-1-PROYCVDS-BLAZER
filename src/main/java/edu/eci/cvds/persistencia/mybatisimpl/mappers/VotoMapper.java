package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Voto;

public interface VotoMapper {

	public void insertarVoto(@Param("voto")Voto voto);
	
	public List<Voto> consultarVotos();
	
	public void quitarVoto(@Param("voto")Voto voto);
	
	public int contarVotosIniciativa(@Param("num_iniciativa")int num_iniciativa);
	
	public int tieneVotos(@Param("num_iniciativa")int num_iniciativa,@Param("id_usuario")int id_usuario);
}
