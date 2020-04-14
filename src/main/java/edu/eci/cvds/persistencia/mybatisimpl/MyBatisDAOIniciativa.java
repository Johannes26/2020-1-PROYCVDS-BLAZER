
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.entidades.Iniciativa;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;

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
}