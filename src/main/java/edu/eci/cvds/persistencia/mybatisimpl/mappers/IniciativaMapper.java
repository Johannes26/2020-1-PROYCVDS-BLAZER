package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Iniciativa;



public interface IniciativaMapper {
	
	/**
	 * metodo que permite consultar la inciativa por medio de su identificador
	 * @param identificador identificador de la inciativa
	 * @return Iniciativa
	 */
	public Iniciativa consultarIniciativa(@Param("num") int identificador);

	/**
	 * metodo que permite mostrar estadisticas de las inciativas agrupadas por area
	 * @param area identificador de area
	 * @return Iniciativa
	 */
	public int consultarIniciativasPorArea(@Param("area") String area);
	
	/**
     * metodo que permite mostrar las iniciativas por estado
     * @param estado identificador de estado
     * @return Iniciativa
     */
    public List<Iniciativa> consultarIniciativasPorEstado(@Param("estado") String estado);
    
	/**
	 * metodo que permite consultar todas las inciativas
	 * @return lista de iniciativas
	 */
	public List<Iniciativa> consultarIniciativas();
	
	/**
	 * metodo que permite crear una inciativa
	 * @param Iniciativa a insertar
	 */
	public void registrarIniciativa(@Param("iniciativa") Iniciativa texto);
	/**
	 * metodo que permite cambiar el estado de una iniciativa
	 * @param identificador numero de identificacion de la inciativa
	 * @param estado texto del estado de la inciativa
	 */
	public void cambiarEstadoIniciativa(@Param("num") int identificador, @Param("estado") String estado);
	/**
	 * consultar una iniciativa de acuerdo a una palara clave
	 * @param palabra palara clave a buscar
	 * @return lista de iniciativas
	 */
	public List<Iniciativa> consultarIniciativaXPalabraClave(@Param("descripcion") String palabra);
	
	/**
	 * Actualiza una inciativa
	 * @param num id de la iniciaitiva
	 * @param descripcion nueva descripcion
	 * 
	 * 
	 **/
	public void cambiarDatosIniciativa(@Param("num")int num, @Param("descripcion") String descripcion);
	/**
	 * Metodo que consulta las inciativas por id del usuario
	 * @param id identificacion del usuario
	 * @return	lista de inciativas
	 */
	public List<Iniciativa> consultarIniciativaXUsuario(@Param("id")int id);
	
	
	public int consultarCantidadIniciativasPorEstado(@Param("estado")String estado);
	
	public List<String> consultarEstadosIniciativas();

}
