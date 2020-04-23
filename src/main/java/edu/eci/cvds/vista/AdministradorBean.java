package edu.eci.cvds.vista;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;




import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "adminiBean")
@ViewScoped
public class AdministradorBean extends BasePageBean {

	@Inject
    private Servicios servicios;
	private Usuario usuariobuscado;
	private String rolNuevo;
	private Iniciativa iniciativabuscada;
	private String estadoNuevo;
	
	/**
	 * metodo que consulta todos los usuarios
	 * @return lista de usuarios
	 * @throws ServiciosException
	 */
	public List <Usuario> consultarUsuarios() throws ServiciosException{
    	return servicios.consultarUsuarios();
    }
	/**
	 * cambiar el rol de un usuario
	 * @param id ide del usuario
	 * @param rol rol nuevo a cambiar
	 * @throws ServiciosException
	 * @throws IOException
	 */
    public void cambiarRol(int id, String rol) throws ServiciosException, IOException{
    	servicios.cambiarRol(id, rol);
    	usuariobuscado = null;
    	rolNuevo = "";
    	FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador.xhtml");
    }

    /**
     * metodo que consulta un usuario de acuerdo a su email
     * @param email email del usuario
     */
	public void consultarUsuario(String email){
		try{
			usuariobuscado = servicios.consultarUsuario(email);
		}catch(ServiciosException e){
			usuariobuscado = null;
		}
	}
	
	/**
	 * metodo que cambia el estado de una inciativa
	 * @param num numero de inciativa
	 * @param estado estado nuevo que se quiere cambiar
	 * @throws IOException
	 */
	public void cambiarEstadoIniciativa(int num, String estado) throws IOException {
		try {
			servicios.cambiarEstadoIniciativa(num, estado);
			iniciativabuscada=null;
			setEstadoNuevo("");
			FacesContext.getCurrentInstance().getExternalContext().redirect("CambiarIniciativa.xhtml");
		}catch(ServiciosException e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("CambiarIniciativa.xhtml");
		}
	}
	/**
	 * metodo que consulta todas las inciativas
	 * @return lista de inciativas
	 * @throws IOException
	 */
	public List<Iniciativa> consultarIniciativas() throws IOException {
		try {
			return servicios.consultarIniciativas();
		}catch(ServiciosException e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador.xhtml");
			return null;
		}
	}
	
	/**
	 * metodo que consulta una inciativa
	 * @param num numero de iniciativa
	 */
	public void consultarIniciativa(int num){
		try{
			iniciativabuscada = servicios.consultarIniciativa(num);
		}catch(ServiciosException e){
			iniciativabuscada = null;
		}
	} 

	
	public Usuario getusuariobuscado() {
		return usuariobuscado;
	}
	
	public void setusuariobuscado(Usuario usuariobuscado) {
		this.usuariobuscado=usuariobuscado;
	}
	
	public Iniciativa getiniciativabuscada() {
		return iniciativabuscada;
	}
	
	public void setiniciativabuscada(Iniciativa iniciativabuscada) {
		this.iniciativabuscada=iniciativabuscada;
	}
	
	
	public String getrolNuevo() {
		return rolNuevo;
	}
	
	public void setrolNuevo(String rolNuevo) {
		this.rolNuevo = rolNuevo;
	}

	public String getEstadoNuevo() {
		return estadoNuevo;
	}

	public void setEstadoNuevo(String estadoNuevo) {
		this.estadoNuevo = estadoNuevo;
	}
	
}
