package com.padova.bc.idgenerator;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.padova.architecture.dao.DAOConstants;
import com.padova.architecture.dao.DAOException;
import com.padova.dbacess.DBAccess;



public class IdGeneratorCorsisti implements IdGeneratorInterface, DAOConstants {

	private static IdGeneratorCorsisti istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private IdGeneratorCorsisti() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {

		conn = DBAccess.getConnection();
	}

	public static IdGeneratorCorsisti getInstance()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {

		if (istanza == null)
			istanza = new IdGeneratorCorsisti();
		return istanza;

	}

	@Override
	public int getNextId() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		int id;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
			rs.next();
			id = rs.getInt(1);

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return id;
	}
}
