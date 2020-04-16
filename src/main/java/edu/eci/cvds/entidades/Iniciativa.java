package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Iniciativa implements Serializable {


	private int num;
	private String descripcion;
	private Usuario usuarioproponente;
	private String palabrasclave;
	private Date fechaRegistro;
	private String estado;
	private String areaProponente;


	public Iniciativa() {
	}

	public Iniciativa(int num, String descripcion, Usuario usuarioproponente,String palabrasClave,Date fechaRegistro,String estado,String areaProponente) {
		this.num=num;
		this.descripcion=descripcion;
		this.usuarioproponente=usuarioproponente;
		this.palabrasclave=palabrasClave;
		this.fechaRegistro=fechaRegistro;
		this.estado=estado;
		this.areaProponente=areaProponente;
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

	public Usuario getusuarioProponente() {
		return usuarioproponente;
	}

	public void setusuarioProponente(Usuario usuarioProponente) {
		this.usuarioproponente = usuarioProponente;
	}


	public String getPalabrasClave() {
		return palabrasclave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasclave = palabrasClave;
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
		return "Iniciativa [num=" + num + ", descripcion=" + descripcion + ", usuarioProponente=" + usuarioproponente
				+ ", palabrasClave=" + palabrasclave + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", areaProponente"+ areaProponente + "]";
	}
}
