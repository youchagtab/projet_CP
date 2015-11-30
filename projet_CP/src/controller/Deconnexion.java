package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.browserlaunchers.locators.GoogleChromeLocator;
@WebServlet("/deconnexion")
public class Deconnexion extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		if (session1.getAttribute("utilisateur") == null){
			
		} 
        HttpSession session = request.getSession();
        session.invalidate();
        //response.sendRedirect("/connexion.jsp");
        System.out.println("deconnexion avec succes");
        
        request.getRequestDispatcher("/connexion.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doGet(request, response);	
	}
	
}
