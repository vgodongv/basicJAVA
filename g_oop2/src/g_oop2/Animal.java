package g_oop2;

public abstract class Animal {

	abstract void sound(); // �Ҹ��� ���� �߻� �޼���
}
                            //�θ�Ŭ������ �׳� ��ӹ޴°Ŷ� �ٸ���? -> �������ο�. ������ �Ȱ��� ������

class Dog extends Animal{ // Dog���� ctrl+1

	@Override
	void sound() {
		
		System.out.println("�۸�!");
	}
	
}

class Cat extends Animal{

	@Override
	void sound() {
		System.out.println("�߿�~");
		
	}
	
}

class Lion extends Animal{ //Ŭ�����̸� �빮��

	@Override
	void sound() {
		System.out.println("������");
		
	}
	
}
