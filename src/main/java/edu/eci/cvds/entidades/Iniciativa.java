package edu.eci.cvds.entidades;

import java.io.Serializable;
import java.sql.Date;

public class Iniciativa implements Serializable {


	private int num;
	private String descripcion;
	private Usuario usuarioProponente;
	private String palabrasClave;
	private Date fechaRegistro;
	private String estado;
	private String areaProponente;
	
		
	public Iniciativa() {
	}
	
	public Iniciativa(int num, String descripcion, Usuario usuarioProponente, String tipoProponente,String palabrasClave,Date fechaRegistro,String estado,String areaProponente) {
		this.num=num;
		this.descripcion=descripcion;
		this.usuarioProponente=usuarioProponente;
		this.palabrasClave=palabrasClave;
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
		return "Iniciativa [num=" + num + ", descripcion=" + descripcion + ", usuarioProponente=" + usuarioProponente
				+ ", palabrasClave=" + palabrasClave + ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", areaProponente"+ areaProponente + "]";
	}
}
