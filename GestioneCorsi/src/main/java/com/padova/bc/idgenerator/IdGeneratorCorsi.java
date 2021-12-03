package com.padova.bc.idgenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.padova.architecture.dao.DAOException;
import com.padova.dbacess.DBAccess;

public class IdGeneratorCorsi implements IdGeneratorInterface {
	private static IdGeneratorCorsi istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private IdGeneratorCorsi() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {

		conn = DBAccess.getConnection();
	}

	public static IdGeneratorCorsi getInstance()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {

		if (istanza == null)
			istanza = new IdGeneratorCorsi();
		return istanza;

	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {
		long id;
		try {
			stmt = conn.createStatement();
			//rs = stmt.executeQuery(SELECT_ARTICOLO_SEQ);
			rs.next();
			id = rs.getLong(1);

		} catch (SQLException sql) {
			throw new DAOException(sql);

		}
		return id;
	}
}
