package register.ak.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.ak.commonutil.CommonUtility;

@WebServlet("/registerUser")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 668021950483083829L;

	@Override
	public void init() throws ServletException {
		System.out.println("initialization for store ing user object");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String emailId = req.getParameter("emailId");
		Connection con = null;
		String sql = "insert into students  (username,password,email) value(?,?,?)";
		PreparedStatement stmt = null;
		// connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = CommonUtility.getJdbcConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			stmt.setString(3, emailId);
			stmt.execute();
			System.out.println("data stored successfully");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CommonUtility.close(con, stmt, null);
		}

		PrintWriter writer = resp.getWriter();
		writer.print("<h1>user register success with email id " + emailId + "</h1>");

	}

}
