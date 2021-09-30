package g_oop2;

public class AccessTest {

	
	public static void main(String[]args){
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMehod();
		
		System.out.println(am.defaultVar);
		
		/*System.out.println(am.privateVar);
		am.privateMehod(); 
		같은 클래스 안에서만 사용가능해서 컴파일에러*/
	}
		
	}


