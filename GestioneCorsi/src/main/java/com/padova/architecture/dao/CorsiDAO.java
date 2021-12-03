package com.padova.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.padova.architecture.model.Corsi;



public class CorsiDAO implements GenericDAO<Corsi>, DAOConstants{
	
	CachedRowSet rowSet;
	
	public static CorsiDAO getFactory () throws DAOException {
		return new CorsiDAO();
	}
	@Override
	public void create(Connection conn, Corsi model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSI);
			rowSet.execute();
			rowSet.moveToInsertRow();
			
			
			rowSet.updateLong(1, model.getCodCorso());
			rowSet.updateString(2, model.getNomeCorso());
			rowSet.updateDate(3, new java.sql.Date(model.getDataInizioCorso().getTime()));
			rowSet.updateDate(4, new java.sql.Date(model.getDataFineCorso().getTime()));
			rowSet.updateDouble(5, model.getCostoCorso()); 
			rowSet.updateString(6, model.getAulaCorso());
			rowSet.updateLong(7, model.getCodDocente());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges(conn);
			
			
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void update(Connection conn, Corsi model) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, Corsi model) throws DAOException {
		PreparedStatement ps;
		long id= model.getCodCorso();
		
		try {
			ps=conn.prepareStatement(DELETE_CORSI);
			ps.setLong(1,id);
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public Corsi[] getAll(Connection conn) throws DAOException {
		Corsi[] corsi=null;
		
		try {
			Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= stmt.executeQuery(SELECT_CORSI);
			rs.last();
			corsi=new Corsi[rs.getRow()];
			
			for(int i=0; rs.next(); i++) {
				Corsi corso=new Corsi();
				
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
				
				corsi[i] = corso;
				
			}
			rs.close();
			
			
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}

	@Override
	public Corsi getById(Connection conn, long id) throws DAOException {
		
		Corsi corso=null;
		PreparedStatement ps;
		
		try {
			ps=conn.prepareStatement(SELECT_CORSI_BY_ID);
			
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				corso=new Corsi();
				
				corso.setCodCorso(rs.getLong(1));
				corso.setNomeCorso(rs.getString(2));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setCostoCorso(rs.getDouble(5));
				corso.setCommentiCorso(rs.getString(6));
				corso.setAulaCorso(rs.getString(7));
				corso.setCodDocente(rs.getLong(8));
			}
		}catch (SQLException sql) {
				throw new DAOException(sql);
			}
		return corso;
			
	}
	@Override
	public Corsi getById(Connection conn, Corsi model) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	public Corsi[] getByCodCorsista(Connection conn, long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}