package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * ����ǥ����: ���ڿ��� ������ �˻��ϴ� ǥ���� => ������ ������ ����
		 * 
		 * ^ �� ���ڷ� ����
		 * $ �� ���ڷ� ����
		 * . ������ ����(�ٹٲ� ����)
		 * * �չ��ڰ� 0�� �̻�
		 * + �չ��ڰ� 1���̻�
		 * ? �չ��ڰ� ���ų� 1��
		 * [] ������ �����̳� ����([a-z]:a���� z����, [^a-z]: a���� z�� �ƴѰ�
		 * {} �� ������ ����({2}: 2��, {2,4}: 2�� �̻� 4������)
		 * () �׷�ȭ (1���� ����ó�� �ν�)
		 * |  OR ����
		 * \s ����, ��, �ٹٲ�
		 * \S ����, ��, �ٹٲ��� �ƴ� ����
		 * \w ���ĺ��̳� ����
		 * \W ���ĺ��̳� ���ڰ� �ƴ� ����
		 * \d ����
		 * \D ���ڰ� �ƴ� ����
		 * (?i) �� ������ ��ҹ��� ���о���
		 * \ ���� ǥ���Ŀ��� ���Ǵ� Ư������ ǥ��
		 * 		  
		 */

		String str ="abc123"; // �˻��� ���ڿ�
		// String regex = "[a-z]{3}[0-9]{1,3}"; // ����ǥ����. true
	   	// String regex = "[a-z0-9]+"; // ����ǥ����. true
		   String regex = "\\w*"; // ����ǥ����. ���ĺ��̳� ���ڰ� 0���̻� �´�. true
				
		
		/*Pattern p =Pattern.compile(regex); //����ǥ������ �ؼ��ؼ� ��ü�� ������ ����
		 Matcher m =p.matcher(str);
		 System.out.println(m.matches());*/
		
		 // ���̵�, ��ȭ��ȣ, �̸����ּ��� ��ȿ���� �˻��ϴ� ����ǥ������ ������ּ���.
		 
		 //���̵�: ��ҹ��� ���� ��ҹ��� �ƹ��ų� , ���ڻ��
		   
		 String id = "[a-zA-Z0-9]";
		 //��й�ȣ: ��ҹ��� ���� ��ҹ��� �Ѵٻ��, ����, Ư�����ڸ� ��� 8�ڸ��̻� 12�ڸ�����.
		 String PW ="Fkaus1234";
		 String pw ="(?i)[a-zA-Z0-9]{8,12}";
		 
		 Pattern p =Pattern.compile(pw); //����ǥ������ �ؼ��ؼ� ��ü�� ������ ����
		 Matcher m =p.matcher(PW);
		 System.out.println(m.matches());
		
	}

}
