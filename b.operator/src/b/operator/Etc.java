package b.operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		  /*
		    * 비트 연산자
		    * - |, &, ^, ~, <<, >>
		    * - 비트 단위로 연산한다.
		    * 
		    * 기타 연산자
		    * - .(참조연산자) : 특정 범위내에 속해 있는 멤버를 지칭할 때 사용한다.
		    * - ?:(삼항연산자-중요): 
		     조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할 문장
		    */
		     
		      
		      System.out.println(10 | 15);
		      // 10을2진수로 표현하면  00001010 15를 2진수로 표현하면 00001111
		      // 00001010
		      // 00001111
		      // 00001111 둘다 0이면 0 그렇지 않으면 1
		      
		       int x = 10;
		       int y = 20;
		       int result = x < y ? x : y;
		       // x < y조건식의 결과에 따라 x아니면 y중 하나가 실행되는 구조
		       // x< y가 참이면 x실행 거짓이면 y
		       System.out.println(result);
		       
		       // 주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면여자
		       
		       int regNO =3;
		       String gender = regNO == 1? "남자" : "여자";
		       System.out.println("당신의 성별은"+ gender +"입니다.");
		       // 2 이외의 값도 여자로 인식되는 문제
		       gender = regNO == 1? "남자" : (regNO ==2 ? "여자": "확인불가");
		       System.out.println("당신의 성별은"+ gender +"입니다.");
		       
		       // 2개의 숫자를 입력받고, 둘중 더큰 숫자를 출력해주세요
		       
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1를 입력해주세요>");
		int num1 = Integer.parseInt(sc.nextLine());

		System.out.println("숫자2를 입력해주세요>");
		int num2 = Integer.parseInt(sc.nextLine());

		int re = num1 < num2 ? num2 : num1;
		System.out.println(re);

		//  이것도 됨 
		
		System.out.println(num1 < num2 ? num2 : num1);
		   
		// 숫자를 입력받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요
		       // 그외의 숫자를 입력하면 확인불가를 출력
		       
		   
		       System.out.println("숫자1를 입력해주세요>");
		       int num3 = Integer.parseInt(sc.nextLine());
		       System.out.println("숫자2를 입력해주세요>");
		       int num4 = Integer.parseInt(sc.nextLine());
		   
		       String cal = num3 == 1 || num4 == 3 ? "남자" : (num3 ==2 || num4==4?"여자":"확인불가");
		   
		       System.out.println("num3"+ cal +"num4"+"="+cal);
		       
		        
		   }

		}
