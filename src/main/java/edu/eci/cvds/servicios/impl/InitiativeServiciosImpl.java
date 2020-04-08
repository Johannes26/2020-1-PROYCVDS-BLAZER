package edu.eci.cvds.servicios.impl;


import com.google.inject.Inject;

import edu.eci.cvds.servicios.IniciativaServicios;
import edu.eci.cvds.servicios.ServiciosException;
import edu.eci.cvds.entidades.Usuario;
import edu.eci.cvds.persistencia.DaoUsuario;


public class InitiativeServiciosImpl implements IniciativaServicios {

	@Inject
    private DaoUsuario daoUser;


	@Override
	public void createUser(Usuario user) throws ServiciosException {
		// TODO Auto-generated method stub
	}

}
