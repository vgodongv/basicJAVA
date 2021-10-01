package h_exception;

import java.io.IOException;

public class ThrowException {//예외를 발생시키기 -> throw를 붙히고 객체 생성

	public static void main(String[] args) {
		 try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 
//		 NullPointerException: 변수에 null이 들어있어서 발생된다.
		 
		/* String str= null;
		 System.out.println(str.equals("")); */ //변수에는 null이 들어있는데 뭘 꺼내서 equals하려고함 -> 변수에 왜 null이 들어갔나 확인해서 해결
		 
//       IndexOutOfBoundsException : 배열의 인덱스를 벗어나서 발생된다.
		 int[] a = new int[10];
		 
		 for(int i =0; i<=a.length; i++){ // <=를 써서 10까지 돔. 예외발생
			 System.out.println(a[i]); 
		 }
		 
		 
		 

	}

}


