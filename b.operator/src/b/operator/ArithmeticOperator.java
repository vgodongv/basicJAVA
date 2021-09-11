package b.operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		 /*
	       * 산술연산자
	       * - 사칙연산자: +, -, *, /, %(나머지)
	       * - 복합연산자: +=, -=, *=,  /=,  %=
	       * - 증감연산자: ++, --
	       */
	      
 int result = 10 + 20 - 30 * 40 / 50 % 60;
	// 곱하기 나누기/나머지 더하기 뺄셈 순으로 연산
	      
	      // 나머지 연산
	      result = 10 / 3 ;
	      System.out.println(result);
	      result = 10 % 3 ;
	      System.out.println(result);

	      //5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요
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
	      
	      //복합 연산자
	      result = 30;
	      
	      result = result + 3;
	      System.out.println(result);
	      
	      result += 3;
	      System.out.println(result);
	      
	      result -= 5;
	      System.out.println(result);
	      
	      result *= 2;
	      System.out.println(result);
	      
	      // 아래의 문장을 복합연산자를 사용한 문장으로 만드시오
	      // result = result + 10
	      // result = result % 5
	      // result = result -2 *3
	      
	      result += 10;
	      result %= 5;
	      result -= 2 *3;
	      System.out.println(result);
	   
	      //증감연산자
	      //증가연산자(++) :  변수의 값을 1 증가시킨다.
	      //감소연산자(--) :  변수의 값을 1 감소시킨다.
	      int i = 0;
	      
	      ++i; // 전위형: 변수의 값을 읽어오기 전에 1증가된다. 읽은값1
	      i++; // 후위형: 변수의 값을 읽어온 후에 1증가된다. 읽은값0
	      
	      i = 0;
	      System.out.println("++i = "+ ++i);
	      i= 0;
	      // 1로증가된다음읽음 읽은값이1
	      System.out.println("i++ = "+ i++);
	      //읽은값이 0
	      System.out.println(i);
	      //다시 출력하면 1로증가되는것 확인가능
	      
	      // 피연산자의 타입이 서로 같아야만 연산이 가능하다. 다르면 형변환됨.
	      // 피연산자 두개를 필요로 하는 연산자 = 이항 연산자.
	      int _int = 10;
	      double _double = 3.14;
	      double result2 = _int + _double;
	       // 엥근데 연산이된다? 이유는 둘중하나가 형변환이 되었기때문.
	       // int가 double로 자동형변환되어서 생략된 상태라 연산이 됨.
	       // 작은 쪽에서 큰쪽으로 자동으로 형변환됨.
	       // double result2 = (double)_int + _double; 이 생략됨.
	      
	      byte _byte = 5;
	      short _short = 10;
	      _int = _byte + _short;
	       // byte타입이 short 타입으로 형변환되어야하는데
	       // byte는1바이트 short는2바이트로 4바이트인 int로 형변환함
	       // 컴퓨터는 4바이트 미만이면 연산 불가넝한 ㅋ
	       // int보다 작은타입은 int로 형변환 된다.
	       
	       // char은 2바이트이기 때문에 int로 형변환 
	       // char은보는건 문자지만 실제로 저장되는건 숫자.
	       char _char = 'a';
	       char _char2 = 'b';
	       _int = _char + _char2;
	       System.out.println(_int);
	       
	       // 오버플로우, 언더플로우
	       // 표현범위를 벗어나는 값을 표현할 때 발생하는 현상.
	       byte b =127;
	       b++;
	       System.out.println(b);
	       // 표현범위인 127을 벗어나면 가장 작은값 출력됨 -128 = 오버플로우
	       b--;
	       System.out.println(b);
	       // 표현범위인 -128을 벗어나면 가장 큰 값 출력됨 127 =  언더플로우
	       //연산에 범위에 맞게 타입을 선택해야함.
	       
	       // 다음을 한줄씩 계산해서 최종 결과값을 출력해주세여
	       // 1. 123456 + 654321
	       // 2. 1번의 결과값 * 123456
	       // 3. 2번의 결과값 / 123456
	       // 4. 3번의 결과값 - 654321
	       // 5, 4반의 결과값 %
	       
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
	       
	       //또는 
	       long num1 = 123456 + 654321;
	      num1*= 123456;
	      num1/=123456;
	      num1-=654321;
	      num1%=123456;
	      System.out.println(num1);
	      
	       
	      
	       // 3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요
	       int aa = 10;
	       int bb = 20;
	       int cc = 11; 
	       int sum= aa + bb + cc;
	       double avg = sum/3.0;
	       // sum/3에서 sum과 3둘다 int형이라 결과값 int. 결과값을 소수점으로 나오려면 3 ->3.0
	       System.out.println(sum);
	       System.out.println(avg);
	       
	       // 반올림
	       avg = Math.round(avg); //소수점 첫째자리에서 반올림을 해준다.
	       // 소수점 첫째자리가 보고싶으면 avg = Math.round(avg * 10)/10.0
	       // 소수점 둘째자리가 보고싶으면 avg = Math.round(avg * 100)/100.0
	       // 곱하고 곱한만큼 소숫점단위로 다시 나눠줌
	       System.out.println(avg);
	       
	       // 랜덤메소드 쓸일 많음
	       // Math.random() - 0.0~ 1.0미만의 수를 랜덤으로 발생시킨다.
	       // 0부터 0.99999''''''미만의수까지
	       int random =(int)(Math.random()*100)+1;
	       // 1~100사이의 랜덤값
	       System.out.println(random);
	       
	       
	       
	   }

	}