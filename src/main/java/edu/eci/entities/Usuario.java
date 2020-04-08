package edu.eci.entities;

import java.io.Serializable;

public class Usuario implements Serializable{
	

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private String tipoUsuario;
	private String contraseña;
	
	public Usuario() {
	}
	
	public Usuario(int id, String nombre, String apellido, String email, int telefono, String tipoUsuario) {
		this.id=id;
		this.apellido=apellido;
		this.email=email;
		this.telefono=telefono;
		this.tipoUsuario=tipoUsuario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + "]";
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
