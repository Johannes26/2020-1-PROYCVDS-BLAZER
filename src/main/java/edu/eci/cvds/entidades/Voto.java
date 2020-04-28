package edu.eci.cvds.entidades;

import java.io.Serializable;

public class Voto implements Serializable{
	
	int id;
	int id_usuario;
	int num_iniciativa;
	Iniciativa ini;
	
	public Voto() {}
	
	public Voto(int id_usuario, int num_iniciativa) {
		this.id_usuario = id_usuario;
		this.num_iniciativa = num_iniciativa;
	}


	public Iniciativa getIni() {
		return ini;
	}

	public void setIni(Iniciativa ini) {
		this.ini = ini;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ini=" + ini + "]";
	}



	

	
	
	
	

}
