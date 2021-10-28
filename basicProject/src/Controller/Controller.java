package Controller;

import java.util.Map;

import Util.ScanUtil;

public class Controller {
	 public static void main(String[] args) {

	      
	      new Controller().start();
	      
	   }
	   
	   public static Map<String, Object> loginUser =null; //로그인 한 사람의 정보 저장
	   UserService userService=UserService.getInstance();
	   BoardService boardService =BoardService.getInstance();
	   
	   private void start() {
	      int view=View.HOME;  //시작을 HOME부터 
	      
	      while(true){
	         switch(view){
	         case View.HOME: view=home();  break;
	         case View.LOGIN:view=userService.login();break;
	         case View.MANAGERLOGIN:view=userService.managerlogin();break;
	         case View.ALBAJOIN: view=userService.albaJoin();break;
	         case View.COMJOIN: view=userService.comJoin();break;
	         case View.MAINMENU: {
	            if(loginUser.get("MEM_TYPE").equals("1")){
	               view=BoardService.comMenu();
	               break;   
	            }
	            else if(loginUser.get("MEM_TYPE").equals("2")){
	            view=BoardService.albaMenu();
	            break;
	            
	         }else{
	            view = BoardService.managerMenu();
	            break;
	         }
	      
	         }
	         case View.LOGOUT: view=userService.logout();break;
	         
	          
	          //리뷰
	         case View.BOARDREVIEW: view=boardService.boardreview();break;
	         case View.GETREVIEW: view=boardService.getreview();break;
	         case View.WRITEREVIEW: view=boardService.writereview(); break;
	         case View.EDITREVIEW:view=boardService.editreview(); break;
	         case View.DELREVIEW:view=boardService.delreview(); break;
	         
	         case View.WRITERSM: view=boardService.writersm(); break;
	         case View.MYRSM:view=boardService.myrsm(); break;
	         case View.GETMYRSM:view=boardService.getmyrsm(); break;
	         case View.EDITRSM:view=boardService.editrsm();break;
	         case View.DELRSM:view=boardService.delrsm();break;
	         
	         case View.BOARDNOTE:view=boardService.boardnote();break;
	         case View.WRITENOTE:view=boardService.writenote();break;
	         case View.GETNOTE:view=boardService.getnote();break;
	         case View.EDITNOTE:view=boardService.editnote();break;
	         case View.DELNOTE:view=boardService.delnote();break;
	   
	         case View.BOARDQNA:view=boardService.boardqna();break;
	         case View.WRITEQNA:view=boardService.writeqna();break;
	         case View.EDITQNA:view=boardService.editqna();break;
	         case View.DELQNA:view=boardService.delqna();break;
	         case View.GETQNA:view=boardService.getqna();break;
	         
	         case View.BOARDINQ:view=boardService.boardinq();break;
	         case View.GETINQ:view=boardService.getinq();break;
	         case View.WRITEINQ:view=boardService.writeinq();break;
	         case View.EDITINQ:view=boardService.editinq();break;
	         case View.DELINQ:view=boardService.delinq();break;
	         case View.ANSINQ:view=boardService.ansinq();break;
	         
	         case View.MYINFO:view=boardService.myinfo();break;
	         case View.CHANGEDETAIL:view=boardService.changedetail(); break;
	         case View.CHANGEPW:view=boardService.changepw(); break;
	         case View.MEMINFO:view=boardService.meminfo();break;
	         case View.ALBAINFO:view=boardService.albainfo();break;
	         case View.COMINFO:view=boardService.cominfo();break;
	         
	         case View.EDITREC:view=boardService.editrec();break;
	         case View.DELREC:view=boardService.delrec();break;
	         case View.GETREC:view=boardService.getrec();break;
	         case View.WRITEREC:view=boardService.writerec();break;
	         case View.RECRUITFILTER:view=boardService.recruitfilter();break;
	         case View.BOARDREC:view=boardService.boardrec();break;
	         case View.RECFILTER_ADDR:view=boardService.recfilteraddr();break;
	         case View.RECFILTER_JOB:view=boardService.recfilterjob();break;
	         case View.RECFILTER_TIME:view=boardService.recfiltertime();break;
	         case View.RECFILTER_TERM:view=boardService.recfilterterm();break;
	         case View.RSMFILTER:view=boardService.resumefilter();break;
	         case View.RSMFILTER_ADDR:view=boardService.rsmfilteraddr();break;
	         case View.RSMFILTER_GEN:view=boardService.rsmfiltergen();break;
	         case View.RSMFILTER_PRE:view=boardService.rsmfilterpre();break;
	         
	         
	         case View.LIKEREC:view=boardService.likerec(); break; //관심공고추가
	         case View.GETLIKE:view=boardService.getlike();break;
	         case View.DELLIKE:view=boardService.dellike();break;
	         case View.BOARDLIKEREC:view=boardService.boardlikerec();break;//관심공고목록
	         
	      
	      
	         case View.MYPAGE:view=boardService.mypage(); break;
	         case View.MYREC:view=boardService.myrec(); break;//내 채용공고목록-추가
	         case View.GETMYREC:view=boardService.getmyrec(); break;//내 채용공고조회-추가
	         
	         case View.BOARDRSM: view=boardService.boardrsm(); break; //추가
	         case View.GETRSM: view=boardService.getrsm(); break; //추가
	         case View.LIKERSM:view=boardService.likersm(); break; //추가
	         case View.DELLIKERSM: view=boardService.dellikersm(); break; //추가
	         case View.BOARDLIKERSM: view=boardService.boardlikersm(); break; //추가
	         case View.GETLIKERSM: view=boardService.getlikersm(); break; //추가
	         case View.OUTMEMBER: view=boardService.outmember(); break; //추가
	         case View.APPLYREC:view=boardService.applyrec(); break;  //추가
	         case View.CHECKAPPLY:view=boardService.checkapply(); break; //추가
	         case View.DELAPPLY:view=boardService.delapply(); break;
	         case View.GETAPPLY:view=boardService.getapply(); break;
	         
	      }
	      }   
	   }



	   //리턴타입: 다음으로 이동할 화면
	   private int home(){
	      System.out.println("1.로그인 2.회원가입 3.관리자 0.프로그램 종료");
	      int input=ScanUtil.nextInt();
	      
	      switch(input){
	      case 1:
	         return View.LOGIN;
	      case 2:
	         System.out.println("회원가입 유형을 선택해주세요");
	         System.out.println("1.기업회원 2.일반회원");
	         int number=ScanUtil.nextInt();
	         if(number==1){
	            return View.COMJOIN;
	         }else if(number==2){
	            return View.ALBAJOIN;
	         }
	      case 3:
	         return View.MANAGERLOGIN;
	      
	      case 0:
	         System.out.println("프로그램이 종료되었습니다");
	         System.exit(0);
	      }
	      return View.HOME;
	   }
	}