package edu.eci.cvds.tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.session.SqlSession;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.entidades.PalabrasClave;
import edu.eci.cvds.servicios.*;

import org.junit.Before;
import org.junit.Test;
import com.google.inject.Inject;



public class IniciativaServiciosTest {

	@Inject
    private SqlSession sqlSession;
	
	private Servicios servicios;

    public IniciativaServiciosTest() {

    	servicios=ServiciosFactory.getInstance().getServiciosTesting();

    }

    

    @Test
    public void deberiaValidarUsuarioExistente() {
    	Boolean a;
    	try {
    		a = servicios.validarUsuario("johann.bogota@mail.escuelaing.edu.co", "1234");
    		assertTrue(a);
    		a = servicios.validarUsuario("johann.bogota@mail.escuelaing.edu.co", "0000");
    		assertTrue(!a);
    		a = servicios.validarUsuario("johann.bogota@mail.escuelaing.edu.co", "78888");
    		assertTrue(!a);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaValidarUsuarioNoExistente() {
    	try {
    		servicios.validarUsuario("otro@gmail.com", "111");
    		fail("error");
    	}catch(ServiciosException e) {
    		assertTrue(true);
    	}
    }
    
  @Test
    public void deberiaCrearIniciativa() {
    	Usuario u;
		try {
			u = servicios.consultarUsuario("johan.Guerrero@mail.escuelaing.edu.co");
	    	Iniciativa ini = new Iniciativa("Segunda iniciativa",u,"Administrador");
	    	servicios.registrarIniciativa(ini,"segun");
	    	assertTrue(servicios.consultarIniciativas().size()==2);
	    	
		} catch (ServiciosException e) {
			fail("error"+e.getMessage());
		}
    }

    
    @Test
    public void deberiaConsultarUsuarios() {
    	try {
    		List<Usuario> a= servicios.consultarUsuarios();
    		assertTrue(a.size()==2);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    
    @Test
    public void deberiaConsultarIniciativa() {
    	try {
    		Iniciativa ini = servicios.consultarIniciativa(0001);
    		assertEquals(servicios.consultarUsuario("johann.bogota@mail.escuelaing.edu.co").getId(),ini.getUsuarioproponente().getId());
    		
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }

    @Test
    public void deberiaConsultarIniciativas() {
        try {
            List<Iniciativa> a= servicios.consultarIniciativas();
            assertTrue(a.size()==1);
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    @Test
    public void deberiaCambiarRolUsuario() {
    	try {
    		servicios.cambiarRol(2158130, "Administrador");
    		Usuario a=servicios.consultarUsuario("johann.bogota@mail.escuelaing.edu.co");
    		assertEquals(a.getTipoUsuario(),"Administrador");
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaCambiarEstadoIniciativa() {
    	try {
    		servicios.cambiarEstadoIniciativa(1,"En revision");
    		Iniciativa a=servicios.consultarIniciativa(1);
    		assertEquals(a.getestado(),"En revision");
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaInsertarPalabraClave(){
    	try {
    		List<PalabrasClave> a=new ArrayList<PalabrasClave>();
    		a.add(new PalabrasClave("aaa"));
    		servicios.registrarPalabras(a);
    		assertEquals(servicios.consultarPalabraClave("aaa").getId(),1);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaConsultarIniciativaXPalabraClave() {
    	try {
    		Usuario u = servicios.consultarUsuario("johan.Guerrero@mail.escuelaing.edu.co");
	    	Iniciativa ini = new Iniciativa("Tercera Iniciativa",u,"Area Administrativa");
	    	servicios.registrarIniciativa(ini,"precio,elevado");
    		List<Iniciativa> i=servicios.consultarIniciativaXPalabraClave("precio,elevado");
    		assertTrue(i.size()==1);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    	
    }
    		
    @Test
    public void deberiaInsertarVoto(){
    	try {

    		//System.out.println(servicios.consultarVotos());
    		servicios.insertarVoto(2158130, 1);
    		assertTrue(servicios.consultarUsuario("johann.bogota@mail.escuelaing.edu.co").getLikes().size()==1);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaElimnarVoto() {
    	try {
    		servicios.quitarVoto(2158130, 1);
    		assertTrue(servicios.consultarUsuario("johann.bogota@mail.escuelaing.edu.co").getLikes().size()==1);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void NodeberiaInsertarDosVoto(){
    	try {
    		servicios.insertarVoto(2158130, 2);
    		servicios.insertarVoto(2158130, 2);
    		assertTrue(false);
    	}catch(ServiciosException e) {
    		assertTrue(true);
    	}
    }
    
    
    
    @Test
    public void deberiaContarVotosXIniciativa() {
    	try {
    		Usuario u = servicios.consultarUsuario("johan.Guerrero@mail.escuelaing.edu.co");
	    	Iniciativa ini = new Iniciativa("Tercera iniciativa",u,"Administrador");
	    	servicios.registrarIniciativa(ini,"");
	    	servicios.insertarVoto(2158130, 3);
    		servicios.insertarVoto(2157826, 3);
    		//assertTrue(servicios.contarVotos(1)==0);
    		assertTrue(servicios.contarVotos(3)==2);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    
    
}