package h_exception;

import java.io.IOException;

public class ThrowException {//���ܸ� �߻���Ű�� -> throw�� ������ ��ü ����

	public static void main(String[] args) {
		 try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 
//		 NullPointerException: ������ null�� ����־ �߻��ȴ�.
		 
		/* String str= null;
		 System.out.println(str.equals("")); */ //�������� null�� ����ִµ� �� ������ equals�Ϸ����� -> ������ �� null�� ���� Ȯ���ؼ� �ذ�
		 
//       IndexOutOfBoundsException : �迭�� �ε����� ����� �߻��ȴ�.
		 int[] a = new int[10];
		 
		 for(int i =0; i<=a.length; i++){ // <=�� �Ἥ 10���� ��. ���ܹ߻�
			 System.out.println(a[i]); 
		 }
		 
		 
		 

	}

}


