package edu.eci.cvds.servicios;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;

import edu.eci.cvds.persistencia.DaoUsuario;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.cvds.servicios.impl.IniciativaServiciosImpl;



public class ServiciosFactory {

	    private static ServiciosFactory instance = new ServiciosFactory();
	    private static Injector injector;
	    private static Injector testingInjector;

	    private ServiciosFactory() {
	        injector = createInjector(new XMLMyBatisModule() {

	            @Override
	            protected void initialize() {
	                install(JdbcHelper.PostgreSQL);
	                setClassPathResource("mybatis-config.xml");
	                //binds
	                bind(IniciativaServicios.class).to(IniciativaServiciosImpl.class);
	                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
	                

	            }

	        }
	        );

	        /*testingInjector = createInjector(new XMLMyBatisModule() {

	            @Override
	            protected void initialize() {
	                install(JdbcHelper.PostgreSQL);
	                setClassPathResource("mybatis-config-h2.xml");
	                //binds
	                bind(IniciativaServicios.class).to(IniciativaServiciosImpl.class);
	                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
	            }

	        }
	        );*/

	    }

	    public IniciativaServicios getInitiativeServices(){
	        return injector.getInstance(IniciativaServicios.class);   
	    }

	    public IniciativaServicios getInitiativeServicesForTesting(){
	        return testingInjector.getInstance(IniciativaServicios.class);   
	    }
	    
	    public static ServiciosFactory getInstance(){
	        return instance;
	    }
	    
	    public static void main(String a[]) throws ServiciosException {
	        System.out.println(ServiciosFactory.getInstance().getInitiativeServices().consultarUsuario(1));
	        System.out.println("sdasda");
	    }

	}