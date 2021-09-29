package f_game;

public class Character {
	// 캐릭터의 속성을 변수로
	
	String name; //이름
	int maxHP;   //최대 체력
	int maxMP;   //최대마나
	int hp;      //체력
	int mp;      //마나
	int att;     //공격력
	int def;     //방어력
	int level;   //레벨
	int exp;     //경험치
	Item[] items; //보유 아이템(을 저장할 배열)
	
	//생성자를 받아서 변수를 초기화
	Character(String name, int hp, int mp,int att, int def){
		this.name = name;
		this.maxHP = hp;
		this.maxMP =mp;
		this.hp = this.maxHP;
		this.mp=this.maxMP;
		this.att=att;
		this.def=def;
		this.level=1; //캐릭터 레벨 1로 시작
		this.exp=0;   //경험치 0에서 시작
		this.items = new Item[10]; //캐릭터가 총 10개의 아이템 보유할 수 있는 배열
	}
	
	// 메서드 만들기
	
	//캐릭터 상태창 
	void showInfo(){
		System.out.println("========================");
		System.out.println("----------상태-----------");
		System.out.println("이름: "+name);
		System.out.println("레벨: "+level+"("+exp+"/100)");
		System.out.println("체력: "+hp+"/"+maxHP);
		System.out.println("마나: "+mp+"/"+maxMP);
		System.out.println("공격: "+att);
		System.out.println("방어: "+def);
		System.out.println("----------아이템----------");
		for(int i=0; i<items.length; i++){
			if(items[i]!=null){
				System.out.println(items[i]);
			}
		}
		System.out.println("========================");
		
	}
	
	//공격하는 메서드
	//파라미터는? 공격하려면 공격대상있어야함.
	//리턴타입은? 한번공격했을때 무엇을 출력해야함? 없음.
	void attack(Monster m){
		int damage=att-m.def;
		damage = damage <= 0 ? 1: damage; //몬스터 방어력이 더 높으면?
		m.hp =m.hp <damage ?m.hp -m.hp:m.hp-damage;
		System.out.println(name+"가 공격으로"+m.name+"에게"+damage+"만큼 데미지를 주었습니다.");
		System.out.println(m.name+"의현재 HP"+m.hp);
		
		/*int damage=att-m.def;
		damage = damage <= 0 ? 1: damage; //몬스터 방어력이 더 높으면?
		m.hp =m.hp <damage ?m.hp -m.hp:m.hp-damage;
		System.out.println(name+"가 공격으로"+m.name+"에게"+damage+"만큼 데미지를 주었습니다.");
		System.out.println(m.name+"의현재 HP"+m.hp);*/
		
	}
    void getExp(int exp){ //경험치를 얻는 메서드에서 경험치 증가. 일정 경험치 증가하면 할 메서드 호출
    	System.out.println(exp+"의 경험치를 획득하였습니다.");
    	this.exp += exp; //내경험치를 파라미터로 받은것만큼 증가
    	while(1000 <= this.exp){
    	levelUp();
    	this.exp -= 1000;
    	}
    }
    
    void levelUp(){// 일정경험치 증가하면 할 행동
    	level++;
    	maxHP+=100;
    	maxMP+=50;
    	att+=10;
    	def+=10;
    	hp=maxHP; // 레벨업을 하면 풀피됨.
    	mp=maxMP; 
    	System.out.println("레벨업~");
    }
    
    void getItem(Item item){ //아이템을 가지고 있으면 능력치가 적용됨
    	System.out.println(item.name+"을 획득하였습니다.");
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
