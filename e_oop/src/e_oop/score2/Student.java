package e_oop.score2;

public class Student {
	// score�� � ������ �޼ҵ�� �ű���ΰ�? �ٽ��� studentŬ������ �л�1���� ǥ���ϱ� ���� Ŭ������ �л��� �ϴ� ��=�Ķ����?
	   
	   int kor;
	   int eng;
	   int math;
	   int sum;
	   double avg;
	   String name;
	   int rank;
	   
	   // ���� ����� �޼ҵ�.......?
	   int kor(){
	      return (int)(Math.random()*101);
	   }
	   int eng(){
	      return (int)(Math.random()*101);
	   }
	   int math(){
	      return (int)(Math.random()*101);
	   }
	   
	   // �հ���� �޼ҵ�?
	   
	   int sum(){
	      return kor()+eng()+math();
	   }
	   
	   double avg(){
	      return Math.round(sum()/3.0*100)/100.0;
	            
	   }
	   
	   // �̸� ���� �޼ҵ�? �ȵɵ� .
	   
	   //���� �޼ҵ�
	   int rank(){
	      return rank=1;
	   }
	   
	   
	   // �������ϱ�
	   // �����հ� ��� ���ϱ�
	   int subsum(){
	      return 0+kor();
	      
	   }
	   

	   
	}