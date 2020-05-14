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
	private List<Comentario> comentariosIni;
	
	public void agregarComentario(String descripcion) {
		try {
			servicios.agregarComentario(descripcion, inic, usua);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","El usuario "+ usua.getNombre() + " ha agregado un comentario a la iniciativa "+inic.getNum()));
		}
		 catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
	}
	
	public String consultarComentariosXid(Iniciativa ini) {
		this.inic=ini;
		String direc = "";
		try {
			comentariosIni=servicios.consultarComentariosXIniciativa(inic.getNum());
			if(comentariosIni.size()==0) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso","La iniciativa no tiene comentarios"));
			}else {
				direc = "ConsultarComentarioXId.xhtml?faces-redirect=true";
			}
		} catch (ServiciosException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
		}
		return direc;
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

	public Iniciativa getInic() {
		return inic;
	}

	public void setInic(Iniciativa inic) {
		this.inic = inic;
	}

	public Usuario getUsua() {
		return usua;
	}

	public void setUsua(Usuario usua) {
		this.usua = usua;
	}

	public List<Comentario> getComentariosIni() {
		return comentariosIni;
	}

	public void setComentariosIni(List<Comentario> comentariosIni) {
		this.comentariosIni = comentariosIni;
	}
	
	
}
