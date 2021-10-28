package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;


public class Controller {
	public static void main(String[] args) {
		  /*
	       * ��ǥ���� : �� �Ұ� > ���� �Ұ� > ���� ���� ��� > �޴� ���� > �ÿ� > ������Ʈ �ı�
	       * ��ǥ�ο� : ��ǥ��1��, ppt �� �ÿ� ����� 1��
	       * //����(�Ʒ�) - �� ���� ���� ������ ������ �� ������ ���̹Ƿ� �̸� �̷� ����.
	       * Controller : ȭ�� �̵�  - �츮�� �޴� Ŭ���ϸ� �̵��Ǵ°�ó�� 
	       * Service : ȭ�� ���  - ���� ���� ����(�����ͺ��̽��� ���� �������� �ʴ� �����)
	       * Dao : ���� �ۼ�  - �����ͺ��̽��� ������(���� �����ϴ�) ���� 
	       *   ���� ����: ���񽺿� �����ͺ��̽� ������� ����ϸ� �ߺ��� ���ɼ��� ����. ���� ��� �� �Ź� �ڵ� �ݺ�
	       * 
	       * ��ǥ�� 10.27.(��)���Ŀ� ppt�̿��ؼ� 15~20�� ����.
	       */

	       new Controller().start();
	   }
	   
	   public static Map<String, Object> loginUser = null;
	   
	   private UserService userService = UserService.getInstance();
	   private BoardService boardService = BoardService.getInstance();

	   private void start() {
	      int view = View.HOME;
	      
	      while(true){
	         switch (view){//view�� ����ִ� ���ڿ� �°� ȭ���̵�
	         case View.HOME: view = home();  break;//�޼���� ���⿡�� ȣ��
	         case View.LOGIN: view = userService.login(); break;
	         case View.JOIN:  view = userService.join(); break;
	         case View.BOARD_LIST: view =  boardService.boardList(); break;
	         case View.BOARD_SEE: view =  boardService.boardsee(); break;
	         case View.BOARD_SEE2: view =  boardService.boardsee2(); break;
	         }
	      }
	   }
	      

	   //����Ÿ��: �������� �̵��� ȭ���� �����Ѵ�.���� �ٸ�ȭ�� ȣ�� ����
	   private int home() {
	      System.out.println("1.�α��� 2.ȸ������ 0.���α׷� ����>");//������ ����� ������ �޼��尡 ������� ��
	      int input = ScanUtil.nextInt();               //��� �޼��忡 intŸ�� ������ �־���Ѵ�.   
	      
	      switch (input){
	      case 1:
	         return View.LOGIN;//������ �޼��带 ȣ������ �ʴ´�.������ ��
	        
	      case 2:
	         return View.JOIN;
	      case 0:
	      System.out.println("���α׷��� ����Ǿ����ϴ�.");
	      System.exit(0);
	      return 0;
	      }
	      
	      return View.HOME; //����ڰ� �ٸ� ���ڸ� �Է��� ��� �ٽ� Ȩ���� ���ư�����
	   }
	}