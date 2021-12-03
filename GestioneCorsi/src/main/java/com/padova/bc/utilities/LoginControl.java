package com.padova.bc.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.padova.architecture.dao.DAOException;
import com.padova.dbacess.DBAccess;
import com.padova.architecture.dao.DAOConstants;

public class LoginControl implements DAOConstants{
	
	private Connection conn;

	public LoginControl() throws DAOException, ClassNotFoundException, FileNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public String getAdminPass(String nomeadmin) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, nomeadmin);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getString(1);
			return null;
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
