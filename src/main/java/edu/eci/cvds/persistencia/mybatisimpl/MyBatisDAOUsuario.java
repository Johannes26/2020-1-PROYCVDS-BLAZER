package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.DaoUsuario;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;
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
