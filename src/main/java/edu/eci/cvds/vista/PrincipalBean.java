package edu.eci.cvds.vista;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;


import java.io.IOException;


import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.ServiciosException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "principalBean")
@SessionScoped
public class PrincipalBean extends BasePageBean {
	@Inject
    private IniciativaServicios iniciativaServicios;

	
	public void iniciarSesion(String email,String contrasena) throws IOException, ServiciosException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
	
		if(iniciativaServicios.validarUsuario(email, contrasena)) {
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
	           session.setAttribute("correo", email);
			FacesContext.getCurrentInstance().getExternalContext().redirect("dos.xhtml");
		}else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
		
		
		
	}
    
}