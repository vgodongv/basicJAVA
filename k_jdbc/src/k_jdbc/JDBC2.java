package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "JHY990208";
		String password ="java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
//		
		try {
			con = DriverManager.getConnection(url, user, password); // 커넥션 얻기=연결
			
			// 쿼리작성. 값대신에 ? 사용하고 ?에 쿼리로 동적으로 값을 넣어줌
			String sql = "select * from cart where cart_member = ? and cart_qty > ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); // 첫번째 물음표 안에 a001 값을 넣음
			ps.setInt(2, 5); // 두번째 물음표 안에 5 넣음
//			ps.setObject(3, 1); 타입 지정하기 귀찮으니께 setObject 메서드로 호출해도 상관없음.
			
			//쿼리 실행
			rs = ps.executeQuery(); // result set 
			
			ResultSetMetaData metaData = rs.getMetaData(); // 메타데이터: 데이터에 대한 데이터
			int columnCount = metaData.getColumnCount(); // 컬럼의 수 알아냄
			
			
			while(rs.next()){// result set 에서 값 꺼내기. 한번에 꺼내는법은? 컬럼의 개수 알아야함. // 세로
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