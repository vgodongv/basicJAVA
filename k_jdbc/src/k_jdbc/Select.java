package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Select {
public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JHY990208";
		String password ="java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 

		try {
			con = DriverManager.getConnection(url, user, password); // 커넥션 얻기=연결
			String sql = "select * from LPROD ORDER BY 1 ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData(); 
			int columnCount = metaData.getColumnCount(); 
			
			while(rs.next()){ 

				for(int i=1; i<= columnCount; i++){ //가로
					Object value = rs.getObject(i);
					System.out.print(value+"\t");
				}
				System.out.println();
				
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}finally{ 
			if(rs != null) try { rs.close();} catch (Exception e){}
			if(ps != null) try { ps.close();} catch (Exception e){}
			if(con != null) try { con.close();} catch (Exception e){}
			
			}
	}

}
