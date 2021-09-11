package c.statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {

	      int result = 0;
	      
	   System.out.println("아침을 배불리 먹은 후 점심시간 전에 배가 고프다. 맞으면1 아니면0");
	      Scanner sc = new Scanner(System.in);
	      int q1 = Integer.parseInt(sc.nextLine());
	      
	      if(q1==0){
	      
	      }else if(q1==1){
	         result +=q1;
	      }
	      
	      System.out.println("밥, 빵 과자 등 음식을 먹기 시작하면 끝이 없다. 맞으면1 아니면0");
	      int q2 = Integer.parseInt(sc.nextLine());
	      if(q2==0){
	         
	      }else if(q2==1){
	         result +=q2;
	      }
	      
	      
	      System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.맞으면1 아니면0 ");
	      int q3 = Integer.parseInt(sc.nextLine());

	      if(q3==0){

	      }else if(q3==1){
	         result +=q3;
	      }


	      System.out.println("정말 배고프지 않더라도 먹을 때가 있다. 맞으면1 아니면0");
	      int q4 = Integer.parseInt(sc.nextLine());
	   
	      if(q4==0){

	      }else if(q4==1){
	         result +=q4;
	      }
	      
	      System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다. 맞으면1 아니면0");
	      int q5 = Integer.parseInt(sc.nextLine());
	      

	      if(q5==0){

	      }else if(q5==1){
	         result +=q5;
	      }
	      
	      System.out.println("스트레스를 받으면 자꾸 먹고 싶어진다. 맞으면1 아니면0");
	      int q6 = Integer.parseInt(sc.nextLine());
	      
	      if(q6==0){

	      }else if(q6==1){
	         result +=q6;
	      }
	      
	      System.out.println("책상이나 식탁위에 항상 과자, 초콜릿 등이 놓여있다. 맞으면1 아니면0");
	      int q7 = Integer.parseInt(sc.nextLine());
	      if(q7==0){

	      }else if(q7==1){
	         result +=q7;
	      }
	      
	      System.out.println("오후5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안잡힌다. 맞으면1 아니면0");
	      int q8 = Integer.parseInt(sc.nextLine());
	      
	      if(q8==0){

	      }else if(q8==1){
	         result +=q8;
	      }
	      
	      System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다. 맞으면1 아니면0");
	      int q9 = Integer.parseInt(sc.nextLine());
	      
	      if(q9==0){

	      }else if(q9==1){
	         result +=q9;
	      }
	      
	      System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못간다. 맞으면1 아니면0");
	      int q10 = Integer.parseInt(sc.nextLine());
	      
	      if(q10==0){

	      }else if(q10==1){
	         result +=q10;
	      }
	      
	      if(result<=3){
	         System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
	      }else if(4<=result && result<=6){
	         System.out.println("위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
	      }else if(7<=result){ 
	         System.out.println("중독! 전문의 상담이 필요함");
	      }
	         
	         
	         
	         
//	         --------------------------------------------------------------------------------------------------------------------------//
	         
	         
	         
	         
	   /*      
	         
	         
	      
	         System.out.println("아침을 배불리 먹은 후 점심시간 전에 배가 고프다. 맞으면1 아니면0");
	         Scanner sc = new Scanner(System.in);
	         int q1 = Integer.parseInt(sc.nextLine());
	         
	         if(q1==0){
	         result=+0;
	         }else if(q1==1){
	            result +=q1;
	         }
	         
	         System.out.println("밥, 빵 과자 등 음식을 먹기 시작하면 끝이 없다. 맞으면1 아니면0");
	         int q2 = Integer.parseInt(sc.nextLine());
	         if(q2==0){
	         result=+0;   
	         }else if(q2==1){
	            result +=q2;
	         }
	         
	         
	         System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.맞으면1 아니면0 ");
	         int q3 = Integer.parseInt(sc.nextLine());

	         if(q3==0){
	            result=+0;
	         }else if(q3==1){
	            result +=q3;
	         }


	         System.out.println("정말 배고프지 않더라도 먹을 때가 있다. 맞으면1 아니면0");
	         int q4 = Integer.parseInt(sc.nextLine());
	      
	         if(q4==0){
	         result=+0;

	         }else if(q4==1){
	            result +=q4;
	         }
	         
	         System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다. 맞으면1 아니면0");
	         int q5 = Integer.parseInt(sc.nextLine());
	         

	         if(q5==0){
	         result=+0;

	         }else if(q5==1){
	            result +=q5;
	         }
	         
	         System.out.println("스트레스를 받으면 자꾸 먹고 싶어진다. 맞으면1 아니면0");
	         int q6 = Integer.parseInt(sc.nextLine());
	         
	         if(q6==0){
	         result=+0;

	         }else if(q6==1){
	            result +=q6;
	         }
	         
	         System.out.println("책상이나 식탁위에 항상 과자, 초콜릿 등이 놓여있다. 맞으면1 아니면0");
	         int q7 = Integer.parseInt(sc.nextLine());
	         if(q7==0){
	         result=+0;

	         }else if(q7==1){
	            result +=q7;
	         }
	         
	         System.out.println("오후5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안잡힌다. 맞으면1 아니면0");
	         int q8 = Integer.parseInt(sc.nextLine());
	         
	         if(q8==0){
	         result=+0;

	         }else if(q8==1){
	            result +=q8;
	         }
	         
	         System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다. 맞으면1 아니면0");
	         int q9 = Integer.parseInt(sc.nextLine());
	         
	         if(q9==0){
	         result=+0;

	         }else if(q9==1){
	            result +=q9;
	         }
	         
	         System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못간다. 맞으면1 아니면0");
	         int q10 = Integer.parseInt(sc.nextLine());
	         
	         if(q10==0){
	         result=+0;

	         }else if(q10==1){
	            result +=q10;
	         }
	         
	         if(result<=3){
	            System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
	         }else if(4<=result && result<=6){
	            System.out.println("위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
	         }else if(7<=result){ 
	            System.out.println("중독! 전문의 상담이 필요함");
	      
	         }
	      
	      */
	      
	      
	      
	      //----------------------------------------------------------------------------------------------------------------
	      /*
	      switch(q1){
	      case 0:
	         
	      case 1:
	         result += 1;
	         break;
	         
	      }
	      
	      System.out.println("밥, 빵 과자 등 음식을 먹기 시작하면 끝이 없다. 맞으면1 아니면0");
	      int q2 = Integer.parseInt(sc.nextLine());
	      switch(q2){
	      case 0:
	         
	      case 1:
	         result += 1;
	         System.out.println(result);
	         break;
	      }*/
	/*      
	      System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.맞으면1 아니면0 ");
	      int q3 = Integer.parseInt(sc.nextLine());
	      switch(q3){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("정말 배고프지 않더라도 먹을 때가 있다. 맞으면1 아니면0");
	      int q4 = Integer.parseInt(sc.nextLine());
	      switch(q4){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다. 맞으면1 아니면0");
	      int q5 = Integer.parseInt(sc.nextLine());
	      switch(q5){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("스트레스를 받으면 자꾸 먹고 싶어진다. 맞으면1 아니면0");
	      int q6 = Integer.parseInt(sc.nextLine());
	      switch(q6){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("책상이나 식탁위에 항상 과자, 초콜릿 등이 놓여있다. 맞으면1 아니면0");
	      int q7 = Integer.parseInt(sc.nextLine());
	      switch(q7){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      

	      System.out.println("오후5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안잡힌다. 맞으면1 아니면0");
	      int q8 = Integer.parseInt(sc.nextLine());
	      switch(q8){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다. 맞으면1 아니면0");
	      int q9 = Integer.parseInt(sc.nextLine());
	      switch(q9){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못간다. 맞으면1 아니면0");
	      int q10 = Integer.parseInt(sc.nextLine());
	      switch(q10){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println(result);
	      
	      if(result<=3){
	         System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
	      }else if(4<=result && result<=6){
	         System.out.println("위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
	      }else if(7<=result){ 
	         System.out.println("중독! 전문의 상담이 필요함");
	      }*/
	   }

	}
