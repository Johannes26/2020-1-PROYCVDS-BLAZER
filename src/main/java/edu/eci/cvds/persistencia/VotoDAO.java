package edu.eci.cvds.persistencia;


import java.util.List;

import edu.eci.cvds.entidades.Voto;

public interface VotoDAO {
	/**
	 * Metodo que inserta un voto
	 * @param u informacion del voto
	 * @throws PersistenciaException
	 */
	public void insertarVoto(Voto u) throws PersistenciaException;
	/**
	 * Metodo que quita un voto
	 * @param u informacion del voto
	 * @throws PersistenciaException
	 */
	public void quitarVoto(Voto u) throws PersistenciaException;
	/**
	 * Metodo que consulta la cantidad de votos por iniciativa
	 * @param num_iniciativa iniciativa a consultar
	 * @return numero de votos
	 * @throws PersistenciaException
	 */
	public int contarVotosIniciativa(int num_iniciativa) throws PersistenciaException;
	/**
	 * Metodo returna la cantidad de votos de un usuario en una iniciativa
	 * @param num_iniciativa identificacion de la iniciativa
	 * @param id_usuario identificacion del usuario
	 * @return cantidad de votos del usuario hacia una iniciativa
	 * @throws PersistenciaException
	 */
	public int tieneVotos(int num_iniciativa,int id_usuario) throws PersistenciaException;
	/**
	 * Metodo que consulta ols votos
	 * @return lista de votos
	 * @throws PersistenciaException
	 */
	public List<Voto> consultarVotos() throws PersistenciaException;

}
