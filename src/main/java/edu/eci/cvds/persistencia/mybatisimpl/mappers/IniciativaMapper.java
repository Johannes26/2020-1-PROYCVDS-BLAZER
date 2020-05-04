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
	 * @return
	 */
	public List<Iniciativa> consultarIniciativaXPalabraClave(@Param("descripcion") String palabra);

}
