package g_oop2;

public interface SampleInterface { //클래스가 인터페이스 상속받음
	
	// 클래스는 구체적인 세부내용이 있는거라면 인터페이스는 설계도처럼 틀만 존재. 
	// 인터페이스는 상수랑 추상 메서드만 존재가능. 일반적인 변수와 메서드 넣을 수 없음.
		
		//상수: 값을 변경할 수 없는 변수. 고정된값을 저장해놓기위해 사용
		
		//인터페이스의 모든 맴버변수는 public static final 제어자를 사용해야된다.
		public static final int NUM1= 1; //final-> 변수의 값을 변경하지 못하게 만듬 -> NUM1이 상수. 상수의 이름은 대문자
		
		//모든 멤버변수의 제어자가 같기 때문에 생략이  가능하다.
		int NUM2 =2;
		
		//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다.
		public abstract void method1();
		
		//모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
		void method2();

	}

	class SampleImplement implements SampleInterface, SampleInterface2 { // 인터페이스의 추상메서드 상속받으니까 오버라이딩
	// 클래스의 경우 하나의 클래스(추상클래스도)만 상속 받을 수 있지만 인터페이스는 여러개의 인터페이스 상속받을 수 있음
		@Override
		public void method1() {
		
			
		}

		@Override
		public void method2() {
			
			
		}

		@Override
		public void method3() {
			// TODO Auto-generated method stub
			
		} 
		
	}

	interface SampleInterface2{
		void method1();
		void method3();
	}

