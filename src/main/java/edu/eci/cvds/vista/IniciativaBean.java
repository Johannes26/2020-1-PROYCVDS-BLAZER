package edu.eci.cvds.vista;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Estadisticas;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
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
	private List<Estadisticas> estadisticas,estadisticasArea;

	
	
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
	
	public PieChartModel estaditicasIniciativasPorEstado() {
		PieChartModel graficaEstado = new PieChartModel();
		try {
			List<String> estados = servicios.consultarEstadosIniciativas();
			for(String i: estados) {
				int cantidad=servicios.consultarCantidadIniciativasPorEstado(i);
				graficaEstado.set(i,cantidad );
			}
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		graficaEstado.setTitle("Grafica porcentaje de inicativas por estado");
		graficaEstado.setLegendPosition("e");
		graficaEstado.setShadow(false);
		graficaEstado.setShowDataLabels(false);
		return  graficaEstado;
	}
	

	public BarChartModel estaditicasIniciativasPorEstado2() {
		BarChartModel model = new BarChartModel();
        try {
        	
        	List<ChartSeries> estados =new ArrayList<>();
			List<String> iniciativas = servicios.consultarEstadosIniciativas();
			for(String i: iniciativas) {
				ChartSeries a= new ChartSeries();
				a.set(i, servicios.consultarCantidadIniciativasPorEstado(i));

				model.addSeries(a);
				
				
			}
			model.setTitle("Grafica cantidad de iniciativas por estado");
			model.setLegendPosition("ne");

			
			
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Estado");
	 
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Cantidad Iniciativas");
	        yAxis.setMin(0);
	        yAxis.setMax(servicios.consultarIniciativas().size());
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		return model;
    }
	
	public void inicializarEstadisticas() {
		estadisticas=new ArrayList<>();
		try {
			
			List<String> estados= servicios.consultarEstadosIniciativas();
			for(String e: estados) {
				int cantidad=servicios.consultarCantidadIniciativasPorEstado(e);
				estadisticas.add(new Estadisticas(e,cantidad));
			}
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inicializarEstadisticas2() {
		estadisticasArea=new ArrayList<>();
		try {
			
			List<String> areas= servicios.consultarAreas();
			for(String e: areas) {
				int cantidad=servicios.consultarIniciativasPorArea(e);
				estadisticasArea.add(new Estadisticas(e,cantidad));
			}
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializar() {
		try {
			iniciativas =servicios.consultarIniciativas();
			consultarIniciativasPorArea();
			inicializarEstadisticas();
			inicializarEstadisticas2();
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
	}
	
	public void inicializarMisIniciativas(int id) {
		try {
			iniciativas =servicios.consultarIniciativaXUsuario(id);
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

	public List<Estadisticas> getEstadisticas() {
		return estadisticas;
	}

	public void setEstadisticas(List<Estadisticas> estadisticas) {
		this.estadisticas = estadisticas;
	}

	public List<Estadisticas> getEstadisticasArea() {
		return estadisticasArea;
	}

	public void setEstadisticasArea(List<Estadisticas> estadisticasArea) {
		this.estadisticasArea = estadisticasArea;
	}

	
	

	
	
	
	
	
	
}

