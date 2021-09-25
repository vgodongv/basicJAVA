package hello;

import java.util.Arrays;

public class hi {

	public static void main(String[] args) {
		//1~10까지 500번생성후 각 숫자가 몇번 생성되었는지 출력
		
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
					System.out.println(j+"이 발생된 횟수는"+count[j-1]);
				}
			}
		
		}
		


	
	


 
	}

}
