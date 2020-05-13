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
     * metodo que permite consultar iniciativas por estado
     * @param esatdo estado de la iniciativa
     * @return Iniciativas con el estado dado
     */
    public abstract List<Iniciativa> consultarIniciativasPorEstado(String estado) throws ServiciosException;
    
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
	
	/**
	 * Metodo que registra palabras clave
	 * @param palabras palabra a registrar
	 * @throws ServiciosException
	 */
	public abstract void registrarPalabras(List<PalabrasClave> palabras) throws ServiciosException;
	
	/**
	 * Metodo que consulta una palabra clave
	 * @param descripcion descripcion de la palabra
	 * @return palabra clave
	 * @throws ServiciosException
	 */
	public abstract PalabrasClave consultarPalabraClave(String descripcion) throws ServiciosException;
	
	/**
	 * Metodo que consulta todas las palabras clave
	 * @return Lista de palabras clave
	 * @throws ServiciosException
	 */
	public abstract List<PalabrasClave> consultarPalabrasClave() throws ServiciosException;
	/**
	 * Metodo que inserta un voto
	 * @param id_Usuario identificaion del usuario
	 * @param num_Iniciativa identificaion de la iniciativa
	 * @throws ServiciosException
	 */
	public abstract void insertarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException;
	/**
	 * Metodo que quita un voto
	 * @param id_Usuario identificaion del usuario
	 * @param num_Iniciativa identifiacion de la inciativa
	 * @throws ServiciosException
	 */
	public abstract void quitarVoto(int id_Usuario, int num_Iniciativa) throws ServiciosException;
	/**
	 * Metodo que cuenta la cantidad de votos de una iniciativa
	 * @param num_Iniciativa identifaicion de la inciativa a buscar
	 * @return cantidad de votos
	 * @throws ServiciosException
	 */
	public abstract int contarVotos(int num_Iniciativa) throws ServiciosException;
	
	/**
	 * Metodo que inserta la relacion de dos inciativas
	 * @param numIniciativa1 identicacion iniciativa 1
	 * @param numIniciativa2 identifiacion iniciativa 2
	 * @param descripcion Texto de la realcion con la inictiva
	 * @throws ServiciosException
	 */
	public abstract void insertarIniciativaRelacionada(int numIniciativa1, int numIniciativa2,String descripcion) throws ServiciosException;

	/**
	 * Metodo que valida si un usuario solo tiene 1 voto
	 * @param num_iniciativa identificaion de la inciativa
	 * @param id_usuario identifiacion del usuario
	 * @return
	 * @throws ServiciosException
	 */
	public abstract boolean tieneVotos(int num_iniciativa,int id_usuario) throws ServiciosException;
	/**
	 * Metodo que consulta la informacion de los votos
	 * @return lista de votos
	 * @throws ServiciosException
	 */
	public abstract List<Voto> consultarVotos() throws ServiciosException;

	/**
	 * Metodo que registra un usuaio
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param telefono
	 * @param tipoUsuario
	 * @param contrasena
	 * @param area
	 * @throws ServiciosException
	 */
	public abstract void registrarUsuario(int id, String nombre,String apellido,String email,
			int telefono,String tipoUsuario,String contrasena,String area) throws ServiciosException;
    /**
     * Metodo que consulta el usario dado su ID
     * @param num identificaion del usuario
     * @return usuario
     * @throws ServiciosException
     */
	public abstract Usuario consultarUsuarioXId(int num) throws ServiciosException;
	/**
	 * Metodo que agrega un comentario
	 * @param descripcion Texto del comentario
	 * @param i identificacion de la inciativa
	 * @param u identificacion de usuario
	 * @throws ServiciosException
	 */
	public abstract void agregarComentario(String descripcion, Iniciativa i, Usuario u) throws ServiciosException;
	/**
	 * Metodo que consulta todos los comentarios
	 * @return lista de comentarios
	 * @throws ServiciosException
	 */
	public abstract List<Comentario> consultarComentarios() throws ServiciosException;
    /**
     * Metodo que actualiza los datos de un inicativa
     * @param ini identificaion de la iniativa
     * @param descripcion 
     * @throws ServiciosException
     */
	public void cambiarDatosIniciativa(Iniciativa ini,String descripcion) throws ServiciosException;
	/**
	 * Metodo que consulta todas las areas de los proponentes
	 * @return
	 * @throws ServiciosException
	 */
	public List<String> consultarAreas() throws ServiciosException;
	/**
	 * Metodo que consulta todas las inciativas de un usuario
	 * @param id identificaion del usuario
	 * @return lista de inciativas
	 * @throws ServiciosException
	 */
	public List<Iniciativa> consultarIniciativaXUsuario(int id) throws ServiciosException;

}