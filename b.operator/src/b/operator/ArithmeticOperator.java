package b.operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		 /*
	       * ���������
	       * - ��Ģ������: +, -, *, /, %(������)
	       * - ���տ�����: +=, -=, *=,  /=,  %=
	       * - ����������: ++, --
	       */
	      
 int result = 10 + 20 - 30 * 40 / 50 % 60;
	// ���ϱ� ������/������ ���ϱ� ���� ������ ����
	      
	      // ������ ����
	      result = 10 / 3 ;
	      System.out.println(result);
	      result = 10 % 3 ;
	      System.out.println(result);

	      //5���� ��������ڸ� ����� 5���� ������ ���� �� ����� ������ּ���
	      /* int a = 20 + 20 ; 
	      System.out.println(a);
	      int b= 30-10;
	      System.out.println(b);
	      int c = 10*10;
	      System.out.println(c);
	      int d = 50/10;
	      System.out.println(d);
	      int e = 70%4;
	      System.out.println(e);
	      */
	      
	      //���� ������
	      result = 30;
	      
	      result = result + 3;
	      System.out.println(result);
	      
	      result += 3;
	      System.out.println(result);
	      
	      result -= 5;
	      System.out.println(result);
	      
	      result *= 2;
	      System.out.println(result);
	      
	      // �Ʒ��� ������ ���տ����ڸ� ����� �������� ����ÿ�
	      // result = result + 10
	      // result = result % 5
	      // result = result -2 *3
	      
	      result += 10;
	      result %= 5;
	      result -= 2 *3;
	      System.out.println(result);
	   
	      //����������
	      //����������(++) :  ������ ���� 1 ������Ų��.
	      //���ҿ�����(--) :  ������ ���� 1 ���ҽ�Ų��.
	      int i = 0;
	      
	      ++i; // ������: ������ ���� �о���� ���� 1�����ȴ�. ������1
	      i++; // ������: ������ ���� �о�� �Ŀ� 1�����ȴ�. ������0
	      
	      i = 0;
	      System.out.println("++i = "+ ++i);
	      i= 0;
	      // 1�������ȴ������� ��������1
	      System.out.println("i++ = "+ i++);
	      //�������� 0
	      System.out.println(i);
	      //�ٽ� ����ϸ� 1�������Ǵ°� Ȯ�ΰ���
	      
	      // �ǿ������� Ÿ���� ���� ���ƾ߸� ������ �����ϴ�. �ٸ��� ����ȯ��.
	      // �ǿ����� �ΰ��� �ʿ�� �ϴ� ������ = ���� ������.
	      int _int = 10;
	      double _double = 3.14;
	      double result2 = _int + _double;
	       // ���ٵ� �����̵ȴ�? ������ �����ϳ��� ����ȯ�� �Ǿ��⶧��.
	       // int�� double�� �ڵ�����ȯ�Ǿ ������ ���¶� ������ ��.
	       // ���� �ʿ��� ū������ �ڵ����� ����ȯ��.
	       // double result2 = (double)_int + _double; �� ������.
	      
	      byte _byte = 5;
	      short _short = 10;
	      _int = _byte + _short;
	       // byteŸ���� short Ÿ������ ����ȯ�Ǿ���ϴµ�
	       // byte��1����Ʈ short��2����Ʈ�� 4����Ʈ�� int�� ����ȯ��
	       // ��ǻ�ʹ� 4����Ʈ �̸��̸� ���� �Ұ����� ��
	       // int���� ����Ÿ���� int�� ����ȯ �ȴ�.
	       
	       // char�� 2����Ʈ�̱� ������ int�� ����ȯ 
	       // char�����°� �������� ������ ����Ǵ°� ����.
	       char _char = 'a';
	       char _char2 = 'b';
	       _int = _char + _char2;
	       System.out.println(_int);
	       
	       // �����÷ο�, ����÷ο�
	       // ǥ�������� ����� ���� ǥ���� �� �߻��ϴ� ����.
	       byte b =127;
	       b++;
	       System.out.println(b);
	       // ǥ�������� 127�� ����� ���� ������ ��µ� -128 = �����÷ο�
	       b--;
	       System.out.println(b);
	       // ǥ�������� -128�� ����� ���� ū �� ��µ� 127 =  ����÷ο�
	       //���꿡 ������ �°� Ÿ���� �����ؾ���.
	       
	       // ������ ���پ� ����ؼ� ���� ������� ������ּ���
	       // 1. 123456 + 654321
	       // 2. 1���� ����� * 123456
	       // 3. 2���� ����� / 123456
	       // 4. 3���� ����� - 654321
	       // 5, 4���� ����� %
	       
	    long _int1 = 123456 + 654321;
	       System.out.println(_int1);
	      long _int2 = _int1 * 123456;
	      System.out.println(_int2);
	      long _int3 = _int2 / 123456;
	       System.out.println(_int3);
	      long _int4 = _int3 - 654321;
	       System.out.println(_int4);
	     long _int5 = _int4 % 123456;
	       System.out.println(_int5);
	       
	       //�Ǵ� 
	       long num1 = 123456 + 654321;
	      num1*= 123456;
	      num1/=123456;
	      num1-=654321;
	      num1%=123456;
	      System.out.println(num1);
	      
	       
	      
	       // 3���� int�� ������ ���� �� �ʱ�ȭ �� �հ�� ����� �����ּ���
	       int aa = 10;
	       int bb = 20;
	       int cc = 11; 
	       int sum= aa + bb + cc;
	       double avg = sum/3.0;
	       // sum/3���� sum�� 3�Ѵ� int���̶� ����� int. ������� �Ҽ������� �������� 3 ->3.0
	       System.out.println(sum);
	       System.out.println(avg);
	       
	       // �ݿø�
	       avg = Math.round(avg); //�Ҽ��� ù°�ڸ����� �ݿø��� ���ش�.
	       // �Ҽ��� ù°�ڸ��� ��������� avg = Math.round(avg * 10)/10.0
	       // �Ҽ��� ��°�ڸ��� ��������� avg = Math.round(avg * 100)/100.0
	       // ���ϰ� ���Ѹ�ŭ �Ҽ��������� �ٽ� ������
	       System.out.println(avg);
	       
	       // �����޼ҵ� ���� ����
	       // Math.random() - 0.0~ 1.0�̸��� ���� �������� �߻���Ų��.
	       // 0���� 0.99999''''''�̸��Ǽ�����
	       int random =(int)(Math.random()*100)+1;
	       // 1~100������ ������
	       System.out.println(random);
	       
	       
	       
	   }

	}