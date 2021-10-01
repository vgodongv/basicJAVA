package g_oop2;

public class AccessModifier {

	public String publicVar = "public : 접근제한이 없음";
	protected String protectedVar
	   = "protected: 같은 패키지+상속받은 클래스에서 접근가능";
	String defaultVar = "default : 같은 패키지에서만 접근가능 "; //접근제어자를 안붙히면 default
	private String privateVar = "private: 클래스 내에서만 접근가능";
	
	
	public void publicMethod(){
		System.out.println(publicVar);
	}
	
	protected void protectedMehod(){
		System.out.println(protectedVar);
	}
	   	
	private void defaultMehod(){
		System.out.println(defaultVar);
	}
	private void privateMehod(){
		System.out.println(privateVar);
	}
	
	public static void main(String[]args){
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMehod();
		
		System.out.println(am.defaultVar);
		am.defaultMehod();
		
		System.out.println(am.privateVar);
		am.privateMehod();
		
		/*
		 * 접근 제어자를 사용하는 이유
		 *  - 데이터를 보호하기 위해
		 *  - 사용하는데 불필요한 멤버를 숨기기 위해
		 *  
		 */
		
		Time t = new Time(); // 객체생성
		

		
	    t.setHour(23);
		t.setMinute(59);
		t.setSecond(55);
		
		System.out.println(t);// 원래 이렇게 그냥 객체를 출력하면 주소나오는데 Time클래스에서 to String() 써서 변환되어서 나옴.
		
		t.clock();
		//t.stop();
		
		
	}
	
		
}












