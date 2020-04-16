
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;

import java.util.List;

import javax.persistence.PersistenceException;



public class MyBatisDAOIniciativa implements DaoIniciativa {
	@Inject
    private IniciativaMapper IniciativaMapper;
    
    public Iniciativa consultarIniciativa(int num) throws PersistenceException{
    	try {
            Iniciativa iniciativa = IniciativaMapper.consultarIniciativa(num);
            return iniciativa;
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar la iniciativa");
        }
    }
    
    public List<Iniciativa> consultarIniciativas() throws PersistenceException{
    	try {
    		return IniciativaMapper.consultarIniciativas();
    	}catch (PersistenceException e){
            throw new PersistenceException("No se pudo consultar las iniciativas");
        }
    }
    
    public void registrarIniciativa(Iniciativa texto) throws PersistenceException{
    	try {
    		IniciativaMapper.registrarIniciativa(texto);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al registrar la iniciativa");
        }
    }


}