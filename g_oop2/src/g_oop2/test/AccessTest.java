package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier {

	
	public static void main(String[]args){
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
	/*	System.out.println(am.protectedVar);
		am.protectedMehod(); 상속받아 쓰려면AccessTest 객체로 접근해야함*/
		
		AccessTest at = new AccessTest();
		
		System.out.println(at.protectedVar);
		at.protectedMehod();
		
		
		// default와 private변수는 아무리 상속을 받아도 다른 패키지에서 접근 불가능.
		/*
	    System.out.println(am.defaultVar);
		am.defaultMethod(); 
		
		System.out.println(am.privateVar);
		am.privateMehod(); 
		같은 클래스 안에서만 사용가능해서 컴파일에러
		*/
	}
		
	}


