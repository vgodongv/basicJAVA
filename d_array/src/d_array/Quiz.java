package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args)  {

		/*int money = (int)(Math.random()*500) * 10;
		int[] coin = {500, 100, 50, 10};
		
		System.out.println("거스름돈: " + money);*/

		/* 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요
		ex. 2860원이면
		500원5개, 100원3개, 50원1개, 10원1개
		
	
		int[] sum = new int[coin.length];
		
	
		for(int j=0; j<coin.length; j++){
			int count = money / coin[j]; 
			money=money%coin[j];
			System.out.println(coin[j]+"원:" + count + "개");
		}
*/
		// 1~5의 숫자가 발생된 횟수만큼 *를 사용해 그래프 그리기
	 /*	ex. 1: ***3
		    2: ****4
		    3: **2
		    4: *****5
		    5: ******6
		    
		    */
		
		/*int[] arr = new int[20];
		for(int i=0; i< arr.length; i++){
			arr[i]=(int)(Math.random()*5)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int[]count =new int[5]; // 인덱스 0~4
		
		for(int i=0; i<arr.length; i++){// 20번반복
			count[arr[i]-1]++; // 왜 1을 빼는거쥐 -> 인덱스 시작이 0이라.
		}
		System.out.println(Arrays.toString(count));
		
		for(int i=0; i<count.length; i++){
			System.out.print(i+1+":");
			for(int j=0; j<count[i]; j++){
				System.out.print("*");
		
			}
			System.out.println(" "+ count[i]);
		}
		
		*/
		
		// 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열
		
		int[] arr= new int[10];
		
		
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
			
		}
		System.out.println(Arrays.toString(arr));
		
	// 중복된 값이 나온다면 최대 5개(중복없을때?)
		
		int[] temp = new int[5];
		int count = 0;
		for(int i =0; i<arr.length; i++){
			boolean flag = false;
			for(int j =0; j<temp.length; j++){
				if(arr[i]==temp[j]){
					flag = true; // 맨처음엔 당연히 0이아니니까 false
					
				}
			}
			if(!flag){
				temp[count++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result =  new int[count];
		for(int i =0; i<result.length; i++){
			result[i]=temp[i];
		}
		System.out.println(Arrays.toString(result));
	
		}

	
		
	}
	
		
	