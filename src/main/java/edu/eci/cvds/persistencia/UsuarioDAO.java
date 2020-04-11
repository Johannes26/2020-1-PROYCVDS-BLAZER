package edu.eci.cvds.persistencia;

import edu.eci.cvds.entidades.Usuario;



public interface UsuarioDAO {
    public Usuario consultarUsuario(String email) throws PersistenceException;

}	