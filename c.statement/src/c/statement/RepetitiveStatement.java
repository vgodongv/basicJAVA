package c.statement;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/* 
		 * �ݺ���
		 * - for��
		 * - while��
		 * - do -while��
		 * 
		 * for��
		 * - for(�ʱ�ȭ; ���ǽ�; ������){}
		 * - �����ϰ� �ִ� ������� ������ Ƚ����ŭ �ݺ��ϴ� ����
		 * 
		 * 		 
		 */

		for(int i =1; i <= 10; i++){
			// �ʱ�ȭ: ���ǽİ� �����Ŀ� ����� ���� �ʱ�ȭ. �ʱ�ȭ�� ������  �� �ȿ����� ��밡��.
			// ���ǽ�: �������� true�̸� ������ ������ ����
			// ������: ������ ����/���ҽ��� �ݺ����� ����

			System.out.println(i + "��° �ݺ�");		
			
		}
	
		int sum = 0 ; // 1���� 10������ �հ踦 ����
		
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
		
		// 1����~10���� ���ϴ°�.
		
		sum = 0;
		for(int i=10; i>=1; i--){
		sum+=i;	
		}
		System.out.println(sum);
		
		// 10����~1���� ���ϴ°�.
		
		// 1���� 100���� ¦���� ���� ������ּ���.
		sum = 0;

		for(int i=1; i<=100; i++){
			if(i % 2 ==0)
				sum+=i;
		}
		System.out.println(sum);
			
			/*
			 * �Ǵ�
			 * for(int i = 2; i <= 100; i +=2){
				sum=+i;	
			}
			
			*/
			
		// 1���� 100���� Ȧ���� ���� ���
			

//		sum =0 ;
//		for(int i=1; i<=100; i++){
//			if(i % 2 ==1)
//				sum+=i;
//		}
//		System.out.println(sum);
		
	
		/* �Ǵ�
		 
		 for(int i = 1; i <= 100; i +=2){
			sum+=i; }
		 System.out.println(sum);
		 
		 */
		
		// ������ ���
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
		
		/* �Ǵ�
		 *
		for(int i =1; i<=9; i ++){
			System.out.println(2 + "*" + i + "="+i*2);
		}
		
		*/
			
		
		// ������ 9��
		/*for(int i = 1; i<=9; i++){
			sum = 9 * i;
			System.out.println(" 9 * "+ i+"="+sum);
		}*/
			
		
		//2�ܺ��� 9�ܱ��� ���
		/*for(int i =2; i<=9; i++){
			for(int j = 1; j<=9; j++){
				sum = i * j;
				System.out.println(i+ " * "+ j+" = "+sum);
			}
		}
		*/
		// ������ ��ü�� ���η� ���
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
			
		//�ȿ� �ִ� for�� ����Ϸ��� �ٱ� for�������ϴ°� !
		
		
		/* �Ǵ�
		  
		   for(int j=1; j<=9; j++){
		for(int i = 2; i<=9; i++){
			System.out.println(j + " * " + i + "= " + i * j);
		}
		Systemp.out.println();
		
		*/
			
	  /*
	   *  while��
	   *  - while(���ǽ�){}
	   *  - �����ϰ� �ִ� ������� ���ǽ��� �����ϴ� ���� �ݺ��ϴ� ����
	   *  - �ݺ�Ƚ���� ��Ȯ���� ���� ��쿡 �ַ� ����Ѵ�.
	   */
			
		int a = 1;
		// a�� 2�� ���ؼ� 1000�̻��� �Ƿ��� ����� ���ؾ� �ϴ°�? �ݺ�Ƚ���� �𸦶� �ַ� while�� ���
		
		
		int count = 0;
		while(a <1000){
			a *= 2;
		    count++;
		    System.out.println(count + " : "+ a);
		}
			
		
		/* do-while��
		 * - do{}while(���ǽ�);
		 * - �ּ��� �ѹ��� ������ �����Ѵ�.
		 * 
		 */
		
		
		// ���� ���߱� ����
		/*int answer = (int)(Math.random() * 100) + 1; // 1~100���� �� �����Ѱ� ����
		
		int input = 0; //���� input ���� �� �ʱ�ȭ
		
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("1~100������ ���� �Է����ּ���>");
			input = Integer.parseInt(s.nextLine());
			
			if(answer < input){
				System.out.println(input+"���� �۽��ϴ�.");
			}else if(answer > input){
				System.out.println(input + "���� Ů�ϴ�.");
			}else{
				System.out.println("�����Դϴ�!!");
			}
			
		}while(input != answer); // ������ ������ ���ϴ� ���� �ݺ� false�� Ż�� 
*/		
		
		//�̸����� �ݺ��� ��Ƶ�. , . , .
		outer :  for(int i =2; i <=9; i++){
			for(int j=1; j<=9; j++){
				if( j ==5){
				     //  break; // j�� 5�϶� ���� ����� �ݺ��� �ϳ��� ����������.
					//break outer; //outer��� �̸��� �ݺ����� ����������.
				    //continue; //���� ����� �ݺ����� ���� �ݺ�ȸ���� ����������.
				    //continue outer; //outer��� �̸��� ���� �ݺ�ȸ���� ����������.
				
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
		
		
		
		/* �ﰢ��
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