package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		  // �˹ٸ� ����ϱ� ���� �˹ٰ�ü ����
	      Alba alba = new Alba();
	      
	      String[] order = alba.order(); // ����Ÿ�԰��� �迭 order������ ����. �ֹ����� ������ �迭 order�� ����
	       System.out.println(Arrays.toString(order));

	       System.out.println("�丮 ����� ��....�ϼ�!");
	       String[] foods={"�ϼ��� ¥���","�ϼ��� ������"};
	       
	       alba.serve(foods);
	       
	       alba.pay(order);
	       
	   }

	}