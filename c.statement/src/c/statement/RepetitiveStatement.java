package c.statement;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/* 
		 * 반복문
		 * - for문
		 * - while문
		 * - do -while문
		 * 
		 * for문
		 * - for(초기화; 조건식; 증감식){}
		 * - 포함하고 있는 문장들을 정해진 횟수만큼 반복하는 문장
		 * 
		 * 		 
		 */

		for(int i =1; i <= 10; i++){
			// 초기화: 조건식과 증감식에 사용할 변수 초기화. 초기화한 변수는  블럭 안에서만 사용가능.
			// 조건식: 연산결과가 true이면 블럭안의 내용을 수행
			// 증감식: 변수를 증가/감소시켜 반복문을 제어

			System.out.println(i + "번째 반복");		
			
		}
	
		int sum = 0 ; // 1부터 10까지의 합계를 저장
		
		sum +=1;
		sum +=2;
		sum +=3;
		sum +=4;
		sum +=5;
		sum +=6;
		sum +=7;
		sum +=8;
		sum +=9;
		sum +=10;
		System.out.println(sum);
		
		
		sum = 0;
		for(int i=1; i<=10; i++){
			sum+=i;
		}
		System.out.println(sum);
		
		// 1부터~10까지 더하는것.
		
		sum = 0;
		for(int i=10; i>=1; i--){
		sum+=i;	
		}
		System.out.println(sum);
		
		// 10에서~1까지 더하는것.
		
		// 1부터 100까지 짝수의 합을 출력해주세요.
		sum = 0;

		for(int i=1; i<=100; i++){
			if(i % 2 ==0)
				sum+=i;
		}
		System.out.println(sum);
			
			/*
			 * 또는
			 * for(int i = 2; i <= 100; i +=2){
				sum=+i;	
			}
			
			*/
			
		// 1부터 100까지 홀수의 합을 출력
			

//		sum =0 ;
//		for(int i=1; i<=100; i++){
//			if(i % 2 ==1)
//				sum+=i;
//		}
//		System.out.println(sum);
		
	
		/* 또는
		 
		 for(int i = 1; i <= 100; i +=2){
			sum+=i; }
		 System.out.println(sum);
		 
		 */
		
		// 구구단 출력
		/*
		 *  2 * 1 =2
		 *  2 * 2 = 4
		 *  2 * 3
		 *  2 * 4
		 *  2 * 5
		 */
		
		/*for(int i = 1; i<=9; i++){
			sum = 2 * i;
			System.out.println(" 2 * "+ i+"="+sum);
		}*/
		
		/* 또는
		 *
		for(int i =1; i<=9; i ++){
			System.out.println(2 + "*" + i + "="+i*2);
		}
		
		*/
			
		
		// 구구단 9단
		/*for(int i = 1; i<=9; i++){
			sum = 9 * i;
			System.out.println(" 9 * "+ i+"="+sum);
		}*/
			
		
		//2단부터 9단까지 출력
		/*for(int i =2; i<=9; i++){
			for(int j = 1; j<=9; j++){
				sum = i * j;
				System.out.println(i+ " * "+ j+" = "+sum);
			}
		}
		*/
		// 구구단 전체를 가로로 출력
		/*
		 *  2*1 =2 3*1 =3 4*1 =4
		 *  2*2= 4 3*2=6 4*2=8
		 *  
		 */
		
		
		for(int j=1; j<=9; j++)
		{System.out.println();
		for(int i =2; i <=9; i++){
			sum = i * j;
			System.out.printf(i + " * "+j +" = " +sum + "  ");
		}
		
		}
			
		//안에 있는 for문 실행완료후 바깥 for문실행하는것 !
		
		
		/* 또는
		  
		   for(int j=1; j<=9; j++){
		for(int i = 2; i<=9; i++){
			System.out.println(j + " * " + i + "= " + i * j);
		}
		Systemp.out.println();
		
		*/
			
	  /*
	   *  while문
	   *  - while(조건식){}
	   *  - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
	   *  - 반복횟수가 정확하지 않은 경우에 주로 사용한다.
	   */
			
		int a = 1;
		// a에 2씩 곱해서 1000이상이 되려면 몇번을 곱해야 하는가? 반복횟수를 모를때 주로 while문 사용
		
		
		int count = 0;
		while(a <1000){
			a *= 2;
		    count++;
		    System.out.println(count + " : "+ a);
		}
			
		
		/* do-while문
		 * - do{}while(조건식);
		 * - 최소한 한번의 수행을 보장한다.
		 * 
		 */
		
		
		// 숫자 맞추기 게임
		/*int answer = (int)(Math.random() * 100) + 1; // 1~100까지 중 랜덤한값 생성
		
		int input = 0; //변수 input 선언 및 초기화
		
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("1~100사이의 수를 입력해주세요>");
			input = Integer.parseInt(s.nextLine());
			
			if(answer < input){
				System.out.println(input+"보다 작습니다.");
			}else if(answer > input){
				System.out.println(input + "보다 큽니다.");
			}else{
				System.out.println("정답입니다!!");
			}
			
		}while(input != answer); // 정답을 맞추지 못하는 동안 반복 false면 탈출 
*/		
		
		//이름붙은 반복문 어렵등. , . , .
		outer :  for(int i =2; i <=9; i++){
			for(int j=1; j<=9; j++){
				if( j ==5){
				     //  break; // j가 5일때 가장 가까운 반복문 하나를 빠져나간다.
					//break outer; //outer라는 이름의 반복문을 빠져나간다.
				    //continue; //가장 가까운 반복문의 현재 반복회차를 빠져나간다.
				    //continue outer; //outer라는 이름의 현재 반복회차를 빠져나간다.
				
				}
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println();
		}
		
		/*
		System.out.println("*****");
		System.out.println("*****");
		System.out.println("*****");
	
		for(int i=1; i<=3; i++){
			for(int j = 1; j<=5; j++){
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		
		
		/* 삼각형
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		System.out.println("*****");*/
		
		/*for(int i=1; i<=5; i++){
			for(int j = 1; j<=i; j++){
				System.out.print("*");
			}
			System.out.println();
		}*/
		
		       
	      /*  for(int i=1; i<=5; i++){
			for(int j =5; j>=i; j--){
				System.out.print("*");
			}
			System.out.println();*/
	
			for(int i=5; i>=1; i--){
				for(int j =1; j<=i; j++){
					System.out.print("*");
				}
				System.out.println();
			
	        }
			
		}
		
		
		
		
		
		
}