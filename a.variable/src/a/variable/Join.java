package a.variable;
 import java.util.Scanner;
 
public class Join {

	public static void main(String[] args) {
		/*   ������ ���� ���α׷��� ������ּ���
	      ==ȸ������==
	      ���̵�>  admin
	      ��й�ȣ(4�ڸ�����)>1234
	      �̸�>ȫ�浿
	      ����>99
	      Ű>185.5
	      ========
	      ȸ�����ԿϷ�!!
	      ==������==
	      ���̵�: admin
	      ��й�ȣ: 1234
	      �̸�: ȫ�浿
	      ����: 99��
	      Ű: 185.5cm
	      =========
	      */
	      
	      // Double.parseDouble()
	      
	      Scanner sc= new Scanner(System.in);
	      
	      System.out.println("���̵� �Է����ּ���>");
	      String id = sc.nextLine(); 
	      
	      System.out.println("��й�ȣ4�ڸ����ڸ� �Է����ּ���>");
	      int num = Integer.parseInt(sc.nextLine());
	      
	      System.out.println("�̸��� �Է����ּ���>");
	      String name = sc.nextLine(); 
	      
	      System.out.println("���̸� �Է����ּ���>");
	      int age = Integer.parseInt(sc.nextLine());
	   
	      System.out.println("Ű�� �Է����ּ���>");
	      double height = Double.parseDouble(sc.nextLine());
	      
	      System.out.println("ȸ�����ԿϷ�!");
	      System.out.println("���̵�: "+ id);
	      System.out.println("��й�ȣ: "+ num);
	      System.out.println("�̸�: "+ name);
	      System.out.println("����: "+ age);
	      System.out.println("Ű: "+ height+ "cm");
	   

	

	}

}
