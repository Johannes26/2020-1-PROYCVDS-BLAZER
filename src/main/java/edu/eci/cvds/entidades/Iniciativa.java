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
	private List<IniciativasRelacionadas> iniciativasRelacionadas;


	public Iniciativa(){
	}

	public Iniciativa(int num, String descripcion, Usuario usuarioproponente,List<IniciativaPalabra> iniciativasPalabras,Date fechaRegistro,String estado) {
		this.num=num;
		this.descripcion=descripcion;
		this.usuarioproponente=usuarioproponente;
		this.iniciativasPalabras=iniciativasPalabras;
		this.fechaRegistro=fechaRegistro;
		this.estado=estado;
	}
	
	public Iniciativa(String descripcion, Usuario usuarioproponente) {
		this.descripcion=descripcion;
		this.usuarioproponente=usuarioproponente;
		iniciativasPalabras=new ArrayList<IniciativaPalabra>();
	}
	
	
	public Iniciativa(int num, String descripcion, Usuario usuarioproponente,
			List<IniciativaPalabra> iniciativasPalabras, Date fechaRegistro, String estado,
			 List<IniciativasRelacionadas> iniciativasRelacionadas) {
		this.num = num;
		this.descripcion = descripcion;
		this.usuarioproponente = usuarioproponente;
		this.iniciativasPalabras = iniciativasPalabras;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.iniciativasRelacionadas = iniciativasRelacionadas;
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

	public List<IniciativasRelacionadas> getIniciativasRelacionadas() {
		return iniciativasRelacionadas;
	}

	public void setIniciativasRelacionadas(List<IniciativasRelacionadas> iniciativasRelacionadas) {
		this.iniciativasRelacionadas = iniciativasRelacionadas;
	}
	
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Iniciativa [num=" + num + ", descripcion=" + descripcion + ", usuarioproponente=" + usuarioproponente
				+ ", iniciativasPalabras=" + iniciativasPalabras + ", fechaRegistro=" + fechaRegistro + ", estado="
				+ estado + ", iniciativasRelacionadas=" + iniciativasRelacionadas + "]";
	}




}
