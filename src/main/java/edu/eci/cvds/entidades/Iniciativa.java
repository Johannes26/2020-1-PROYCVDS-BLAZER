package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Iniciativa implements Serializable {

	private int num;
	private String descripcion;
	private Usuario usuarioproponente;
	private List<IniciativaPalabra> iniciativasPalabras;
	private Date fechaRegistro;
	private String estado;
	private String areaProponente;


	public Iniciativa(){
	};

	public Iniciativa(int num, String descripcion, Usuario usuarioproponente,List<IniciativaPalabra> iniciativasPalabras,Date fechaRegistro,String estado,String areaProponente) {
		this.num=num;
		this.descripcion=descripcion;
		this.usuarioproponente=usuarioproponente;
		this.iniciativasPalabras=iniciativasPalabras;
		this.fechaRegistro=fechaRegistro;
		this.estado=estado;
		this.areaProponente=areaProponente;
	}
	
	public Iniciativa(String descripcion, Usuario usuarioproponente , String areaProponente) {
		this.descripcion=descripcion;
		this.usuarioproponente=usuarioproponente;
		this.areaProponente=areaProponente;
		iniciativasPalabras=new ArrayList<IniciativaPalabra>();
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuarioproponente() {
		return usuarioproponente;
	}

	public void setUsuarioproponente(Usuario usuarioproponente) {
		this.usuarioproponente = usuarioproponente;
	}

	public List<IniciativaPalabra> getIniciativasPalabras() {
		return iniciativasPalabras;
	}

	public void setIniciativasPalabras(List<IniciativaPalabra> iniciativasPalabras) {
		this.iniciativasPalabras = iniciativasPalabras;
	}

	public Date getfechaRegistro() {
		return fechaRegistro;
	}

	public void setfechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	public String getareaProponente() {
		return areaProponente;
	}

	public void setareaProponente(String areaProponente) {
		this.areaProponente = areaProponente;
	}

	@Override
	public String toString() {
		return "Iniciativa [num=" + num + ", descripcion=" + descripcion + ", usuarioproponente=" + usuarioproponente
				+ ", iniciativasPalabras=" + iniciativasPalabras + ", fechaRegistro=" + fechaRegistro + ", estado="
				+ estado + ", areaProponente=" + areaProponente + "]";
	}
	



}
