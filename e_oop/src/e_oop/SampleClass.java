package e_oop;

public class SampleClass {

	public static void main(String[] args) {
		//프로그램을 실행시키면 main메소드 실행됨
	      // 클래스는 변수, 메소드로 구성가능
	      int local=10; //지역변수: 메서드 안에서만 사용하는 변수
	      
	   }
	       int field; // 전역변수: 클래스 전체 영역에서 사용하는 변수. 초기화하지 않아도 기본값 0으로 초기화됨.
	       
	       /*
	        * - 메서드: 변수를 가지고 할일 // 보통은 전역변수
	        * - 선언방법: 리턴타입 메서드명(파라미터) {}
	        * - 파라미터(매개변수) : 실행에 필요한 정보
	        * - 리턴 타입(반환타입): 실행후 돌려줘야하는 결과물. 결과의 타입.
	        */
	       
	       String method1(int parameter){
	          return parameter + "를 받아 명령을 수행하고 결과물을 리턴하는 메서드"; // 반환값은 반환타입인 String과 일치하거나 적어도 자동형변환이 가능한것이어야함.
	       }
	       
	       void method2(){// void 비어있다.
	          System.out.println("파라미터도 리턴타입도 없는 메서드");
	       }
	       
	       void flowTest1(){
	          System.out.println("flowTest1 시작: 1");
	          flowTest3();
	          System.out.println("flowTest1 종료: 6");
	       }
	       
	       void flowTest2(){
	          System.out.println("flowTest2 시작: 3");
	          System.out.println("flowTest2 종료: 4");
	       }
	       
	        void flowTest3(){
	           System.out.println("flowTest3 시작: 2");
	           flowTest2();
	           System.out.println("flowTest3 종료:5 ");
	        }
	        
	}








