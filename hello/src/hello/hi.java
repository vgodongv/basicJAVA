package hello;

import java.util.Arrays;

public class hi {

	public static void main(String[] args) {
		//1~10���� 500�������� �� ���ڰ� ��� �����Ǿ����� ���
		
		int[] arr = new int[10];
		int[] count= new int[10];
		
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*count.length)+1;
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<count.length+1; j++) {
				if(arr[i]==j) {
					count[j-1]++;
					System.out.println(j+"�� �߻��� Ƚ����"+count[j-1]);
				}
			}
		
		}
		


	
	


 
	}

}
