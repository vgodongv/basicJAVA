package c.statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		// ������ 3�ڸ� ���ڸ� ���� ����� ���ؼ� ��Ʈ����ũ_�ڸ����� ���ڶ� �Ȱ�����. ��_���ڴ� ������ �ڸ����� �ٸ���. �ƿ�_�ƿ� ���� ���ڰ� ������
	    //      1~9������ ���ڰ� ���� �ٸ��� 
	    //      ex. 123 -> 135 : 1S 1B 10
	      
	      /*do{
	         System.out.println("1~100������ ���� �Է����ּ���>");
	         input = Integer.parseInt(sc.nextLine());
	         
	         if(answer < input){
	            System.out.println(input+"���� �۽��ϴ�.");
	         }else if(answer > input){
	            System.out.println(input + "���� Ů�ϴ�.");
	         }else{
	            System.out.println("�����Դϴ�!!");
	         }
	         
	      }while(input != answer); // ������ ������ ���ϴ� ���� �ݺ� false�� Ż�� 
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
	      

	      System.out.println("��������"+random1+""+random2+""+random3);
	      
	      /*System.out.println("���ڸ� �Է����ּ���>");
	      int num = Integer.parseInt(sc.nextLine());
	      
	      int num1 = (num /100);
	      int num2 = (num - (num1*100)) / 10;
	      int num3 = (num - (num1*100 + num2 *10));*/
	      
	   
	      int st = 0;
	      int ba = 0;
	      int ou = 0;
	      
	      
	      do{
	         st = 0; ba = 0; ou = 0;
	         
	         System.out.println("ù�������ڸ� �Է����ּ���>");
	         int num1 = Integer.parseInt(sc.nextLine());
	         System.out.println("�ι�°���ڸ� �Է����ּ���>");
	         int num2 = Integer.parseInt(sc.nextLine());
	         System.out.println("����°���ڸ� �Է����ּ���>");
	         int num3 = Integer.parseInt(sc.nextLine());
	         
	         
	         
	      if(num1 == random1) //ù°¥�� ��Ʈ����ũ
	      {
	         st += 1;
	         
	      }else if( num1 == random2 ) // ù���ڸ� ��
	      {
	         
	         ba+=1;
	      }else if (num1 == random3)
	      {  ba+=1;

	      }else if (num1 != random1){ // ù°�ڸ� �ƿ�
	         ou+=1;
	      }else if (num1 != random2){
	      ou+=1;
	       }else if (num1 != random3){
	        ou+=1;
	         }
	      
	   
	      if(num2 == random2) //��°¥�� ��Ʈ����ũ
	      {
	         st += 1;
	         
	      }else if( num2 == random1 ) // �Ѥ��ڸ� ��
	      {
	         
	         ba+=1;
	      }else if (num2 == random3)
	      {  ba+=1;

	      }else if (num2 != random1){ // ��°�ڸ� �ƿ�
	         ou+=1;
	      }else if (num2 != random2){
	      ou+=1;
	       }else if (num2 != random2){
	        ou+=1;
	         }
	      
	      if(num3 == random3) //��°¥�� ��Ʈ����ũ
	      {
	         st += 1;
	         
	      }else if( num3 == random1 ) // �¤��ڸ� ��
	      {
	         
	         ba+=1;
	      }else if (num3 == random2)
	      {  ba+=1;

	      }else if (num3 != random1){ // ��°�ڸ� �ƿ�
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