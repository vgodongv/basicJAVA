package f_game;

import java.util.Scanner;

public class MyGame {


	// 게임에 등장하는 것들 = 캐릭터, 아이템 등을 변수로 만듬
	
	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("고동",50,40,40,50);
		
		items = new Item[10];
		items[0] = new Item("마법지팡이",0,30,10,10);
		items[1] = new Item("방패",30,0,10,10);
		
	}
	
	public static void main(String[] args) {
		new MyGame().start(); // 메인메서드에 static이 붙어있기때문에 클래스안의 변수를 사용할때마다 객체 생성해야하므로 메소드에 게임을 진행.

	}
	
	void start(){
		int input = 0;
		while(true){
			System.out.println("1.내정보\t2.사냥\t0.종료");
			Scanner sc = new Scanner(System.in);
	          input =Integer.parseInt(sc.nextLine());
			switch(input){
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
			
		}
	}
	
	void hunt(){//사냥하는내용
		Monster m = new Monster("고블린", 30, 30, 30, 30, new Item[]{items[0],items[1]});
		System.out.println(m.name +"을 만났습니다. 전투를 시작합니다.");
	
		int input = 0;
		battle : while(true){//?????????????????????????????
			System.out.println("1.공격\t2.도망");
			Scanner sc = new Scanner(System.in);
	          input =Integer.parseInt(sc.nextLine());
			switch (input){
			case 1:
				c.attack(m); //캐릭터가 몬스터 공격
				if(m.hp<=0){
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(150);
					c.getItem(m.itemDrop());
					break battle; // 몬스터 죽으면 while문 빠져나감.
				}
				m.attack(c); //몬스터가 캐릭터 공격
				
				break;
			case 2:
				System.out.println("도망쳤습니다.");
				break battle;//????????????????????????????????????
			}
		}
	}

}
