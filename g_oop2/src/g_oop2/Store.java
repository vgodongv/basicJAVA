package g_oop2;

public class Store {
public static void main(String[] args) {
		
		//��ü����
		Desktop d= new Desktop();
		
		Aircon ac = new Aircon();
		TV tv = new TV();
		
		Customer c = new Customer();
		
		//���� �ڽ�Ÿ���� �� �迭�� �����ϰ������ �θ�Ÿ���� ����ϸ� �ڽ� Ÿ���� �ٵ� �� ����
		c.buy(d);
		c.buy(ac);
		c.buy(tv);
	}

}

//���� ����� - ���ǵ��� �������� �������ִ� �Ӽ��� �θ�Ŭ������
class Product{
	String name; //�̸�
	int price;   //����
	
	//���Ǹ��� �̸�, ���� �޶� �ʱ�ȭ�Ұ���. �ܺο��� ���� �����;��� -> �������ʿ�:�Ķ���� �޾Ƽ� ���� �ʱ�ȭ
	Product(String name, int price){
		this.name=name;
		this.price=price;
	}
	
	//��ǰ�� ������ �������ִ� �޼���
	String getInfo(){
		return name + "(" + price + "��)";
		
	}
	
}

class Desktop extends Product{ //�θ�Ŭ������ �����ڸ� ȣ���Ϸ��� �Ķ���Ͱ� ����. �����Ϸ��� �Ķ���ͱ��� �ڵ����� �־��� �� ���� -> �����������
	
	 Desktop(){//�����ڸ� ���� �θ� ������ ȣ���� ���� �ʱ�ȭ����
		 super("�Ｚ��ǻ��",1000000);
	 }
	 
	 void programming(){//��ǻ�Ͱ� �Ҽ��ִ����� �޼���� ����
		 System.out.println("���α׷��� ����ϴ�.");
	 }
}

class Aircon extends Product{
	Aircon(){
		super("LG ������",2000000);
	}
	
	void setTemperature(){
		System.out.println("�µ��� �����մϴ�.");
	}
}

class TV extends Product{
	TV(){
		super("LG TV",3000000);
	}
	void setChannel(){
		System.out.println("ä���� �����մϴ�.");
	}
}

//������ ������ �մ�
class Customer{
	int money = 100000000;
	
	//������ ������ ���� �� �ִ� �迭. �迭�� Ÿ����? Product �ֳĸ� �� Ŭ���� ��� Product�� ��ӹ���. ������
	Product[] item = new Product[10]; //���� �ڽ�Ÿ���� �� �迭�� �����ϰ������ �θ�Ÿ���� ����ϸ� �ڽ� Ÿ���� �ٵ� �� ����
	
	//������ �� �� �ִ� �ൿ�� �ϴ� �޼���
	void buy(Product p){//�Ķ���ͷ� Ÿ���� ��� �ٸ� ���� 3���� ���� �� �־����. �Ķ������ Ÿ����? ���� Product. 
		if(money<p.price){
			System.out.println("�ܵ��� �����մϴ�.");
			return;
		}
		
		money -= p.price;
		
		for(int i=0; i<item.length; i++){
			if(item[i]==null){
				item[i]=p;
				break;
			}
		}
		System.out.println(p.getInfo()+"�� �����߽��ϴ�.");
	}
	
}







