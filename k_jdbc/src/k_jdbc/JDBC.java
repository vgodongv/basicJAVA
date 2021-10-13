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
		    * - 자바와 데이터베이스를 연결해주는 라이브러리
		    * -ojdbc : 오라클 JDBC
		    * 
		    * JDBC 작성 단계
		    * 1. Connection 생성(DB와 연결)
		    * 2. Statement 생성(쿼리작성)
		    * 3. Query 실행
		    * 4. ResultSet에서 결과 추출(select인 경우에만)
		    * 5. ResultSet, Statement, Connection 닫기
		    * 
		    * 
		    */
			
			// 데이터 베이스 접속 정보 생성
			// jdbc:oracle:thin: -> 드라이버의 주소. 드라이버=자바와 오라클을 연결. 호스트이름, 포트. SID
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "JHY990208";
			String password ="java";

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
//			1. Connection 생성(DB와 연결) - 드라이버매니저: 드라이버들을 관리해주는 클래스. 메서드 호출. 예외처리 try/catch
			try {
				con = DriverManager.getConnection(url, user, password);
//		    2. Statement 생성(쿼리작성)
				String sql = "select * from member";
				ps = con.prepareStatement(sql); //쿼리에 대한 정보 담김
				
//			3. Query 실행. 
				
//			select-result set 리턴
			rs = ps.executeQuery();
			
//			insert, update,delete - int 타입의 값 리턴. 영향받은 행의 개수 리턴. 0이나오면 실행이안된것. 
//			int result = ps.executeUpdate();
			
			while(rs.next()){ 
//				next()호출하여 while문 돌림. next()호출하면 rs는 첫번째 행을 바라보게되고 첫번째 행에서 값을 추출하게됨. 그리고 그다음행,,그다음행..이 있는지 없는지
//				다음행이 있으면 true, 없으면 false
				
//				getString = 가져올 값의 타입이 String. get으로 시작하는 메서드는 파라미터타입이 2가지로 나뉨-> 컬럼의 이름, 순서
				String memId = rs.getString(1); 
				String memPass = rs.getString("MEM_PASS");
				
				System.out.println("MEM_ID : "+ memId + " / MEM_PASS : " + memPass);
				
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{ //5.ResultSet, Statement, Connection 닫기 != null 이 아닌 경우 -> 객체가 있는 경우
				if(rs != null) try { rs.close();} catch (Exception e){}
				if(ps != null) try { ps.close();} catch (Exception e){}
				if(con != null) try { con.close();} catch (Exception e){}
				
				}
			}
		
//		테이블 되돌리기,,
//		SELECT *
//		FROM MEMBER AS OF TIMESTAMP(SYSTIMESTAMP - INTERVAL '10' MINUTE)
//		WHERE MEM_ID = 'a1001';

	}







