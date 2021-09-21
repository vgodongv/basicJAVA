package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * 다차원배열
		 *  - 배열안에 배열이 저장되어 있는 형태이다.
		 */

		// 1차원 배열은
		int[] array1;
		
		// 2차원 배열은
		int[][] array2;
		
		// 3차원 배열은
		int[][][] array3;
		
		int[][] arr = new int[2][3]; // 1차원배열 2개가 생성되고 각 배열안에 3칸짜리 배열이 생성된다.
		/*
		 * arr(변수) = 1차원 배열의 주소인 100번지
		 * 
		 * 100번지를 찾아갔을때
		 * {200번지, 300번지} 배열안에 값이 아닌 2차원 배열의 주소가 또 들어가 있는 것.
		 * 
		 * 200번지
		 * {0,0,0}
		 * 
		 * 300번지
		 * {0,0,0}
		 */
		
		int arr2[][] = new int[][]{{1,2,3},{4,5,6}}; // 실제 넣고싶은 값을 넣어 배열을 초기화 하는것. 값의 개수로 배열의 길이가 정해진다.
		int[] arr3[] = { {1, 2, 3}
		                ,{4, 5, 6}
		                ,{7, 8, 9} };
		
		int[][] arr4 = new int[3][]; // 가변배열
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];
		
		System.out.println(arr[0][1]);
		
		arr[0]=new int[5];// 0번인덱스에 5칸짜리 배열넣음
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;

		
		System.out.println(arr.length); //1차원 배열의 길이
		System.out.println(arr[0].length); //0번 인덱스의 2차원 배열의 길이
		System.out.println(arr[1].length); //1번 인덱스의 2차원 배열의 길이
		
		
		/*
		 * arr = { {10, 20, 0, 0, 0}
		 *        ,{100,0,0}}; 
		 */
		
		for(int i=0; i< arr.length; i++){ //1차원에 접근하기 위한 for문. 2번
			for(int j=0; j < arr[i].length; j++){ //2차원에 접근하기 위한 for문. 5번 3번
				System.out.println(arr[i][j]);
			}
		} 
		
		int[][] scores = new int[3][5]; // int[학생수][과목수]
		int[] sum= new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i=0; i<scores.length; i++){ // 1차원배열의 길이 3.
			for(int j=0; j< scores[i].length; j++){ //2차원배열의 길이 5.
				scores[i][j] = (int)(Math.random()*101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
	
			for(int i=0; i<scores.length; i++){ // 1차원배열의 길이 3.
				for(int j=0; j< scores[i].length; j++){  //2차원배열의 길이 5.	
					sum[i] +=scores[i][j]; 
					
				}
			}	
			
			System.out.println(Arrays.toString(sum));
		    
	for(int i=0; i<scores.length; i++){
		avg[i]=sum[i]/5.0;
		// avg[i]=(double)sum[i] / scores[i].length;
	}
	System.out.println(Arrays.toString(avg));
	
	
	}

}

