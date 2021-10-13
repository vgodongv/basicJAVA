package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class Insert {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JHY990208";
		String password ="java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into LPROD values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setObject(1, "9");
			ps.setObject(2, "P403");
			ps.setObject(3, "아이패드");
			
		
		
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
