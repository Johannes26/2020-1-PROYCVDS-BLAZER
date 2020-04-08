package edu.eci.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.entities.Usuario;
import edu.eci.persistence.DaoUsuario;
import edu.eci.persistence.PersistenceException;
import edu.eci.persistence.mybatisimpl.mappers.UsuarioMapper;
import java.util.List;



public class MyBatisDAOUsuario implements DaoUsuario {

    @Inject
    private UsuarioMapper usuarioMapper;
    
    @Override
	  public Usuario consultarCliente(int id) throws PersistenceException {
	  try{
	      return usuarioMapper.consultarUsuario(id);
	  }
	  		catch(org.apache.ibatis.exceptions.PersistenceException e){
	      throw new PersistenceException("Error al consultar el usuario "+ id , e);
	  }
	  }
    
}
