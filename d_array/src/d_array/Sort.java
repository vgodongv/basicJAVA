package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 *  - ���� ���ϱ� : ������ ����  ���� ������ ����� ������Ű�� ���. 1������ �� �����س��� ��. ���������ϼ��� ��� ����.
		 *  - ���� ����: ���� ���� ���ڸ� ã�Ƽ� ������ ������ ���
		 *  - ���� ����: �ٷ� ���� ���ڿ� ���ؼ� ū ���� �ڷ� ������ ���.
		 *  - ���� ����: �ι�° ���ں��� ���� ���ڵ�� ���ؼ� ū���� �ڷ� �а� �߰��� �����ϴ� ���
		 */

		int[] arr = new int[10];
		
		for (int i =0; i< arr.length; i++){
			
			arr[i]=(int)(Math.random()*100)+1;
					
		}
		System.out.println(Arrays.toString(arr));
		
	/*	 �������ϱ�
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
		//i�� �� j�� �ٸ� �����
		
		
		
		}
		
		for(int i = 0; i<arr.length; i++){
			System.out.println(arr[i]+" : "+ rank[i]+"��");
		}
		*/
		
	/* ��������	for(int i = 0; i<arr.length-1; i++){
			int min = i; // ������ arr[0]�� �ִ°� �ƴ϶� �ּҰ��� �ε����� ã�����ؼ� �ּҰ��� �ε����� ����. = i
			
			for(int j = i+1; j<arr.length; j++){
				if(arr[j]<arr[min]){ // ������ �ּҰ��� �ε���(min)���� ������ �װ� �ּҰ�
					min = j; // �������� �������� min���� �������� �ε����� ����
				}
				
			}
			int temp = arr[i]; //i�� 0���� 8���� �ٲ�
						arr[i]=arr[min];
			arr[min]=temp; // ���� ��ġ�� �ٲ���
		}
		System.out.println(Arrays.toString(arr));
		*/
		
		// ��������
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

// ���޸��ڵ�
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
	 // flag == false�� !flag�� �ٲٴ°� ����
	}
	
}*/