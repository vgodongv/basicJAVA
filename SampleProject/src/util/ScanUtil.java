package util;

import java.util.Scanner;

public class ScanUtil {

	//�޼��忡 static�� ������ ������ ��ü�� �����ϰ� ���� �ʾƼ�.
	
	
	private static Scanner s = new Scanner(System.in);
	
	//���ڿ� �Է¹޴� �޼ҵ�
	public static String nextLine(){
		return s.nextLine(); //��ĳ�ʿ��� nextLineȣ�⿡�� ����� ����
		
	}
	// intŸ�� �Է¹޴� �޼ҵ�
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
		
	}
}
