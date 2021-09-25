package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		  // 알바를 사용하기 위해 알바객체 생성
	      Alba alba = new Alba();
	      
	      String[] order = alba.order(); // 리턴타입값을 배열 order변수에 저장. 주문받은 내용을 배열 order에 저장
	       System.out.println(Arrays.toString(order));

	       System.out.println("요리 만드는 중....완성!");
	       String[] foods={"완성된 짜장면","완성된 탕수육"};
	       
	       alba.serve(foods);
	       
	       alba.pay(order);
	       
	   }

	}