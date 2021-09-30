package g_oop2;

public class SampleChild extends SampleParent {

	void childMethod(){
		System.out.println(var); // 상속받은 변수
		System.out.println(method(7,13)); // 상속받아 오버라이딩 메서드

	}
	
	//오버라이딩
	//super-부모클래스와 자식클래스의 변수의 이름이 똑같을 때 구분하기 위해사용. 중복되는 메서드명도 구분가능.
	//super()-생성자안에서 부모클래스의 생성자를 호출할때 사용
	//다형성- 변수의 타입과 객체의 타입이 서로다름
	
	//오버라이딩: 상속받은 메서드의 내용을 재정의 하는것
	@Override //어노테이션: 클래스, 변수, 메서드 등에 표시해 놓는 것. 
	int method(int x, int y){//선언하는 부분을 똑같이 해서 메서드 만들어줌(리턴타입, 메서드이름, 파라미터 다 똑같아야함)
		return x * y;
		
	}
	
	//super, super()
	int var=10;
	 
	void test(double var){
		
		System.out.println(var); //지역변수 double var
        System.out.println(this.var);//인스턴스 변수 int var
        System.out.println(super.var); // 부모 클래스의 인스턴스 변수 String var
        //super: 부모 클래스와 자식 클래스의 멤버(변수,메서드)가 이름이 중복될 때 둘을 구분하기 위해 사용
        System.out.println(this.method(10, 20)); //상속받아서 오버라이딩한 내가만든메서드
        System.out.println(super.method(10, 20));//부모클래스에 있는 메서드
        
	}
	
	SampleChild(){//자식클래스의 생성자에는 반드시 super() 안써도 컴파일러가 자동으로 넣어줌
		super(); // 부모클래스의 생성자 호출
		//super()를 통해 클래스의 생성자를 호출하고 부모 클래스의 인스턴스 변수도 초기화한다.
		//super()가 없으면 컴파일러가 자동으로 super()를 넣어준다.
	}
	
	//다형성: 부모타입변수를 가지고 자식 타입 객체를 사용하는것.
	public static void main(String[] args) { //main -> Ctrl+Space
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		
		//sc = sp; 부모->자식 자동형변환 안됨
		//SampleParent : 멤버의 개수 2개
		//SampleChild: 멤버의 개수 6개
		sc = (SampleChild)sp; // 형변환 시켜줘야함
		sp = sc;// 자식->부모 자동형변환
		
		sc.childMethod();
		sc.test(5);
		
	}
	
	
	
	
	
}
