package c.statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {

	      int result = 0;
	      
	   System.out.println("��ħ�� ��Ҹ� ���� �� ���ɽð� ���� �谡 ������. ������1 �ƴϸ�0");
	      Scanner sc = new Scanner(System.in);
	      int q1 = Integer.parseInt(sc.nextLine());
	      
	      if(q1==0){
	      
	      }else if(q1==1){
	         result +=q1;
	      }
	      
	      System.out.println("��, �� ���� �� ������ �Ա� �����ϸ� ���� ����. ������1 �ƴϸ�0");
	      int q2 = Integer.parseInt(sc.nextLine());
	      if(q2==0){
	         
	      }else if(q2==1){
	         result +=q2;
	      }
	      
	      
	      System.out.println("������ �ݹ� ���� �Ŀ��� ���������� ���ϰ� �� �Դ´�.������1 �ƴϸ�0 ");
	      int q3 = Integer.parseInt(sc.nextLine());

	      if(q3==0){

	      }else if(q3==1){
	         result +=q3;
	      }


	      System.out.println("���� ������� �ʴ��� ���� ���� �ִ�. ������1 �ƴϸ�0");
	      int q4 = Integer.parseInt(sc.nextLine());
	   
	      if(q4==0){

	      }else if(q4==1){
	         result +=q4;
	      }
	      
	      System.out.println("������ �԰� ������ ���� ������ ���� ���� �ʴ´�. ������1 �ƴϸ�0");
	      int q5 = Integer.parseInt(sc.nextLine());
	      

	      if(q5==0){

	      }else if(q5==1){
	         result +=q5;
	      }
	      
	      System.out.println("��Ʈ������ ������ �ڲ� �԰� �;�����. ������1 �ƴϸ�0");
	      int q6 = Integer.parseInt(sc.nextLine());
	      
	      if(q6==0){

	      }else if(q6==1){
	         result +=q6;
	      }
	      
	      System.out.println("å���̳� ��Ź���� �׻� ����, ���ݸ� ���� �����ִ�. ������1 �ƴϸ�0");
	      int q7 = Integer.parseInt(sc.nextLine());
	      if(q7==0){

	      }else if(q7==1){
	         result +=q7;
	      }
	      
	      System.out.println("����5�ð� �Ǹ� �ǰ��԰� ������� ������ ���� �տ� ��������. ������1 �ƴϸ�0");
	      int q8 = Integer.parseInt(sc.nextLine());
	      
	      if(q8==0){

	      }else if(q8==1){
	         result +=q8;
	      }
	      
	      System.out.println("����, ���ݸ� �� �� ������ ����ص� �԰� �;�����. ������1 �ƴϸ�0");
	      int q9 = Integer.parseInt(sc.nextLine());
	      
	      if(q9==0){

	      }else if(q9==1){
	         result +=q9;
	      }
	      
	      System.out.println("���̾�Ʈ�� ���� ���������� �ϴµ� 3�ϵ� ������. ������1 �ƴϸ�0");
	      int q10 = Integer.parseInt(sc.nextLine());
	      
	      if(q10==0){

	      }else if(q10==1){
	         result +=q10;
	      }
	      
	      if(result<=3){
	         System.out.println("����! ������ ������ �ƴ����� ���� �ʿ�");
	      }else if(4<=result && result<=6){
	         System.out.println("����! ź��ȭ�� ���� ���̱� ���� �Ľ��� ������ �ʿ���");
	      }else if(7<=result){ 
	         System.out.println("�ߵ�! ������ ����� �ʿ���");
	      }
	         
	         
	         
	         
//	         --------------------------------------------------------------------------------------------------------------------------//
	         
	         
	         
	         
	   /*      
	         
	         
	      
	         System.out.println("��ħ�� ��Ҹ� ���� �� ���ɽð� ���� �谡 ������. ������1 �ƴϸ�0");
	         Scanner sc = new Scanner(System.in);
	         int q1 = Integer.parseInt(sc.nextLine());
	         
	         if(q1==0){
	         result=+0;
	         }else if(q1==1){
	            result +=q1;
	         }
	         
	         System.out.println("��, �� ���� �� ������ �Ա� �����ϸ� ���� ����. ������1 �ƴϸ�0");
	         int q2 = Integer.parseInt(sc.nextLine());
	         if(q2==0){
	         result=+0;   
	         }else if(q2==1){
	            result +=q2;
	         }
	         
	         
	         System.out.println("������ �ݹ� ���� �Ŀ��� ���������� ���ϰ� �� �Դ´�.������1 �ƴϸ�0 ");
	         int q3 = Integer.parseInt(sc.nextLine());

	         if(q3==0){
	            result=+0;
	         }else if(q3==1){
	            result +=q3;
	         }


	         System.out.println("���� ������� �ʴ��� ���� ���� �ִ�. ������1 �ƴϸ�0");
	         int q4 = Integer.parseInt(sc.nextLine());
	      
	         if(q4==0){
	         result=+0;

	         }else if(q4==1){
	            result +=q4;
	         }
	         
	         System.out.println("������ �԰� ������ ���� ������ ���� ���� �ʴ´�. ������1 �ƴϸ�0");
	         int q5 = Integer.parseInt(sc.nextLine());
	         

	         if(q5==0){
	         result=+0;

	         }else if(q5==1){
	            result +=q5;
	         }
	         
	         System.out.println("��Ʈ������ ������ �ڲ� �԰� �;�����. ������1 �ƴϸ�0");
	         int q6 = Integer.parseInt(sc.nextLine());
	         
	         if(q6==0){
	         result=+0;

	         }else if(q6==1){
	            result +=q6;
	         }
	         
	         System.out.println("å���̳� ��Ź���� �׻� ����, ���ݸ� ���� �����ִ�. ������1 �ƴϸ�0");
	         int q7 = Integer.parseInt(sc.nextLine());
	         if(q7==0){
	         result=+0;

	         }else if(q7==1){
	            result +=q7;
	         }
	         
	         System.out.println("����5�ð� �Ǹ� �ǰ��԰� ������� ������ ���� �տ� ��������. ������1 �ƴϸ�0");
	         int q8 = Integer.parseInt(sc.nextLine());
	         
	         if(q8==0){
	         result=+0;

	         }else if(q8==1){
	            result +=q8;
	         }
	         
	         System.out.println("����, ���ݸ� �� �� ������ ����ص� �԰� �;�����. ������1 �ƴϸ�0");
	         int q9 = Integer.parseInt(sc.nextLine());
	         
	         if(q9==0){
	         result=+0;

	         }else if(q9==1){
	            result +=q9;
	         }
	         
	         System.out.println("���̾�Ʈ�� ���� ���������� �ϴµ� 3�ϵ� ������. ������1 �ƴϸ�0");
	         int q10 = Integer.parseInt(sc.nextLine());
	         
	         if(q10==0){
	         result=+0;

	         }else if(q10==1){
	            result +=q10;
	         }
	         
	         if(result<=3){
	            System.out.println("����! ������ ������ �ƴ����� ���� �ʿ�");
	         }else if(4<=result && result<=6){
	            System.out.println("����! ź��ȭ�� ���� ���̱� ���� �Ľ��� ������ �ʿ���");
	         }else if(7<=result){ 
	            System.out.println("�ߵ�! ������ ����� �ʿ���");
	      
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
	      
	      System.out.println("��, �� ���� �� ������ �Ա� �����ϸ� ���� ����. ������1 �ƴϸ�0");
	      int q2 = Integer.parseInt(sc.nextLine());
	      switch(q2){
	      case 0:
	         
	      case 1:
	         result += 1;
	         System.out.println(result);
	         break;
	      }*/
	/*      
	      System.out.println("������ �ݹ� ���� �Ŀ��� ���������� ���ϰ� �� �Դ´�.������1 �ƴϸ�0 ");
	      int q3 = Integer.parseInt(sc.nextLine());
	      switch(q3){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("���� ������� �ʴ��� ���� ���� �ִ�. ������1 �ƴϸ�0");
	      int q4 = Integer.parseInt(sc.nextLine());
	      switch(q4){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("������ �԰� ������ ���� ������ ���� ���� �ʴ´�. ������1 �ƴϸ�0");
	      int q5 = Integer.parseInt(sc.nextLine());
	      switch(q5){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("��Ʈ������ ������ �ڲ� �԰� �;�����. ������1 �ƴϸ�0");
	      int q6 = Integer.parseInt(sc.nextLine());
	      switch(q6){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("å���̳� ��Ź���� �׻� ����, ���ݸ� ���� �����ִ�. ������1 �ƴϸ�0");
	      int q7 = Integer.parseInt(sc.nextLine());
	      switch(q7){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      

	      System.out.println("����5�ð� �Ǹ� �ǰ��԰� ������� ������ ���� �տ� ��������. ������1 �ƴϸ�0");
	      int q8 = Integer.parseInt(sc.nextLine());
	      switch(q8){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("����, ���ݸ� �� �� ������ ����ص� �԰� �;�����. ������1 �ƴϸ�0");
	      int q9 = Integer.parseInt(sc.nextLine());
	      switch(q9){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println("���̾�Ʈ�� ���� ���������� �ϴµ� 3�ϵ� ������. ������1 �ƴϸ�0");
	      int q10 = Integer.parseInt(sc.nextLine());
	      switch(q10){
	      case 0:
	         result += 0;
	      case 1:
	         result += 1;
	      }
	      
	      System.out.println(result);
	      
	      if(result<=3){
	         System.out.println("����! ������ ������ �ƴ����� ���� �ʿ�");
	      }else if(4<=result && result<=6){
	         System.out.println("����! ź��ȭ�� ���� ���̱� ���� �Ľ��� ������ �ʿ���");
	      }else if(7<=result){ 
	         System.out.println("�ߵ�! ������ ����� �ʿ���");
	      }*/
	   }

	}
