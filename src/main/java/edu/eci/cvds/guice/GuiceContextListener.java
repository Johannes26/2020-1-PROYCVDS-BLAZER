package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.persistencia.ComentarioDAO;
import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.IniciativaPalabraDAO;
import edu.eci.cvds.persistencia.IniciativasRelacionadasDAO;
import edu.eci.cvds.persistencia.PalabrasClaveDao;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.VotoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisComentarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisDAOIniciativa;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisIniciativaPalabraDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisIniciativasRelacionadasDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisPalabrasClaveDao;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisVotoDAO;
import edu.eci.cvds.servicios.Servicios;
import edu.eci.cvds.servicios.impl.ServiciosImpl;
import edu.eci.cvds.vista.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(DaoIniciativa.class).to(MyBatisDAOIniciativa.class);
                bind(BasePageBean.class).to(PrincipalBean.class);
                bind(Servicios.class).to(ServiciosImpl.class);
                bind(PalabrasClaveDao.class).to(MyBatisPalabrasClaveDao.class);
                bind(VotoDAO.class).to(MyBatisVotoDAO.class);
                bind(ComentarioDAO.class).to(MyBatisComentarioDAO.class);
                bind(IniciativaPalabraDAO.class).to(MyBatisIniciativaPalabraDAO.class);
                bind(IniciativasRelacionadasDAO.class).to(MyBatisIniciativasRelacionadasDAO.class);

            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}