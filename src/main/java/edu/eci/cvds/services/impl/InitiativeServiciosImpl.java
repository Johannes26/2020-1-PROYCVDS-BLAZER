package edu.eci.cvds.services.impl;


import com.google.inject.Inject;

import edu.eci.cvds.services.IniciativaServicios;
import edu.eci.cvds.services.ServiciosException;
import edu.eci.entities.Usuario;
import edu.eci.persistence.DaoUsuario;

public class InitiativeServiciosImpl implements IniciativaServicios {

	@Inject
    private DaoUsuario daoUser;


	@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}

}
