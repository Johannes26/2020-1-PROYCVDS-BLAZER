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
	    	Iniciativa ini = new Iniciativa("Segunda iniciativa",u);
	    	servicios.registrarIniciativa(ini,"segun");
	    	assertTrue(servicios.consultarIniciativas().size()==3);
	    	
		} catch (ServiciosException e) {
			fail("error"+e.getMessage());
		}
    }

    
    @Test
    public void deberiaConsultarUsuarios() {
    	try {
    		List<Usuario> a= servicios.consultarUsuarios();
    		assertTrue(a.size()==4);
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
            assertTrue(a.size()==2);
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
    public void deberiaContarIniciativasPorArea() {
        try {
        	int b = servicios.consultarIniciativasPorArea("sistemas");
            assertEquals(b,1);
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    @Test
    public void deberiaConsultarAreas() {
        try {
            assertEquals(servicios.consultarAreas().size(),3);
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    @Test
    public void deberiaCambiarEstadoIniciativa() {
    	try {
    		servicios.cambiarEstadoIniciativa(1,"En revision");
    		Iniciativa a=servicios.consultarIniciativa(1);
    		assertEquals(a.getEstado(),"En revision");
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
	    	Iniciativa ini = new Iniciativa("Tercera Iniciativa",u);
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
	    	Iniciativa ini = new Iniciativa("Tercera iniciativa",u);
	    	servicios.registrarIniciativa(ini,"");
	    	servicios.insertarVoto(2158130, 3);
    		servicios.insertarVoto(2157826, 3);
    		assertTrue(servicios.contarVotos(3)==2);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
 
    @Test
    public void deberiaInsertarComentario() {
    	try {
    		Usuario g = servicios.consultarUsuario("guillermo.bernal@mail.escuelaing.edu.co");
	    	Iniciativa ini4 = new Iniciativa("Cuarta iniciativa",g);
	    	servicios.registrarIniciativa(ini4,"");
	    	Iniciativa ini4_1 = servicios.consultarIniciativa(2);
	    	servicios.agregarComentario("fgh", ini4_1, g);
	    	assertTrue(servicios.consultarComentarios().get(0).getDescripcion()=="fgh" && 
	    			servicios.consultarComentarios().get(0).getIdComentario()==1);
    		//assertTrue(servicios.contarVotos(1)==0);
    		//assertTrue(servicios.contarVotos(3)==2);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    

    @Test
    public void deberiaModificarIni() {
    	try {
    		Iniciativa i = servicios.consultarIniciativa(1);
    		servicios.cambiarDatosIniciativa(i, "cambiar descripcion iniciativa");
    		assertTrue(servicios.consultarIniciativa(1).getDescripcion()=="cambiar descripcion iniciativa");
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
  
    @Test
    public void deberiaConsultarIniciativasPorEstado(){
        try{

            servicios.cambiarEstadoIniciativa(1,"En revision");
            assertEquals(servicios.consultarIniciativasPorEstado("En revision").size(),1);
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    @Test
    public void deberiaConsultarIniciativasXUsuario(){
        try{
        	List<Iniciativa> inis = servicios.consultarIniciativaXUsuario(2158130);
        	List<Iniciativa> inis2 = servicios.consultarIniciativaXUsuario(2155042);
        	assertEquals(inis.size(),1);
        	assertEquals(inis2.size(),1);
        	
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    @Test
    public void deberiaConsultarComentariosXiniciativa(){
        try{
        	assertEquals(servicios.consultarComentariosXIniciativa(2).get(0).getIdComentario(),1);
        	assertEquals(servicios.consultarComentariosXIniciativa(2).get(0).getIni().getNum(),2);
        }catch(ServiciosException e) {
            fail("error"+e.getMessage());
        }
    }
    
    

}