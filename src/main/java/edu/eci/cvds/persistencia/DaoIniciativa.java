
package edu.eci.cvds.persistencia;

import java.util.List;


import edu.eci.cvds.entidades.Iniciativa;


public interface DaoIniciativa {
 
	/**
	 * metodo que permite consultar la inciativa por medio de su identificador
	 * @param num identificador de la inciativa
	 * @return Iniciativa
	 */
	public Iniciativa consultarIniciativa(int num) throws PersistenciaException;
	
	/**
	 * metodo que permite contar las inciativas agrupadas por un area especifica
	 * @param area area del propontente 
	 * @return int
	 */
	public int consultarIniciativasPorArea(String area) throws PersistenciaException;
	
	/**
     * metodo que permite consultar las iniciativas con un estado dado
     * @param estado estado de la iniciativa
     * @return Lista Iniciativas
     */
    public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws PersistenciaException;
    
	/**
	 * metodo que permite consultar todas las inciativas
	 * @return lista de iniciativas
	 */
    public List<Iniciativa> consultarIniciativas() throws PersistenciaException;
	
    /**
	 * metodo que permite crear una inciativa
	 * @param texto a insertar
	 */
	public void registrarIniciativa(Iniciativa texto) throws PersistenciaException;
	/**
	 * metodo que permite cambiar el estado de una iniciativa
	 * @param identificador numero de identificacion de la inciativa
	 * @param estado texto del estado de la inciativa
	 */
	public void cambiarEstadoIniciativa(int num, String estado) throws PersistenciaException;
	/**
	 * consultar una iniciativa de acuerdo a una palara clave
	 * @param palabra palara clave a buscar
	 * @return
	 */
	public List<Iniciativa> consultarIniciativaXPalabraClave(String PalabrasClave) throws PersistenciaException;
	
	/**
	 * Actualiza una inciativa
	 * @param num id de la iniciaitiva
	 * @param descripcion nueva descripcion
	 * 
	 * 
	 **/
	public void cambiarDatosIniciativa(int num, String descripcion) throws PersistenciaException;
	
	/**
	 * Metodo que consulta las inciativas por id del usuario
	 * @param id identificacion del usuario
	 * @return	lista de inciativas
	 */
	public List<Iniciativa> consultarIniciativaXUsuario(int id) throws PersistenciaException;
}