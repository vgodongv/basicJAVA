package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
	       * ��ü���� ���α׷���(Object Oriented Programming)
	       * - ���α׷��� �ܼ��� �ڵ��� �������� ���°��� �ƴ϶� ��ü���� ��ȣ�ۿ����� ���°�
	       * - �ڵ��� ���뼺�� ���� ���������� �����ϴ�.
	       */
	      
	      SampleClass sc = new SampleClass(); //��ü����.
	                                          // Sampleclass�� ������ �޸𸮿� �ö󰡰� �޸��� �ּҰ� sc��� ������ ��. ������sc�� ���� SampleClass��밡��
	      System.out.println(sc.field);
	      
	      String returnValue = sc.method1(10); //ȣ���� �޼��带 returnValue ������ ����
	      System.out.println(returnValue);
	       
	      sc.method2();
	      
	      sc.flowTest1();
	      
	      Calculator calculator= new Calculator(); //��ü����
	      
	       long result1 = calculator.add(123456, 654321);
	      System.out.println(result1);
	      
	      long result2 = calculator.mul(result1, 123456);
	      System.out.println(result2);
	      
	      long result3 = calculator.div(result2, 123456);
	      System.out.println(result3);
	      
	       long result4 = calculator.sub(result3, 654321);
	      System.out.println(result4);
	      
	      long result5 = calculator.remain(result4, 123456);
	      System.out.println(result5);
	      

	      /*���ސ� �ڵ�
	       double result = cal.add
	      result=cal.mul
	      result=cal.div
	      result=cal.sub
	      result=cal.mod
	      System.out.println(result);*/
	   }

	}