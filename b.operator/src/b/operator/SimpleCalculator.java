package b.operator;

import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		
		      // �ΰ��� ���ڿ� �����ڸ� �Է¹޾� �������� �˷��ִ� ���α׷��� ������ּ���. (���⸸��. 

		       Scanner sc = new Scanner(System.in);
		       System.out.println("����1�� �Է����ּ���>");
		       int num1 = Integer.parseInt(sc.nextLine());
		      
		       System.out.println("�����ڸ� �Է����ּ���>");
		            String y = sc.nextLine(); 
		            
		       System.out.println("����2�� �Է����ּ���>");
		       int num2 = Integer.parseInt(sc.nextLine());
		       
		      
		         
		         int a = num1 / num2;
		         int b = num1 + num2; 
		         int c = num1 - num2;
		         int d = num1 * num2;
		         int e = num1 % num2;
		         
		         int cal = y.equals("/") ? a : (y.equals("+")? b : (y.equals("-")? c : (y.equals("*")? d:(y.equals("%")? e : 0))));   
		          System.out.println(num1+ y +num2+"="+cal);
		          
					/*
					 * �Ǵ� int cal = y.equals("/") ? a : (y.equals("+")? b : (y.equals("-")? c :
					 * (y.equals("*")? d:(y.equals("%")? e : 0)))); System.out.println(num1+ y
					 * +num2+"="+cal)
					 */
		          
	}
		}