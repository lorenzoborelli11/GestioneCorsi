package com.padova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padova.bc.utilities.LoginControl;
import com.padova.bc.AdminFacade;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsi;
import com.padova.architecture.model.Corsista;
import com.padova.architecture.model.CorsoCorsista;
import com.padova.architecture.model.Docenti;

@WebServlet("/eliminacorso")
public class EliminaCorso extends HttpServlet {
	private static final long serialVersionUID = -4219162777969866619L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String admin = request.getParameter("admin");
		String idCorso = request.getParameter("codCorso");
		int codCorso = Integer.parseInt(idCorso);
		

		try {
			CorsoCorsista[] corsoCorsista = AdminFacade.getInstance().getCorsiCorsisti();
			if (codCorso != 0) {
				for (CorsoCorsista cc : corsoCorsista) {
					if (codCorso == cc.getIdCorso()) {
						CorsoCorsista c = new CorsoCorsista();
						c.setIdCorso(cc.getIdCorso());
						c.setIdCorsista(cc.getIdCorsista());
						AdminFacade.getInstance().deleteCorsoCorsista(c);
					}
				}
				AdminFacade.getInstance().deleteCorso(codCorso);
			}

		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
		session.setAttribute("admin", admin);
		response.sendRedirect("home.jsp");
	}
}
