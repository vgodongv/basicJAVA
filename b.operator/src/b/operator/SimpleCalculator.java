package b.operator;

import java.util.Scanner;
public class SimpleCalculator {

	public static void main(String[] args) {
		
		      // 두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요. (계산기만듬. 

		       Scanner sc = new Scanner(System.in);
		       System.out.println("숫자1를 입력해주세요>");
		       int num1 = Integer.parseInt(sc.nextLine());
		      
		       System.out.println("연산자를 입력해주세요>");
		            String y = sc.nextLine(); 
		            
		       System.out.println("숫자2를 입력해주세요>");
		       int num2 = Integer.parseInt(sc.nextLine());
		       
		      
		         
		         int a = num1 / num2;
		         int b = num1 + num2; 
		         int c = num1 - num2;
		         int d = num1 * num2;
		         int e = num1 % num2;
		         
		         int cal = y.equals("/") ? a : (y.equals("+")? b : (y.equals("-")? c : (y.equals("*")? d:(y.equals("%")? e : 0))));   
		          System.out.println(num1+ y +num2+"="+cal);
		          
					/*
					 * 또는 int cal = y.equals("/") ? a : (y.equals("+")? b : (y.equals("-")? c :
					 * (y.equals("*")? d:(y.equals("%")? e : 0)))); System.out.println(num1+ y
					 * +num2+"="+cal)
					 */
		          
	}
		}