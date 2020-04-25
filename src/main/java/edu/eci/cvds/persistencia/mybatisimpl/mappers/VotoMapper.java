package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.h2.jdbc.JdbcSQLException;

import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.persistencia.PersistenciaException;

public interface VotoMapper {

	public void insertarVoto(@Param("voto")Voto voto);
	
	public void quitarVoto(@Param("voto")Voto voto);
	
	public int contarVotosIniciativa(@Param("num_iniciativa")int num_iniciativa);
}
