package edu.eci.cvds.entidades;


import java.io.Serializable;

public class Usuario implements Serializable{
	

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private String tipoUsuario;
	private String contrasena;
	
	public Usuario() {
	}
	
	public Usuario(int id, String nombre, String apellido, String email, int telefono, String tipoUsuario, String contrasena) {
		this.id=id;
		this.apellido=apellido;
		this.email=email;
		this.telefono=telefono;
		this.tipoUsuario=tipoUsuario;
		this.contrasena=contrasena;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}