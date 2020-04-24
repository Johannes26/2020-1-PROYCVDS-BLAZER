package edu.eci.cvds.persistencia;



import org.h2.jdbc.JdbcSQLException;

import edu.eci.cvds.entidades.Voto;

public interface VotoDAO {
	
	public void insertarVoto(Voto u) throws PersistenciaException;
	
	public void quitarVoto(Voto u) throws PersistenciaException;
	
	public int contarVotosIniciativa(int num_iniciativa) throws PersistenciaException;
}
