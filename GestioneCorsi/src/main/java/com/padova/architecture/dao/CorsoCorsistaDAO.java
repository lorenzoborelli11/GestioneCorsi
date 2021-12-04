package com.padova.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.padova.architecture.model.CorsoCorsista;

public class CorsoCorsistaDAO implements GenericDAO<CorsoCorsista>, DAOConstants{
	private CachedRowSet rowSet;
	
	private CorsoCorsistaDAO() throws DAOException{
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	} 
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	//asdasd
	@Override
	public void create(Connection conn, CorsoCorsista model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, model.getIdCorsista());
			rowSet.updateLong(2, model.getIdCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, CorsoCorsista model) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, model.getIdCorsista());
			rowSet.updateLong(2, model.getIdCorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void delete(Connection conn, CorsoCorsista model) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
			ps.setLong(1, model.getIdCorso());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		  CorsoCorsista[] corsoCorsista = null;
		  try {
		   Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		   ResultSet rs = stmt.executeQuery(SELECT_CORSO_CORSISTA);
		   rs.last();
		   corsoCorsista = new CorsoCorsista[rs.getRow()];
		   rs.beforeFirst();

		   for (int i = 0; rs.next(); i++) {
		    CorsoCorsista c = new CorsoCorsista();
		    c.setIdCorso(rs.getLong(1));
		    c.setIdCorsista(rs.getLong(2));
		    corsoCorsista[i] = c;
		   }
		   rs.close();
		  } catch (SQLException e) {
		   throw new DAOException(e);
		  }
		  return corsoCorsista;
	}

	@Override
	public CorsoCorsista getById(Connection conn, CorsoCorsista model) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
