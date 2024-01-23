package register.ak.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.ak.commonutil.CommonUtility;

@WebServlet("/viewUser")
public class ViewUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			PrintWriter writer = resp.getWriter();
			// Start HTML document and create the table header
			writer.println("<html><head><title>User Data</title></head><body>");
			writer.println("<h2>User Data</h2>");
			writer.println("<table border='1'>");
			writer.println("<tr><th>Name</th><th>Password</th><th>Email</th><th>delete</th></tr>");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = CommonUtility.getJdbcConnection();
			stmt = con.createStatement();
			String sql = "select * from students";
			result = stmt.executeQuery(sql);
			while (result.next()) {
				String name = result.getString("username");
				String password = result.getString("password");
				String email = result.getString("email");
				String encodedName = URLEncoder.encode(name, "UTF-8");
				// Create a table row with the data
				writer.println("<tr><td>" + name + "</td><td>" + password + "</td><td>" + email + "</td>"
						+ "<td><a href='/register/delete'>delete</a></td>"+"</tr>");
			}
			// Close the table and HTML document
			writer.println("</table></body></html>");
			writer.close();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CommonUtility.close(con, null, result);
			try {

				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
