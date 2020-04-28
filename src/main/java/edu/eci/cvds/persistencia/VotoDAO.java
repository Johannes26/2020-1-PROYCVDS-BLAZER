package edu.eci.cvds.persistencia;


import java.util.List;

import edu.eci.cvds.entidades.Voto;

public interface VotoDAO {
	
	public void insertarVoto(Voto u) throws PersistenciaException;
	
	public void quitarVoto(Voto u) throws PersistenciaException;
	
	public int contarVotosIniciativa(int num_iniciativa) throws PersistenciaException;
	
	public int tieneVotos(int num_iniciativa,int id_usuario) throws PersistenciaException;
	
	public List<Voto> consultarVotos() throws PersistenciaException;

}
