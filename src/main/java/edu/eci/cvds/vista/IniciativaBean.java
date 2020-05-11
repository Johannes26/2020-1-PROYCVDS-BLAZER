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
import org.primefaces.model.chart.PieChartModel;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@ViewScoped
public class IniciativaBean extends BasePageBean {
	@Inject
    private Servicios servicios;
	
	private String descripcion;
	private List<Iniciativa> iniciativas;
	private String actdescripcion;
	private PieChartModel pieModel;
	
	public void actualizar(RowEditEvent event) {
		Iniciativa ini = (Iniciativa) event.getObject();
		try {
			servicios.cambiarDatosIniciativa(ini, actdescripcion);
			iniciativas =servicios.consultarIniciativas();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha modificado la iniciativa"));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		
	}
	
	public void cancelar(RowEditEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se cancelo correctamente"));
	}

	
	public void registrarIniciativa(String emailProponente ,String palabrasclave) {
		try {
			Usuario u = servicios.consultarUsuario(emailProponente);
			servicios.registrarIniciativa(new Iniciativa(descripcion,u),palabrasclave);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha registrado la inicativa"));
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		
	}
	

	public void consultarIniciativasPorArea() {
			pieModel = new PieChartModel();
			try {
				List<String> areas = servicios.consultarAreas();
				for(String i: areas) {
					pieModel.set(i, servicios.consultarIniciativasPorArea(i));
				}
			} catch (ServiciosException e) {}
			pieModel.setTitle("Grafica de numero de inicativas por area");
			pieModel.setLegendPosition("w");
			pieModel.setShadow(false);
			pieModel.setShowDataLabels(true);
	}
	
	public void inicializar() {
		try {
			iniciativas =servicios.consultarIniciativas();
			consultarIniciativasPorArea();
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


	public String getActdescripcion() {
		return actdescripcion;
	}

	public void setActdescripcion(String actdescripcion) {
		this.actdescripcion = actdescripcion;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	
	
	
	
}

