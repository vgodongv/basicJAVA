package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * �������迭
		 *  - �迭�ȿ� �迭�� ����Ǿ� �ִ� �����̴�.
		 */

		// 1���� �迭��
		int[] array1;
		
		// 2���� �迭��
		int[][] array2;
		
		// 3���� �迭��
		int[][][] array3;
		
		int[][] arr = new int[2][3]; // 1�����迭 2���� �����ǰ� �� �迭�ȿ� 3ĭ¥�� �迭�� �����ȴ�.
		/*
		 * arr(����) = 1���� �迭�� �ּ��� 100����
		 * 
		 * 100������ ã�ư�����
		 * {200����, 300����} �迭�ȿ� ���� �ƴ� 2���� �迭�� �ּҰ� �� �� �ִ� ��.
		 * 
		 * 200����
		 * {0,0,0}
		 * 
		 * 300����
		 * {0,0,0}
		 */
		
		int arr2[][] = new int[][]{{1,2,3},{4,5,6}}; // ���� �ְ���� ���� �־� �迭�� �ʱ�ȭ �ϴ°�. ���� ������ �迭�� ���̰� ��������.
		int[] arr3[] = { {1, 2, 3}
		                ,{4, 5, 6}
		                ,{7, 8, 9} };
		
		int[][] arr4 = new int[3][]; // �����迭
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];
		
		System.out.println(arr[0][1]);
		
		arr[0]=new int[5];// 0���ε����� 5ĭ¥�� �迭����
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;

		
		System.out.println(arr.length); //1���� �迭�� ����
		System.out.println(arr[0].length); //0�� �ε����� 2���� �迭�� ����
		System.out.println(arr[1].length); //1�� �ε����� 2���� �迭�� ����
		
		
		/*
		 * arr = { {10, 20, 0, 0, 0}
		 *        ,{100,0,0}}; 
		 */
		
		for(int i=0; i< arr.length; i++){ //1������ �����ϱ� ���� for��. 2��
			for(int j=0; j < arr[i].length; j++){ //2������ �����ϱ� ���� for��. 5�� 3��
				System.out.println(arr[i][j]);
			}
		} 
		
		int[][] scores = new int[3][5]; // int[�л���][�����]
		int[] sum= new int[scores.length];
		double[] avg = new double[scores.length];
		
		for(int i=0; i<scores.length; i++){ // 1�����迭�� ���� 3.
			for(int j=0; j< scores[i].length; j++){ //2�����迭�� ���� 5.
				scores[i][j] = (int)(Math.random()*101);
			}
			System.out.println(Arrays.toString(scores[i]));
		}
		
	
			for(int i=0; i<scores.length; i++){ // 1�����迭�� ���� 3.
				for(int j=0; j< scores[i].length; j++){  //2�����迭�� ���� 5.	
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

