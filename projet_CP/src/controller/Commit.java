package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommitDAOImpl;
import dao.ICommitDAO;


@WebServlet("/commit")
public class Commit extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_COMMIT = "/restreint/commit.jsp";
	public static final String PARAM_ID_COMMIT = "idCommit";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String ATT_COMMIT = "commit";
	public static final String ATT_COMMITS = "commits";
	public static final String ATT_TACHE = "idTache";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String idCommit = request.getParameter(PARAM_ID_COMMIT);
		//String idSprint = request.getParameter(PARAM_ID_SPRINT);
		String idTache = request.getParameter(PARAM_ID_TACHE);
		
		ICommitDAO commitDAO = new CommitDAOImpl();
		
		List<beans.Commit> commits = commitDAO.recupererListCommit(Integer.parseInt(idTache));
		System.out.println("Size : "+commits.size());
		
		
		request.setAttribute(ATT_COMMITS, commits);
		request.setAttribute(ATT_TACHE, idTache);
		
		
		request.getRequestDispatcher(VUE_COMMIT).forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
