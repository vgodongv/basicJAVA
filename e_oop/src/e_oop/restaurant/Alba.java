package e_oop.restaurant;

import java.util.Arrays;

public class Alba {

	   // 메서드: 알바가 할 일(보스가 알바에게 시킨 일)
	   // 파라미터: 일을 하기 위해 필요한것(보스가 알바에게 주는것)
	   // 리턴타입: 일을 하고 난 후 돌려주는것(알바가 보스에게 주는것)
	   
	   // 주문받기 위해 필요한 것? 없음(있을수도있지만 없다고 가정)
	   // 주문받은 후 보스에게 줄 것? 주문서. 주문서라는 클래스를 만들어 쓰는게 베스트긴함.
	   String[] order(){
	      System.out.println("주문하시겠습니까?");
	      //손님이 주문했다치고
	      return new String[]{"짜장면","탕수육"};
	   }
	   
	   // 서빙하기 위해 필요한 것? 파라미터 음식
	   // 서빙 후 보스에게 줄것?return타입 x
	   
	   void serve(String[] foods){
	      System.out.println(Arrays.toString(foods));
	      System.out.println("맛있게 드세요.");
	   }
	   
	   //계산하기 위해 필요한 것? 주문서
	   // 계산 후 보스에게 줄것?없음
	   
	   void pay(String[] order){
	      System.out.println("2만원 입니다. 안녕히 가세요.");
	      
	   }
	   
	}