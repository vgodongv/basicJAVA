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
			con = DriverManager.getConnection(url, user, password); // Ŀ�ؼ� ���=����
			
			// �����ۼ�. ����ſ� ? ����ϰ� ?�� ������ �������� ���� �־���
			String sql = "select * from cart where cart_member = ? and cart_qty > ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); // ù��° ����ǥ �ȿ� a001 ���� ����
			ps.setInt(2, 5); // �ι�° ����ǥ �ȿ� 5 ����
//			ps.setObject(3, 1); Ÿ�� �����ϱ� �������ϲ� setObject �޼���� ȣ���ص� �������.
			
			//���� ����
			rs = ps.executeQuery(); // result set 
			
			ResultSetMetaData metaData = rs.getMetaData(); // ��Ÿ������: �����Ϳ� ���� ������
			int columnCount = metaData.getColumnCount(); // �÷��� �� �˾Ƴ�
			
			
			while(rs.next()){// result set ���� �� ������. �ѹ��� �����¹���? �÷��� ���� �˾ƾ���. // ����
				for(int i=1; i<= columnCount; i++){ //����
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