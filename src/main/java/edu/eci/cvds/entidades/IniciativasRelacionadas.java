package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;

public class IniciativasRelacionadas implements Serializable{
	
	private int numIniciativa1;
	private int numIniciativa2;
	private Date fechaCreacion;
	private String descripcion;
	private Iniciativa iniciativaRelacionada;
	

	public IniciativasRelacionadas() {}
	
	public IniciativasRelacionadas(int numIniciativa1, int numIniciativa2, String descripcion,
			Iniciativa iniciativaRelacionada) {
		
		this.numIniciativa1 = numIniciativa1;
		this.numIniciativa2 = numIniciativa2;
		this.descripcion = descripcion;
		this.iniciativaRelacionada = iniciativaRelacionada;
	}


	public int getNumIniciativa1() {
		return numIniciativa1;
	}


	public void setNumIniciativa1(int numIniciativa1) {
		this.numIniciativa1 = numIniciativa1;
	}


	public int getNumIniciativa2() {
		return numIniciativa2;
	}


	public void setNumIniciativa2(int numIniciativa2) {
		this.numIniciativa2 = numIniciativa2;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Iniciativa getIniciativaRelacionada() {
		return iniciativaRelacionada;
	}


	public void setIniciativaRelacionada(Iniciativa iniciativaRelacionada) {
		this.iniciativaRelacionada = iniciativaRelacionada;
	}


	@Override
	public String toString() {
		return "IniciativasRelacionadas [numIniciativa1=" + numIniciativa1 + ", numIniciativa2=" + numIniciativa2
				+ ", fechaCreacion=" + fechaCreacion + ", descripcion=" + descripcion + ", iniciativaRelacionada="
				+ iniciativaRelacionada + "]";
	}
	
	
	
	
}
