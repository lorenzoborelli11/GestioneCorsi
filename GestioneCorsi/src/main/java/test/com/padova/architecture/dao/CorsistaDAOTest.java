package test.com.padova.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.padova.architecture.dao.CorsistaDAO;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsista;
import com.padova.dbacess.DBAccess;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();

		corsista = new Corsista();
		corsista.setNomeCorsista("Pinco");
		corsista.setCognomeCorsista("Pallino");
		corsista.setCodCorsista(2);
		corsista.setPrecedentiFormativi(1);

	}

	//--------CREATE--------
	@Test
	@Order(value = 1)
	void testCreate() {
		try {
			corsista = new Corsista();
			corsista.setNomeCorsista("Pinco");
			corsista.setCognomeCorsista("Pallino");
			corsista.setCodCorsista(2);
			corsista.setPrecedentiFormativi(1);
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Corsista creato");
			System.out.println(corsista.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	//--------GETALL--------
	@Test
	@Order(value = 2)
	void testGetAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			for (Corsista c : corsisti) {
				System.out.println(c.toString());
			}
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	//--------GETBYID--------
	@Test
	@Order(value = 3)
	void testGetById() {
		try {
			Corsista c = CorsistaDAO.getFactory().getById(conn, corsista);
			System.out.println(c.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	//--------DELETE--------
	@Test
	@Order(value = 4)
	void testDelete() {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
			System.out.println("Corsista eliminato");
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
