package f_game;

public class Character {
	// ĳ������ �Ӽ��� ������
	
	String name; //�̸�
	int maxHP;   //�ִ� ü��
	int maxMP;   //�ִ븶��
	int hp;      //ü��
	int mp;      //����
	int att;     //���ݷ�
	int def;     //����
	int level;   //����
	int exp;     //����ġ
	Item[] items; //���� ������(�� ������ �迭)
	
	//�����ڸ� �޾Ƽ� ������ �ʱ�ȭ
	Character(String name, int hp, int mp,int att, int def){
		this.name = name;
		this.maxHP = hp;
		this.maxMP =mp;
		this.hp = this.maxHP;
		this.mp=this.maxMP;
		this.att=att;
		this.def=def;
		this.level=1; //ĳ���� ���� 1�� ����
		this.exp=0;   //����ġ 0���� ����
		this.items = new Item[10]; //ĳ���Ͱ� �� 10���� ������ ������ �� �ִ� �迭
	}
	
	// �޼��� �����
	
	//ĳ���� ����â 
	void showInfo(){
		System.out.println("========================");
		System.out.println("----------����-----------");
		System.out.println("�̸�: "+name);
		System.out.println("����: "+level+"("+exp+"/100)");
		System.out.println("ü��: "+hp+"/"+maxHP);
		System.out.println("����: "+mp+"/"+maxMP);
		System.out.println("����: "+att);
		System.out.println("���: "+def);
		System.out.println("----------������----------");
		for(int i=0; i<items.length; i++){
			if(items[i]!=null){
				System.out.println(items[i]);
			}
		}
		System.out.println("========================");
		
	}
	
	//�����ϴ� �޼���
	//�Ķ���ʹ�? �����Ϸ��� ���ݴ���־����.
	//����Ÿ����? �ѹ����������� ������ ����ؾ���? ����.
	void attack(Monster m){
		int damage=att-m.def;
		damage = damage <= 0 ? 1: damage; //���� ������ �� ������?
		m.hp =m.hp <damage ?m.hp -m.hp:m.hp-damage;
		System.out.println(name+"�� ��������"+m.name+"����"+damage+"��ŭ �������� �־����ϴ�.");
		System.out.println(m.name+"������ HP"+m.hp);
		
		/*int damage=att-m.def;
		damage = damage <= 0 ? 1: damage; //���� ������ �� ������?
		m.hp =m.hp <damage ?m.hp -m.hp:m.hp-damage;
		System.out.println(name+"�� ��������"+m.name+"����"+damage+"��ŭ �������� �־����ϴ�.");
		System.out.println(m.name+"������ HP"+m.hp);*/
		
	}
    void getExp(int exp){ //����ġ�� ��� �޼��忡�� ����ġ ����. ���� ����ġ �����ϸ� �� �޼��� ȣ��
    	System.out.println(exp+"�� ����ġ�� ȹ���Ͽ����ϴ�.");
    	this.exp += exp; //������ġ�� �Ķ���ͷ� �����͸�ŭ ����
    	while(1000 <= this.exp){
    	levelUp();
    	this.exp -= 1000;
    	}
    }
    
    void levelUp(){// ��������ġ �����ϸ� �� �ൿ
    	level++;
    	maxHP+=100;
    	maxMP+=50;
    	att+=10;
    	def+=10;
    	hp=maxHP; // �������� �ϸ� Ǯ�ǵ�.
    	mp=maxMP; 
    	System.out.println("������~");
    }
    
    void getItem(Item item){ //�������� ������ ������ �ɷ�ġ�� �����
    	System.out.println(item.name+"�� ȹ���Ͽ����ϴ�.");
    	for(int i=0; i<items.length; i++){
    		if(items[i]==null){
    			items[i]=item;
    			break;
    		}
    	}
    	maxHP+=item.hp;
    	maxMP+=item.mp;
    	att += item.att;
    	def += item.def;
    	
    }
    
	
}
