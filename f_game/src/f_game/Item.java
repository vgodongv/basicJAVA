package f_game;

public class Item {
	String name; //������ �̸�
	int hp;      //ü��
	int mp;      //����
	int att;     //���ݷ�
	int def;     //����
	
	//������ ���� ���� �ʱ�ȭ
	Item(String name, int hp, int mp, int att, int def){
		this.name = name;
		this.hp=hp;
		this.mp=mp;
		this.att=att;
		this.def=def;
	}
	
	//��ü�� ������ ���ڿ��� ��ȯ���ִ� �޼���. 
	public String toString(){
		String info = name + ":";
		if(0<hp) info += "ü��+"+hp;
		if(0<mp) info += "����+"+mp;
		if(0<att) info += "����+"+att;
		if(0<def) info +="���+"+def;
		return info;
	}
}
