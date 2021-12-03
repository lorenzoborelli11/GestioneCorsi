package com.padova.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.padova.architecture.dao.CorsoCorsistaDAO;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.CorsoCorsista;
import com.padova.dbacess.DBAccess;


public class CorsoCorsistaBC {
	private Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsoCorsista cc) throws DAOException{
		try {
			CorsoCorsistaDAO.getFactory().create(conn, cc);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void delete(CorsoCorsista cc) throws DAOException{
		try {
			CorsoCorsistaDAO.getFactory().delete(conn, cc);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
