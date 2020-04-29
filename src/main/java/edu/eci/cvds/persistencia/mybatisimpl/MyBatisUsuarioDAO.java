package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.entidades.Usuario;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.UsuarioMapper;

import java.util.List;


public class MyBatisUsuarioDAO implements UsuarioDAO {
	@Inject
    private UsuarioMapper usuarioMapper;
	

    public Usuario consultarUsuario(String email) throws PersistenciaException{
        try {
            Usuario usuario = usuarioMapper.consultarUsuario(email);
            return usuario;
        } catch (PersistenceException e){
            throw new PersistenciaException("No se pudo consultar el usuario");
        }
    }
    
    public Usuario consultarUsuarioXId(int id) throws PersistenciaException{
    	try {
            Usuario usuario = usuarioMapper.consultarUsuarioXId(id);
            return usuario;
        } catch (PersistenceException e){
            throw new PersistenciaException("No se pudo consultar el usuario");
        }
    }
    
    public List<Usuario> consultarUsuarios() throws PersistenciaException{
    	try {
    		return usuarioMapper.consultarUsuarios();
    	}catch (PersistenceException e){
            throw new PersistenciaException("No se pudo consultar los usuarios");
        }
    }
    
    public void cambiarRol(int id, String rol) throws PersistenciaException{
    	try {
    		usuarioMapper.cambiarRol(id, rol);
    	}catch(PersistenceException e) {
            throw new PersistenciaException("No se pudo actualizar el rol");
    	}
    }


	@Override
	public void registrarUsuario(int id, String nombre, String apellido, String email, int telefono, String tipoUsuario,
			String contrasena) throws PersistenciaException {
		try {
    		usuarioMapper.registrarUsuario(id, nombre, apellido, email, telefono, tipoUsuario, contrasena);
    	}catch(PersistenceException e) {
            throw new PersistenciaException("No se crear usuario");
    	}
		
	}

	
}