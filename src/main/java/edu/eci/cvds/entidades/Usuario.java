package edu.eci.cvds.entidades;


import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable{
	

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private String tipoUsuario;
	private String contrasena;
	private String area;
	private List<Voto> likes;
	

	public Usuario() {
	}
	
	public Usuario(int id, String nombre, String apellido, String email, int telefono, String tipoUsuario, String contrasena,String area) {
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.telefono=telefono;
		this.tipoUsuario=tipoUsuario;
		this.contrasena=contrasena;
		this.area=area;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	public List<Voto> getLikes() {
		return likes;
	}

	public void setLikes(List<Voto> likes) {
		this.likes = likes;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + ", contrasena=" + contrasena + ", area="
				+ area + ", likes=" + likes + "]";
	}

	
	
}