package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {
	public static void main(String[] args) {
		/*
		 * ����
		 *  - ������ ����: �����Ͻÿ� �߻��Ǵ� ����(������)
		 *  - ���� ����: ������ ������, �ǵ��� �ٸ��� �����ϴ� ��(����)
		 *  - ��Ÿ�� ����: ���� �ÿ� �߻��Ǵ� ����
		 *  
		 *  ��Ÿ�� ����
		 *  - ��Ÿ�� ���� �߻��� �߻��� ��ġ���� ���α׷��� ������������ ����ȴ�.
		 *  - ����: ���α׷� �ڵ忡 ���� ������ �� ���� �ɰ��� ����(ó���Ұ�)
		 *  - ����: ���α׷� �ڵ忡 ���ؼ� ������ �� �ִ� �ټ� �̾��� ����(ó������)
		 *  
		 *  ����
		 *  - ��� ���ܴ� Exception Ŭ������ �ڽ� Ŭ�����̴�.
		 *  - RuntimeException Ŭ������ �� �ڽĵ��� ���� ó���� �������� �ʴ´�.
		 *  [RuntimeException Ŭ������ �� �ڽĵ��� ������]
		 *  Exception Ŭ������ �ڽĵ��� ����ó���� �����ȴ�.
		 *  
		 *  ����ó��(try-catch)
		 *  - ����ó���� ���� ���α׷��� ������������ ����Ǵ°͵� ������ �� �ִ�.
		 *  - try {} catch(Exception e) {}
		 *  - try ������ ������ ������ ���ܰ� �߻��ϸ� catch�� �Ѿ��.
		 *  - catch�� () �ȿ��� ó���� ���ܸ� �������� �� �ִ�.
		 *  - ���������� ���ܸ� ó���� �� �ֵ��� catch�� �ϳ� �̻� �� �� �ִ�.
		 *  - �߻��� ���ܿ� ��ġ�ϴ� catch ������ ������ ����� �� try-catch�� ����������.
		 *  - �߻��� ���ܿ� ��ġ�ϴ� catch�� ���� ��� ���ܴ� ó������ �ʴ´�.
		 */
		
		// ����ó���� ������ ���������� �ؾ��Ҷ��� ����. 
		// ���ܰ� �߻��Ǵ¼��� ���ܰ�ü�� �����Ǿ �� ��ü�� �Ķ���ͷ� ������ ���»��¿��� catch�� �����.
		try{
			int result = 10 / 0;                 // ������ 0���� ���� �� ���� ������ ���� �߻�
			System.out.println(result);
		}catch(ArithmeticException | IndexOutOfBoundsException e){	
			e.printStackTrace();                 // ������ ������� ���ܰ� ó���Ǿ� ���������� ������ �����. 
		}catch(NullPointerException e){
			
		}catch(Exception e){ //��� Ŭ������ �θ� Ŭ������ Exception�� ���� ��� ����ó���� ������. �ظ��ϸ� �������� ����ó���Ҷ� �̰Ż��
			e.printStackTrace(); 
		}
		
		// Ctrl+1 ������ ����ó�� ����
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		test1();

	}

	private static void test1() {
		test2();
		
	}

	private static void test2() {
		//System.out.println(10/0); // ���ܸ��̶߸� �������� �ִ� ���ܷ� �����.
		
		// ���ڵ尡 ������ ���ܰ� �ٸ������� �߻��Ѵٰ� �������. �׷� �������� ���� ����޼���κ��� �����
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}





















