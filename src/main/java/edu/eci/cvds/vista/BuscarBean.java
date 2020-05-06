package edu.eci.cvds.vista;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "buscarBean")
@ViewScoped
public class BuscarBean extends BasePageBean{
		@Inject
	    private Servicios servicios;


		private List<Iniciativa> iniciativasBuscadas=null;

		public void buscar(String palabras) {
			try {
				iniciativasBuscadas=servicios.consultarIniciativaXPalabraClave(palabras);
			}catch(ServiciosException e) {
			}
		}

		public List<Iniciativa> getIniciativasBuscadas() {
			return iniciativasBuscadas;
		}

		public void setIniciativasBuscadas(List<Iniciativa> iniciativasBuscadas) {
			this.iniciativasBuscadas = iniciativasBuscadas;
		}





}
