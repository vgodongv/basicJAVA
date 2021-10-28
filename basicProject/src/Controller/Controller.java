package Controller;

import java.util.Map;

import Util.ScanUtil;

public class Controller {
	 public static void main(String[] args) {

	      
	      new Controller().start();
	      
	   }
	   
	   public static Map<String, Object> loginUser =null; //�α��� �� ����� ���� ����
	   UserService userService=UserService.getInstance();
	   BoardService boardService =BoardService.getInstance();
	   
	   private void start() {
	      int view=View.HOME;  //������ HOME���� 
	      
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
	         
	          
	          //����
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
	         
	         
	         case View.LIKEREC:view=boardService.likerec(); break; //���ɰ����߰�
	         case View.GETLIKE:view=boardService.getlike();break;
	         case View.DELLIKE:view=boardService.dellike();break;
	         case View.BOARDLIKEREC:view=boardService.boardlikerec();break;//���ɰ�����
	         
	      
	      
	         case View.MYPAGE:view=boardService.mypage(); break;
	         case View.MYREC:view=boardService.myrec(); break;//�� ä�������-�߰�
	         case View.GETMYREC:view=boardService.getmyrec(); break;//�� ä�������ȸ-�߰�
	         
	         case View.BOARDRSM: view=boardService.boardrsm(); break; //�߰�
	         case View.GETRSM: view=boardService.getrsm(); break; //�߰�
	         case View.LIKERSM:view=boardService.likersm(); break; //�߰�
	         case View.DELLIKERSM: view=boardService.dellikersm(); break; //�߰�
	         case View.BOARDLIKERSM: view=boardService.boardlikersm(); break; //�߰�
	         case View.GETLIKERSM: view=boardService.getlikersm(); break; //�߰�
	         case View.OUTMEMBER: view=boardService.outmember(); break; //�߰�
	         case View.APPLYREC:view=boardService.applyrec(); break;  //�߰�
	         case View.CHECKAPPLY:view=boardService.checkapply(); break; //�߰�
	         case View.DELAPPLY:view=boardService.delapply(); break;
	         case View.GETAPPLY:view=boardService.getapply(); break;
	         
	      }
	      }   
	   }



	   //����Ÿ��: �������� �̵��� ȭ��
	   private int home(){
	      System.out.println("1.�α��� 2.ȸ������ 3.������ 0.���α׷� ����");
	      int input=ScanUtil.nextInt();
	      
	      switch(input){
	      case 1:
	         return View.LOGIN;
	      case 2:
	         System.out.println("ȸ������ ������ �������ּ���");
	         System.out.println("1.���ȸ�� 2.�Ϲ�ȸ��");
	         int number=ScanUtil.nextInt();
	         if(number==1){
	            return View.COMJOIN;
	         }else if(number==2){
	            return View.ALBAJOIN;
	         }
	      case 3:
	         return View.MANAGERLOGIN;
	      
	      case 0:
	         System.out.println("���α׷��� ����Ǿ����ϴ�");
	         System.exit(0);
	      }
	      return View.HOME;
	   }
	}