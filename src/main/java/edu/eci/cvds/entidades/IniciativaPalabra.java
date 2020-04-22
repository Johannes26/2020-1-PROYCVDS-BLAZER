package edu.eci.cvds.entidades;

public class IniciativaPalabra {
	
	private int id;
	private int idIniciativa;
	private int idPalabraClave;
	private PalabrasClave palabra;
	
	public IniciativaPalabra(int idIniciativa, int idPalabraClave) {
		this.idIniciativa=idIniciativa;
		this.idPalabraClave=idPalabraClave;
	}
	
	public IniciativaPalabra() {
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdIniciativa() {
		return idIniciativa;
	}

	public void setIdIniciativa(int idIniciativa) {
		this.idIniciativa = idIniciativa;
	}

	public int getIdPalabraClave() {
		return idPalabraClave;
	}

	public void setIdPalabraClave(int idPalabraClave) {
		this.idPalabraClave = idPalabraClave;
	}
	
	
	
	
	public PalabrasClave getPalabra() {
		return palabra;
	}

	public void setPalabra(PalabrasClave palabra) {
		this.palabra = palabra;
	}

	@Override
	public String toString() {
		return "IniciativaPalabra [id=" + id + ", idIniciativa=" + idIniciativa + ", idPalabraClave=" + idPalabraClave
				+ ", palabra=" + palabra + "]";
	}

	


	
	
	
}
