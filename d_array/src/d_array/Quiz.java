package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args)  {

		/*int money = (int)(Math.random()*500) * 10;
		int[] coin = {500, 100, 50, 10};
		
		System.out.println("�Ž�����: " + money);*/

		/* �Ž������� ������ �������� ��� ������ �ʿ����� ������ּ���
		ex. 2860���̸�
		500��5��, 100��3��, 50��1��, 10��1��
		
	
		int[] sum = new int[coin.length];
		
	
		for(int j=0; j<coin.length; j++){
			int count = money / coin[j]; 
			money=money%coin[j];
			System.out.println(coin[j]+"��:" + count + "��");
		}
*/
		// 1~5�� ���ڰ� �߻��� Ƚ����ŭ *�� ����� �׷��� �׸���
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
		
		int[]count =new int[5]; // �ε��� 0~4
		
		for(int i=0; i<arr.length; i++){// 20���ݺ�
			count[arr[i]-1]++; // �� 1�� ���°��� -> �ε��� ������ 0�̶�.
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
		
		// 1~5 ������ ������ ���� 10�� ����� �迭���� �ߺ��� ���� ���ŵ� �迭
		
		int[] arr= new int[10];
		
		
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*5)+1;
			
		}
		System.out.println(Arrays.toString(arr));
		
	// �ߺ��� ���� ���´ٸ� �ִ� 5��(�ߺ�������?)
		
		int[] temp = new int[5];
		int count = 0;
		for(int i =0; i<arr.length; i++){
			boolean flag = false;
			for(int j =0; j<temp.length; j++){
				if(arr[i]==temp[j]){
					flag = true; // ��ó���� �翬�� 0�̾ƴϴϱ� false
					
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
	
		
	