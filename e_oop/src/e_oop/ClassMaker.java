package e_oop;

public class ClassMaker {
	  // 전역변수 하나를 선언 및 초기화 해주세요.
	   int a=1;
	   
	   // 리턴타입과 파라미터가 없는 메서드 하나를 만들어주세요
	   // 메서드 안에서 전역변수를 출력해주세요
	   void method(){
	      System.out.println(a);
	   }
	   
	   //전역변수와 동일한 타입의 리턴타입이 있고 파라미터는 없는 메서드를 만들어주세요
	   // 메서드안에서 전역변수를 리턴해주세요
	   
	   int methodd(){
	      return a;
	   }
	   
	   //리턴타입은 없고 파라미터가 있는 메서드 하나를 만들어주세요
	   // 메서드 안에서 파라미터를 출력해주세요
	   
	   void methoddd(int b){
	      System.out.println(b);
	   }
	   
	   
	   //int 타입의 리턴타입과 int타입의 파라미터 두개가 있는 메서드 하나
	   // 메서드안에 두 파라미터를 곱한 결과를 리턴
	   
	   int methodddd(int z,int y){
	        return z*y;
	   }
	    
	   //return : 값을 돌려주는 역할과 메서드를 종료시키는 역할. void 메서드에서도 return사용가능한데 이때가 메서드를 종료시키는역할.
	
	   main()함수에서의 return 0은 프로그램의 종료를 나타낸다.
	   
	   
	}
