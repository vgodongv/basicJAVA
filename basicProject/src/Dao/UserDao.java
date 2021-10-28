package Dao;

import java.util.ArrayList;
import java.util.Map;

import Util.JDBCUtil;

public class UserDao {

	   private UserDao() {
	   }

	   private static UserDao instance;

	   public static UserDao getInstance() {
	      if (instance == null) {
	         instance = new UserDao();
	      }
	      return instance;
	   }

	   private JDBCUtil jdbc = JDBCUtil.getInstance();

	   public Map<String, Object> overlap(String userId) {
	      String sql = "SELECT MEM_ID" + "   FROM MEMBER" + "  WHERE MEM_ID=?";
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(userId);
	      return jdbc.selectOne(sql, list);
	   }

	   public void memInsert(String userId, String pw, int type) {
	      String sql = "INSERT INTO MEMBER VALUES(?,?,?)";
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(userId);
	      list.add(pw);
	      list.add(type);
	      jdbc.update(sql, list);

	   }

	   public int albaInsert(Map<String, Object> map) {
	      String sql = "INSERT INTO ALBA VALUES(?,?,?,?,?,?)";
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(map.get("아이디"));
	      list.add(map.get("이름"));
	      list.add(map.get("주소"));
	      list.add(map.get("생년월일"));
	      list.add(map.get("연락처"));
	      list.add(map.get("성별"));

	      return jdbc.update(sql, list);

	   }

	   public Map<String, Object> getType(Map<String, Object> map) {
	      String sql = "SELECT MEM_TYPE" + "    FROM MEMBER"
	            + "   WEHRE MEM_ID=?";
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(map.get("아이디"));
	      return jdbc.selectOne(sql, list);

	   }

	   public Map<String, Object> login(String userId, String pw) {
	      String sql = "SELECT MEM_ID, MEM_PW, MEM_TYPE" + "    FROM MEMBER"
	            + "   WHERE MEM_ID=?" + "     AND MEM_PW=?";
	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(userId);
	      list.add(pw);
	      return jdbc.selectOne(sql, list);

	   }

	   public Map<String, Object> loginmanager(String userId, String pw) {
	      String sql = "SELECT MANAGER_ID, MANAGER_PW, MANAGER_NAME"
	            + "    FROM MANAGER" + "   WHERE MANAGER_ID=?"
	            + "     AND MANAGER_PW=?";

	      ArrayList<Object> list = new ArrayList<Object>();
	      list.add(userId);
	      list.add(pw);
	      return jdbc.selectOne(sql, list);

	   }

	public int ownerInsert(String userId, String comName, String comOwner,
			String comAddr, String comTel) {
		String sql="INSERT INTO OWNER VALUES(?,?,?,?,?)";
		ArrayList<Object> list = new ArrayList<>();
		list.add(userId);
		list.add(comName);
		list.add(comOwner);
		list.add(comAddr);
		list.add(comTel);
		
		return jdbc.update(sql,list);
		
	}



}
