package edu.eci.cvds.vista;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;


import com.google.inject.Inject;


import java.io.IOException;


import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;

import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "principalBean")
@SessionScoped
public class PrincipalBean extends BasePageBean {

	@Inject
    private Servicios servicios;
    private Usuario usuario;


	public void iniciarSesion(String email,String contrasena) throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		try {
			
			if(servicios.validarUsuario(email, contrasena)) {
				usuario = servicios.consultarUsuario(email);
				
				HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
				session.setAttribute("id", usuario.getId());
				session.setAttribute("name", usuario.getNombre());
				session.setAttribute("type", usuario.getTipoUsuario());
		        
				FacesContext.getCurrentInstance().getExternalContext().redirect("dos.xhtml");
			}else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}
			
		}catch(ServiciosException e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
	}
	
	public void logOut() throws IOException{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		session.removeAttribute("id");
		facesContext.getExternalContext().redirect("index.xhtml");
	}


	
    public String getNombre() {
    	return usuario.getNombre();
    }


}
