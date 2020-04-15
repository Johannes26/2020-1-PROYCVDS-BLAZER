package edu.eci.cvds.tests;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.servicios.*;
import org.junit.Test;
import com.google.inject.Inject;



public class IniciativaServiciosTest {

	@Inject
    private SqlSession sqlSession;
	
    private IniciativaServicios iniciativaServicios;

    public IniciativaServiciosTest() {

    iniciativaServicios=ServiciosFactory.getInstance().getServiciosTesting();

    }

    @Test
    public void deberiaIniciarSesion() {
    	try {
    		Boolean a=iniciativaServicios.validarUsuario("johann.bogota@mail.escuelaing.edu.co", "1234");
    		assertTrue(a);

    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    @Test
    public void deberiaConsultarUsuarios() {
    	try {
    		List<Usuario> a= iniciativaServicios.consultarUsuarios();
    		assertTrue(a.size()==2);
    	}catch(ServiciosException e) {
    		fail("error"+e.getMessage());
    	}
    }
    
    

}