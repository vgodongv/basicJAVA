package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		  /* 
	       * 사용자 정의 데이터 타입
	       * - 데이터의 최종 진화 형태이다. (기본형->배열->클래스)
	       * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
	       * - 변수와 메서드로 구성할 수 있다.
	       */
	      
	      // 기본형
	      int kor;
	      int eng;
	      int math;
	      int sum;
	      double avg;
	      
	      // 배열
	      int[] scores = new int[3];
	      int sum2;
	      double avg2;
	      
	      // 클래스
	      Student student = new Student(); //객체생성 = 인스턴스화
	      /*
	       * student(변수) = 100번지(주소)
	       * 
	       * 100번지에 가보면
	       * Student{ //메모리에 저장된 변수들을 객체/인스턴스 라고 부름.
	       * kor, eng, math, sum, avg, name
	       * }
	       */
	      student.kor = 80;
	      student.eng = 90;
	      student.math = 70;
	      student.sum= student.kor+student.eng+student.math;
	      student.avg = student.sum/3.0;
	      student.name = "홍길동";
	      
	      System.out.println(student.name +"의 합계:"+student.sum +" / 평균:"+student.avg);
	      
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









