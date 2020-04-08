package edu.eci.cvds.entidades;

import java.io.Serializable;

public class Iniciativa implements Serializable {


	private int num;
	private String descripcion;
	private Usuario usuarioProponente;
	private String palabrasClave;
		
	public Iniciativa() {
	}
	
	public Iniciativa(int num, String descripcion, Usuario usuarioProponente, String tipoProponente,String palabrasClave) {
		this.num=num;
		this.descripcion=descripcion;
		this.usuarioProponente=usuarioProponente;
		this.palabrasClave=palabrasClave;
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

	public Usuario getUsuarioProponente() {
		return usuarioProponente;
	}

	public void setUsuarioProponente(Usuario usuarioProponente) {
		this.usuarioProponente = usuarioProponente;
	}


	public String getPalabrasClave() {
		return palabrasClave;
	}

	public void setPalabrasClave(String palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
	@Override
	public String toString() {
		return "Iniciativa [num=" + num + ", descripcion=" + descripcion + ", usuarioProponente=" + usuarioProponente
				+ ", palabrasClave=" + palabrasClave + "]";
	}
}
