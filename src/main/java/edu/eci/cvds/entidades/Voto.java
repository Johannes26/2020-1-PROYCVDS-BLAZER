package edu.eci.cvds.entidades;

import java.io.Serializable;

public class Voto implements Serializable{
	
	int id_usuario;
	int num_iniciativa;
	
	public Voto() {}
	
	public Voto(int id_usuario, int num_iniciativa) {
		this.id_usuario = id_usuario;
		this.num_iniciativa = num_iniciativa;
	}
	public int getUsuario() {
		return id_usuario;
	}

	public void setUsuario(int usuario) {
		this.id_usuario = usuario;
	}

	public int getIniciativa() {
		return num_iniciativa;
	}

	public void setIniciativa(int iniciativa) {
		this.num_iniciativa = iniciativa;
	}

	@Override
	public String toString() {
		return "Voto [usuario=" + id_usuario + ", iniciativa=" + num_iniciativa + "]";
	}
	
	

}
