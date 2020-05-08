package edu.eci.cvds.vista;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.IniciativaPalabra;
import edu.eci.cvds.entidades.IniciativasRelacionadas;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@ViewScoped
public class IniciativaBean extends BasePageBean {
	@Inject
    private Servicios servicios;
	
	private String descripcion;
	private List<Iniciativa> iniciativas;
	private String actarea;
	private String actdescripcion;
	
	public void actualizar(RowEditEvent event) {
		Iniciativa ini = (Iniciativa) event.getObject();
		try {
			servicios.cambiarDatosIniciativa(ini, actdescripcion, actarea);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha modificado la iniciativa"));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		
	}
	
	public void cancelar(RowEditEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se cancelo correctamente"));
	}

	
	public void registrarIniciativa(String emailProponente ,String palabrasclave, String areaProponente) {
		try {
			Usuario u = servicios.consultarUsuario(emailProponente);
			servicios.registrarIniciativa(new Iniciativa(descripcion,u,areaProponente),palabrasclave);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha registrado la inicativa"));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		
	}

	public int consultarIniciativasPorArea(String area) {
		try {
			int iniciativasPorArea = servicios.consultarIniciativasPorArea(area);
			String stringIniciativaPorArea = String.valueOf(iniciativasPorArea);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", stringIniciativaPorArea));
			return iniciativasPorArea;
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
			return 0;
		}
		
		
	}
	
	public void inicializar() {
		try {
			iniciativas =servicios.consultarIniciativas();
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

	public String getActarea() {
		return actarea;
	}

	public void setActarea(String actarea) {
		this.actarea = actarea;
	}

	public String getActdescripcion() {
		return actdescripcion;
	}

	public void setActdescripcion(String actdescripcion) {
		this.actdescripcion = actdescripcion;
	}
	
	
	
	
}

