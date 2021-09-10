package a.variable;

import java.util.Scanner; // Scanner는 java.util아래에있는 스캐너

//근데내가 위치를 어케알아!! ㅠ 위한 단축키 Ctrl+ shift + o

public class Variable { //클래스: 데이터와 기능을 모아놓은것

public static void main(String[] args) { 
//	메서드: 명령문의 집합
 // main 메서드: 프로그램의 시작과 끝 

 //   한줄주석: Ctrl + Shift+ c 또는 Ctrl + /

 /* 범위 주석: Ctrl + Shift+ /( 해제:\) */

 // 프로그래밍: 컴퓨터에게 일을 시키기 위해 일하는 과정을 만드는것
 // 재료: 데이터와 조작

 int x;
 long y;
 float z;
 char abc;
 boolean boolean$;
 String name123; 
 x= 10;
 y= 20L; //접미사 L을 붙여야  long타입이된다.
 z= 3.14f; // 접미사 f를 붙여야 float타입이된다. 안붙히면 double타입
 abc= '가'; // 따옴표안에 반드시 한글자를 넣어야한다.
 boolean$= true; // true아니면 false 둘중하나만 저장가능


 byte a;
 short b;
 int c;
 long d;
 float e;
 double f;
 char g;
 boolean h;
 String i;

 a= 3;
 b= 10;
 c= 200;
 d= 5L;
 e= 3.15f;
 f= 3.16;
 g= '나';
 h= false;
 i= "사과는 apple";

 int q= 10;


 int _int= 10;
 long _long= 20L;

 _int =(int) _long; // long타입이  int타입으로 바뀌어 저장.
 _long= _int; //표현 범위가 작은 타입에서 큰 타입으로의 형변환은 생략할 수 있다.
 // long이 더 크고 int가 더 작음. 

 int ab=10;
 long abz=30L;
 float abcd= 3.15f;

 ab=(int) abz; //long을 int로
 abz=(int)abcd; // float를  int(원래long인데 윗줄에서 int됨)로
 abcd = ab; // int를 float로

 char ch = 'a';
 short sh= 10; // 같은 2바이트여도 크기가 다르다함;

 ch = (char)sh;
 sh=(short)ch; // J애서 이렇게 ㅋ..

 System.out.print("출력");
 System.out.println("출력 후! 줄바꿈");
 System.out.printf("출력 후 포멧 지정");
 // 실행 단축키: 컨트롤+f11 굳이?

 // 탈출 문자
 System.out.println();
 System.out.println("탭은\t4칸에 맞춰 띄워줍니다."); // \t=탭
 System.out.println("줄바꿈을 \n해줍니다."); // \n=줄바꿈
 System.out.println("\"쌍따옴표를 넣어줍니다.\"");
 System.out.println("\\역슬래시를 넣어줍니다.");

 // 입력
 Scanner sc= new Scanner(System.in); 
 // 스캐너라는 클래스가 어디서 왔는지 알수없어서 오류뜸. 위치를 정확히 알려줘야함.
  // 위치를 알려주는것이 import 맨위로3번

 System.out.println("아무거나 입력해주세요>");
 String str = sc.nextLine(); // 괄호가 붙어있으면 메서드.
 //nextLine은 string타입!!
 System.out.println("입력받은내용: " +str);


 // 숫자를 입력받는 메서드
 System.out.println("숫자를 입력해주세요>");
 int num =  sc.nextInt(); 
 System.out.println("입력받은 숫자: " + num);
 // 문자입력 안받고 바로 넘어감 버그임.ㅋ
 System.out.println("문자열을 입력해주세요>");
 String str1= sc.nextLine();
 System.out.println("입력받은 문자열: " + str);
 System.out.println("입력끝!!!!");


 // 버그 안나게 숫자입력받기
    System.out.println("숫자를 입력해주세요>");
 int num1 = Integer.parseInt(sc.nextLine());
 // 문자열타입인 sc.nextLine을 Int타입으로 형변환!!
 System.out.println("입력받은 숫자: "+ num);

 System.out.println("이름과 나이를 입력해주세요>");
 String name = sc.nextLine(); 
 int age = Integer.parseInt(sc.nextLine());
 System.out.println("이름:" + name + " / 나이:" + age);



 float zx= 10.5f;
 double xc;
 xc =  zx; // float값을 double값으로 형변환
 System.out.println(zx);// 결과값 10.5
}

}

