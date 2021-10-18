package dao;

import java.util.List;
import java.util.Map;

public class BoardDao {
	 private BoardDao(){}
	    private static BoardDao instance;
	    public static BoardDao getInstance(){
	       if(instance == null){
	          instance = new  BoardDao();
	       }
	       return instance;
	    }
	    
	    private JDBCUtil jdbc = JDBCUtil.getInstance(); //DB접속위해 객체생성
	    
	    public List<Map<String, Object>> selectBoardList(){ //게시판 조회위한 메서드
	    	String sql="SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE"
	    			+"    FROM TB_JDBC_BOARD A"
	    			+"    LEFT OUTER JOIN TB_JDBC_USER B ON A.USER_ID = B.USER_ID"
	    			+"   ORDER BY A.BOARD_NO DESC";
	    	
	    	return jdbc.selectList(sql);
	    	
	    }

}
