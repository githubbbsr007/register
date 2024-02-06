package register.ak.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.ak.commonutil.CommonUtility;
@WebServlet("/savestudents")
public class StudentInfoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4287808824109477857L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name =req.getParameter("name");
	String adress =req.getParameter("adress");
	String emailId = req.getParameter("emailId");
	String age = req.getParameter("age");
	int age1 =Integer.parseInt(age);
	String dob =req.getParameter("DOB");
	// Parse the date string into a LocalDate object
    LocalDate dateOfBirth = LocalDate.parse(dob);
	
	System.out.println(name+adress+emailId+age+dob);
	Connection con =null;
	String sql= "insert into STUDENTES_INFO (name,address,email,age,dob) values(?,?,?,?,?)";
	PreparedStatement pre = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = CommonUtility.getJdbcConnection();
		pre = con.prepareStatement(sql);
		pre.setString(1, name);
		pre.setString(2, adress);
		pre.setString(3, emailId);
		pre.setInt(4, age1);
		pre.setDate(5, java.sql.Date.valueOf(dateOfBirth ));
		pre.execute();
		System.out.println("data stored successfully");
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		CommonUtility.close(con, pre, null);
	}

	PrintWriter writer = resp.getWriter();
	writer.print("<h1>user register success with email id " + emailId + "</h1>");

		
	}
}

