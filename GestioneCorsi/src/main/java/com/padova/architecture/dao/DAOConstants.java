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
	String SELECT_MEDIACORSI = "select avg(to_date(datafinecorso, 'YYYY-MM-DD') - to_date(datainiziocorso, 'YYYY-MM-DD')) from corsi";
	
	//--------CORSICORSISTI--------
	String SELECT_CORSO_CORSISTA_BY_ID = "select * from corsocorsista where IDCORSO=?";
	String SELECT_CORSO_CORSISTA = "Select * from corsocorsista";
	String DELETE_CORSO_CORSISTA = "delete from corsocorsista where IDCORSI=?";
	String INSERT_CORSO_CORSISTA = "Insert into corsocorsista values(?,?,?)";
	String SELECT_MAXCORSI ="select corsi.nomecorso, count(*) from corsi, corsocorsista, corsisti where corsi.codcorso = corsocorsista.idcorsi and corsocorsista.idcorsisti = corsisti.codcorsista group by corsi.nomecorso having count(*) = (select max(count(*)) from corsi, corsisti, corsocorsista where corsi.codcorso = corsocorsista.idcorsi and corsocorsista.idcorsisti = codcorsista group by corsi.nomecorso)";

	//--------CORSISTI--------
	String SELECT_CORSISTI = "Select * from corsisti";
	String SELECT_CORSISTI_BY_ID = "Select * from corsisti where codcorsista = ?";
	String DELETE_CORSISTI = "Delete from corsisti where codcorsista = ?";
	String SELECT_CORSISTI_TOT = "select count(*) from corsisti";
	
	//--------AMMINISTRATORI--------
	String SELECT_ADMINPASS = "Select codadmin from amministratore where nomeadmin = ?";
	
	//--------STATISTICHE--------
	
	
	//--------SEQUENZE--------
	String SELECT_CORSISTA_SEQ = "Select corsisti_seq.nextval from dual";
	String SELECT_CORSO_SEQ = "Select corsi_seq.nextval from dual";
}


