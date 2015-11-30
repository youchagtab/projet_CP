package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Commit;
import dao.CommitDAOImpl;
import dao.ICommitDAO;

@WebServlet("/AjouterCommit")
public class AjouterCommit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_COMMIT = "commit";
	public static final String VUE_AJOUTER_COMMIT = "/restreint/ajoutercommit.jsp";
	public static final String PARAM_DESCRITPION = "description";
	public static final String PARAM_NUMERO = "numero";
	public static final String PARAM_ID_COMMIT = "idCommit";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String PARAM_ID_PROJET = "idProjet";
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_COMMIT)
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int idTache = Integer.parseInt(request.getParameter(PARAM_ID_TACHE));

		if (request.getParameter(PARAM_NUMERO) != null
				&& request.getParameter(PARAM_DESCRITPION) != null
				&& !request.getParameter(PARAM_NUMERO).isEmpty()
				&& !request.getParameter(PARAM_DESCRITPION).isEmpty()) 
		{
			String numero = request.getParameter(PARAM_NUMERO);
			String description = request.getParameter(PARAM_DESCRITPION);
			String idProjet = request.getParameter(PARAM_ID_PROJET);

			ICommitDAO commitDAO = new CommitDAOImpl();
			Commit commit = new Commit(idTache, description, numero);

			commitDAO.ajouter(commit);
			request.setAttribute(PARAM_ID_TACHE, idTache);
			response.sendRedirect(VUE_COMMIT + "?idTache=" + idTache +"&idProjet=" + idProjet);

		}
		else
		{
			request.setAttribute("erreur", "Veuillez remplir tous les champs");
			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_COMMIT)
			.forward(request, response);		
		}


	}

}
