package edu.eci.cvds.servicios;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Voto;
import edu.eci.cvds.persistencia.PersistenciaException;
import edu.eci.cvds.entidades.Comentario;

import java.util.List;


import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.PalabrasClave;

public interface Servicios {

	//public abstract void createUser(Usuario user) throws ServiciosException;
	/**
	 * metodo que permite consultar el usuario en la base de datos
	 * @param email correo de un Usuario
	 * @return Usuario de acuerdo al correo
	 */
	public abstract  Usuario consultarUsuario(String email) throws ServiciosException;

	/**
	 * metodo que permite consultar la inciativa por medio de su identificador
	 * @param identificador identificador de la inciativa
	 * @return Iniciativa
	 */
	public abstract Iniciativa consultarIniciativa(int num) throws ServiciosException;

	/**
	 * metodo que permite contar iniciativas por area 
	 * @param area nombre del area
	 * @return int numero de iniciativas por area
	 */
	public abstract int consultarIniciativasPorArea(String area) throws ServiciosException;
	
	/**
	 * metodo que permite crear una inciativa
	 * @param i a insertar
	 */
	public abstract void registrarIniciativa(Iniciativa i, String palabrasclave) throws ServiciosException;
	/**
	 * valida si el usuario se encuentra en la base de datos
	 * @param email email del usuario
	 * @param contrasena contrase�a del usuario
	 * @return booleano validando si existe
	 * @throws ServiciosException
	 */
	public abstract Boolean validarUsuario(String email, String contrasena)throws ServiciosException;
	/**
	 * consulta todos los usuarios en la base de datos
	 * @return lista de usuarios
	 * @throws ServiciosException
	 */
	public abstract List<Usuario> consultarUsuarios() throws ServiciosException;
	/**
	 * consultar todas las iniciativas
	 * @return lista de iniciativas
	 * @throws ServiciosException
	 */
	public abstract List<Iniciativa> consultarIniciativas() throws ServiciosException;
	/**
	 * camiar el rol a un usuario
	 * @param id id del usuario
	 * @param rol rol nuevo a cambiar
	 * @throws ServiciosException
	 */
	public abstract void cambiarRol(int id, String rol) throws ServiciosException;
	/**
	 * cambiar el estado de una inciativa
	 * @param num numero de inciativa
	 * @param estado estado nuevo que se le quiere poner
	 * @throws ServiciosException
	 */
	public abstract void cambiarEstadoIniciativa(int num, String estado) throws ServiciosException;
	/**
	 * consutar inciativas de acuerdo a una palabra clave
	 * @param PalabrasClave texto que contiene la palabra clave
	 * @return lista de inciativas con esa palabra
	 * @throws ServiciosException
	 */
	public abstract List<Iniciativa> consultarIniciativaXPalabraClave(String palabras) throws ServiciosException;
	
	
	public abstract void registrarPalabras(List<PalabrasClave> palabras) throws ServiciosException;
	
	
	public abstract PalabrasClave consultarPalabraClave(String descripcion) throws ServiciosException;
	

	public abstract List<PalabrasClave> consultarPalabrasClave() throws ServiciosException;
	
	public abstract void insertarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException;
	
	public abstract void quitarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException;
	
	public abstract int contarVotos(int num_Iniciativa) throws ServiciosException;
	

	public abstract void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,String descripcion) throws ServiciosException;


	public abstract boolean tieneVotos(int num_iniciativa,int id_usuario) throws ServiciosException;
	
	public abstract List<Voto> consultarVotos() throws ServiciosException;

	
	public abstract void registrarUsuario(int id, String nombre,String apellido,String email,
			int telefono,String tipoUsuario,String contrasena,String area) throws ServiciosException;
    
	public abstract Usuario consultarUsuarioXId(int num) throws ServiciosException;
	
	public abstract void agregarComentario(String descripcion, Iniciativa i, Usuario u) throws ServiciosException;
	
	public abstract List<Comentario> consultarComentarios() throws ServiciosException;
    
	public void cambiarDatosIniciativa(Iniciativa ini,String descripcion,String areaProponente) throws ServiciosException;
	
	public List<String> consultarAreas()throws ServiciosException;

}