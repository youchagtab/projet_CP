package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;
import javax.servlet.annotation.WebServlet;
import dao.IProjetDAO;
import dao.ProjetDAOimpl;

@WebServlet("/ListCommitGitHub")
public class ListCommitGitHub extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_COMMITGITHUB = "/restreint/CommitGitHub.jsp";
	
	public static final String PARAM_PROJET = "idProjet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idProjet = Integer.parseInt(request.getParameter(PARAM_PROJET));
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet p = projetDAO.recupererProjet(idProjet);
		
		GitHub github = GitHub.connectAnonymously();
		GHRepository repo = github.getRepository(p.getRepertoireGitHub());
		PagedIterable<GHCommit> cs = repo.listCommits();
		
		request.setAttribute("commits", cs.asList());
		
		this.getServletContext().getRequestDispatcher(VUE_COMMITGITHUB).forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
	
}
