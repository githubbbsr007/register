package register.ak.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerUser")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 668021950483083829L;
	Map<String,String> listUser;

	@Override
	public void init() throws ServletException {
		System.out.println("initialization for store ing user object");
		listUser = new HashMap<>();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		String emailId=req.getParameter("emailId");
		System.out.println(emailId);
		System.out.println(userName);
		listUser.put(userName, password);		
		PrintWriter writer=resp.getWriter();
		writer.print("<h1>user register success with email id "+ emailId +"</h1>");
		System.out.println(listUser.size());
	}

}
