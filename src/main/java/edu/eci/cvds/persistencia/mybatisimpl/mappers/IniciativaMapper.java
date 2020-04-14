package edu.eci.cvds.persistencia.mybatisimpl.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.entidades.Iniciativa;

//import java.util.List;
//import java.util.Set;


//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Result;
//import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Select;

public interface IniciativaMapper {

	public Iniciativa consultarIniciativa(@Param("num") int identificador);

}
