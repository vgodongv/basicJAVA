package service;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import dao.UserDao;
import util.ScanUtil;
import util.View;



public class UserService {
	  //�̱��� ���� : ��ü�� �� ���� ���� �����ϴ� �ͤ�>�ٸ� Ŭ���������� ��ü ������ �� ��.
	   //->�����ڿ� private�� ���δ�.
	   private UserService(){}
	   private static UserService instance;
	   public static UserService getInstance(){
	      if(instance == null){
	         instance = new UserService();
	      }
	      return instance;
	   }
	   
	   private UserDao userDao = UserDao.getInstance();
	   
	   //ȸ������
	   public int join(){
	      System.out.println("==============ȸ������=============");
	      System.out.println("���̵�>");
	      String userId = ScanUtil.nextLine();
	      System.out.println("��й�ȣ>");
	      String password = ScanUtil.nextLine();
	      System.out.println("�̸�>");
	      String userName = ScanUtil.nextLine();
	      //���̵� �ߺ� Ȯ�� ����
	      //��й�ȣ Ȯ�� ����
	      //��ȿ�� �˻�(����ǥ����) ����:������ �� �߰��ؾ�
	      
	      Map<String, Object> param = new HashMap<>();
	      param.put("USER_ID",userId);
	      param.put("PASSWORD",password);
	      param.put("USER_NAME",userName);
	      
	      int result = userDao.insertUser(param);
	      
	      if(0<result){
	         System.out.println("ȸ������ ����");
	      }else{
	         System.out.println("ȸ������ ����");
	      }
	      return View.HOME;
	      
	      
	   }
	   public int login() {
	      System.out.println("==============�α���=============");
	      System.out.println("���̵�>");
	      String userId = ScanUtil.nextLine();
	      System.out.println("��й�ȣ>");
	      String password = ScanUtil.nextLine();
	      
	      Map<String, Object> user = userDao.selectUser(userId, password);
	      
	      if(user == null){
	         System.out.println("���̵� Ȥ�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
	      }else{
	         System.out.println("�α��� ����");
	         //�α��� ����:�α����� ����� ������ ��򰡿� �����ϴ� ��(�׷��� �� ����� ���� �� Ȱ�� ����)
	         Controller.loginUser = user;
	         return View.BOARD_LIST;
	      }
	      
	      return View.LOGIN;//�α��� ���� �� �ٽ� �α����ϵ���.
	      
	      
	   }
	   

	   
	}