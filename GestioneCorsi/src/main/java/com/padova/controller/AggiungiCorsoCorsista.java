package com.padova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padova.bc.AdminFacade;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsista;
import com.padova.architecture.model.CorsoCorsista;


@WebServlet("/aggiungicorsocorsista")
public class AggiungiCorsoCorsista extends HttpServlet {
	private static final long serialVersionUID = -4219162777969866619L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String admin = request.getParameter("admin");
		CorsoCorsista cc = new CorsoCorsista();

		try {
			cc.setIdCorsista(Integer.parseInt(request.getParameter("idCorsista")));
			cc.setIdCorso(Integer.parseInt(request.getParameter("idCorso")));
			AdminFacade.getInstance().createCorsoCorsista(cc);
			
			session.setAttribute("admin", admin);
			
			response.sendRedirect("home.jsp");
		} catch (DAOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
}
