package e_oop.score2;

public class Student {
	// score의 어떤 내용을 메소드로 옮길것인가? 핵심은 student클레스는 학생1명을 표현하기 위한 클래스로 학생이 하는 일=파라미터?
	   
	   int kor;
	   int eng;
	   int math;
	   int sum;
	   double avg;
	   String name;
	   int rank;
	   
	   // 과목값 만드는 메소드.......?
	   int kor(){
	      return (int)(Math.random()*101);
	   }
	   int eng(){
	      return (int)(Math.random()*101);
	   }
	   int math(){
	      return (int)(Math.random()*101);
	   }
	   
	   // 합계평균 메소드?
	   
	   int sum(){
	      return kor()+eng()+math();
	   }
	   
	   double avg(){
	      return Math.round(sum()/3.0*100)/100.0;
	            
	   }
	   
	   // 이름 저장 메소드? 안될듯 .
	   
	   //석차 메소드
	   int rank(){
	      return rank=1;
	   }
	   
	   
	   // 석차구하기
	   // 과목합계 평균 구하기
	   int subsum(){
	      return 0+kor();
	      
	   }
	   

	   
	}