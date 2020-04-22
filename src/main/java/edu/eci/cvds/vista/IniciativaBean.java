package edu.eci.cvds.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.PalabrasClave;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@ViewScoped
public class IniciativaBean extends BasePageBean {
	@Inject
    private Servicios servicios;
	
	public String registrarIniciativa(String descripcion, String emailProponente ,String palabrasclave, String areaProponente) {
		String redirec = null;
		try {
			String[] p=palabrasclave.split(",");
			List<PalabrasClave> palabras= new ArrayList<PalabrasClave>();
			for(String s: p) {
				palabras.add(new PalabrasClave(s));
			}
			Usuario u = servicios.consultarUsuario(emailProponente);
			servicios.registrarIniciativa(new Iniciativa(descripcion,u,areaProponente),palabras);
			redirec = "UsuarioProponente.xhtml?faces-redirect=true";
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","Error al registrar iniciativa del usuario"));
		}
		return redirec;
		
	}
	
	
}

