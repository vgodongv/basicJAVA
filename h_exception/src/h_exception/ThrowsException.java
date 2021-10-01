package h_exception;

import java.io.IOException;

public class ThrowsException {

	public static void main(String[] args) {
		try {
			method();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void method() throws IOException { //메소들을 호출했을때 IOException 발생함을 알려주기 위해 예외를 선언
		throw new IOException();
	}
}
