package edu.eci.cvds.persistencia;

import java.sql.Date;

public interface IniciativasRelacionadasDAO {

	/**
	 * Metodo que inserta la relacion de las inciativas que se relacionan
	 * @param numIniciativa1 iniciativa 1
	 * @param numIniciativa2 inciativa 2
	 * @param descripcion Texto que indica el motivo de la relacion
	 */
	public abstract void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,String descripcion) throws PersistenciaException;
}
