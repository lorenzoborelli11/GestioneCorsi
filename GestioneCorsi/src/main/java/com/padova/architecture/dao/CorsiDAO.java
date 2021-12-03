package com.padova.architecture.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			rowSet.setCommand("");
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
			ps=conn.prepareStatement("");
			ps.setLong(1,id);
			ps.execute();
			conn.commit();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public Corsi[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corsi getById(Connection conn, Corsi model) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}