package edu.eci.cvds.vista;

import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Comentario;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

@SuppressWarnings("deprecation")
@ManagedBean(name = "comentariosBean")
@SessionScoped
public class ComentariosBean extends BasePageBean {
	
	@Inject
    private Servicios servicios;
	private Iniciativa inic;
	private Usuario usua;
	
	public void agregarComentario(String descripcion) {
		System.out.println("Hola");
		System.out.println(descripcion);
		System.out.println(inic);
		System.out.println(usua);
		try {
			servicios.agregarComentario(descripcion, inic, usua);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El usuario "+ usua.getNombre() + " ha agregado un comentario a la iniciativa "+inic.getNum()));
		}
		 catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
	}
	
	public String redireccionarAComentarios(Iniciativa ini,Usuario usu) {
		inic=ini;
		usua=usu;
		return "AgregarComentarios.xhtml?faces-redirect=true";
	}
	
	public String redireccionarAComentariosConsulta(Iniciativa ini,Usuario usu) {
		inic=ini;
		usua=usu;
		return "ConsultarComentarios.xhtml?faces-redirect=true";
	}
	
	public List<Comentario> consultarComentarios() throws IOException {
		try {
			return servicios.consultarComentarios();
		}catch(ServiciosException e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("ConsultarIniciativas.xhtml");
			return null;
		}
	
	}
}
