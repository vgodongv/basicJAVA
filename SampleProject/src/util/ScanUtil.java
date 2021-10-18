package util;

public class ScanUtil {

	//메서드에 static을 붙히는 이유는 객체를 생성하고 싶지 않아서.
	
	
	private static Scanner s = new Scanner(System.in);
	
	//문자열 입력받는 메소드
	public static String nextLine(){
		return s.nextLine(); //스캐너에서 nextLine호출에서 결과를 리턴
		
	}
	// int타입 입력받는 메소드
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
		
	}
}
