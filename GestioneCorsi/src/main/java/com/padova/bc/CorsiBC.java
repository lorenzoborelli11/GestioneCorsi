package com.padova.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import com.padova.architecture.dao.CorsiDAO;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsi;
import com.padova.bc.idgenerator.IdGeneratorCorsi;
import com.padova.dbacess.DBAccess;





public class CorsiBC {
	private IdGeneratorCorsi idGen;
	private Connection conn;
	
	public CorsiBC() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		conn=DBAccess.getConnection();
		idGen=IdGeneratorCorsi.getInstance();
	}
	
	
	public Corsi[] getCorsi() throws DAOException {
		return CorsiDAO.getFactory().getAll(conn);
	}

}
