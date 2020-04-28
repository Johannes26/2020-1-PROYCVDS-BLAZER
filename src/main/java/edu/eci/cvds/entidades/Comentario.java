package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Comentario implements Serializable{
	
	int idComentario;
	String descripcion;
	Date FechaRegistro;
	int numIniciativa;
	int usuario;
	
	public Comentario() {}
	
	public Comentario(int idComentario, String descripcion, Date FechaRegistro, int numIniciativa, int usuario) {
		this.idComentario = idComentario;
		this.descripcion = descripcion;
		this.FechaRegistro = FechaRegistro;
		this.numIniciativa = numIniciativa;
		this.usuario = usuario;
	}
	public int getComentario() {
		return idComentario;
	}

	public void setComentario(int Comentario) {
		this.idComentario = Comentario;
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

	public void setFechaRegistro(Date FechaRegistro) {
		this.FechaRegistro = FechaRegistro;
	}
	
	public int getIniciativa() {
		return numIniciativa;
	}

	public void setIniciativa(int iniciativa) {
		this.numIniciativa = iniciativa;
	}
	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Comentario [Comentario=" + idComentario + ", descripcion=" + descripcion + ", FechaDeRegistro=" + FechaRegistro + ", Iniciativa=" + numIniciativa + ", Usuario=" + usuario + "]";
	}
	
	

}
