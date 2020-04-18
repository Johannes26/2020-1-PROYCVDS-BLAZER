
package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.Iniciativa;


public interface DaoIniciativa {
 
	/**
	 * metodo que permite consultar la inciativa por medio de su identificador
	 * @param num identificador de la inciativa
	 * @return Iniciativa
	 */
	public Iniciativa consultarIniciativa(int num) throws PersistenceException;
	
	/**
	 * metodo que permite consultar todas las inciativas
	 * @return lista de iniciativas
	 */
    public List<Iniciativa> consultarIniciativas() throws PersistenceException;
	
    /**
	 * metodo que permite crear una inciativa
	 * @param texto a insertar
	 */
	public void registrarIniciativa(Iniciativa texto) throws PersistenceException;
	/**
	 * metodo que permite cambiar el estado de una iniciativa
	 * @param identificador numero de identificacion de la inciativa
	 * @param estado texto del estado de la inciativa
	 */
	public void cambiarEstadoIniciativa(int num, String estado) throws PersistenceException;
	/**
	 * consultar una iniciativa de acuerdo a una palara clave
	 * @param palabra palara clave a buscar
	 * @return
	 */
	public List<Iniciativa> consultarIniciativaXPalabraClave(String PalabrasClave) throws PersistenceException;
}