package edu.eci.cvds.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;

import com.google.inject.Inject;

import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.ServiciosException;

@SuppressWarnings("deprecation")
@ManagedBean(name = "agruparBean")
@ViewScoped
public class AgruparBean extends BasePageBean{
	
	@Inject
    private Servicios servicios;
	
	private List<Iniciativa> iniciativas;
	private List<Iniciativa> iniciativasArrastradas;
	
	
	public void inicializar()  {
		try {
			iniciativas=servicios.consultarIniciativas();
			iniciativasArrastradas=new ArrayList<>();
		} catch (ServiciosException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciativaArrastrada(DragDropEvent ddEvent) {
        Iniciativa iniciativa = (Iniciativa) ddEvent.getData();
  
        iniciativasArrastradas.add(iniciativa);
        iniciativas.remove(iniciativa);
    }

	public List<Iniciativa> getIniciativas() {
		return iniciativas;
	}


	public List<Iniciativa> getIniciativasArrastradas() {
		return iniciativasArrastradas;
	}

	public void agruparIniciativas(String descripcion)  {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
			for(int x=0;x<iniciativasArrastradas.size()-1;x++) {
				for(int y=x+1;y<iniciativasArrastradas.size();y++) {
					Iniciativa ini1=iniciativasArrastradas.get(x);
					Iniciativa ini2=iniciativasArrastradas.get(y);
					try {
						servicios.insertarIniciativaRelacionada(ini1.getNum(), ini2.getNum(), descripcion);	
						facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se ha relacionado "+
								ini1.getNum()+" y "+ini2.getNum()));
					} catch (ServiciosException e) {
						facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso",e.getMessage()));
					}
				}
			}
	}
 

}
