package edu.eci.cvds.servicios;

import com.google.inject.Injector;

import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;

import edu.eci.cvds.servicios.impl.IniciativaServiciosImpl;

import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosFactory {

    private static ServiciosFactory instance = new ServiciosFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                //bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(IniciativaServicios.class).to(IniciativaServiciosImpl.class);
   
            }
        });
    }
    private ServiciosFactory(){
        optInjector = Optional.empty();
    }

    public IniciativaServicios getServiciosBancoProyectos(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(IniciativaServicios.class);
    }


    public IniciativaServicios getServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(IniciativaServicios.class);
    }


    public static ServiciosFactory getInstance(){
        return instance;
    }

}