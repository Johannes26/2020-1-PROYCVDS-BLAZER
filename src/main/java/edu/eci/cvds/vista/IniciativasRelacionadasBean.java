package edu.eci.cvds.vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.IniciativaPalabra;
import edu.eci.cvds.entidades.IniciativasRelacionadas;
import edu.eci.cvds.servicios.Servicios;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativasrela")
@SessionScoped
public class IniciativasRelacionadasBean extends BasePageBean {

	@Inject
    private Servicios servicios;
	private List<IniciativasRelacionadas> iniciativasRelacionadas;
	
	public String consultarIniciativasRelacionadas(List<IniciativasRelacionadas> iniciativasRelacionadas) {
		this.iniciativasRelacionadas=iniciativasRelacionadas;
		return "IniciativasRelacionadas.xhtml?faces-redirect=true";
	}

	public List<IniciativasRelacionadas> getIniciativasRelacionadas() {
		return iniciativasRelacionadas;
	}

	public void setIniciativasRelacionadas(List<IniciativasRelacionadas> iniciativasRelacionadas) {
		this.iniciativasRelacionadas = iniciativasRelacionadas;
	}
}
