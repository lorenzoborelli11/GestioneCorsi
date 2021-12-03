package com.padova.dbacess;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.padova.architecture.DAO.DAOException;

public class DBAccess {
	private static Connection conn;

	public static synchronized Connection getConnection()
			throws ClassNotFoundException, DAOException, FileNotFoundException, IOException {

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream input = classloader.getResourceAsStream("properties/config.properties");

			Properties p = new Properties();
			p.load(input);

			Class.forName(p.getProperty("jdbcDriver"));
			conn = DriverManager.getConnection(p.getProperty("jdbcURL"), p.getProperty("jdbcUsername"),
					p.getProperty("jdbcPassword"));
			conn.setAutoCommit(false);

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return conn;

	}

	public static void closeConnection() throws DAOException {
		try {
			if (conn != null)
				conn.close();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}
}
