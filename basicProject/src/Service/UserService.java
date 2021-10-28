package Service;

import java.util.HashMap;
import java.util.Map;

import Dao.UserDao;
import Util.ScanUtil;

public class UserService {
	 private UserService(){}
	   private static UserService instance;
	   public static UserService getInstance() {
	      if(instance==null){
	         instance=new UserService();
	      }
	      return instance;
	   }
	   UserDao userdao=UserDao.getInstance();
	   
	   public int albaJoin() {
	      HashMap<String, Object> map2 = new HashMap<String,Object>();
	      String userId=null;
	      String pw=null;
	      
	      String regex="^[a-zA-Z0-9]*$";
	      Pattern p=Pattern.compile(regex);
	      Matcher m=null;
	      Map<String, Object> map;
	      
	      do{
	      System.out.println("아이디: ");
	      userId=ScanUtil.nextLine();
	       m=p.matcher(userId);
	       map =userdao.overlap(userId);
	      if(!m.matches()){      
	      System.out.println("숫자와 영문자 조합으로 사용해야 합니다.");
	      }
	      if(map!=null){
	         System.out.println("중복된 아이디입니다");
	      }
	      }while(!m.matches()||map!=null);
	      
	      System.out.println("사용가능한 아이디입니다");
	      
	      regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";   
	      p=Pattern.compile(regex);
	      do{
	      System.out.println("비밀번호: ");
	      pw=ScanUtil.nextLine();      
	       m=p.matcher(pw);    
	      if(!m.matches()){
	         System.out.println("최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다");
	      }
	      
	      }while(!m.matches());
	         
	      System.out.println("사용가능한 비밀번호입니다");
	      
	      System.out.println("이름: ");
	      String albaName=ScanUtil.nextLine();
	      System.out.println("생년월일(6자리): ");
	      String albaBir=ScanUtil.nextLine();
	      System.out.println("주소: ");
	      String albaAddr=ScanUtil.nextLine();
	      System.out.println("연락처('-'포함): ");
	      String albaHp=ScanUtil.nextLine();
	      System.out.println("성별(남/여): ");
	      String albaGender=ScanUtil.nextLine();
	      
	      userdao.memInsert(userId,pw,2);
	      
	      map2.put("아이디",userId);
	      map2.put("이름",albaName);
	      map2.put("주소",albaAddr);
	      map2.put("생년월일",albaBir);
	      map2.put("연락처",albaHp);
	      map2.put("성별",albaGender);
	      
	      
	      int result=userdao.albaInsert(map2);
	      
	      
	      if(result>0){
	    	  System.out.println("회원가입이 완료되었습니다");
	      }else{
	    	  System.out.println("회원가입에 실패하였습니다");
	      }
	      
	      return View.HOME;
	      
	      
	      
	   }
	   public int comJoin() {
		   HashMap<String, Object> map2 = new HashMap<String,Object>();
		      String userId=null;
		      String pw=null;
		      
		      String regex="^[a-zA-Z0-9]*$";
		      Pattern p=Pattern.compile(regex);
		      Matcher m=null;
		      Map<String, Object> map;
		      
		      do{
		      System.out.println("아이디: ");
		      userId=ScanUtil.nextLine();
		       m=p.matcher(userId);
		       map =userdao.overlap(userId);
		      if(!m.matches()){      
		      System.out.println("숫자와 영문자 조합으로 사용해야 합니다.");
		      }
		      if(map!=null){
		         System.out.println("중복된 아이디입니다");
		      }
		      }while(!m.matches()||map!=null);
		      
		      
		      System.out.println("사용가능한 아이디입니다");
		      
		      regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";   
		      p=Pattern.compile(regex);
		      do{
		      System.out.println("비밀번호: ");
		      pw=ScanUtil.nextLine();      
		       m=p.matcher(pw);    
		      if(!m.matches()){
		         System.out.println("최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다");
		      }
		      
		      }while(!m.matches());
		         
		      System.out.println("사용가능한 비밀번호입니다");
	      map = new HashMap<String,Object>();
	    
	      System.out.println("업체명: ");
	      String comName=ScanUtil.nextLine();
	      System.out.println("대표자 이름: ");
	      String comOwner=ScanUtil.nextLine();
	      System.out.println("본사주소: ");
	      String comAddr=ScanUtil.nextLine();
	      System.out.println("본사 연락처('-'제외): ");
	      String comTel=ScanUtil.nextLine();
	      
	      userdao.memInsert(userId,pw,1);
	      
	      map.put("아이디: ",userId);
	      map.put("업체명: ",comName);
	      map.put("대표자 이름: ",comOwner);
	      map.put("본사주소: ",comAddr);
	      map.put("본사 연락처: ",comTel);
	     int result= userdao.ownerInsert(userId, comName,comOwner,comAddr,comTel);
	   
	      
	      
	      if(result>0){
	    	  System.out.println("회원가입이 완료되었습니다");
	      }else{
	    	  System.out.println("회원가입에 실패하였습니다");
	      }
	      
	      
	      return View.HOME;
	      
	      
	      
	      
	   }

	   public int login() {
	      System.out.println("아이디: ");      
	      String userId=ScanUtil.nextLine();
	      System.out.println("비밀번호: ");   
	      String pw=ScanUtil.nextLine();
	      Map<String, Object>map2= userdao.login(userId,pw);
	      if(map2!=null){
	         System.out.println("로그인에 성공하였습니다");
	         Controller.loginUser=map2;
	         return View.MAINMENU;      
	      }
	      else{
	         System.out.println("로그인에 실패하였습니다");
	      }
	      return View.LOGIN;
	      
	   }

	    public int managerlogin() {
	        System.out.println("아이디: ");      
	        String managerId=ScanUtil.nextLine();
	        System.out.println("비밀번호: ");   
	        String managerpw=ScanUtil.nextLine();
	      
	        Map<String, Object>map= userdao.loginmanager(managerId,managerpw);
	        
	        
	        if(map!=null){
	              System.out.println("로그인에 성공하였습니다");
	              Controller.loginUser=map;
	              Controller.loginUser.put("MEM_TYPE","3");
	              return View.MAINMENU;      
	           }
	           else{
	              System.out.println("로그인에 실패하였습니다");
	           }
	           return View.MANAGERLOGIN;
	        
	     }
	    
	   public int logout() {
	      Controller.loginUser=null;
	      System.out.println("로그아웃하였습니다");
	      return View.HOME;
	      
	   }
	   
	}