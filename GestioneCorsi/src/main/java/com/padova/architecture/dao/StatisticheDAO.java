package com.padova.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


import com.padova.architecture.model.Statistica;

public class StatisticheDAO implements GenericDAO<Statistica>, DAOConstants{
	
	public static StatisticheDAO getFactory() throws DAOException{
		return new StatisticheDAO();
	}
	public Statistica getCorsoFrequentato(Connection conn) throws DAOException {
		Statistica sta = new Statistica();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_MAXCORSI);
			
			if(rs.next()) {
				sta.setCorsoFrequentato(rs.getString(1));
				sta.setTotalePosti(rs.getInt(2));
			} 
			}catch (SQLException sql) {
				throw new DAOException(sql);
		}
		return sta;
	}

	
	public Date getDataInizioUltimoCorso(Connection conn) throws DAOException {
		Date Data = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DATAINIZIOCORSO);
			
			if(rs.next()) {
				Data = (new java.util.Date(rs.getDate(1).getTime()));
			} 
			}catch (SQLException sql) {
				throw new DAOException(sql);
			
		}
		return Data;
	}
	
	public float getDurataMediaCorsi(Connection conn) throws DAOException {
		float durata = 0;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("");
			
			if(rs.next()) {
				durata = rs.getFloat(1);
			} 
			}catch (SQLException sql) {
				throw new DAOException(sql);
			
		}
		return durata;
	}
	
	public String getDocenteTipologie(Connection conn) throws DAOException {
		String docente = "";
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("");
			
			if(rs.next()) {
				docente = rs.getString(1);
			} 
			}catch (SQLException sql) {
				throw new DAOException(sql);
			
		}
		return docente;
		
	}
	public String getCorsiPostiDisponibili(Connection conn) throws DAOException {
		String corsiposti = "";
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("");
			
			if(rs.next()) {
				corsiposti = rs.getString(1);
			} 
			}catch (SQLException sql) {
				throw new DAOException(sql);
			
		}
		return corsiposti;
	}


	@Override
	public void create(Connection conn, Statistica model) throws DAOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Connection conn, Statistica model) throws DAOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Connection conn, Statistica model) throws DAOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Statistica[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Statistica getById(Connection conn, Statistica model) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Statistica getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
