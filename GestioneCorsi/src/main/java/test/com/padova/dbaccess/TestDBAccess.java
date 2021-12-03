package test.com.padova.dbaccess;


import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.padova.architecture.DAO.DAOException;
import com.padova.dbacess.DBAccess;

class TestDBAccess {

	@Test
	void testConnection() {
		try {
			DBAccess.getConnection();
		} catch ( DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			fail("Connessione non funzionante");
		} finally {
			try {
				DBAccess.closeConnection();
			} catch(DAOException exc) {
				exc.printStackTrace();
				fail("Impossibile chiudere la connessione");
			}
		}
	}

}
