package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		// 402ȣ ��ü �л��� �� ����ڰ� �Է��� ���ڸ�ŭ �������� �л��� �̴� ���α׷��� ������ּ���.
				// 25�� �л����� �̴»���� ������ ������ȵ�


				String[] students = {"������","����ȯ","���¿�","������","�輭��","�迵��","������","�����","�ڽ���",
						"��ä��","�տ���","������","������","�̼���","�̼���","����ȫ","����ȣ","������","������","���ž�",
						"������","���Ͽ�","������","�����","������"};
				
				Scanner sc = new Scanner(System.in);
				System.out.println("1~25 ������ ���ڸ� �Է����ּ���>");
				int num = Integer.parseInt(sc.nextLine());
				
				for(int i=1; i<students.length+1; i++){
					if(num==i){ // ����ڰ� i�� �Է��ߴٸ�
						String [] random = new String [i]; // iũ���� �迭 ����
						
						for(int j=0; j<random.length; j++){
							
								int k = (int)(Math.random()*25); // 0~25���� �ߺ��� �ȳ����� ���?
								
								random[j] = students[k];
							
						}
						System.out.println(Arrays.toString(random));
					}
					
				}
				
				
			}

		}

		/* ���ސ� �ڵ�
		int count = Integer.parseInt(sc.nextLine()); 

		 String[] pick =  new String[count];// ���� ����� ������ �迭
		 
		 int pickCount = 0; // ���� ���� ��� ��

		 do{
		       int random = (int)(Math.random()*students.length);
		       
		       boolean flag = true ;
		       for(int i =0; i<pick.length; i++){
		    	   if (students[random].equals(pick[i])){ // ��������̶� �̹� �̾Ƽ� �迭�� ������ ����̶� ������ false ==���ϸ� �迭�� ������ �ƴ� �ּҰ��� ����.
		    	   flag = false;
		    	   }
		       }
		       
		       if(flag){
		    	   pick[pickCount++]=students[random]; // ��������̶� �̹� �̾Ƽ� �迭�� ������ ����̶� �ٸ��� ���� �迭�� ��� ����
		    	   
		} while(pickCount < count);

		System.out.println(Arrays.toString(pick));
		 
		*/