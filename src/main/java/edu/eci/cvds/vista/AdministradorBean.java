package edu.eci.cvds.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;




import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Usuario;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminiBean")
@SessionScoped
public class AdministradorBean extends BasePageBean {

	@Inject
    private Servicios servicios;
	private Usuario usuariobuscado = null;
	private String rolNuevo;
	
	public List <Usuario> consultarUsuarios() throws ServiciosException{
    	return servicios.consultarUsuarios();
    }

    public void cambiarRol(int id, String rol) throws ServiciosException{
    	servicios.cambiarRol(id, rol);
    	usuariobuscado = null;
    	rolNuevo = "";
    }

    
	public Usuario consultarUsuario(String email){
		try{
			usuariobuscado = servicios.consultarUsuario(email);
		}catch(ServiciosException e){
			usuariobuscado = null;
		}
		return usuariobuscado;
	}

	
	public Usuario getusuariobuscado() {
		return usuariobuscado;
	}
	
	public void setusuariobuscado(Usuario usuariobuscado) {
		this.usuariobuscado=usuariobuscado;
	}
	
	
	public String getrolNuevo() {
		return rolNuevo;
	}
	
	public void setrolNuevo(String rolNuevo) {
		this.rolNuevo = rolNuevo;
	}
	
}
