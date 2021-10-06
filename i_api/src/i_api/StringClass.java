package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - �ڹٿ� �����ϴ� ���̺귯��
		 * - �������� ���ڸ� ����ϱ� ���� ����� ���� Ŭ����
		 * 
		 * String�� �ֿ� �޼���
		 * - equals() : ���ڿ��� ������ ������ ��ȯ�Ѵ�. boolean
		 * - length() : ���ڿ��� ���̸� ��ȯ�Ѵ�. int
		 * - charAt() : Ư�� �ε����� ��ġ�� ���ڸ� ��ȯ�Ѵ�. char
		 * - substring() : ���ڿ��� Ư�� �κ��� �߶� ��ȯ�Ѵ�.
		 * - indexOf() : ���ڿ� ���� Ư�� ������ �ε����� ��ȯ�Ѵ�.
		 * - contains() : ���ڿ��� Ư�� ���ڿ��� �����ϰ� �ִ��� ���θ� ��ȯ�Ѵ�.
		 * - split() : ���ڿ��� Ư�� ���ڸ� �������� ������ �迭���·� ��ȯ�Ѵ�.
		 * - trim() : ���ڿ� �յ��� ������ ������ ��ȯ�Ѵ�.
		 * - valueOf(): �ٸ� Ÿ���� �����͸� ���ڿ��� ��ȯ�� ��ȯ�Ѵ�.
		 */
		
		
		
		
		
		boolean equals ="���ڿ�".equals("���ڿ�");
		// ���ڿ��� ������ ����Ͽ� �ִ°�� �� Ÿ���� String �̾����
		String str1 = "���ڿ�";
		String str2 = null;
		System.out.println(str1.equals(str2));
		// System.out.println(str2.equals(str1)); ���ܹ߻�. String Ÿ���̾ null�ΰ��� �Ķ���Ϳ� �� �� �־ �տ� ������ ����
		
		String str ="12345";
		int length = str.length(); // int������ ��ȯ����
		for(int i=0; i<length; i++){
			char charAt = str.charAt(i); //char������ ��ȯ����
			System.out.println(charAt);
		}
		
		//���ڿ� ������
		String rev = ""; // 12345���� 5���� �����ͼ� rev�� ����
		for(int i=str.length()-1; 0<=i; i--){
			rev += str.charAt(i);
		}
		System.out.println(rev);//54321
		
		str="0123456789";
		String sub1 = str.substring(3); // �Ķ���� 1���ƴ� 2�� ���� �� ����. 3���ε������� �߶� ��ȯ
		System.out.println(sub1);//3456789
		String sub2 = str.substring(5,8); // �����ϴ� �ε����� ������ �ε����ε� 567���� ��ȯ. ������ �ε��� 8���� ��µ������� ��-
		System.out.println(sub2); //567
		
		str ="���� ������ �� ��纣��";
		int index = str.indexOf("������"); //�Ķ���ͷ� �ѱ� �������� str���� �����ϴ� �ε��� ��ȯ = 3��
		System.out.println(index);//3
		
		//substring�� indexOf�� �����ؼ� ���ڿ� �ڸ���. �����̸��� ��������
		String[] menu = {
				"���� 20000��",
				"������ 100000��",
				"�� 500��",
				"��纣�� 3000��"
		};
		for(int i=0; i<menu.length; i++){
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
		}
		

		// ���ݸ� �߶� int Ÿ�� ������ ����
		for(int i=0; i<menu.length; i++){
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1, menu[i].indexOf("��")));
			System.out.println(price);
		
		
		}
		
		
		str = "abcd"; 
		boolean contains = str.contains("c");
		System.out.println(contains); //���θ� �˷��ִϱ� boolean Ÿ��
		
		//�������� �޴��� ��� �ε����� �ִ��� ã�� 
		for(int i=0; i<menu.length; i++){
			boolean o = menu[i].contains("������");
			if(o){ // if(menu[i].contains("������")) ����
				System.out.println(i+"�� �ε���");
			}
		}
	
		str = "a/b/c";
		String[] split = str.split("/"); // /�� �������� a,b,c�� �����ְ� �̸� String �迭�� ����
		System.out.println(Arrays.toString(split));
		
		// ������ ���� menu�迭�� �޴���� ���� ������
		for(int i =0; i<menu.length; i++){
			String[] arr = menu[i].split(" ");
		/*	System.out.println(Arrays.toString(arr));*/
			System.out.println("�޴���: "+ arr[0]+" / ����: "+arr[1]);
		}
		
		str= "        �� �� ��     ";
		String trim = str.trim(); // ���ڿ� ���̿� �ִ� ������ �������� �ʰ� ���ڿ� �յڿ� �ִ� ���鸸 ������
		System.out.println("["+str+"] - > ["+trim+"]"); //[        �� �� ��     ] - > [�� �� ��]
		
		
		String id = " myid";
		String password = "mypassword ";
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());
		
		//�ļ��� ���ڿ��� ��ȯ�ϱ�
		int number =10;
		str = number + ""; //�ڹٿ����� Ÿ�Կ�������� ���ڿ��� ������ ���ڿ��� �ٲ�
		
		str= String.valueOf(number); //String Ŭ������ ���� ���
		System.out.println(str);
		
		
	}

}




