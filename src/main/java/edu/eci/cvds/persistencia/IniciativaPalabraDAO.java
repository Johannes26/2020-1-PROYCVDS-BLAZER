package edu.eci.cvds.persistencia;

public interface IniciativaPalabraDAO {
	
	
	/**
	 * Metodo que inserta la relacion de la palabras clave de la inciativa
	 * @param id_iniciativa identificacion de la inciativa
	 * @param id_palabra identificaion de la palabra
	 */
	public abstract void insertarIniciativaPalabra(int idIniciativa,int idPalabra) throws PersistenciaException;



}
