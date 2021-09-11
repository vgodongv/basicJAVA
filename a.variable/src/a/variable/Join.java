package a.variable;
 import java.util.Scanner;
 
public class Join {

	public static void main(String[] args) {
		/*   다음과 같은 프로그램을 만들어주세요
	      ==회원가입==
	      아이디>  admin
	      비밀번호(4자리숫자)>1234
	      이름>홍길동
	      나이>99
	      키>185.5
	      ========
	      회원가입완료!!
	      ==내정보==
	      아이디: admin
	      비밀번호: 1234
	      이름: 홍길동
	      나이: 99세
	      키: 185.5cm
	      =========
	      */
	      
	      // Double.parseDouble()
	      
	      Scanner sc= new Scanner(System.in);
	      
	      System.out.println("아이디를 입력해주세요>");
	      String id = sc.nextLine(); 
	      
	      System.out.println("비밀번호4자리숫자를 입력해주세요>");
	      int num = Integer.parseInt(sc.nextLine());
	      
	      System.out.println("이름을 입력해주세요>");
	      String name = sc.nextLine(); 
	      
	      System.out.println("나이를 입력해주세요>");
	      int age = Integer.parseInt(sc.nextLine());
	   
	      System.out.println("키를 입력해주세요>");
	      double height = Double.parseDouble(sc.nextLine());
	      
	      System.out.println("회원가입완료!");
	      System.out.println("아이디: "+ id);
	      System.out.println("비밀번호: "+ num);
	      System.out.println("이름: "+ name);
	      System.out.println("나이: "+ age);
	      System.out.println("키: "+ height+ "cm");
	   

	

	}

}
