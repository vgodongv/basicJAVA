package d_array;

import java.util.Arrays;

public class Mytest {

	public static void main(String[] args) {
		
			int[] random =  new int[500];
			
			int [] count =  new int[10];
			
			int [] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			
			
			for(int i=0; i<random.length; i++){
				random[i] = (int)(Math.random()*10)+1;
				
			for(int j=0; j<num.length; j++)
				if(random[i] == num[j]){
					count[j]++;
					
				}
				
				}
			System.out.println(Arrays.toString(random));
			
			for(int k=0; k<num.length; k++){
			System.out.println(k+1+"이 생성된 횟수는"+count[k]);}
			
		
		}

	}

	// 쓰앵릠 counts[random-1]++;


	/*int countone = 0;
	int counttwo = 0;
	int countthree = 0;
	int countfour = 0;
	int countfive = 0;
	int countsix = 0;
	int countseven = 0;
	int counteight = 0;
	int countnine = 0;
	int countten = 0;
	int [] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


	for(int i=0; i<random.length; i++){
		random[i] = (int)(Math.random()*10)+1;

		if(random[i] == num[0]){
			countone++;
			
		}
		
		if(random[i] == num[1]){
			counttwo++;
			
		}
		if(random[i] == num[2]){
			countthree++;
			
		}
		if(random[i] == num[3]){
			countfour++;
			
		}
		if(random[i] == num[4]){
			countfive++;
			
		}
		if(random[i] == num[5]){
			countsix++;
			
		}
		if(random[i] == num[6]){
			countseven++;
			
		}
		if(random[i] == num[7]){
			counteight++;
			
		}
		if(random[i] == num[8]){
			countnine++;
			
		}
		if(random[i] == num[9]){
			countten++;
			
		}
		
		}
		System.out.println("1이 생성된 횟수는"+countone);	
			System.out.println("2가 생성된 횟수는"+counttwo);	
			System.out.println("3이 생성된 횟수는"+countthree);	
			System.out.println("4이 생성된 횟수는"+countfour);	
			System.out.println("5이 생성된 횟수는"+countfive);	
			System.out.println("6이 생성된 횟수는"+countsix);	
			System.out.println("7이 생성된 횟수는"+countseven);	
			System.out.println("8이 생성된 횟수는"+counteight);	
			System.out.println("9이 생성된 횟수는"+countnine);	
			System.out.println("10이 생성된 횟수는"+countten);	
		*/