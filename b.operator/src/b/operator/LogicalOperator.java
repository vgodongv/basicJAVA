package b.operator;

public class LogicalOperator {

	public static void main(String[] args) {
		   /*
	       * 논리 연산자
	       * - &&(AND), ||(OR), !(NOT)
	       * - 피연산자로 boolean만 허용한다.
	       * 
	       */
	      
	      int x= 10;
	      int y= 20;
	      boolean b = 0 < x && x < 10 || x < y ; 
	      // and와 or같이 있으면 and부터 결과값 true

	      b =  !(x<y);
	      System.out.println(b); // 결과값 false

	      // 효율적 연산
	      b = true && true; // t
	      b= true  && false; // f
	      b= false &&  true; // f
	      b= false && false; // f
	        // 논리연산자의 경우 왼쪽부터 확인. 
	      //왼쪽에서 false가 나와버리면 결과는 이미 false라서 오른쪽은 실행하지 않는다.
	      b= true || true; // t
	      b= true || false; // t
	      b= false || true; // t
	      b= false || false; // f
	      // 역시 왼쪽에서 true가 나와버리면 오른쪽을 실행하지않는다. 
	      
	      int a= 10;
	      b = a< 5 && 0 < a++;
	      System.out.println(a);
	      // 의도와 다르게 11이아닌 10이나올수도있음
	      
	      // 다음의 문장들을 코드로 작성해주세요.
	      // 1. x가 y보다 크고 x가 10보다 작다.
	      b= x > y && x<10;
	      
	      // 2. x가 짝수이고 y보다 작거나 같다.
	      b= x % 2 == 0 && x<=y;
	      
	      // 3. x가 3의 배수이거나 5의 배수이다.
	      b= x % 3 ==0 || x % 5 ==0;



	   }

	}