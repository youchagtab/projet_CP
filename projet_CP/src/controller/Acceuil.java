package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Projet;
import dao.IProjetDAO;
import dao.ProjetDAOimpl;

public class Acceuil extends HttpServlet {
	private IProjetDAO metier;

	@Override
	public void init() throws ServletException {
		metier = new ProjetDAOimpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getRequestDispatcher("acceuil.jsp").forward(request, response);
		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AcceuilModel model = new AcceuilModel();
		request.setAttribute("model", model);
		String action = request.getParameter("action");

		if (action != null) {
			if (action.equals("chercher")) {
				model.setMotCle(request.getParameter("motCle"));
				List<Projet> p = metier.listerMotCle(model.getMotCle());
				model.setProjets(p);

			} else if (action.equals("delete")) {
				int reference = Integer.parseInt(request.getParameter("ref"));
				// String ref = request.getParameter("ref");
				metier.supprimer(reference);
				model.setProjets(metier.lister());
			} 
			
		}
		request.getRequestDispatcher("acceuil.jsp").forward(request, response);
	}
}
