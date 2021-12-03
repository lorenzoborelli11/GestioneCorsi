package com.padova.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.padova.architecture.dao.CorsistaDAO;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsista;
import com.padova.bc.idgenerator.IdGeneratorCorsisti;
import com.padova.dbacess.DBAccess;

public class CorsistaBC {
	private Connection conn;
	private IdGeneratorCorsisti idGen;
	
	public CorsistaBC() throws DAOException, FileNotFoundException, IOException, ClassNotFoundException {
		conn = DBAccess.getConnection(); 
		idGen = IdGeneratorCorsisti.getInstance();
	}
	
	public void createCosista(Corsista corsista) throws DAOException, ClassNotFoundException, FileNotFoundException, IOException {
		try {
			corsista.setCodCorsista(idGen.getNextId());
			CorsistaDAO.getFactory().create(conn, corsista);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void deleteCosista(Corsista corsista) throws DAOException {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Corsista[] getCosisti() throws DAOException {
		Corsista[] corsisti = null;
		try {
			corsisti = CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return corsisti;
	}
	
	public Corsista getCosistaById(Corsista corsista) throws DAOException {
		try {
			return CorsistaDAO.getFactory().getById(conn, corsista);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
