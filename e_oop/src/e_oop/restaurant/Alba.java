package e_oop.restaurant;

import java.util.Arrays;

public class Alba {

	   // �޼���: �˹ٰ� �� ��(������ �˹ٿ��� ��Ų ��)
	   // �Ķ����: ���� �ϱ� ���� �ʿ��Ѱ�(������ �˹ٿ��� �ִ°�)
	   // ����Ÿ��: ���� �ϰ� �� �� �����ִ°�(�˹ٰ� �������� �ִ°�)
	   
	   // �ֹ��ޱ� ���� �ʿ��� ��? ����(�������������� ���ٰ� ����)
	   // �ֹ����� �� �������� �� ��? �ֹ���. �ֹ������ Ŭ������ ����� ���°� ����Ʈ����.
	   String[] order(){
	      System.out.println("�ֹ��Ͻðڽ��ϱ�?");
	      //�մ��� �ֹ��ߴ�ġ��
	      return new String[]{"¥���","������"};
	   }
	   
	   // �����ϱ� ���� �ʿ��� ��? �Ķ���� ����
	   // ���� �� �������� �ٰ�?returnŸ�� x
	   
	   void serve(String[] foods){
	      System.out.println(Arrays.toString(foods));
	      System.out.println("���ְ� �弼��.");
	   }
	   
	   //����ϱ� ���� �ʿ��� ��? �ֹ���
	   // ��� �� �������� �ٰ�?����
	   
	   void pay(String[] order){
	      System.out.println("2���� �Դϴ�. �ȳ��� ������.");
	      
	   }
	   
	}