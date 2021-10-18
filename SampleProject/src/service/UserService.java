package service;

import java.util.HashMap;
import java.util.Map;



public class UserService {
	  //싱글톤 패턴 : 객체를 한 개만 만들어서 공유하는 것ㅡ>다른 클래스에서는 객체 생성을 안 함.
	   //->생성자에 private를 붙인다.
	   private UserService(){}
	   private static UserService instance;
	   public static UserService getInstance(){
	      if(instance == null){
	         instance = new UserService();
	      }
	      return instance;
	   }
	   
	   private UserDao userDao = UserDao.getInstance();
	   
	   //회원가입
	   public int join(){
	      System.out.println("==============회원가입=============");
	      System.out.println("아이디>");
	      String userId = ScanUtil.nextLine();
	      System.out.println("비밀번호>");
	      String password = ScanUtil.nextLine();
	      System.out.println("이름>");
	      String userName = ScanUtil.nextLine();
	      //아이디 중복 확인 생략
	      //비밀번호 확인 생략
	      //유효성 검사(정규표현식) 생략:생략한 것 추가해야
	      
	      Map<String, Object> param = new HashMap<>();
	      param.put("USER_ID",userId);
	      param.put("PASSWORD",password);
	      param.put("USER_NAME",userName);
	      
	      int result = userDao.insertUser(param);
	      
	      if(0<result){
	         System.out.println("회원가입 성공");
	      }else{
	         System.out.println("회원가입 실패");
	      }
	      return View.HOME;
	      
	      
	   }
	   public int login() {
	      System.out.println("==============로그인=============");
	      System.out.println("아이디>");
	      String userId = ScanUtil.nextLine();
	      System.out.println("비밀번호>");
	      String password = ScanUtil.nextLine();
	      
	      Map<String, Object> user = userDao.selectUser(userId, password);
	      
	      if(user == null){
	         System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
	      }else{
	         System.out.println("로그인 성공");
	         //로그인 성공:로그인한 사람의 정보를 어딘가에 저장하는 것(그래야 그 사람의 접속 후 활동 저장)
	         Controller.loginUser = user;
	         return View.BOARD_LIST;
	      }
	      
	      return View.LOGIN;//로그인 실패 시 다시 로그인하도록.
	      
	      
	   }
	   

	   
	}