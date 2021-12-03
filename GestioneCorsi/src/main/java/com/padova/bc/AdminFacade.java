package com.padova.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsi;
import com.padova.architecture.model.Corsista;
import com.padova.architecture.model.CorsoCorsista;
import com.padova.architecture.model.Docenti;

public class AdminFacade {
	private static AdminFacade istanza;

	private AdminFacade() {

	}

	public static AdminFacade getInstance() { // singleton
		if (istanza == null) {
			istanza = new AdminFacade();
		}
		return istanza;
	}

	// ---------------------------DOCENTI---------

	public Docenti[] getDocenti() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		DocentiBC dBC = new DocentiBC();
		return dBC.getDocenti();
	}

	public Docenti getDocenteById(Docenti docente)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		DocentiBC dBC = new DocentiBC();
		return dBC.getDocentiById(docente);
	}

	// ---------------------------CORSI---------

	public void deleteCorso(long id)
			throws DAOException, FileNotFoundException, ClassNotFoundException, IOException {
		CorsiBC cBC = new CorsiBC();
		cBC.delete(id);
	}

	public Corsi[] getCorsi() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsiBC cBC = new CorsiBC();
		return cBC.getCorsi();
	}

	public Corsi getCorsoById(long id)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsiBC cBC = new CorsiBC();
		return cBC.getCorsoById(id);
	}

	// ---------------------------CORSICORSISTI---------

	public void createCorsoCorsista(CorsoCorsista cc)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		ccBC.create(cc);
	}

	public void deleteCorsoCorsista(CorsoCorsista cc)
			throws DAOException, FileNotFoundException, ClassNotFoundException, IOException {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		ccBC.delete(cc);
	}
	

	// ---------------------------CORSISTI---------

	public void createCorsista(Corsista corsista)
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		cBC.createCosista(corsista);
	}

	public void deleteCorsista(Corsista corsista)
			throws DAOException, FileNotFoundException, ClassNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		cBC.deleteCosista(corsista);
	}
	
	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		CorsistaBC cBC = new CorsistaBC();
		return cBC.getCosisti();
	}


	// ---------------------------STATISTICHE--------
	
	public String getCorsoFrequentato()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		StatisticheBC cfBC = new StatisticheBC();
		return cfBC.getCorsoFrequentato();
	}
	
	public Date getDataInizioUltimoCorso()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		StatisticheBC cfBC = new StatisticheBC();
		return cfBC.getDataInizioUltimoCorso();
	}
	
	public float getDurataMediaCorsi()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		StatisticheBC cfBC = new StatisticheBC();
		return cfBC.getDurataMediaCorsi();
	}
	
	public String getDocenteTipologie()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		StatisticheBC cfBC = new StatisticheBC();
		return cfBC.getDocenteTipologie();
	}
	
	public String getCorsiPostiDispionibli()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		StatisticheBC cfBC = new StatisticheBC();
		return cfBC.getCorsiPostiDispionibli();
	}
}
