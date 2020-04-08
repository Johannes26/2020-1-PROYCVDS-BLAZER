
package edu.eci.persistence.mybatisimpl;

import com.google.inject.Inject;

import edu.eci.persistence.DaoIniciativa;
import edu.eci.persistence.PersistenceException;
import edu.eci.persistence.mybatisimpl.mappers.IniciativaMapper;

import java.util.List;


public class MyBatisDAOIniciativa implements DaoIniciativa {
    @Inject
    private IniciativaMapper IniciativaMapper;
}
