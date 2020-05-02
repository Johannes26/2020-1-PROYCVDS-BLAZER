package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Comentario implements Serializable{
	
	int idComentario;
	String descripcion;
	Date FechaRegistro;
	Iniciativa ini;
	Usuario usu;
	
	public Comentario() {}
	
	public Comentario(int idComentario, String descripcion, Date FechaRegistro, Iniciativa ini, Usuario usu) {
		this.idComentario = idComentario;
		this.descripcion = descripcion;
		this.FechaRegistro = FechaRegistro;
		this.ini = ini;
		this.usu = usu;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public Iniciativa getIni() {
		return ini;
	}

	public void setIni(Iniciativa ini) {
		this.ini = ini;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", descripcion=" + descripcion + ", FechaRegistro="
				+ FechaRegistro + ", ini=" + ini + ", usu=" + usu + "]";
	}
	
	
	

}
