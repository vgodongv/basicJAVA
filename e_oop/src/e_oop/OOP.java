package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
	       * 객체지향 프로그래밍(Object Oriented Programming)
	       * - 프로그램을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
	       * - 코드의 재사용성이 높고 유지보수가 용이하다.
	       */
	      
	      SampleClass sc = new SampleClass(); //객체생성.
	                                          // Sampleclass의 내용이 메모리에 올라가고 메모리의 주소가 sc라는 변수에 들어감. 때문에sc를 통해 SampleClass사용가능
	      System.out.println(sc.field);
	      
	      String returnValue = sc.method1(10); //호출한 메서드를 returnValue 변수에 저장
	      System.out.println(returnValue);
	       
	      sc.method2();
	      
	      sc.flowTest1();
	      
	      Calculator calculator= new Calculator(); //객체생성
	      
	       long result1 = calculator.add(123456, 654321);
	      System.out.println(result1);
	      
	      long result2 = calculator.mul(result1, 123456);
	      System.out.println(result2);
	      
	      long result3 = calculator.div(result2, 123456);
	      System.out.println(result3);
	      
	       long result4 = calculator.sub(result3, 654321);
	      System.out.println(result4);
	      
	      long result5 = calculator.remain(result4, 123456);
	      System.out.println(result5);
	      

	      /*쓰앵님 코드
	       double result = cal.add
	      result=cal.mul
	      result=cal.div
	      result=cal.sub
	      result=cal.mod
	      System.out.println(result);*/
	   }

	}
