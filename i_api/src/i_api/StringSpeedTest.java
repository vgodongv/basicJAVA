package i_api;

public class StringSpeedTest {

	public static void main(String[] args) {
		System.out.println("���ڿ�"+"�߰�");
		String st = "���ڿ�1";
		st += "�߰�"; 
		// �߰���� ���ڿ��� ���ڿ�1�� �پ ���̰� �þ�°��̾ƴ϶� ������ ���ο� ���ڿ��� �����Ǿ� ��µ�. �� ���ڿ��� ����Ǹ� ��ü�� ������ ���θ���
		
		
		//���ڿ� �߰��ϴ� Ƚ�� �þ�� ��ü �����ؾ��ؼ� �ӵ��� ������ �޸� ���� �Ͼ
	/*	String str = "a";
		
		long start = System.currentTimeMillis();
		for(int i=0; i< 200000; i++){
			str += "a";
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start +"ms"); �� 10�� �ɸ� */
		
		StringBuffer sb = new StringBuffer("a");
		long start = System.currentTimeMillis();
		
		for(int i=0; i<200000; i++){
			sb.append("a");
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms"); // ��0.1�ʰɸ�
	}

}
