package b.operator;

public class CoparingOperator {

	public static void main(String[] args) {
		 /*
	       * 비교 연산자
	       * - <, >, <=, >=, ==, !=
	       * - 문자열 비교: equals()
	       */

	      int x = 10;
	      int y = 20;
	      boolean b = x < y;
	      System.out.println(b);
	      
	      b = x <= y - 15; // 비교연산보다 산술연산이 먼저 실행됨. 어찌보면 당연한것.
	      System.out.println(b);
	      
	      String str1 = "abc";
	      String str2 = "ABC";
	      b = str1 == str2;
	      // 변수안에 들어있는 주소를 비교한것. 내용이 다르기 때문에 주소가 다름 때문에 false
	      System.out.println(b);
	      // 문자열의 내용을 비교한것이아님. 
	      // 중요!! String은 참조형타입. 변수안에 실제 값이 들어있는것이 아니라 주소가 들어있음
	      
	      // equals() 메소드 -주소값이 아닌 문자열의 내용을 비교하는 방법. 
	      b = str1.equals(str2);
	      System.out.println(b);
	     
	      
	      //같지 않다로 비교하고싶을때
	      String str3 = "abc";
	      String str4 = "ABC";
	      b = str3 != str4;
	      b = !str1.equals(str2);
	      
	      //다음의 문장들을 코드로 작성해주세요.
	      // x는 y보다 작거나 같다.
	      b = x <= y;
	      
	      // x + 5 와 y는 같다.
	      b= x + 5 == y;
	      
	      // y는 홀수이다.
	      b = y % 2 == 1;
	      
	      // "기본형"과 "참조형"은 다르다.   
	      b = !"기본형".equals("참조형");
	   }

	}
