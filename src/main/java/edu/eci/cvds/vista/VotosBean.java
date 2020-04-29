package edu.eci.cvds.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "votosBean")
@ViewScoped
public class VotosBean extends BasePageBean  {

		@Inject
	    private Servicios servicios;
		
		private ArrayList<Integer> idvotosiniciativa= new ArrayList<>();
		
		public void consultarVotos() {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Usuario u = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuario");
			
			try {
				List<Voto> votos = servicios.consultarUsuarioXId(u.getId()).getLikes();
				for(Voto v: votos) {
					idvotosiniciativa.add(v.getIni().getNum());
				}
			} catch (ServiciosException e) {
				//
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
		
		public boolean validarVoto(int num_Iniciativa) {
			
			return idvotosiniciativa.contains(num_Iniciativa)?true:false;
		}
		
	

		
		
}

