  
package edu.eci.cvds.vista;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Usuario;


@SuppressWarnings("deprecation")
@ManagedBean(name = "principalBean")
@SessionScoped
public class PrincipalBean extends BasePageBean {

	@Inject
    private Servicios servicios;
	
	private Usuario usuario;
	private HashMap<String, List<String>> verificacion;
	
	public PrincipalBean() {
		verificacion = new HashMap<String, List<String>>();
		ArrayList<String> usuarioAdmin = new ArrayList<String>(
				Arrays.asList("/ConsultarUsuarios.xhtml","/CambiarIniciativa.xhtml","/ConsultarIniciativaXPalabra.xhtml",
						"/ConsultarIniciativas.xhtml","/PalabrasClaveXIniciativa.xhtml","/AgruparIniciativas.xhtml","/ConsultarIniciativasOrdenadas.xhtml",
						"/IniciativasRelacionadas.xhtml","/AgregarComentarios.xhtml","/ConsultarComentarios.xhtml"));
		
		ArrayList<String> usuarioPropo = new ArrayList<String>(
				Arrays.asList("/AgregarIniciativa.xhtml","/ConsultarIniciativaXPalabra.xhtml","/ConsultarIniciativas.xhtml",
						"/PalabrasClaveXIniciativa.xhtml","/ConsultarIniciativasOrdenadas.xhtml","/IniciativasRelacionadas.xhtml",
						"/ModificarIniciativa.xhtml","/AgregarComentarios.xhtml","/ConsultarComentarios.xhtml"));
		
		ArrayList<String> usuarioPubli = new ArrayList<String>(
				Arrays.asList("/ConsultarIniciativaXPalabra.xhtml","/ConsultarIniciativas.xhtml","/PalabrasClaveXIniciativa.xhtml",
						"/ConsultarIniciativasOrdenadas.xhtml","/IniciativasRelacionadas.xhtml","/AgregarComentarios.xhtml","/ConsultarComentarios.xhtml"));
		
		ArrayList<String> usuarioPmo = new ArrayList<String>(
				Arrays.asList("/ConsultarIniciativaXPalabra.xhtml","/ConsultarIniciativas.xhtml","/PalabrasClaveXIniciativa.xhtml",
						"/ConsultarIniciativasOrdenadas.xhtml","/IniciativasRelacionadas.xhtml","/AgregarComentarios.xhtml","/ConsultarComentarios.xhtml"));
																												
		verificacion.put("Administrador", usuarioAdmin);
		verificacion.put("Proponente", usuarioPropo);
		verificacion.put("PMO", usuarioPmo);
		verificacion.put("Publico", usuarioPubli);
		

	}
	public ArrayList<String> consultarPaginas(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Usuario u = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuario");
		String RolU = u.getTipoUsuario();
		ArrayList<String> e = (ArrayList<String>) verificacion.get(RolU);
		return e;
	}
	
	public boolean esVisibleConsultarUsuarios() {
			return consultarPaginas().contains("/ConsultarUsuarios.xhtml")?true:false;
	}
	
	public boolean esVisibleModificarIniciativa() {
		return consultarPaginas().contains("/ModificarIniciativa.xhtml")?true:false;
	}
	
	public boolean esVisibleConsultarIniciativaXPalabra() {
		return consultarPaginas().contains("/ConsultarIniciativaXPalabra.xhtml")?true:false;
}
	
	public boolean esVisibleConsultarIniciativas() {
		return consultarPaginas().contains("/ConsultarIniciativas.xhtml")?true:false;
	}
	
	public boolean esVisibleConsultarIniciativasOrdenadas() {
		return consultarPaginas().contains("/ConsultarIniciativasOrdenadas.xhtml")?true:false;
	}
	
	public boolean esVisibleAgregarIniciativas() {
		return consultarPaginas().contains("/AgregarIniciativa.xhtml")?true:false;
	}
	
	public boolean esVisibleCambiarIniciativa() {
		return consultarPaginas().contains("/CambiarIniciativa.xhtml")?true:false;
	}
	
	public boolean esVisibleAgruparIniciativas() {
		return consultarPaginas().contains("/AgruparIniciativas.xhtml")?true:false;
	}

	


/**
    * metodo que inicia sesion en la pagina
    * @param email email del usuario
    * @param contrasena contrase�a del usuario
    * @throws IOException
    */
	public String iniciarSesion(String email,String contrasena) throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String redirec = null;
		
		
		try {
			if(servicios.validarUsuario(email, contrasena)) {
				usuario = servicios.consultarUsuario(email);
				String tipo = usuario.getTipoUsuario();
				if (tipo.equals("Administrador")) {
					redirec = "ConsultarUsuarios.xhtml?faces-redirect=true";
				}else if (tipo.equals("Proponente")) {
					redirec = "ConsultarIniciativaXPalabra.xhtml?faces-redirect=true";
				}else if (tipo.equals("Publico")) {
					redirec = "ConsultarIniciativaXPalabra.xhtml?faces-redirect=true";
				}
				
				//almacenar Sesion
				facesContext.getExternalContext().getSessionMap().put("usuario", usuario);
		        
			}else {
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aviso","La clave no coincide"));
			}
			
		}catch(ServiciosException e) {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		return redirec;
	}
	
	/**
	 * metodo que termina sesion del usuario
	 * @throws IOException
	 */
	public String cerrarSesion() throws IOException{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
	}

	/**
	 * metodo que verifica si hay una sesion activa
	 */
	public void verificarSesion() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			
			Usuario u = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuario");
			
			if (u == null) {
				facesContext.getExternalContext().redirect("index.xhtml");
			}else {
				redireccionar();
			}
		}catch(Exception e) {
			//
		}
	}
	
	public void redireccionar() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
			String url =req.getRequestURI();
			
			if (!consultarPaginas().contains(url)) {
					facesContext.getExternalContext().redirect(consultarPaginas().get(0));
			}
		}catch(Exception e) {
			//
		}
	}
	
	public void verificarSesionIndex() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			
			Usuario u = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuario");
			
			if (u != null) {
				redireccionar();
			}
		}catch(Exception e) {
			//
		}
	}
	

	  public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

}