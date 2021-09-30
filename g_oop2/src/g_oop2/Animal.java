package g_oop2;

public abstract class Animal {

	abstract void sound(); // 소리를 내는 추상 메서드
}
                            //부모클래에서 그냥 상속받는거랑 다른점? -> 강제성부여. 완전히 똑같이 만들어라

class Dog extends Animal{ // Dog에서 ctrl+1

	@Override
	void sound() {
		
		System.out.println("멍멍!");
	}
	
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹~");
		
	}
	
}

class Lion extends Animal{ //클래스이름 대문자

	@Override
	void sound() {
		System.out.println("으르뤙");
		
	}
	
}
