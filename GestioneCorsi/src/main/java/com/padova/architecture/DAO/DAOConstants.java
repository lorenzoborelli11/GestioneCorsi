package com.padova.architecture.DAO;

public interface DAOConstants {
	//--------DOCENTI--------
	String SELECT_DOCENTI_BY_ID = "Select * from docenti where coddocente = ?";
	String SELECT_DOCENTI = "Select * from docenti";
	
	//--------CORSI--------
	
	
	//--------CORSICORSISTI--------
	
	
	//--------CORSISTI--------
	String SELECT_CORSISTI = "Select * from corsisti";
	String SELECT_CORSISTI_BY_ID = "Select * from corsisti where codcorsista = ?";
	String DELETE_CORSISTI = "Delete from corsisti where codcorsista = ?";
	
	//--------AMMINISTRATORI--------
	
	
	//--------STATISTICHE--------
	
	
	//--------SEQUENZE--------
	String SELECT_CORSISTA_SEQ = "Select corsisti_seq.nextval from dual";
	String SELECT_CORSO_SEQ = "Select corsi_seq.nextval from dual";
}
