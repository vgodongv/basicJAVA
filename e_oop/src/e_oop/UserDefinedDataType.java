package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		  /* 
	       * ����� ���� ������ Ÿ��
	       * - �������� ���� ��ȭ �����̴�. (�⺻��->�迭->Ŭ����)
	       * - ���� �ٸ� Ÿ���� �����͸� ��� ����ϴ� ���̴�.
	       * - ������ �޼���� ������ �� �ִ�.
	       */
	      
	      // �⺻��
	      int kor;
	      int eng;
	      int math;
	      int sum;
	      double avg;
	      
	      // �迭
	      int[] scores = new int[3];
	      int sum2;
	      double avg2;
	      
	      // Ŭ����
	      Student student = new Student(); //��ü���� = �ν��Ͻ�ȭ
	      /*
	       * student(����) = 100����(�ּ�)
	       * 
	       * 100������ ������
	       * Student{ //�޸𸮿� ����� �������� ��ü/�ν��Ͻ� ��� �θ�.
	       * kor, eng, math, sum, avg, name
	       * }
	       */
	      student.kor = 80;
	      student.eng = 90;
	      student.math = 70;
	      student.sum= student.kor+student.eng+student.math;
	      student.avg = student.sum/3.0;
	      student.name = "ȫ�浿";
	      
	      System.out.println(student.name +"�� �հ�:"+student.sum +" / ���:"+student.avg);
	      
	   }

	}

	class Student{
	   int kor;
	   int eng;
	   int math;
	   int sum;
	   double avg;
	   String name;
	}









