package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다.
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 */
		
		// int타입의 변수를 여러게 만들고싶다
		int[] array; // 배열의 주소를 저장할 공간이 만들어진다. int array[]도 됨.
        array = new int[5]; // 배열의 초기화. 배열이 생성되고 그 주소가 저장된다.
        // 배열 초기화시 기본값이 저장된다. int타입의 경우0.
        
        /*
         * array(변수) = 100번지(주소)
         * 변수에는 배열의 주소가 저장됨
         * 
         * 100번지 주소를 찾아갔을때
         * {0,0,0,0,0}의 값이 들어가 있음. 사실 첫번째0이100번지 그다음이 101,102,103번지 이렇게임.
         */
        
        array = new int[]{1, 2, 3, 4, 5}; // 값을 넣어서 배열을 초기화 하는 방법
      
        // array = {1, 2, 3, 4, 5};    new int 생략가능. 대신 선언과 초기화를 동시에 해야함
        int[] array2 = {1, 2, 3, 4, 5};
        
        
        System.out.println(array); // 배열의 주소가 출력됨. 주소 말고 안에 들어있는 실제 값을 출력하려면?
        System.out.println(array[0]); // 인덱스사용~. 인덱스는 0부터 시작
        System.out.println(array[1]);

        array[0] = 10; 
        array[1] = 20; 
        array[2] = 30; 
        array[3] = 40; 
        array[4] = 50; 
        
        // 인덱스가 반복문으로 만들기 딱 좋음. length -> 배열의 크기 
        for(int i =0; i< array.length; i++){
        	array[i]= (i+1) * 10;
        }
        
        // 모든 인덱스의 값 출력
        for(int i = 0; i< array.length; i++){
            System.out.println(array[i]); 	
       }
        
        // 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화
        int[] arrayy ;
        arrayy = new int [10];
         
        // 또는  int[] arrayy  = new int [10];
        
        // 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장
    
        for(int i =0; i< arrayy.length; i++){
        	arrayy[i] = (int)(Math.random()*100)+1;
        	
        }
        
        //10개의 인덱스 출력
        for(int i = 0; i< arrayy.length; i++){
            System.out.println(arrayy[i]); 	
       }
        
        //또는. Arrays.toString는 배열에 있는 모든 값을 문자열로 만들어서 출력해줌.
        System.out.println(Arrays.toString(arrayy));
        
        // 배열에 저장된 모든 값의 합계와 평균출력
        int sum = 0;
        double avg = 0;
        
        for(int i =0; i< arrayy.length; i++){
        	sum += arrayy[i];
        }
     
        avg = sum / 10.0;
        avg = Math.round(avg * 10)/10.0;
        // 또는 형변환 double avg = (double)sum / arr.length;
        System.out.println("합계: "+sum+" 평균: "+avg);
    
        
  // 배열에 저장된 값들 중 최소값과 최대값
        int min = arrayy[0];
        int max = arrayy[0];

      for(int i=0; i <arrayy.length-1; i++){

       if( arrayy[i] <min)
        	min = arrayy[i]; // 순서 바껴서 arrayy[i] = min 하면 값안나옴
    	if( max< arrayy[i])
    		max =  arrayy[i]; // 마찬가지로 순서 바껴서 arrayy[i] = max 하면 값안나옴
      }
      
      System.out.println("min="+min+" max="+max);
      
      // 1~10인 배열의 값을 섞으시오. 어이없게 까다로운문제~
      
      
      int[] shuffle = new int[10];
      for(int i=0; i<shuffle.length; i++){
    	  shuffle[i]= i+1;
      }
      
   System.out.println(Arrays.toString(shuffle));
   
  // j의 값은 인덱스가 될거라 중복이어도 노상관
   for(int i=0; i<shuffle.length; i++){
	   int j = (int)(Math.random()*shuffle.length);
	   /* Math.random()의 반환값은 0.0~0.99999미만의 값임
	    * 때문에 10을곱하면 0.0~9.99999..즉 0~9까지의 랜덤수를 
	    * 반환받음. 여기에  1을 더하면 범위는 1.0~10.999..를
	    * 가지게 되어 1~10까지의 수를 반환함.
	    */
	   
	   System.out.println(j);
	
	   int temp = shuffle[0];
	   
	   shuffle[0] = shuffle[j];
	   shuffle[j] = temp;
	   
   }
   System.out.println(Arrays.toString(shuffle));


   
   
	}

}
