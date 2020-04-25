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
	
	private String descripcion;
	
	
	public void registrarIniciativa(String emailProponente ,String palabrasclave, String areaProponente) {
		try {
			Usuario u = servicios.consultarUsuario(emailProponente);
			servicios.registrarIniciativa(new Iniciativa(descripcion,u,areaProponente),palabrasclave);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha registrado la inicativa"));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		
	}
	
	public void registrarVoto(int id_Usuario, int num_Iniciativa) {
		try {
			servicios.insertarVoto(id_Usuario, num_Iniciativa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Le has dado me gusta a la iniciativa "+num_Iniciativa));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
	}
	
	public void quitarVoto(int id_Usuario, int num_Iniciativa) {
		try {
			servicios.quitarVoto(id_Usuario, num_Iniciativa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Ya no te gusta la iniciativa "+num_Iniciativa));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
	}
	
	public int consultarVotos(int num_Iniciativa) {
		try {
			return servicios.contarVotos(num_Iniciativa);
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
			return 0;
		}
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}

