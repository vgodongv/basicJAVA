package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Finally {

	public static void main(String[] args) {
		/*
		 * finally �ݵ�ý����ϰ���������� ����->�ַ� closed ȣ������
		 * - �ʿ信 ���� try-catch �ڿ� finally�� �߰��� �� �ִ�.
		 * - finally�� ������ �߻� ���ο� ������� ���� �������� ����ȴ�.
		 * 
		 * �ڵ��ڿ� ��ȯ->closed ȣ������� ���
		 * - try(��������; ��������) {} catch(Exception e) {}
		 * - ��� �� ��ȯ�� �ʿ��� ��ü�� try�� ()�ȿ��� �����ϸ� try�� ����� �ڵ����� ��ȯ�ȴ�.
		 */
		
		FileInputStream fis = null; //���� �б�
		
		try {
			fis = new FileInputStream("d:/file.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{  
			try { // ���ܰ� �߻��ϵ� ���� �ü���κ��� �ڿ��� �ް� �ݳ�
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//���� �߻�: try -> catch -> finally
		//���� �̹߻�: try -> finally
		
		//�ڵ� �ڿ� ��ȯ(JDK1.7)
		try(FileOutputStream fos = new FileOutputStream("d:/file.txt") ){
			String str = "�ƹ�����";
			
			byte[] bytes = str.getBytes();
			for(int i=0; i< bytes.length; i++){
				fos.write(bytes[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
	}

}
