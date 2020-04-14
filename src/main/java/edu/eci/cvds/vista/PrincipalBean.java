package edu.eci.cvds.vista;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
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

	
	public void iniciarSesion(String email,String contrasena) throws ServiciosException, IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		if(iniciativaServicios.consultarUsuario(email).getContrasena().equals(contrasena)) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			
		}else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
	}
	

    
}