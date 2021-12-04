package com.padova.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsista;
import com.padova.bc.AdminFacade;

/**
 * Servlet implementation class RimuoviCorsista
 */
@WebServlet("/rimuoviCorsista")
public class RimuoviCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		long codCorsista = Long.parseLong(request.getParameter("id"));
		System.out.println("cod:" + codCorsista);
		Corsista corsista = null;
		try {
			corsista = AdminFacade.getInstance().getCorsistaById(codCorsista);
			if (codCorsista != 0 && corsista != null) {

				AdminFacade.getInstance().deleteCorsista(corsista);
			}
		} catch (ClassNotFoundException | DAOException | IOException e) {
			
			e.printStackTrace();
			
		}
		response.sendRedirect("ListaCorsisti.jsp");

	}

}
