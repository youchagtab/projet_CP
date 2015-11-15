package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tache;
import dao.ITacheDAO;
import dao.TacheDAOimpl;
@WebServlet("/ModifierTache")
public class ModifierTache extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String VUE_MODIFIER_TACHE = "/restreint/modifiertache.jsp";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String ATT_TACHE = "tache";
	public static final String PARAM_ID_USER_STORY = "idUserStory";
	public static final String PARAM_COUT = "cout";
	public static final String PARAM_STATUS = "status";
	public static final String PARAM_TAG = "tag";
	public static final String PARAM_DESCRITPION = "description";
	public static final String VUE_SPRINT = "/projet_CP/Sprint";
	public static final String PARAM_ID_PROJET = "idProjet";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		int idtache = Integer.parseInt(request.getParameter(PARAM_ID_TACHE));
		Tache tache = tacheDAO.recupererTache(idtache);
		request.setAttribute(ATT_TACHE, tache);
		
		
		this.getServletContext().getRequestDispatcher(VUE_MODIFIER_TACHE).forward(request, response);
	
	}

	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter(PARAM_DESCRITPION);
		//String tag = request.getParameter(PARAM_TAG);
		//int cout = Integer.parseInt(request.getParameter(PARAM_COUT));
		//String status = request.getParameter(PARAM_STATUS);
		int idTache = Integer.parseInt(request.getParameter(PARAM_ID_TACHE));
		int idUS = Integer.parseInt(request.getParameter(PARAM_ID_USER_STORY));
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
	
		Tache tache = new Tache(idTache,  description, idUS);
		ITacheDAO tacheDAO = new TacheDAOimpl();
		tacheDAO.modifier(tache);
		request.setAttribute(PARAM_ID_USER_STORY, idUS);
		request.setAttribute(PARAM_ID_PROJET, idProjet);
		response.sendRedirect(VUE_SPRINT+"?idUS="+idUS+"?idProjet="+idProjet);
		
		
		
		
	}
}
