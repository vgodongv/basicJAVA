package d_array;

import java.util.Arrays;

public class array_test {

	public static void main(String[] args) {
	//  10���� ������ ������ �� �ִ� �迭�� ���� �� �ʱ�ȭ
			int[] array =  new int[10];
			
			// �迭�� ��� �ε����� 1~100������ ������ ���� ����
			for(int i=0; i<array.length; i++){
				array[i] = (int)(Math.random()*100)+1;
			}
			
			//10���� �ε��� ���
			System.out.println(Arrays.toString(array));
			
			// �迭�� ����� ��� ���� �հ�� ������
			int sum=0;
			
			for(int k=0; k<array.length; k++){
				sum+=array[k];
			}
			double avg= (double)sum /array.length ;
			System.out.println("�հ��"+sum+" �����"+avg);
			
			// �迭�� ����� ���� �� �ּҰ��� �ִ밪
			int min = array[0];
			int max = array[0];
			
			for(int l=0; l<array.length; l++){ // �� -1????????????????????????????????????????????????????
				
				if(array[l] < min)
					
					min = array[l];
				
				if(array[l] > max)
					
					max = array[l];
				
			}
			System.out.println("�ּҰ���"+min+"�ִ���"+max);
			
			// �迭�� ���� �����ÿ�
			
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
