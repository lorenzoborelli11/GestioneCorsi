package com.padova.architecture.dao;

public interface DAOConstants {
	//--------DOCENTI--------
	String SELECT_DOCENTI_BY_ID = "Select * from docenti where coddocente = ?";
	String SELECT_DOCENTI = "Select * from docenti";
	
	//--------CORSI--------
	String SELECT_CORSI = "select * from corsi";
	String DELETE_CORSI = "delete from corsi where codcorso = ?";
	String SELECT_CORSI_BY_ID = "select * from corsi where codcorso = ?";
	String SELECT_DATAINIZIOCORSO = "select max(datainiziocorso) from corsi";

	//--------CORSICORSISTI--------
	String SELECT_CORSO_CORSISTA_BY_ID = "select * from corsocorsista where IDCORSO=?";
	String SELECT_CORSO_CORSISTA = "Select * from corsocorsista";
	String DELETE_CORSO_CORSISTA = "delete from corsocorsista where IDCORSI=?";
	String INSERT_CORSO_CORSISTA = "Insert into corsocorsista values(?,?,?)";
	
	//--------CORSISTI--------
	String SELECT_CORSISTI = "Select * from corsisti";
	String SELECT_CORSISTI_BY_ID = "Select * from corsisti where codcorsista = ?";
	String DELETE_CORSISTI = "Delete from corsisti where codcorsista = ?";

	
	//--------AMMINISTRATORI--------
	String SELECT_ADMINPASS = "Select codadmin from amministratore where nomeadmin = ?";
	
	//--------STATISTICHE--------
	
	
	//--------SEQUENZE--------
	String SELECT_CORSISTA_SEQ = "Select corsisti_seq.nextval from dual";
	String SELECT_CORSO_SEQ = "Select corsi_seq.nextval from dual";
}


