package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * �迭
		 * - �������� ���� �ϳ��� ������ �����ؼ� ����ϴ� ���̴�.
		 * - ������ Ÿ���̴�.
		 * - �ε����� ���� �����Ѵ�.
		 * - ���̸� ������ �� ����.
		 */
		
		// intŸ���� ������ ������ �����ʹ�
		int[] array; // �迭�� �ּҸ� ������ ������ ���������. int array[]�� ��.
        array = new int[5]; // �迭�� �ʱ�ȭ. �迭�� �����ǰ� �� �ּҰ� ����ȴ�.
        // �迭 �ʱ�ȭ�� �⺻���� ����ȴ�. intŸ���� ���0.
        
        /*
         * array(����) = 100����(�ּ�)
         * �������� �迭�� �ּҰ� �����
         * 
         * 100���� �ּҸ� ã�ư�����
         * {0,0,0,0,0}�� ���� �� ����. ��� ù��°0��100���� �״����� 101,102,103���� �̷�����.
         */
        
        array = new int[]{1, 2, 3, 4, 5}; // ���� �־ �迭�� �ʱ�ȭ �ϴ� ���
      
        // array = {1, 2, 3, 4, 5};    new int ��������. ��� ����� �ʱ�ȭ�� ���ÿ� �ؾ���
        int[] array2 = {1, 2, 3, 4, 5};
        
        
        System.out.println(array); // �迭�� �ּҰ� ��µ�. �ּ� ���� �ȿ� ����ִ� ���� ���� ����Ϸ���?
        System.out.println(array[0]); // �ε������~. �ε����� 0���� ����
        System.out.println(array[1]);

        array[0] = 10; 
        array[1] = 20; 
        array[2] = 30; 
        array[3] = 40; 
        array[4] = 50; 
        
        // �ε����� �ݺ������� ����� �� ����. length -> �迭�� ũ�� 
        for(int i =0; i< array.length; i++){
        	array[i]= (i+1) * 10;
        }
        
        // ��� �ε����� �� ���
        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]); 	
       }
        
        // 10���� ������ ������ �� �ִ� �迭�� ���� �� �ʱ�ȭ
        int[] arrayy ;
        arrayy = new int [10];
         
        // �Ǵ�  int[] arrayy  = new int [10];
        
        // �迭�� ��� �ε����� 1~100������ ������ ���� ����
    
        for(int i =0; i< arrayy.length; i++){
        	arrayy[i] = (int)(Math.random()*100)+1;
        	
        }
        
        //10���� �ε��� ���
        for(int i = 0; i< arrayy.length; i++){
            System.out.println(arrayy[i]); 	
       }
        
        //�Ǵ�. Arrays.toString�� �迭�� �ִ� ��� ���� ���ڿ��� ���� �������.
        System.out.println(Arrays.toString(arrayy));
        
        // �迭�� ����� ��� ���� �հ�� ������
        int sum = 0;
        double avg = 0;
        
        for(int i =0; i< arrayy.length; i++){
        	sum += arrayy[i];
        }
     
        avg = sum / 10.0;
        avg = Math.round(avg * 10)/10.0;
        // �Ǵ� ����ȯ double avg = (double)sum / arr.length;
        System.out.println("�հ�: "+sum+" ���: "+avg);
    
        
  // �迭�� ����� ���� �� �ּҰ��� �ִ밪
        int min = arrayy[0];
        int max = arrayy[0];

      for(int i=0; i <arrayy.length-1; i++){

       if( arrayy[i] <min)
        	min = arrayy[i]; // ���� �ٲ��� arrayy[i] = min �ϸ� ���ȳ���
    	if( max< arrayy[i])
    		max =  arrayy[i]; // ���������� ���� �ٲ��� arrayy[i] = max �ϸ� ���ȳ���
      }
      
      System.out.println("min="+min+" max="+max);
      
      // 1~10�� �迭�� ���� �����ÿ�. ���̾��� ��ٷο��~
      
      
      int[] shuffle = new int[10];
      for(int i=0; i<shuffle.length; i++){
    	  shuffle[i]= i+1;
      }
      
   System.out.println(Arrays.toString(shuffle));
   
  // j�� ���� �ε����� �ɰŶ� �ߺ��̾ ����
   for(int i=0; i<shuffle.length; i++){
	   int j = (int)(Math.random()*shuffle.length);
	   /* Math.random()�� ��ȯ���� 0.0~0.99999�̸��� ����
	    * ������ 10�����ϸ� 0.0~9.99999..�� 0~9������ �������� 
	    * ��ȯ����. ���⿡  1�� ���ϸ� ������ 1.0~10.999..��
	    * ������ �Ǿ� 1~10������ ���� ��ȯ��.
	    */
	   
	   System.out.println(j);
	
	   int temp = shuffle[0];
	   
	   shuffle[0] = shuffle[j];
	   shuffle[j] = temp;
	   
   }
   System.out.println(Arrays.toString(shuffle));


   
   
	}

}
