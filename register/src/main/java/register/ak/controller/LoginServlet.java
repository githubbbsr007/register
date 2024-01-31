package register.ak.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.ak.commonutil.CommonUtility;

@WebServlet("/SignIn")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173470985323911685L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");// UI Username
		String password = req.getParameter("password");// UI Password
		HttpSession session=req.getSession();
		String sessionUser=(String) session.getAttribute(userName);
		if(sessionUser==null) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PrintWriter writer = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = CommonUtility.getJdbcConnection();
			String sql = "Select * from students1 where username=?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();//database result and assign
			if (rs.next()) {
				if (password.equalsIgnoreCase(rs.getString("password"))) {
					session.setAttribute(userName, userName);
					//writer.write("<h1>login success welcome to home page<h1>");
					RequestDispatcher rd= req.getRequestDispatcher("/jsp/home.jsp");
					rd.forward(req, resp);
				}else {
					writer.write("<h1>invalid password<h1>");
				}
			} else {
				System.out.println("username not correct ");
				writer.write("<h1>invalid username<h1>");
			}
		} catch (Exception ex) {
			System.out.println("execption occours while connect db" + ex);
		} finally {
			CommonUtility.close(connection, stmt, rs);
			writer.close();
		}
		}else {
			System.out.println("session user found");
			//writer.write("<h1>login success welcome to home page<h1>");
			RequestDispatcher rd= req.getRequestDispatcher("/jsp/home.jsp");
			rd.forward(req, resp);
		}
	}

}
