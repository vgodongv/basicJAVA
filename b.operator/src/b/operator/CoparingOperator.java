package b.operator;

public class CoparingOperator {

	public static void main(String[] args) {
		 /*
	       * �� ������
	       * - <, >, <=, >=, ==, !=
	       * - ���ڿ� ��: equals()
	       */

	      int x = 10;
	      int y = 20;
	      boolean b = x < y;
	      System.out.println(b);
	      
	      b = x <= y - 15; // �񱳿��꺸�� ��������� ���� �����. ����� �翬�Ѱ�.
	      System.out.println(b);
	      
	      String str1 = "abc";
	      String str2 = "ABC";
	      b = str1 == str2;
	      // �����ȿ� ����ִ� �ּҸ� ���Ѱ�. ������ �ٸ��� ������ �ּҰ� �ٸ� ������ false
	      System.out.println(b);
	      // ���ڿ��� ������ ���Ѱ��̾ƴ�. 
	      // �߿�!! String�� ������Ÿ��. �����ȿ� ���� ���� ����ִ°��� �ƴ϶� �ּҰ� �������
	      
	      // equals() �޼ҵ� -�ּҰ��� �ƴ� ���ڿ��� ������ ���ϴ� ���. 
	      b = str1.equals(str2);
	      System.out.println(b);
	     
	      
	      //���� �ʴٷ� ���ϰ������
	      String str3 = "abc";
	      String str4 = "ABC";
	      b = str3 != str4;
	      b = !str1.equals(str2);
	      
	      //������ ������� �ڵ�� �ۼ����ּ���.
	      // x�� y���� �۰ų� ����.
	      b = x <= y;
	      
	      // x + 5 �� y�� ����.
	      b= x + 5 == y;
	      
	      // y�� Ȧ���̴�.
	      b = y % 2 == 1;
	      
	      // "�⺻��"�� "������"�� �ٸ���.   
	      b = !"�⺻��".equals("������");
	   }

	}
