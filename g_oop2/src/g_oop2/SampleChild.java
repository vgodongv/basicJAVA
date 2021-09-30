package g_oop2;

public class SampleChild extends SampleParent {

	void childMethod(){
		System.out.println(var); // ��ӹ��� ����
		System.out.println(method(7,13)); // ��ӹ޾� �������̵� �޼���

	}
	
	//�������̵�
	//super-�θ�Ŭ������ �ڽ�Ŭ������ ������ �̸��� �Ȱ��� �� �����ϱ� ���ػ��. �ߺ��Ǵ� �޼���� ���а���.
	//super()-�����ھȿ��� �θ�Ŭ������ �����ڸ� ȣ���Ҷ� ���
	//������- ������ Ÿ�԰� ��ü�� Ÿ���� ���δٸ�
	
	//�������̵�: ��ӹ��� �޼����� ������ ������ �ϴ°�
	@Override //������̼�: Ŭ����, ����, �޼��� � ǥ���� ���� ��. 
	int method(int x, int y){//�����ϴ� �κ��� �Ȱ��� �ؼ� �޼��� �������(����Ÿ��, �޼����̸�, �Ķ���� �� �Ȱ��ƾ���)
		return x * y;
		
	}
	
	//super, super()
	int var=10;
	 
	void test(double var){
		
		System.out.println(var); //�������� double var
        System.out.println(this.var);//�ν��Ͻ� ���� int var
        System.out.println(super.var); // �θ� Ŭ������ �ν��Ͻ� ���� String var
        //super: �θ� Ŭ������ �ڽ� Ŭ������ ���(����,�޼���)�� �̸��� �ߺ��� �� ���� �����ϱ� ���� ���
        System.out.println(this.method(10, 20)); //��ӹ޾Ƽ� �������̵��� ��������޼���
        System.out.println(super.method(10, 20));//�θ�Ŭ������ �ִ� �޼���
        
	}
	
	SampleChild(){//�ڽ�Ŭ������ �����ڿ��� �ݵ�� super() �Ƚᵵ �����Ϸ��� �ڵ����� �־���
		super(); // �θ�Ŭ������ ������ ȣ��
		//super()�� ���� Ŭ������ �����ڸ� ȣ���ϰ� �θ� Ŭ������ �ν��Ͻ� ������ �ʱ�ȭ�Ѵ�.
		//super()�� ������ �����Ϸ��� �ڵ����� super()�� �־��ش�.
	}
	
	//������: �θ�Ÿ�Ժ����� ������ �ڽ� Ÿ�� ��ü�� ����ϴ°�.
	public static void main(String[] args) { //main -> Ctrl+Space
		SampleChild sc = new SampleChild();
		SampleParent sp = new SampleChild();
		
		//sc = sp; �θ�->�ڽ� �ڵ�����ȯ �ȵ�
		//SampleParent : ����� ���� 2��
		//SampleChild: ����� ���� 6��
		sc = (SampleChild)sp; // ����ȯ ���������
		sp = sc;// �ڽ�->�θ� �ڵ�����ȯ
		
		sc.childMethod();
		sc.test(5);
		
	}
	
	
	
	
	
}
