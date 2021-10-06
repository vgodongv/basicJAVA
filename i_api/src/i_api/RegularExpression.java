package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 * 정규표현식: 문자열의 패턴을 검사하는 표현식 => 범위가 좁은게 좋음
		 * 
		 * ^ 뒷 문자로 시작
		 * $ 앞 문자로 종료
		 * . 임의의 문자(줄바꿈 제외)
		 * * 앞문자가 0개 이상
		 * + 앞문자가 1개이상
		 * ? 앞문자가 없거나 1개
		 * [] 문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]: a부터 z가 아닌것
		 * {} 앞 문자의 개수({2}: 2개, {2,4}: 2개 이상 4개이하)
		 * () 그룹화 (1개의 문자처럼 인식)
		 * |  OR 연산
		 * \s 공백, 탭, 줄바꿈
		 * \S 공백, 탭, 줄바꿈이 아닌 문자
		 * \w 알파벳이나 숫자
		 * \W 알파벳이나 숫자가 아닌 문자
		 * \d 숫자
		 * \D 숫자가 아닌 문자
		 * (?i) 뒷 문자의 대소문자 구분안함
		 * \ 정규 표현식에서 사용되는 특수문자 표현
		 * 		  
		 */

		String str ="abc123"; // 검사할 문자열
		// String regex = "[a-z]{3}[0-9]{1,3}"; // 정규표현식. true
	   	// String regex = "[a-z0-9]+"; // 정규표현식. true
		   String regex = "\\w*"; // 정규표현식. 알파벳이나 숫자가 0개이상 온다. true
				
		
		/*Pattern p =Pattern.compile(regex); //정규표현식을 해석해서 객체를 가지고 있음
		 Matcher m =p.matcher(str);
		 System.out.println(m.matches());*/
		
		 // 아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		 
		 //아이디: 대소문자 구분 대소문자 아무거나 , 숫자사용
		   
		 String id = "[a-zA-Z0-9]";
		 //비밀번호: 대소문자 구분 대소문자 둘다사용, 숫자, 특수문자를 사용 8자리이상 12자리이하.
		 String PW ="Fkaus1234";
		 String pw ="(?i)[a-zA-Z0-9]{8,12}";
		 
		 Pattern p =Pattern.compile(pw); //정규표현식을 해석해서 객체를 가지고 있음
		 Matcher m =p.matcher(PW);
		 System.out.println(m.matches());
		
	}

}
