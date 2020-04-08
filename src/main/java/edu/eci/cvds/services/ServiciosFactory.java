package edu.eci.cvds.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Injector;


import static com.google.inject.Guice.createInjector;

public class ServiciosFactory {

	    private static ServiciosFactory instance = new ServiciosFactory();

	    private static Injector injector;
	    private static Injector testingInjector;

	    private ServiciosFactory() {
	        injector = createInjector(new XMLMyBatisModule() {

	            @Override
	            protected void initialize() {
	                install(JdbcHelper.MySQL);
	                setClassPathResource("mybatis-config.xml");
	                
	                //binds

	            }

	        }
	        );

	        testingInjector = createInjector(new XMLMyBatisModule() {

	            @Override
	            protected void initialize() {
	                install(JdbcHelper.MySQL);
	                setClassPathResource("mybatis-config-h2.xml");
	                //binds
	            }

	        }
	        );

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

	}