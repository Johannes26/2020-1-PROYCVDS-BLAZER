package edu.eci.cvds.entidades;

public class Estadisticas {
	private String descripcion;
	private int cantidad;
	
	public Estadisticas(String descripcion, int cantidad) {
		super();
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "EstadisticaEstado [descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
	}
	
}
