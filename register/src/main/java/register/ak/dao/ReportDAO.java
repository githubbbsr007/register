package register.ak.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import register.ak.commonutil.CommonUtility;

public class ReportDAO {
	public List<User> getReportDAO() throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		List<User> listUser= new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = CommonUtility.getJdbcConnection();
			String sql = "Select * from students1";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User use =new User();
				use.setId(rs.getInt("id"));
				use.setUsername(rs.getString("username"));
				use.setPassword(rs.getString("password"));
				use.setEmailId(rs.getString("email"));
			listUser.add(use);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			CommonUtility.close(connection, null, rs);
			if (stmt != null) {
				stmt.close();
			}
		}
		return listUser;
	}
}
