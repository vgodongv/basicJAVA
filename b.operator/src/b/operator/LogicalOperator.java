package b.operator;

public class LogicalOperator {

	public static void main(String[] args) {
		   /*
	       * �� ������
	       * - &&(AND), ||(OR), !(NOT)
	       * - �ǿ����ڷ� boolean�� ����Ѵ�.
	       * 
	       */
	      
	      int x= 10;
	      int y= 20;
	      boolean b = 0 < x && x < 10 || x < y ; 
	      // and�� or���� ������ and���� ����� true

	      b =  !(x<y);
	      System.out.println(b); // ����� false

	      // ȿ���� ����
	      b = true && true; // t
	      b= true  && false; // f
	      b= false &&  true; // f
	      b= false && false; // f
	        // ���������� ��� ���ʺ��� Ȯ��. 
	      //���ʿ��� false�� ���͹����� ����� �̹� false�� �������� �������� �ʴ´�.
	      b= true || true; // t
	      b= true || false; // t
	      b= false || true; // t
	      b= false || false; // f
	      // ���� ���ʿ��� true�� ���͹����� �������� ���������ʴ´�. 
	      
	      int a= 10;
	      b = a< 5 && 0 < a++;
	      System.out.println(a);
	      // �ǵ��� �ٸ��� 11�̾ƴ� 10�̳��ü�������
	      
	      // ������ ������� �ڵ�� �ۼ����ּ���.
	      // 1. x�� y���� ũ�� x�� 10���� �۴�.
	      b= x > y && x<10;
	      
	      // 2. x�� ¦���̰� y���� �۰ų� ����.
	      b= x % 2 == 0 && x<=y;
	      
	      // 3. x�� 3�� ����̰ų� 5�� ����̴�.
	      b= x % 3 ==0 || x % 5 ==0;



	   }

	}