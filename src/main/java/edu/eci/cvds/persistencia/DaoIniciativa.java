
package edu.eci.cvds.persistencia;

import edu.eci.cvds.entidades.Iniciativa;

public interface DaoIniciativa {
 
	public Iniciativa consultarIniciativa(int num) throws PersistenceException;
}