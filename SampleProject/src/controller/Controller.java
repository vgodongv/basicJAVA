package controller;

import java.util.Map;


public class Controller {
	public static void main(String[] args) {
		  /*
	       * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 프로젝트 후기
	       * 발표인원 : 발표자1명, ppt 및 시연 도우미 1명
	       * //구조(아래) - 웹 개발 구조 이지만 앞으로 웹 개발할 것이므로 미리 이런 구조.
	       * Controller : 화면 이동  - 우리가 메뉴 클릭하면 이동되는것처럼 
	       * Service : 화면 기능  - 실제 서비스 내용(데이터베이스에 직접 접근하지 않는 내용들)
	       * Dao : 쿼리 작성  - 데이터베이스와 연관된(직접 접근하는) 내용 
	       *   구분 이유: 서비스에 데이터베이스 내용까지 기술하면 중복의 가능성이 있음. 서비스 사용 시 매번 코드 반복
	       * 
	       * 발표는 10.27.(수)오후에 ppt이용해서 15~20분 정도.
	       */

	      new Controller().start();
	   }
	   
	   public static Map<String, Object> loginUser = null;
	   
	   private UserService userService = UserService.getInstance();
	   private BoardService boardService = BoardService.getInstance();

	   private void start() {
	      int view = View.HOME;
	      
	      while(true){
	         switch (view){//view에 들어있는 숫자에 맞게 화면이동
	         case View.HOME: view = home();  break;//메서드는 여기에서 호출
	         case View.LOGIN: view = userService.login(); break;
	         case View.JOIN:  view = userService.join(); break;
	         case View.BOARD_LIST: view =  boardService.boardList(); break;
	         case View.BOARD_SEE: view =  boardService.boardsee(); break;
	         case View.BOARD_SEE2: view =  boardService.boardsee2(); break;
	         }
	      }
	   }
	      

	   //리턴타입: 다음으로 이동할 화면을 리턴한다.직접 다른화면 호출 금지
	   private int home() {
	      System.out.println("1.로그인 2.회원가입 0.프로그램 종료>");//각각의 기능을 구현한 메서드가 만들어질 것
	      int input = ScanUtil.nextInt();               //모든 메서드에 int타입 리턴이 있어야한다.   
	      
	      switch (input){
	      case 1:
	         return View.LOGIN;//각각의 메서드를 호출하지 않는다.리턴할 뿐
	        
	      case 2:
	         return View.JOIN;
	      case 0:
	      System.out.println("프로그램이 종료되었습니다.");
	      System.exit(0);
	      return 0;
	      }
	      
	      return View.HOME; //사용자가 다른 숫자를 입력할 경우 다시 홈으로 돌아가도록
	   }
	}