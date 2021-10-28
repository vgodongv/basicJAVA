package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import util.ScanUtil;
import util.View;



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
    
    //�Խ��� ���
    public int boardList(){
    	List<Map<String, Object>> boardList = boardDao.selectBoardList();
    	
    	System.out.println("================================");
    	System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
    	for(Map<String, Object> board : boardList){
    		System.out.println("---------------------------");
    		System.out.println(board.get("BOARD_NO")
    				+"\t" + board.get("TITLE")
    				+"\t" + board.get("USER_NAME")
    				+" \t"+ board.get("REG_DATE"));
    		
    	}
    	System.out.println("===========================");
    	
    	System.out.println("1.��ȸ  2.���  0.�α׾ƿ�>");
    	int input =ScanUtil.nextInt();
    	switch (input){
    	case 1:
    		System.out.println("��ȸ�� �� ��ȣ�� �Է����ּ���>");
    		boardsee();
    		
    	case 2:
    		
    		break;
    		
    	case 0:
    		
    		Controller.loginUser= null;
    		return View.HOME;
    	
    	}
    	return View.BOARD_LIST;
    	
    }
    
	   public int boardsee(){ //��ȸ�޼���
		   String sql= "select * from TB_JDBC_BOARD where cart_member = ?";
		   
    		return boardsee2();
	   }
	   
	   public int boardsee2(){ //�����޼���
		   System.out.println("1.����\t2.����\t3.���");
		   
		   return View.BOARD_LIST;
	   }
	   
}


