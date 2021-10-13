package k_jdbc;

public class JDBCTest {
	public static void main(String[] args) {
		JDBCUtil jdbc = JDBCUtil.getInstance();
		

		

		
		
//		1번
/*		String sql= "select * from cart where cart_no = 2005040100001";
		Map<String, Object> map = jdbc.selectOne(sql);
		System.out.println(map);
*/
			
		
 //		2번
/*		String sql= "select * from cart where cart_member = ?";
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		
		Map<String, Object> Map = jdbc.selectOne(sql, param);
		System.out.println(Map);
*/

		
//		//3번
/*		String sql = " select * from cart ";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for(Map<String, Object>map : list){
				System.out.println(map);
		}
*/
		
//		4번		
/*		String sql = "select * from cart"
		+ " where cart_member = ? "
		+ "and cart_qty > ?";
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		param.add(5);
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		for(Map<String, Object>map : list){
			System.out.println(map);
		}
*/
		
//		5번
		/*
		String sql = "update cart set cart_qty = cart_qty - 1";
		int result = jdbc.update(sql);
		System.out.println(result);
		*/		
		
//		6번
/*		String sql = "insert into cart values(?,?,?,?)";
		ArrayList<Object> param = new ArrayList<>();
		param.add("a001");
		param.add("200504010001");
		param.add("P101000002");
		param.add(10);
		
		int result = jdbc.update(sql, param);
		System.out.println(result);
*/		
		
		
				
		
	}

