package e_oop;

public class SampleClass {

	public static void main(String[] args) {
		//���α׷��� �����Ű�� main�޼ҵ� �����
	      // Ŭ������ ����, �޼ҵ�� ��������
	      int local=10; //��������: �޼��� �ȿ����� ����ϴ� ����
	      
	   }
	       int field; // ��������: Ŭ���� ��ü �������� ����ϴ� ����. �ʱ�ȭ���� �ʾƵ� �⺻�� 0���� �ʱ�ȭ��.
	       
	       /*
	        * - �޼���: ������ ������ ���� // ������ ��������
	        * - ������: ����Ÿ�� �޼����(�Ķ����) {}
	        * - �Ķ����(�Ű�����) : ���࿡ �ʿ��� ����
	        * - ���� Ÿ��(��ȯŸ��): ������ ��������ϴ� �����. ����� Ÿ��.
	        */
	       
	       String method1(int parameter){
	          return parameter + "�� �޾� ����� �����ϰ� ������� �����ϴ� �޼���"; // ��ȯ���� ��ȯŸ���� String�� ��ġ�ϰų� ��� �ڵ�����ȯ�� �����Ѱ��̾����.
	       }
	       
	       void method2(){// void ����ִ�.
	          System.out.println("�Ķ���͵� ����Ÿ�Ե� ���� �޼���");
	       }
	       
	       void flowTest1(){
	          System.out.println("flowTest1 ����: 1");
	          flowTest3();
	          System.out.println("flowTest1 ����: 6");
	       }
	       
	       void flowTest2(){
	          System.out.println("flowTest2 ����: 3");
	          System.out.println("flowTest2 ����: 4");
	       }
	       
	        void flowTest3(){
	           System.out.println("flowTest3 ����: 2");
	           flowTest2();
	           System.out.println("flowTest3 ����:5 ");
	        }
	        
	}








