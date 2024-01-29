package register.ak.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import register.ak.commonutil.CommonUtility;

public class DashBoardDAO {
	public int getDashBoardCount() throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = CommonUtility.getJdbcConnection();
			String sql = "Select count(*) totalUser from students";
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("totalUser");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			CommonUtility.close(connection, null, rs);
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
}
