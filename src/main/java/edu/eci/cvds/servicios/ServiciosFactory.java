package edu.eci.cvds.servicios;

import com.google.inject.Injector;

import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.VotoDAO;
import edu.eci.cvds.persistencia.PalabrasClaveDao;
import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisVotoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisPalabrasClaveDao;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisIniciativaPalabraDAO;


import edu.eci.cvds.servicios.impl.ServiciosImpl;
import edu.eci.cvds.vista.AdministradorBean;
import edu.eci.cvds.vista.BasePageBean;

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
                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(PalabrasClaveDao.class).to(MyBatisPalabrasClaveDao.class);
                bind(IniciativaPalabraDAO.class).to(MyBatisIniciativaPalabraDAO.class);
                bind(VotoDAO.class).to(MyBatisVotoDAO.class);
                bind(Servicios.class).to(ServiciosImpl.class);
                bind(BasePageBean.class).to(AdministradorBean.class);
                
   
            }
        });
    }
    private ServiciosFactory(){
        optInjector = Optional.empty();
    }

    public Servicios getServicios(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(Servicios.class);
    }


    public Servicios getServiciosTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(Servicios.class);
    }


    public static ServiciosFactory getInstance(){
        return instance;
    }

}