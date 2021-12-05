package com.padova.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.padova.bc.AdminFacade;
import com.padova.bc.idgenerator.IdGeneratorCorsisti;
import com.padova.bc.idgenerator.IdGeneratorInterface;
import com.padova.architecture.dao.DAOException;
import com.padova.architecture.model.Corsi;
import com.padova.architecture.model.Corsista;
import com.padova.architecture.model.CorsoCorsista;


@WebServlet("/aggiungicorsista")
public class AggiungiCorsista extends HttpServlet {
	private static final long serialVersionUID = -4219162777969866619L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String admin = request.getParameter("admin");
		Corsista corsista = new Corsista();
		Corsi co = new Corsi();
		CorsoCorsista corsocorsista = new CorsoCorsista();
		String[] corso = request.getParameterValues("corso");
		
		String[] precedenti = request.getParameterValues("precedenti");
		int valore = 0;
		for(String prec : precedenti)
		{
			if(prec.equals("Si"))
			valore = 1;
			else
			valore = 0;
		}
		System.out.println(corso[0]);
		System.out.println(precedenti[0]);
		try {
			corsista.setNomeCorsista(request.getParameter("nome"));
			corsista.setCognomeCorsista(request.getParameter("cognome"));
			corsista.setCodCorsista(IdGeneratorCorsisti.getInstance().getNextId());
			corsista.setPrecedentiFormativi(valore);
			AdminFacade.getInstance().createCorsista(corsista);
			
			for(String cor : corso)
			{
			corsocorsista.setIdCorso(Integer.parseInt(cor));
			corsocorsista.setIdCorsista(corsista.getCodCorsista());
			}
		
			AdminFacade.getInstance().createCorsoCorsista(corsocorsista);
			response.sendRedirect("ListaCorsisti.jsp");
		} catch (DAOException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
}
