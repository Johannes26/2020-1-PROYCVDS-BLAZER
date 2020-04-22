package edu.eci.cvds.entidades;

public class PalabrasClave {
	
	private int id;
	private String descripcion;

	
	public PalabrasClave(){
	}
	
	public PalabrasClave (String descripcion) {
		this.descripcion=descripcion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "PalabrasClave [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	
}
