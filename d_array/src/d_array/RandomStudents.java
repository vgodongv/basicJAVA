package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		// 402호 전체 학생들 중 사용자가 입력한 숫자만큼 랜덤으로 학생을 뽑는 프로그램을 만들어주세요.
				// 25명 학생들중 뽑는사람이 여러번 뽑히면안됨


				String[] students = {"강나영","강동환","강태영","곽지훈","김서윤","김영훈","김진석","김충신","박슬기",
						"박채린","손영태","손형흔","안정연","이선우","이수보","이주홍","이중호","임현정","장유진","정신애",
						"조수경","조하영","조혜민","허민정","박지은"};
				
				Scanner sc = new Scanner(System.in);
				System.out.println("1~25 사이의 숫자를 입력해주세요>");
				int num = Integer.parseInt(sc.nextLine());
				
				for(int i=1; i<students.length+1; i++){
					if(num==i){ // 사용자가 i를 입력했다면
						String [] random = new String [i]; // i크기의 배열 생성
						
						for(int j=0; j<random.length; j++){
							
								int k = (int)(Math.random()*25); // 0~25까지 중복값 안나오게 어떻게?
								
								random[j] = students[k];
							
						}
						System.out.println(Arrays.toString(random));
					}
					
				}
				
				
			}

		}

		/* 쓰앵릠 코드
		int count = Integer.parseInt(sc.nextLine()); 

		 String[] pick =  new String[count];// 뽑은 사람을 저장할 배열
		 
		 int pickCount = 0; // 현재 뽑은 사람 수

		 do{
		       int random = (int)(Math.random()*students.length);
		       
		       boolean flag = true ;
		       for(int i =0; i<pick.length; i++){
		    	   if (students[random].equals(pick[i])){ // 뽑은사람이랑 이미 뽑아서 배열에 저장한 사람이랑 같으면 false ==로하면 배열의 내용이 아닌 주소값이 나옴.
		    	   flag = false;
		    	   }
		       }
		       
		       if(flag){
		    	   pick[pickCount++]=students[random]; // 뽑은사람이랑 이미 뽑아서 배열에 저장한 사람이랑 다르면 만든 배열에 사람 넣음
		    	   
		} while(pickCount < count);

		System.out.println(Arrays.toString(pick));
		 
		*/