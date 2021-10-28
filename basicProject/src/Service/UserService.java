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
	      System.out.println("���̵�: ");
	      userId=ScanUtil.nextLine();
	       m=p.matcher(userId);
	       map =userdao.overlap(userId);
	      if(!m.matches()){      
	      System.out.println("���ڿ� ������ �������� ����ؾ� �մϴ�.");
	      }
	      if(map!=null){
	         System.out.println("�ߺ��� ���̵��Դϴ�");
	      }
	      }while(!m.matches()||map!=null);
	      
	      System.out.println("��밡���� ���̵��Դϴ�");
	      
	      regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";   
	      p=Pattern.compile(regex);
	      do{
	      System.out.println("��й�ȣ: ");
	      pw=ScanUtil.nextLine();      
	       m=p.matcher(pw);    
	      if(!m.matches()){
	         System.out.println("�ּ� 8�ڸ��� ����, ����, Ư������ ���� 1�� �̻� �����ؾ� �մϴ�");
	      }
	      
	      }while(!m.matches());
	         
	      System.out.println("��밡���� ��й�ȣ�Դϴ�");
	      
	      System.out.println("�̸�: ");
	      String albaName=ScanUtil.nextLine();
	      System.out.println("�������(6�ڸ�): ");
	      String albaBir=ScanUtil.nextLine();
	      System.out.println("�ּ�: ");
	      String albaAddr=ScanUtil.nextLine();
	      System.out.println("����ó('-'����): ");
	      String albaHp=ScanUtil.nextLine();
	      System.out.println("����(��/��): ");
	      String albaGender=ScanUtil.nextLine();
	      
	      userdao.memInsert(userId,pw,2);
	      
	      map2.put("���̵�",userId);
	      map2.put("�̸�",albaName);
	      map2.put("�ּ�",albaAddr);
	      map2.put("�������",albaBir);
	      map2.put("����ó",albaHp);
	      map2.put("����",albaGender);
	      
	      
	      int result=userdao.albaInsert(map2);
	      
	      
	      if(result>0){
	    	  System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
	      }else{
	    	  System.out.println("ȸ�����Կ� �����Ͽ����ϴ�");
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
		      System.out.println("���̵�: ");
		      userId=ScanUtil.nextLine();
		       m=p.matcher(userId);
		       map =userdao.overlap(userId);
		      if(!m.matches()){      
		      System.out.println("���ڿ� ������ �������� ����ؾ� �մϴ�.");
		      }
		      if(map!=null){
		         System.out.println("�ߺ��� ���̵��Դϴ�");
		      }
		      }while(!m.matches()||map!=null);
		      
		      
		      System.out.println("��밡���� ���̵��Դϴ�");
		      
		      regex="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";   
		      p=Pattern.compile(regex);
		      do{
		      System.out.println("��й�ȣ: ");
		      pw=ScanUtil.nextLine();      
		       m=p.matcher(pw);    
		      if(!m.matches()){
		         System.out.println("�ּ� 8�ڸ��� ����, ����, Ư������ ���� 1�� �̻� �����ؾ� �մϴ�");
		      }
		      
		      }while(!m.matches());
		         
		      System.out.println("��밡���� ��й�ȣ�Դϴ�");
	      map = new HashMap<String,Object>();
	    
	      System.out.println("��ü��: ");
	      String comName=ScanUtil.nextLine();
	      System.out.println("��ǥ�� �̸�: ");
	      String comOwner=ScanUtil.nextLine();
	      System.out.println("�����ּ�: ");
	      String comAddr=ScanUtil.nextLine();
	      System.out.println("���� ����ó('-'����): ");
	      String comTel=ScanUtil.nextLine();
	      
	      userdao.memInsert(userId,pw,1);
	      
	      map.put("���̵�: ",userId);
	      map.put("��ü��: ",comName);
	      map.put("��ǥ�� �̸�: ",comOwner);
	      map.put("�����ּ�: ",comAddr);
	      map.put("���� ����ó: ",comTel);
	     int result= userdao.ownerInsert(userId, comName,comOwner,comAddr,comTel);
	   
	      
	      
	      if(result>0){
	    	  System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
	      }else{
	    	  System.out.println("ȸ�����Կ� �����Ͽ����ϴ�");
	      }
	      
	      
	      return View.HOME;
	      
	      
	      
	      
	   }

	   public int login() {
	      System.out.println("���̵�: ");      
	      String userId=ScanUtil.nextLine();
	      System.out.println("��й�ȣ: ");   
	      String pw=ScanUtil.nextLine();
	      Map<String, Object>map2= userdao.login(userId,pw);
	      if(map2!=null){
	         System.out.println("�α��ο� �����Ͽ����ϴ�");
	         Controller.loginUser=map2;
	         return View.MAINMENU;      
	      }
	      else{
	         System.out.println("�α��ο� �����Ͽ����ϴ�");
	      }
	      return View.LOGIN;
	      
	   }

	    public int managerlogin() {
	        System.out.println("���̵�: ");      
	        String managerId=ScanUtil.nextLine();
	        System.out.println("��й�ȣ: ");   
	        String managerpw=ScanUtil.nextLine();
	      
	        Map<String, Object>map= userdao.loginmanager(managerId,managerpw);
	        
	        
	        if(map!=null){
	              System.out.println("�α��ο� �����Ͽ����ϴ�");
	              Controller.loginUser=map;
	              Controller.loginUser.put("MEM_TYPE","3");
	              return View.MAINMENU;      
	           }
	           else{
	              System.out.println("�α��ο� �����Ͽ����ϴ�");
	           }
	           return View.MANAGERLOGIN;
	        
	     }
	    
	   public int logout() {
	      Controller.loginUser=null;
	      System.out.println("�α׾ƿ��Ͽ����ϴ�");
	      return View.HOME;
	      
	   }
	   
	}