package c.statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		// 랜덤한 3자리 숫자를 만들어서 정답과 비교해서 스트라이크_자릿수랑 숫자랑 똑같을때. 볼_숫자는 같은데 자릿수가 다를때. 아웃_아예 같은 숫자가 없을때
	    //      1~9사이의 숫자가 각각 다르게 
	    //      ex. 123 -> 135 : 1S 1B 10
	      
	      /*do{
	         System.out.println("1~100사이의 수를 입력해주세요>");
	         input = Integer.parseInt(sc.nextLine());
	         
	         if(answer < input){
	            System.out.println(input+"보다 작습니다.");
	         }else if(answer > input){
	            System.out.println(input + "보다 큽니다.");
	         }else{
	            System.out.println("정답입니다!!");
	         }
	         
	      }while(input != answer); // 정답을 맞추지 못하는 동안 반복 false면 탈출 
	*/      
	      Scanner sc = new Scanner(System.in);
	      
	      int random1 = (int)(Math.random()*9)+1;
	      
	      int random2 = (int)(Math.random()*9)+1;
	      do {
	          random2 = (int)(Math.random()*9)+1;
	      }while(random2==random1 );
	      
	      int random3 = (int)(Math.random()*9)+1;
	      do {
	          random3 = (int)(Math.random()*9)+1;
	      }while(random1 == random3 || random2 == random3 || random1 == random2);
	      

	      System.out.println("랜덤값은"+random1+""+random2+""+random3);
	      
	      /*System.out.println("숫자를 입력해주세요>");
	      int num = Integer.parseInt(sc.nextLine());
	      
	      int num1 = (num /100);
	      int num2 = (num - (num1*100)) / 10;
	      int num3 = (num - (num1*100 + num2 *10));*/
	      
	   
	      int st = 0;
	      int ba = 0;
	      int ou = 0;
	      
	      
	      do{
	         st = 0; ba = 0; ou = 0;
	         
	         System.out.println("첫번쨰숫자를 입력해주세요>");
	         int num1 = Integer.parseInt(sc.nextLine());
	         System.out.println("두번째숫자를 입력해주세요>");
	         int num2 = Integer.parseInt(sc.nextLine());
	         System.out.println("세번째숫자를 입력해주세요>");
	         int num3 = Integer.parseInt(sc.nextLine());
	         
	         
	         
	      if(num1 == random1) //첫째짜리 스트라이크
	      {
	         st += 1;
	         
	      }else if( num1 == random2 ) // 첫쨰자리 볼
	      {
	         
	         ba+=1;
	      }else if (num1 == random3)
	      {  ba+=1;

	      }else if (num1 != random1){ // 첫째자리 아웃
	         ou+=1;
	      }else if (num1 != random2){
	      ou+=1;
	       }else if (num1 != random3){
	        ou+=1;
	         }
	      
	   
	      if(num2 == random2) //둘째짜리 스트라이크
	      {
	         st += 1;
	         
	      }else if( num2 == random1 ) // 둘쨰자리 볼
	      {
	         
	         ba+=1;
	      }else if (num2 == random3)
	      {  ba+=1;

	      }else if (num2 != random1){ // 둘째자리 아웃
	         ou+=1;
	      }else if (num2 != random2){
	      ou+=1;
	       }else if (num2 != random2){
	        ou+=1;
	         }
	      
	      if(num3 == random3) //셋째짜리 스트라이크
	      {
	         st += 1;
	         
	      }else if( num3 == random1 ) // 셋쨰자리 볼
	      {
	         
	         ba+=1;
	      }else if (num3 == random2)
	      {  ba+=1;

	      }else if (num3 != random1){ // 셋째자리 아웃
	         ou+=1;
	      }else if (num3 != random2){
	      ou+=1;
	       }else if (num3 != random2){
	        ou+=1;
	         }
	      
	      System.out.println(st+"   strik    "+ ba+"    ball     "+ou+"   out   ");
	      
	      }while(st!=3);
	      
	   }

	}