package f_game;

public class Monster {


	String name; //�̸�
	int maxHP;   //�ִ� ü��
	int maxMP;   //�ִ븶��
	int hp;      //ü��
	int mp;      //����
	int att;     //���ݷ�
	int def;     //����
	Item[] items; //���� ������(�� ������ �迭)
	
	//�����ڸ� ����� ���� �ʱ�ȭ
	Monster(String name, int hp, int mp, int att, int def, Item[] items){
		this.name=name;
		this.maxHP=hp;
		this.maxMP=mp;
		this.hp=this.maxHP;
		this.mp=this.maxMP;
		this.att=att;
		this.def=def;
		this.items=items;
	}
	
	void attack(Character c){//ĳ���͸� �����ؾ��ϴϱ� �Ķ���Ͱ� ĳ����
		int damage=att-c.def;
		damage = damage <= 0 ? 1: damage; //���� ������ �� ������?
		c.hp =c.hp <damage ?c.hp -c.hp:c.hp-damage;
		System.out.println(name+"�� ��������"+c.name+"���� "+damage+"��ŭ �������� �־����ϴ�.");
		System.out.println(c.name+"������ HP"+c.hp);
	}
	
	//���Ͱ� ���� �������� �����ִ� �޼���
	Item itemDrop(){
		//������ �������� ������ �ε����� �߻����� �ϳ��� ���Ͻ�Ŵ
		return items[(int)(Math.random()*items.length)];
		
	}
}
