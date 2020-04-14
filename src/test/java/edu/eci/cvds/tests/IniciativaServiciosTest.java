package edu.eci.cvds.tests;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.apache.ibatis.session.SqlSession;
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

    	}catch(Exception e) {

    		System.out.println(e.getMessage());
    		fail();

    	}

    }

}

