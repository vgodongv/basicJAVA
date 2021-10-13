package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	public static void main(String[] args) {
		   /*
		    * Java Database Connectivity
		    * - �ڹٿ� �����ͺ��̽��� �������ִ� ���̺귯��
		    * -ojdbc : ����Ŭ JDBC
		    * 
		    * JDBC �ۼ� �ܰ�
		    * 1. Connection ����(DB�� ����)
		    * 2. Statement ����(�����ۼ�)
		    * 3. Query ����
		    * 4. ResultSet���� ��� ����(select�� ��쿡��)
		    * 5. ResultSet, Statement, Connection �ݱ�
		    * 
		    * 
		    */
			
			// ������ ���̽� ���� ���� ����
			// jdbc:oracle:thin: -> ����̹��� �ּ�. ����̹�=�ڹٿ� ����Ŭ�� ����. ȣ��Ʈ�̸�, ��Ʈ. SID
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "JHY990208";
			String password ="java";

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
//			1. Connection ����(DB�� ����) - ����̹��Ŵ���: ����̹����� �������ִ� Ŭ����. �޼��� ȣ��. ����ó�� try/catch
			try {
				con = DriverManager.getConnection(url, user, password);
//		    2. Statement ����(�����ۼ�)
				String sql = "select * from member";
				ps = con.prepareStatement(sql); //������ ���� ���� ���
				
//			3. Query ����. 
				
//			select-result set ����
			rs = ps.executeQuery();
			
//			insert, update,delete - int Ÿ���� �� ����. ������� ���� ���� ����. 0�̳����� �����̾ȵȰ�. 
//			int result = ps.executeUpdate();
			
			while(rs.next()){ 
//				next()ȣ���Ͽ� while�� ����. next()ȣ���ϸ� rs�� ù��° ���� �ٶ󺸰Եǰ� ù��° �࿡�� ���� �����ϰԵ�. �׸��� �״�����,,�״�����..�� �ִ��� ������
//				�������� ������ true, ������ false
				
//				getString = ������ ���� Ÿ���� String. get���� �����ϴ� �޼���� �Ķ����Ÿ���� 2������ ����-> �÷��� �̸�, ����
				String memId = rs.getString(1); 
				String memPass = rs.getString("MEM_PASS");
				
				System.out.println("MEM_ID : "+ memId + " / MEM_PASS : " + memPass);
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{ //5.ResultSet, Statement, Connection �ݱ� != null �� �ƴ� ��� -> ��ü�� �ִ� ���
				if(rs != null) try { rs.close();} catch (Exception e){}
				if(ps != null) try { ps.close();} catch (Exception e){}
				if(con != null) try { con.close();} catch (Exception e){}
				
				}
			}
		
//		���̺� �ǵ�����,,
//		SELECT *
//		FROM MEMBER AS OF TIMESTAMP(SYSTIMESTAMP - INTERVAL '10' MINUTE)
//		WHERE MEM_ID = 'a1001';

	}







