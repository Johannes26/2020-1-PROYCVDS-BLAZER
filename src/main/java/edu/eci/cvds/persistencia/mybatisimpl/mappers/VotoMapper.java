package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.persistencia.PersistenciaException;

public interface VotoMapper {
	/**
	 * Metodo que inserta un voto
	 * @param u	informacion del voto
	 * @throws PersistenciaException
	 */
	public void insertarVoto(@Param("voto")Voto voto);
	/**
	 * Metodo que consulta ols votos
	 * @return lista de votos
	 * @throws PersistenciaException
	 */
	public List<Voto> consultarVotos();
	/**
	 * Metodo que quita un voto
	 * @param u informacion del voto
	 * @throws PersistenciaException
	 */
	public void quitarVoto(@Param("voto")Voto voto);
	/**
	 * Metodo que consulta la cantidad de votos por iniciativa
	 * @param num_iniciativa iniciativa a consultar
	 * @return numero de votos
	 * @throws PersistenciaException
	 */
	public int contarVotosIniciativa(@Param("num_iniciativa")int num_iniciativa);
	/**
	 * Metodo returna la cantidad de votos de un usuario en una iniciativa
	 * @param num_iniciativa identificacion de la iniciativa
	 * @param id_usuario identificacion del usuario
	 * @return cantidad de votos del usuario hacia una iniciativa
	 * @throws PersistenciaException
	 */
	public int tieneVotos(@Param("num_iniciativa")int num_iniciativa,@Param("id_usuario")int id_usuario);
}
