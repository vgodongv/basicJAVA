package g_oop2;

public interface SampleInterface { //Ŭ������ �������̽� ��ӹ���
	
	// Ŭ������ ��ü���� ���γ����� �ִ°Ŷ�� �������̽��� ���赵ó�� Ʋ�� ����. 
	// �������̽��� ����� �߻� �޼��常 ���簡��. �Ϲ����� ������ �޼��� ���� �� ����.
		
		//���: ���� ������ �� ���� ����. �����Ȱ��� �����س������� ���
		
		//�������̽��� ��� �ɹ������� public static final �����ڸ� ����ؾߵȴ�.
		public static final int NUM1= 1; //final-> ������ ���� �������� ���ϰ� ���� -> NUM1�� ���. ����� �̸��� �빮��
		
		//��� ��������� �����ڰ� ���� ������ ������  �����ϴ�.
		int NUM2 =2;
		
		//�������̽��� ��� �޼���� public abstract �����ڸ� ����ؾ��Ѵ�.
		public abstract void method1();
		
		//��� �޼����� �����ڰ� ���� ������ ������ �����ϴ�.
		void method2();

	}

	class SampleImplement implements SampleInterface, SampleInterface2 { // �������̽��� �߻�޼��� ��ӹ����ϱ� �������̵�
	// Ŭ������ ��� �ϳ��� Ŭ����(�߻�Ŭ������)�� ��� ���� �� ������ �������̽��� �������� �������̽� ��ӹ��� �� ����
		@Override
		public void method1() {
		
			
		}

		@Override
		public void method2() {
			
			
		}

		@Override
		public void method3() {
			// TODO Auto-generated method stub
			
		} 
		
	}

	interface SampleInterface2{
		void method1();
		void method3();
	}

