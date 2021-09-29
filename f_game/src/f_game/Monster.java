package f_game;

public class Monster {


	String name; //이름
	int maxHP;   //최대 체력
	int maxMP;   //최대마나
	int hp;      //체력
	int mp;      //마나
	int att;     //공격력
	int def;     //방어력
	Item[] items; //보유 아이템(을 저장할 배열)
	
	//생성자를 만들어 변수 초기화
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
	
	void attack(Character c){//캐릭터를 공격해야하니까 파라미터가 캐릭터
		int damage=att-c.def;
		damage = damage <= 0 ? 1: damage; //몬스터 방어력이 더 높으면?
		c.hp =c.hp <damage ?c.hp -c.hp:c.hp-damage;
		System.out.println(name+"이 공격으로"+c.name+"에게 "+damage+"만큼 데미지를 주었습니다.");
		System.out.println(c.name+"의현재 HP"+c.hp);
	}
	
	//몬스터가 가진 아이템을 돌려주는 메서드
	Item itemDrop(){
		//보유한 아이템의 랜덤한 인덱스를 발생시켜 하나를 리턴시킴
		return items[(int)(Math.random()*items.length)];
		
	}
}
