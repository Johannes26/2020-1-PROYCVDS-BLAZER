package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.PalabrasClave;
import edu.eci.cvds.persistencia.PalabrasClaveDao;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.PalabrasClaveMapper;

import java.util.List;

import javax.persistence.PersistenceException;

public class MyBatisPalabrasClaveDao implements PalabrasClaveDao{
	@Inject
    private PalabrasClaveMapper palabrasClaveMapper;
	
	
	public PalabrasClave consultarPalabraClave(String descripcion) throws PersistenceException{
    	try {
            return  palabrasClaveMapper.consultarPalabraClave(descripcion);
            
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar la palabra");
        }
    	
	}
	
	public void insertarPalabraClave(String descripcion) throws PersistenceException{
    	try {
            palabrasClaveMapper.insertarPalabraClave(descripcion);
            
        } catch (PersistenceException e){
            throw new PersistenceException("Error al insertar la palabra");
        }
	}
	
	public List<PalabrasClave> consultarPalabrasClave()throws PersistenceException{
    	try {
            return palabrasClaveMapper.consultarPalabrasClave();
            
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar las palabras");
        }
	}
}