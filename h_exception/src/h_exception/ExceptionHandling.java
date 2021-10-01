package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {
	public static void main(String[] args) {
		/*
		 * 에러
		 *  - 컴파일 에러: 컴파일시에 발생되는 에러(빨간줄)
		 *  - 논리적 에러: 실행은 되지만, 의도와 다르게 동작하는 것(버그)
		 *  - 런타임 에러: 실행 시에 발생되는 에러
		 *  
		 *  런타임 에러
		 *  - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료된다.
		 *  - 에러: 프로그램 코드에 의해 수습될 수 없는 심각한 오류(처리불가)
		 *  - 예외: 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류(처리가능)
		 *  
		 *  예외
		 *  - 모든 예외는 Exception 클래스의 자식 클래스이다.
		 *  - RuntimeException 클래스와 그 자식들은 예외 처리가 강제되지 않는다.
		 *  [RuntimeException 클래스와 그 자식들을 제와한]
		 *  Exception 클래스의 자식들은 예외처리가 강제된다.
		 *  
		 *  예외처리(try-catch)
		 *  - 예외처리를 통해 프로그램이 비정상적으로 종료되는것들 방지할 수 있다.
		 *  - try {} catch(Exception e) {}
		 *  - try 블럭안의 내용을 실행중 예외가 발생하면 catch로 넘어간다.
		 *  - catch의 () 안에는 처리할 예외를 지정해줄 수 있다.
		 *  - 여러종류의 예외를 처리할 수 있도록 catch는 하나 이상 올 수 있다.
		 *  - 발생한 예외와 일치하는 catch 블럭안의 내용이 수행된 후 try-catch를 빠져나간다.
		 *  - 발생한 예외와 일치하는 catch가 없는 경우 예외는 처리되지 않는다.
		 */
		
		// 예외처리를 강제로 형식적으로 해야할때가 많음. 
		// 예외가 발생되는순간 예외객체가 생성되어서 그 객체가 파라미터로 들어오고 들어온상태에서 catch가 실행됨.
		try{
			int result = 10 / 0;                 // 정수는 0으로 나눌 수 없기 때문에 예외 발생
			System.out.println(result);
		}catch(ArithmeticException | IndexOutOfBoundsException e){	
			e.printStackTrace();                 // 블럭안을 비워놔도 예외가 처리되어 정상적으로 실행후 종료됨. 
		}catch(NullPointerException e){
			
		}catch(Exception e){ //모든 클래스의 부모 클래스인 Exception을 통해 모든 예외처리가 가능함. 왠만하면 형식적인 예외처리할때 이거사용
			e.printStackTrace(); 
		}
		
		// Ctrl+1 누르면 예외처리 가능
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		test1();

	}

	private static void test1() {
		test2();
		
	}

	private static void test2() {
		//System.out.println(10/0); // 예외많이뜨면 가장위에 있는 예외로 들어가면됨.
		
		// 내코드가 문젠데 예외가 다른곳에서 발생한다고 뜰수있음. 그럼 다제끼고 내가 만든메서드부분을 보면됨
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}





















