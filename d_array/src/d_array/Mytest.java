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
			System.out.println(k+1+"�� ������ Ƚ����"+count[k]);}
			
		
		}

	}

	// ���ސ� counts[random-1]++;


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
		System.out.println("1�� ������ Ƚ����"+countone);	
			System.out.println("2�� ������ Ƚ����"+counttwo);	
			System.out.println("3�� ������ Ƚ����"+countthree);	
			System.out.println("4�� ������ Ƚ����"+countfour);	
			System.out.println("5�� ������ Ƚ����"+countfive);	
			System.out.println("6�� ������ Ƚ����"+countsix);	
			System.out.println("7�� ������ Ƚ����"+countseven);	
			System.out.println("8�� ������ Ƚ����"+counteight);	
			System.out.println("9�� ������ Ƚ����"+countnine);	
			System.out.println("10�� ������ Ƚ����"+countten);	
		*/