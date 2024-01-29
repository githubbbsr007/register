package register.ak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get session from request
		HttpSession session=req.getSession();
		
		//need to invalidate session
		session.invalidate();
		
		RequestDispatcher rd= req.getRequestDispatcher("/login.html");
		rd.forward(req, resp);
		System.out.println("logout success");
		
	}

}
