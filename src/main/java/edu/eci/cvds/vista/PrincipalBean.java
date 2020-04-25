  
package edu.eci.cvds.vista;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


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
	/*private HashMap<String, List<String>> verificacion;
	
	public PrincipalBean() {
		verificacion = new HashMap<String, List<String>>();
		ArrayList<String> paginas = new ArrayList<String>(
				Arrays.asList("index", "Administrador"));

	}*/

   public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
					redirec = "Administrador.xhtml?faces-redirect=true";
				}else if (tipo.equals("Proponente")) {
					redirec = "UsuarioProponente.xhtml?faces-redirect=true";
				}else if (tipo.equals("Publico")) {
					redirec = "Publico.xhtml?faces-redirect=true";
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
			}
		}catch(Exception e) {
			//
		}
	}


}