package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		System.out.println("문자열"+"추가");
		String st = "문자열1";
		st += "추가"; 
		// 추가라는 문자열이 문자열1에 붙어서 길이가 늘어나는것이아니라 완전히 새로운 문자열이 생성되어 출력됨. 즉 문자열은 변경되면 객체를 완전히 새로만듬
		
		
		//문자열 추가하는 횟수 늘어나면 객체 생성해야해서 속도도 느리고 메모리 낭비도 일어남
	/*	String str = "a";
		
		long start = System.currentTimeMillis();
		for(int i=0; i< 200000; i++){
			str += "a";
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start +"ms"); 약 10초 걸림 */
		
		StringBuffer sb = new StringBuffer("a");
		long start = System.currentTimeMillis();
		
		for(int i=0; i<200000; i++){
			sb.append("a");
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms"); // 약0.1초걸림
	}

}
