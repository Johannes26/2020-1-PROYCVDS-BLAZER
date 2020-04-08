
package edu.eci.cvds.persistencia.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.cvds.persistencia.DaoIniciativa;
import edu.eci.cvds.persistencia.PersistenceException;
import edu.eci.cvds.persistencia.mybatisimpl.mappers.IniciativaMapper;

import java.util.List;


public class MyBatisDAOIniciativa implements DaoIniciativa {
    @Inject
    private IniciativaMapper IniciativaMapper;
}
