package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.entidades.Usuario;

import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;

import javax.persistence.PersistenceException;

public class MyBatisUsuarioDAO implements UsuarioDAO {
	@Inject
    private UsuarioMapper usuarioMapper;
	
 

    public Usuario consultarUsuario(String email) throws PersistenceException{
        try {
            Usuario usuario = usuarioMapper.consultarUsuario(email);
            return usuario;
        } catch (PersistenceException e){
            throw new PersistenceException("El usuario no existe");
        }
    }
}