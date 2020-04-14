package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;

import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.impl.IniciativaServiciosImpl;
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
                bind(BasePageBean.class).to(PrincipalBean.class);
                bind(IniciativaServicios.class).to(IniciativaServiciosImpl.class);

            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}