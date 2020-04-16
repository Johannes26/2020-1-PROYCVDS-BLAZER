package edu.eci.cvds.tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.util.List;


import org.apache.ibatis.session.SqlSession;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.entidades.Iniciativa;
import edu.eci.cvds.servicios.*;

import org.junit.Assert;
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
    public void deberiaIniciarSesion() {
    	try {
    		Boolean a=servicios.validarUsuario("johann.bogota@mail.escuelaing.edu.co", "1234");
    		assertTrue(a);
    	}catch(ServiciosException e) {
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
    		assertEquals(servicios.consultarUsuario("johann.bogota@mail.escuelaing.edu.co").getId(),ini.getusuarioProponente().getId());
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
    		servicios.cambiarEstadoIniciativa(1,"En revisión");
    		Iniciativa a=servicios.consultarIniciativa(1);
    		assertEquals(a.getestado(),"En revisión");
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    

}