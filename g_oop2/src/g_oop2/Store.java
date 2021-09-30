package g_oop2;

public class Store {
public static void main(String[] args) {
		
		//객체생성
		Desktop d= new Desktop();
		
		Aircon ac = new Aircon();
		TV tv = new TV();
		
		Customer c = new Customer();
		
		//여러 자식타입을 한 배열에 저장하고싶을때 부모타입을 사용하면 자식 타입은 다들어갈 수 있음
		c.buy(d);
		c.buy(ac);
		c.buy(tv);
	}

}

//물건 만들기 - 물건들이 공통으로 가지고있는 속성을 부모클래스로
class Product{
	String name; //이름
	int price;   //가격
	
	//물건마다 이름, 가격 달라서 초기화불가능. 외부에서 값을 가져와야함 -> 생성자필요:파라미터 받아서 값을 초기화
	Product(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	//상품의 정보를 리턴해주는 메서드
	String getInfo(){
		return name + "(" + price + "원)";
		
	}
	
}

class Desktop extends Product{ //부모클래스의 생성자를 호출하려니 파라미터가 있음. 컴파일러가 파라미터까지 자동으로 넣어줄 수 없음 -> 직접해줘야함
	
	 Desktop(){//생성자를 만들어서 부모 생성자 호출후 직접 초기화해줌
		 super("삼성컴퓨터",1000000);
	 }
	 
	 void programming(){//컴퓨터가 할수있는일을 메서드로 만듬
		 System.out.println("프로그램을 만듭니다.");
	 }
}

class Aircon extends Product{
	Aircon(){
		super("LG 에어컨",2000000);
	}
	
	void setTemperature(){
		System.out.println("온도를 설정합니다.");
	}
}

class TV extends Product{
	TV(){
		super("LG TV",3000000);
	}
	void setChannel(){
		System.out.println("채널을 변경합니다.");
	}
}

//물건을 구매할 손님
class Customer{
	int money = 100000000;
	
	//구매한 물건을 넣을 수 있는 배열. 배열의 타입은? Product 왜냐면 세 클래스 모두 Product를 상속받음. 다형성
	Product[] item = new Product[10]; //여러 자식타입을 한 배열에 저장하고싶을때 부모타입을 사용하면 자식 타입은 다들어갈 수 있음
	
	//물건을 살 수 있는 행동을 하는 메서드
	void buy(Product p){//파라미터로 타입이 모두 다른 물건 3개를 받을 수 있어야함. 파라미터의 타입은? 역시 Product. 
		if(money<p.price){
			System.out.println("잔돈이 부족합니다.");
			return;
		}
		
		money -= p.price;
		
		for(int i=0; i<item.length; i++){
			if(item[i]==null){
				item[i]=p;
				break;
			}
		}
		System.out.println(p.getInfo()+"를 구매했습니다.");
	}
	
}







