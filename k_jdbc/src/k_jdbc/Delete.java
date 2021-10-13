package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JHY990208";
		String password ="java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from LPROD where LPROD_GU = ?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, "P508");
			int result = ps.executeUpdate();
			System.out.println(result);
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally{ 
			if(rs != null) try { rs.close();} catch (Exception e){}
			if(ps != null) try { ps.close();} catch (Exception e){}
			if(con != null) try { con.close();} catch (Exception e){}
			
			}

	}

}
