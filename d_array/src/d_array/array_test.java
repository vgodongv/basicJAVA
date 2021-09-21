package d_array;

import java.util.Arrays;

public class array_test {

	public static void main(String[] args) {
	//  10개의 정수를 저장할 수 있는 배열을 선언 및 초기화
			int[] array =  new int[10];
			
			// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장
			for(int i=0; i<array.length; i++){
				array[i] = (int)(Math.random()*100)+1;
			}
			
			//10개의 인덱스 출력
			System.out.println(Arrays.toString(array));
			
			// 배열에 저장된 모든 값의 합계와 평균출력
			int sum=0;
			
			for(int k=0; k<array.length; k++){
				sum+=array[k];
			}
			double avg= (double)sum /array.length ;
			System.out.println("합계는"+sum+" 평균은"+avg);
			
			// 배열에 저장된 값들 중 최소값과 최대값
			int min = array[0];
			int max = array[0];
			
			for(int l=0; l<array.length; l++){ // 왜 -1????????????????????????????????????????????????????
				
				if(array[l] < min)
					
					min = array[l];
				
				if(array[l] > max)
					
					max = array[l];
				
			}
			System.out.println("최소값은"+min+"최댓값은"+max);
			
			// 배열의 값을 섞으시오
			
			// int [] shuffle = {1,2,3,4,5,6,7,8,9,10};
			int[] shuffle =  new int [10];
			for(int m=0; m<shuffle.length; m++){
				shuffle[m] = m+1;
			}
			
			for(int i=0; i<shuffle.length; i++){
				  int j = (int)(Math.random()*shuffle.length);
				int a = shuffle[0];
				
				shuffle[0]= shuffle[j];
		        shuffle[j]=a;
			}
			
			System.out.println(Arrays.toString(shuffle));
		}

	}
