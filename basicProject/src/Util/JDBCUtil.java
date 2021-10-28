package Util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JDBCUtil {
	//쿼리를 작성할때마다 매 번 코드를 작성하기에는 너무 번거로우므로 메서드를 만들어서 활용하면 편하다.
		//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴(메모리 낭비 방지)
		
		private JDBCUtil(){
			
		}

		private static JDBCUtil instance;
		
		public static JDBCUtil getInstance(){
			if(instance==null){//instance변수가 null일때만 객체 생성>다음부터는 있는 객체 리턴
				instance = new JDBCUtil();
			}
			return instance;
		}
		
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String user = "ALBAPROJECT";
		private String password ="JAVA";

		private Connection con = null;
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		
		/*
		 * Map<String, Object>selectOne(String sql)//select메서드(1행용)-?없음
		 * Map<String, Object>selectOne(String sql,List<object> param)//?에 들어갈 값을 list에 넣어서 넘김.
		 * List<Map<String, Object>> selectList(String sql)
		 * List<Map<String, Object>> selectList(String sql,List<object> param)
		 * int update(String sql)//업데이트한 행의 수를 int로 받음
		 * int update(String sql,List<object> param)
		 */
		
		//1번
		public Map<String, Object>selectOne(String sql){
//			HashMap<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> map = null;
	//차이는 조회조건에 맞는 결과값이 없을 때 null이 리턴되느냐, 아니면 초기값 해시맵이 반환되느냐 
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
			    int columnCount = metaData.getColumnCount();
			    //한 행만 출력할 것이므로 세로반복할 while가 필요 없다.
			    if(rs.next()){//다음 행이 있으면 참, 없으면 거짓
			    	map = new HashMap<>();
			    for(int i = 1; i<= columnCount; i++){//전체 컬럼의 수만큼 반복하며 값 처리(가로반복)
			    	map.put(metaData.getColumnName(i), rs.getObject(i));
				  }
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{ 
		         if(rs != null) try { rs.close();} catch (Exception e){}
		         if(ps != null) try { ps.close();} catch (Exception e){}
		         if(con != null) try { con.close();} catch (Exception e){}
		    }return map;
		
			
		}
		//2번
		public Map<String, Object>selectOne(String sql,List<Object> param){
			Map<String, Object> map = null;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				for(int i = 0; i < param.size(); i++){
					ps.setObject(i+1, param.get(i));
				}
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				if(rs.next()){//다음 행이 있으면 참, 없으면 거짓
			    	map = new HashMap<>();
			    for(int i = 1; i<= columnCount; i++){//전체 컬럼의 수만큼 반복하며 값 처리(가로반복)
			    	map.put(metaData.getColumnName(i), rs.getObject(i));
				  }
			   }
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{ 
		         if(rs != null) try { rs.close();} catch (Exception e){}
		         if(ps != null) try { ps.close();} catch (Exception e){}
		         if(con != null) try { con.close();} catch (Exception e){}
		    }return map;
			
		}
		//3번
		public List<Map<String, Object>> selectList(String sql){
			List<Map<String, Object>> list = new ArrayList<>();
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			      
			      ResultSetMetaData metaData = rs.getMetaData();
			      int columnCount = metaData.getColumnCount();

			      while(rs.next()){//한 줄씩 바라보며 해당하는 결과를 찾음(세로반복)
			    	  HashMap<String,Object> map = new HashMap<>();
				      for(int i = 1; i<= columnCount; i++){//전체 컬럼의 수만큼 반복하며 값 처리(가로반복)
				      	map.put(metaData.getColumnName(i), rs.getObject(i));//키는 컬럼명,값은 컬럼의 데이터
					    	}
					   	list.add(map);	 	 
				        }
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{ 
		         if(rs != null) try { rs.close();} catch (Exception e){}
		         if(ps != null) try { ps.close();} catch (Exception e){}
		         if(con != null) try { con.close();} catch (Exception e){}
		    }
			return list;
		}
		//4번
		public List<Map<String, Object>> selectList(String sql,List<Object> param){
			List<Map<String, Object>> list = new ArrayList<>();
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				for(int i=0;i<param.size();i++){
					ps.setObject(i+1, param.get(i));//?는 1부터 시작하므로 +1
				}
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
			    int columnCount = metaData.getColumnCount();
			    
			    while(rs.next()){
			    	HashMap<String,Object> map = new HashMap<>();
			    	for(int i=1;i<=columnCount;i++){
			    		map.put(metaData.getColumnName(i), rs.getObject(i));//키는 컬럼명,값은 컬럼의 데이터
			    	}
			    	list.add(map);
			    }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{ 
		         if(rs != null) try { rs.close();} catch (Exception e){}
		         if(ps != null) try { ps.close();} catch (Exception e){}
		         if(con != null) try { con.close();} catch (Exception e){}
		    }
			
			return list;
		}
		
		public int update(String sql){
			int result = 0;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return result;
		}
		public int update(String sql, List<Object> param){
			int result = 0;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				for(int i = 0; i < param.size(); i++){
					ps.setObject(i + 1, param.get(i));
				}
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return result;
		}
		
		
	}



