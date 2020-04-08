
package edu.eci.cvds.persistencia;

import edu.eci.cvds.entidades.Usuario;



public interface DaoUsuario {

	public Usuario consultarUsuario(int id) throws PersistenceException;

}
