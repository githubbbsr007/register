package register.ak.commonutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonUtility {
	public static void close(Connection con, PreparedStatement stmt, ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException sqlEx) {
			System.out.println(sqlEx);
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/developer1", "root", "root");		
	}
}
