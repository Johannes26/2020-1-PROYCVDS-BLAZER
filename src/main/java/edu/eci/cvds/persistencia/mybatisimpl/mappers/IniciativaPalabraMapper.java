package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

public interface IniciativaPalabraMapper {
	public void insertarIniciativaPalabra(@Param("iniciativa") int id_iniciativa,
										@Param("palabra")int id_palabra);
}
