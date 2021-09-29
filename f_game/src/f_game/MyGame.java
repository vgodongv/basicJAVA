package f_game;

import java.util.Scanner;

public class MyGame {


	// ���ӿ� �����ϴ� �͵� = ĳ����, ������ ���� ������ ����
	
	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("��",50,40,40,50);
		
		items = new Item[10];
		items[0] = new Item("����������",0,30,10,10);
		items[1] = new Item("����",30,0,10,10);
		
	}
	
	public static void main(String[] args) {
		new MyGame().start(); // ���θ޼��忡 static�� �پ��ֱ⶧���� Ŭ�������� ������ ����Ҷ����� ��ü �����ؾ��ϹǷ� �޼ҵ忡 ������ ����.

	}
	
	void start(){
		int input = 0;
		while(true){
			System.out.println("1.������\t2.���\t0.����");
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
				System.out.println("����Ǿ����ϴ�.");
				System.exit(0);
				break;
			}
			
		}
	}
	
	void hunt(){//����ϴ³���
		Monster m = new Monster("���", 30, 30, 30, 30, new Item[]{items[0],items[1]});
		System.out.println(m.name +"�� �������ϴ�. ������ �����մϴ�.");
	
		int input = 0;
		battle : while(true){//?????????????????????????????
			System.out.println("1.����\t2.����");
			Scanner sc = new Scanner(System.in);
	          input =Integer.parseInt(sc.nextLine());
			switch (input){
			case 1:
				c.attack(m); //ĳ���Ͱ� ���� ����
				if(m.hp<=0){
					System.out.println(m.name + "�� óġ�Ͽ����ϴ�.");
					c.getExp(150);
					c.getItem(m.itemDrop());
					break battle; // ���� ������ while�� ��������.
				}
				m.attack(c); //���Ͱ� ĳ���� ����
				
				break;
			case 2:
				System.out.println("�����ƽ��ϴ�.");
				break battle;//????????????????????????????????????
			}
		}
	}

}
