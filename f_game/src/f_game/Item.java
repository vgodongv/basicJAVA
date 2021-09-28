package f_game;

public class Item {
	String name; //아이템 이름
	int hp;      //체력
	int mp;      //마나
	int att;     //공격력
	int def;     //방어력
	
	//생성자 만들어서 변수 초기화
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp=hp;
		this.mp=mp;
		this.att=att;
		this.def=def;
	}
	
	//객체의 정보를 문자열로 반환해주는 메서드. 
	public String toString(){
		String info = name + ":";
		if(0<hp) info += "체력+"+hp;
		if(0<mp) info += "마나+"+mp;
		if(0<att) info += "공격+"+att;
		if(0<def) info +="방어+"+def;
		return info;
	}
}
