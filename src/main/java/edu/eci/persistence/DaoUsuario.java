
package edu.eci.persistence;

import edu.eci.entities.Usuario;
import edu.eci.persistence.PersistenceException ;
import edu.eci.entities.Usuario;
import edu.eci.entities.Iniciativa;
import java.util.List;


public interface DaoUsuario {

	public Usuario consultarCliente(int id) throws PersistenceException;

}
