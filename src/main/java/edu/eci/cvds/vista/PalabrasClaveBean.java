package edu.eci.cvds.vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.IniciativaPalabra;
import edu.eci.cvds.servicios.Servicios;

@SuppressWarnings("deprecation")
@ManagedBean(name = "palabrasBean")
@SessionScoped
public class PalabrasClaveBean extends BasePageBean {

	@Inject
    private Servicios servicios;
	private List<IniciativaPalabra> palabras;
	
	public String consultarPalabras(List<IniciativaPalabra> palabras) {
		this.palabras=palabras;
		return "PalabrasClaveXIniciativa.xhtml?faces-redirect=true";
	}
	
	public List<IniciativaPalabra> getPalabras() {
		return palabras;
	}


	public void setPalabras(List<IniciativaPalabra> palabras) {
		this.palabras = palabras;
	}
}
