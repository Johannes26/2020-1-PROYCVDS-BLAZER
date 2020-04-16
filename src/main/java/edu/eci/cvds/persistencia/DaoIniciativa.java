
package edu.eci.cvds.persistencia;

import java.util.List;

import edu.eci.cvds.entidades.Iniciativa;


public interface DaoIniciativa {
 
	public Iniciativa consultarIniciativa(int num) throws PersistenceException;
	
    public List<Iniciativa> consultarIniciativas() throws PersistenceException;
	
	public void registrarIniciativa(Iniciativa texto) throws PersistenceException;
}