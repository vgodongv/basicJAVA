package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 *  - 석차 구하기 : 점수를 비교해  작은 점수의 등수를 증가시키는 방식. 1등으로 다 저장해놓고 비교. 작은정수일수록 등수 증가.
		 *  - 선택 정렬: 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 *  - 버블 정렬: 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식.
		 *  - 삽입 정렬: 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */

		int[] arr = new int[10];
		
		for (int i =0; i< arr.length; i++){
			
			arr[i]=(int)(Math.random()*100)+1;
					
		}
		System.out.println(Arrays.toString(arr));
		
	/*	 석차구하기
		int[] rank = new int[arr.length];
		for(int i=0; i<arr.length; i++){
			rank[i]=1;
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i] < arr[j]){
					rank[i]++;
					
				}
		}
		//i는 나 j는 다른 사람들
		
		
		
		}
		
		for(int i = 0; i<arr.length; i++){
			System.out.println(arr[i]+" : "+ rank[i]+"등");
		}
		*/
		
	/* 선택정렬	for(int i = 0; i<arr.length-1; i++){
			int min = i; // 변수에 arr[0]을 넣는게 아니라 최소값의 인덱스를 찾기위해서 최소값의 인덱스를 저장. = i
			
			for(int j = i+1; j<arr.length; j++){
				if(arr[j]<arr[min]){ // 설정한 최소값의 인덱스(min)보다 작으면 그게 최소값
					min = j; // 작은값이 구해지면 min에는 작은값의 인덱스를 저장
				}
				
			}
			int temp = arr[i]; //i는 0부터 8까지 바뀜
						arr[i]=arr[min];
			arr[min]=temp; // 값의 위치를 바꿔줌
		}
		System.out.println(Arrays.toString(arr));
		*/
		
		// 버블정렬
		for(int j = 1; j<arr.length; j++){
			
		for(int i = 0; i<arr.length-j; i++){
			if(arr[i]>arr[i+1]){
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1]= temp;
			}
		}
		}
		
		System.out.println(Arrays.toString(arr));
		
		
	}
}

// 쓰앵림코드
/*for(int i = 0; i<arr.length-1; i++){
	booelan flag = false;
	for(int j = 0; j<arr.length-1-i; i++){
	if(arr[j]<arr(j+1)){
		int temp = arr[j];
		arr[j] =arr[j+1];
		arr[j+1]=temp;
		flag = true;
	}
	}
	if(flag == false){
	 break; 
	 // flag == false는 !flag로 바꾸는거 가능
	}
	
}*/