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

@WebServlet("/delete")
public class DeleeteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String userName = req.getParameter("name");
		String userName = "asit";
		String sql = "delete from students where username=?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			PrintWriter writer = resp.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = CommonUtility.getJdbcConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, userName);
			statement.execute();
			writer.write("<h1>record delete success</h1>");
			writer.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CommonUtility.close(con, statement, null);
		}
	}
}
