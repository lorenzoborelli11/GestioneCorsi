package com.padova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padova.bc.utilities.LoginControl;
import com.padova.architecture.dao.DAOException;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = -5595211750128964026L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeadmin = request.getParameter("nomeadmin");
		String codadmin = request.getParameter("codadmin");

		HttpSession session = request.getSession();
		
		if (nomeadmin != null && codadmin != null) {
		try {
			LoginControl lc = new LoginControl();
			codadmin = lc.getAdminPass(codadmin);
			if (codadmin != null) {
				if (codadmin.equals(codadmin)) {
					session.setAttribute("admin", nomeadmin);
					response.sendRedirect("admin/admin.jsp");
				} else
					response.sendRedirect("accessonegato.jsp");
			}else
				response.sendRedirect("accessonegato.jsp");
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		  }
		}
	}
}
