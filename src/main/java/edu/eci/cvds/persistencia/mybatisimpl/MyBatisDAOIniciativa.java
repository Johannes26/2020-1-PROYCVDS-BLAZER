
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;



public class MyBatisDAOIniciativa implements DaoIniciativa {
	@Inject
    private IniciativaMapper IniciativaMapper;
	
    
    public Iniciativa consultarIniciativa(int num) throws PersistenciaException{
    	try {
            Iniciativa iniciativa = IniciativaMapper.consultarIniciativa(num);
            return iniciativa;
        } catch (PersistenceException e){
            throw new PersistenciaException("Error al consultar la iniciativa");
        }
    }

    public int consultarIniciativasPorArea(String area) throws PersistenciaException{
        try {
            int numIniciativas = IniciativaMapper.consultarIniciativasPorArea(area);
            return numIniciativas;
        } catch (PersistenceException e){
            throw new PersistenciaException("No pudo contar las iniciativas");
        }
    }
    
    public List<Iniciativa> consultarIniciativasPorEstado(String estado) throws PersistenciaException{
        try {
            return IniciativaMapper.consultarIniciativasPorEstado(estado);
        } catch (PersistenceException e){
            throw new PersistenciaException("No pudo consultar las iniciativas por estado");
        }
    }
    
    public List<Iniciativa> consultarIniciativas() throws PersistenciaException{
    	try {
    		return IniciativaMapper.consultarIniciativas();
    	}catch (PersistenceException e){
            throw new PersistenciaException("No se pudo consultar las iniciativas");
        }
    }
    
    public void registrarIniciativa(Iniciativa texto) throws PersistenciaException{
    	try {
    		IniciativaMapper.registrarIniciativa(texto);
        } catch (PersistenceException e){
            throw new PersistenciaException("Error al registrar la iniciativa");
        }
    }

	@Override
	public void cambiarEstadoIniciativa(int num, String estado) throws PersistenciaException {
		try {
    		IniciativaMapper.cambiarEstadoIniciativa(num,estado);
        } catch (PersistenceException e){
            throw new PersistenciaException("Error al cambiar el estado de la iniciativa");
        }
		
	}
	
	public List<Iniciativa> consultarIniciativaXPalabraClave(String PalabrasClave) throws PersistenciaException{
    	try {
    		return IniciativaMapper.consultarIniciativaXPalabraClave(PalabrasClave);
    	}catch (PersistenceException e){
            throw new PersistenciaException("No se pudo consultar las iniciativas por su palabra clave");
        }
    }

	@Override
	public void cambiarDatosIniciativa(int num, String descripcion) throws PersistenciaException{
		try {
    		IniciativaMapper.cambiarDatosIniciativa(num, descripcion);
    	}catch (PersistenceException e){
            throw new PersistenciaException("No se pudo actualizar");
        }
	}

	@Override
	public List<Iniciativa> consultarIniciativaXUsuario(int id) throws PersistenciaException {
		try {
    		return IniciativaMapper.consultarIniciativaXUsuario(id);
    	}catch (PersistenceException e){
            throw new PersistenciaException("Error consulta inciativia X usuario");
        }
		
	}


}