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
	//������ �ۼ��Ҷ����� �� �� �ڵ带 �ۼ��ϱ⿡�� �ʹ� ���ŷο�Ƿ� �޼��带 ���� Ȱ���ϸ� ���ϴ�.
		//�̱��� ���� : �ν��Ͻ��� ������ �����Ͽ� �ϳ��� �ν��Ͻ��� ����ϴ� ������ ����(�޸� ���� ����)
		
		private JDBCUtil(){
			
		}

		private static JDBCUtil instance;
		
		public static JDBCUtil getInstance(){
			if(instance==null){//instance������ null�϶��� ��ü ����>�������ʹ� �ִ� ��ü ����
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
		 * Map<String, Object>selectOne(String sql)//select�޼���(1���)-?����
		 * Map<String, Object>selectOne(String sql,List<object> param)//?�� �� ���� list�� �־ �ѱ�.
		 * List<Map<String, Object>> selectList(String sql)
		 * List<Map<String, Object>> selectList(String sql,List<object> param)
		 * int update(String sql)//������Ʈ�� ���� ���� int�� ����
		 * int update(String sql,List<object> param)
		 */
		
		//1��
		public Map<String, Object>selectOne(String sql){
//			HashMap<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> map = null;
	//���̴� ��ȸ���ǿ� �´� ������� ���� �� null�� ���ϵǴ���, �ƴϸ� �ʱⰪ �ؽø��� ��ȯ�Ǵ��� 
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
			    int columnCount = metaData.getColumnCount();
			    //�� �ุ ����� ���̹Ƿ� ���ιݺ��� while�� �ʿ� ����.
			    if(rs.next()){//���� ���� ������ ��, ������ ����
			    	map = new HashMap<>();
			    for(int i = 1; i<= columnCount; i++){//��ü �÷��� ����ŭ �ݺ��ϸ� �� ó��(���ιݺ�)
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
		//2��
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
				
				if(rs.next()){//���� ���� ������ ��, ������ ����
			    	map = new HashMap<>();
			    for(int i = 1; i<= columnCount; i++){//��ü �÷��� ����ŭ �ݺ��ϸ� �� ó��(���ιݺ�)
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
		//3��
		public List<Map<String, Object>> selectList(String sql){
			List<Map<String, Object>> list = new ArrayList<>();
			try {
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			      
			      ResultSetMetaData metaData = rs.getMetaData();
			      int columnCount = metaData.getColumnCount();

			      while(rs.next()){//�� �پ� �ٶ󺸸� �ش��ϴ� ����� ã��(���ιݺ�)
			    	  HashMap<String,Object> map = new HashMap<>();
				      for(int i = 1; i<= columnCount; i++){//��ü �÷��� ����ŭ �ݺ��ϸ� �� ó��(���ιݺ�)
				      	map.put(metaData.getColumnName(i), rs.getObject(i));//Ű�� �÷���,���� �÷��� ������
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
		//4��
		public List<Map<String, Object>> selectList(String sql,List<Object> param){
			List<Map<String, Object>> list = new ArrayList<>();
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				for(int i=0;i<param.size();i++){
					ps.setObject(i+1, param.get(i));//?�� 1���� �����ϹǷ� +1
				}
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
			    int columnCount = metaData.getColumnCount();
			    
			    while(rs.next()){
			    	HashMap<String,Object> map = new HashMap<>();
			    	for(int i=1;i<=columnCount;i++){
			    		map.put(metaData.getColumnName(i), rs.getObject(i));//Ű�� �÷���,���� �÷��� ������
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



