package edu.eci.cvds.vista;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.ServiciosException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public abstract class PrincipalBean implements Serializable {
	@Inject
    private IniciativaServicios iniciativaServicios;

	
	public void iniciarSesion(String email,String contrasena) throws ServiciosException, IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		if(iniciativaServicios.consultarUsuario(email).getContrasena().equals(email)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsp");
		}else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
	}
		
    
}