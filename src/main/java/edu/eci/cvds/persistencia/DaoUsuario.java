
package edu.eci.cvds.persistencia;

import edu.eci.cvds.entidades.Usuario;



public interface DaoUsuario {

	public Usuario consultarCliente(int id) throws PersistenceException;

}
