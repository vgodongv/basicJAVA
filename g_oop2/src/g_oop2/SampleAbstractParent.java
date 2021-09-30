package g_oop2;

public  abstract class SampleAbstractParent { //추상 메서드 만들려면 abstract 붙혀주세옹
    // 추상클래스: 추상 메서드를 하나라도 가지고있는것. 즉 내용이 없는 메서드를 가지고 있어서 객체생성 불가능.
    // 때문에 부모 클래스로만 사용가능.


void method(){ //일반적인 메서드
System.out.println("내용");
}

//추상 메서드: 선언부만 있고 구현부가 없는 메서드. 내용이 없는 메서드
abstract void abstractMethod();
}

class SampleAbstractChild extends SampleAbstractParent{

@Override
void abstractMethod() { //컴파일에러: 추상메서드를 상속받은경우 오버라이딩해서 내용을 만들어줘야함. 자식클래스는 추상클래스가 될것이 아니기때문에 
//자식클래스들간의 똑같은 메소드가 있지만 그 내용이 조금씩 다를때 추상메서드 사용
System.out.println("내용");
}


}