package b.operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		  /*
		    * ��Ʈ ������
		    * - |, &, ^, ~, <<, >>
		    * - ��Ʈ ������ �����Ѵ�.
		    * 
		    * ��Ÿ ������
		    * - .(����������) : Ư�� �������� ���� �ִ� ����� ��Ī�� �� ����Ѵ�.
		    * - ?:(���׿�����-�߿�): 
		     ���ǽ� ? ���ǽ��� ���� ��� ������ ���� : ���ǽ��� ������ ��� ������ ����
		    */
		     
		      
		      System.out.println(10 | 15);
		      // 10��2������ ǥ���ϸ�  00001010 15�� 2������ ǥ���ϸ� 00001111
		      // 00001010
		      // 00001111
		      // 00001111 �Ѵ� 0�̸� 0 �׷��� ������ 1
		      
		       int x = 10;
		       int y = 20;
		       int result = x < y ? x : y;
		       // x < y���ǽ��� ����� ���� x�ƴϸ� y�� �ϳ��� ����Ǵ� ����
		       // x< y�� ���̸� x���� �����̸� y
		       System.out.println(result);
		       
		       // �ֹε�Ϲ�ȣ ���ڸ��� ù��° ���ڰ� 1�̸� ���� 2�鿩��
		       
		       int regNO =3;
		       String gender = regNO == 1? "����" : "����";
		       System.out.println("����� ������"+ gender +"�Դϴ�.");
		       // 2 �̿��� ���� ���ڷ� �νĵǴ� ����
		       gender = regNO == 1? "����" : (regNO ==2 ? "����": "Ȯ�κҰ�");
		       System.out.println("����� ������"+ gender +"�Դϴ�.");
		       
		       // 2���� ���ڸ� �Է¹ް�, ���� ��ū ���ڸ� ������ּ���
		       
		Scanner sc = new Scanner(System.in);
		System.out.println("����1�� �Է����ּ���>");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.println("����2�� �Է����ּ���>");
		int num2 = Integer.parseInt(sc.nextLine());

		int re = num1 < num2 ? num2 : num1;
		System.out.println(re);

		//  �̰͵� �� 
		
		System.out.println(num1 < num2 ? num2 : num1);
		   
		// ���ڸ� �Է¹ް�, �� ���ڰ� 1�̳� 3�̸� ���ڸ� 2�� 4�� ���ڸ� ������ּ���
		       // �׿��� ���ڸ� �Է��ϸ� Ȯ�κҰ��� ���
		       
		   
		       System.out.println("����1�� �Է����ּ���>");
		       int num3 = Integer.parseInt(sc.nextLine());
		       System.out.println("����2�� �Է����ּ���>");
		       int num4 = Integer.parseInt(sc.nextLine());
		   
		       String cal = num3 == 1 || num4 == 3 ? "����" : (num3 ==2 || num4==4?"����":"Ȯ�κҰ�");
		   
		       System.out.println("num3"+ cal +"num4"+"="+cal);
		       
		        
		   }

		}
