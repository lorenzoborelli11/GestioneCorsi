package com.padova.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.padova.architecture.DAO.DAOException;
import com.padova.architecture.DAO.StatisticheDAO;
import com.padova.dbacess.DBAccess;

public class StatisticheBC {
private Connection conn;
	
	public StatisticheBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	
	public String getCorsoFrequentato() throws DAOException {
		String corso="";
		try {
			corso = StatisticheDAO.getFactory().getCorsoFrequentato(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}
	public Date getDataInizioUltimoCorso() throws DAOException {
		Date Datainizio= null;
		try {
			Datainizio = StatisticheDAO.getFactory().getDataInizioUltimoCorso(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return Datainizio;
	}
	public float getDurataMediaCorsi() throws DAOException {
		float duratamedia= 0;
		try {
			duratamedia = StatisticheDAO.getFactory().getDurataMediaCorsi(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return duratamedia;
	}

	public String getDocenteTipologie() throws DAOException {
		String DocenteTipologia="";
		try {
			DocenteTipologia = StatisticheDAO.getFactory().getDocenteTipologie(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return DocenteTipologia;
	}
	public String getCorsiPostiDispionibli() throws DAOException {
		String CorsiPosti="";
		try {
			CorsiPosti = StatisticheDAO.getFactory().getCorsiPostiDisponibili(conn);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return CorsiPosti;
	}
	

}
