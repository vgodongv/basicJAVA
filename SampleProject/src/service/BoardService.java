package service;

import java.util.List;
import java.util.Map;



public class BoardService {
	private BoardService(){}
    private static BoardService instance;
    public static BoardService getInstance(){
       if(instance == null){
          instance = new BoardService();
       }
       return instance;
    }
    
    private BoardDao boardDao = BoardDao.getInstance();
    
    //게시판 목록
    public int boardList(){
    	List<Map<String, Object>> boardList = boardDao.selectBoardList();
    	
    	System.out.println("================================");
    	System.out.println("번호\t제목\t작성자\t작성일");
    	for(Map<String, Object> board : boardList){
    		System.out.println("---------------------------");
    		System.out.println(board.get("BOARD_NO")
    				+"\t" + board.get("TITLE")
    				+"\t" + board.get("USER_NAME")
    				+" \t"+ board.get("REG_DATE"));
    		
    	}
    	System.out.println("===========================");
    	
    	System.out.println("1.조회  2.등록  0.로그아웃>");
    	int input =ScanUtil.nextInt();
    	switch (input){
    	case 1:
    		System.out.println("조회할 글 번호를 입력해주세요>");
    		boardsee();
    		
    	case 2:
    		
    		break;
    		
    	case 0:
    		
    		Controller.loginUser= null;
    		return View.HOME;
    	
    	}
    	return View.BOARD_LIST;
    	
    }
    
	   public int boardsee(){ //조회메서드
		   String sql= "select * from TB_JDBC_BOARD where cart_member = ?";
		   
    		return boardsee2();
	   }
	   
	   public int boardsee2(){ //수정메서드
		   System.out.println("1.수정\t2.삭제\t3.목록");
		   
		   return View.BOARD_LIST;
	   }
	   
}


