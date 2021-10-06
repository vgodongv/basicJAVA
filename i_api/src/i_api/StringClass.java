package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {
		/*
		 * String
		 * - 자바에 존재하는 라이브러리
		 * - 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 * String의 주요 메서드
		 * - equals() : 문자열의 내용이 같은지 반환한다. boolean
		 * - length() : 문자열의 길이를 반환한다. int
		 * - charAt() : 특정 인덱스에 위치한 문자를 반환한다. char
		 * - substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 * - indexOf() : 문자열 내의 특정 문자의 인덱스를 반환한다.
		 * - contains() : 문자열이 특정 문자열을 포함하고 있는지 여부를 반환한다.
		 * - split() : 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 * - trim() : 문자열 앞뒤의 공백을 제거해 반환한다.
		 * - valueOf(): 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 */
		
		
		
		
		
		boolean equals ="문자열".equals("문자열");
		// 문자열을 변수를 사용하여 넣는경우 그 타입은 String 이어야함
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2));
		// System.out.println(str2.equals(str1)); 예외발생. String 타입이어도 null인값은 파라미터엔 들어갈 수 있어도 앞에 변수에 못들어감
		
		String str ="12345";
		int length = str.length(); // int형으로 반환해줌
		for(int i=0; i<length; i++){
			char charAt = str.charAt(i); //char형으로 반환해줌
			System.out.println(charAt);
		}
		
		//문자열 뒤집기
		String rev = ""; // 12345에서 5부터 가져와서 rev에 넣음
		for(int i=str.length()-1; 0<=i; i--){
			rev += str.charAt(i);
		}
		System.out.println(rev);//54321
		
		str="0123456789";
		String sub1 = str.substring(3); // 파라미터 1개아님 2개 받을 수 있음. 3번인덱스부터 잘라서 반환
		System.out.println(sub1);//3456789
		String sub2 = str.substring(5,8); // 시작하는 인덱스와 끝나는 인덱스인데 567까지 반환. 끝나는 인덱스 8번은 출력되지않음 ㄱ-
		System.out.println(sub2); //567
		
		str ="수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지"); //파라미터로 넘긴 오렌지가 str에서 시작하는 인덱스 반환 = 3번
		System.out.println(index);//3
		
		//substring과 indexOf를 조합해서 문자열 자르기. 과일이름만 가져오기
		String[] menu = {
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원"
		};
		for(int i=0; i<menu.length; i++){
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);
		}
		

		// 가격만 잘라서 int 타입 변수에 저장
		for(int i=0; i<menu.length; i++){
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ")+1, menu[i].indexOf("원")));
			System.out.println(price);
		
		
		}
		
		
		str = "abcd"; 
		boolean contains = str.contains("c");
		System.out.println(contains); //여부를 알려주니까 boolean 타입
		
		//오렌지가 메뉴의 몇번 인덱스에 있는지 찾기 
		for(int i=0; i<menu.length; i++){
			boolean o = menu[i].contains("오렌지");
			if(o){ // if(menu[i].contains("오렌지")) 도됨
				System.out.println(i+"번 인덱스");
			}
		}
	
		str = "a/b/c";
		String[] split = str.split("/"); // /를 기준으로 a,b,c로 나눠주고 이를 String 배열로 리턴
		System.out.println(Arrays.toString(split));
		
		// 위에서 만든 menu배열의 메뉴명과 가격 나누기
		for(int i =0; i<menu.length; i++){
			String[] arr = menu[i].split(" ");
		/*	System.out.println(Arrays.toString(arr));*/
			System.out.println("메뉴명: "+ arr[0]+" / 가격: "+arr[1]);
		}
		
		str= "        문 자 열     ";
		String trim = str.trim(); // 문자열 사이에 있는 공백은 없애주지 않고 문자열 앞뒤에 있는 공백만 없애줌
		System.out.println("["+str+"] - > ["+trim+"]"); //[        문 자 열     ] - > [문 자 열]
		
		
		String id = " myid";
		String password = "mypassword ";
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());
		
		//꼼수로 문자열로 반환하기
		int number =10;
		str = number + ""; //자바에서는 타입에상관없이 문자열과 만나면 문자열로 바뀜
		
		str= String.valueOf(number); //String 클래스를 통해 사용
		System.out.println(str);
		
		
	}

}




