package util;

public class JDBCUtil {
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	
		private JDBCUtil(){
			
		}
		
		private static JDBCUtil instance;
		
		public static JDBCUtil getInstance(){
			if(instance == null){
				instance = new JDBCUtil();
			}
			return instance;
		}
		
		
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String user = "JHY990208";
		private String password ="java";

		private Connection con = null;
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		
		/*
		 * Map<String, Object> selectOne(String sql)
		 * Map<String, Object> selectOne(String sql, List<Object> param)
		 * List<Map<String, Object>> selectList(String sql)
		 * List<Map<String, Object>> selectList(String sql, List<Object> param)
		 * int update(String sql)
		 * int update(String sql, List<Object> param)
		 */
		
		public Map<String, Object> selectOne(String sql){
			Map<String, Object> map = null;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				if(rs.next()){
					map = new HashMap<>();
					for(int i = 1; i <= columnCount; i++){
						map.put(metaData.getColumnName(i), rs.getObject(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return map;
		}
		
		public Map<String, Object> selectOne(String sql, List<Object> param){
			Map<String, Object> map = null;
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				for(int i = 0; i < param.size(); i++){
					ps.setObject(i + 1, param.get(i));
				}
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				if(rs.next()){
					map = new HashMap<>();
					for(int i = 1; i <= columnCount; i++){
						map.put(metaData.getColumnName(i), rs.getObject(i));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return map;
		}
		
		public List<Map<String, Object>> selectList(String sql){
			List<Map<String, Object>> list = new ArrayList<>();
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				while(rs.next()){
					HashMap<String, Object> map = new HashMap<>();
					for(int i = 1; i <= columnCount; i++){
						map.put(metaData.getColumnName(i), rs.getObject(i));
					}
					list.add(map);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			return list;
		}
		
		public List<Map<String, Object>> selectList(String sql, List<Object> param){
			List<Map<String, Object>> list = new ArrayList<>();
			
			try {
				con = DriverManager.getConnection(url, user, password);
				
				ps = con.prepareStatement(sql);
				for(int i = 0; i < param.size(); i++){
					ps.setObject(i + 1, param.get(i));
				}
				
				rs = ps.executeQuery();
				
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				
				while(rs.next()){
					HashMap<String, Object> map = new HashMap<>();
					for(int i = 1; i <= columnCount; i++){
						map.put(metaData.getColumnName(i), rs.getObject(i));
					}
					list.add(map);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
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
			} finally {
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










