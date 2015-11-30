package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedIterable;

import dao.CommitDAOImpl;
import dao.ICommitDAO;
import dao.IProjetDAO;
import dao.ITacheDAO;
import dao.ProjetDAOimpl;
import dao.TacheDAOimpl;


@WebServlet("/commit")
public class Commit extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE_COMMIT = "/restreint/commit.jsp";
	public static final String VUE_COMMIT_GITHUB= "/restreint/commitGitHubParTache.jsp";
	
	public static final String PARAM_ID_COMMIT = "idCommit";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_COMMIT = "commit";
	public static final String ATT_COMMITS = "commits";
	public static final String ATT_TACHE = "idTache";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String idCommit = request.getParameter(PARAM_ID_COMMIT);
		//String idSprint = request.getParameter(PARAM_ID_SPRINT);
		String idTache = request.getParameter(PARAM_ID_TACHE);
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet p = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		
		if(p.estGitHub()){
			ITacheDAO tacheDAO = new TacheDAOimpl();
			beans.Tache tache = tacheDAO.recupererTache(Integer.parseInt(idTache));
			
			GitHub github = GitHub.connectAnonymously();
			GHRepository repo = github.getRepository(p.getRepertoireGitHub());
			PagedIterable<GHCommit> cs = repo.listCommits();
			List<GHCommit> commits = new ArrayList<GHCommit>();
			for(GHCommit c : cs){
				if(c.getCommitShortInfo().getMessage().startsWith(tache.getTag())){
					commits.add(c);
				}
			}
			request.setAttribute("commits", commits);
			request.getRequestDispatcher(VUE_COMMIT_GITHUB).forward(request, response);
			
			
		}else{
		ICommitDAO commitDAO = new CommitDAOImpl();
		
		List<beans.Commit> commits = commitDAO.recupererListCommit(Integer.parseInt(idTache));
		System.out.println("Size : "+commits.size());
		
		
		request.setAttribute(ATT_COMMITS, commits);
		request.setAttribute(ATT_TACHE, idTache);
		
		request.setAttribute("idProjet", idProjet);
		request.getRequestDispatcher(VUE_COMMIT).forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
