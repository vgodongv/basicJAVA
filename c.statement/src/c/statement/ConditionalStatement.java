package c.statement;

import java.util.Scanner;

public class ConditionalStatement {


		public static void main(String[] args) {
			/*
			 * 조건문
			 * - if문
			 * - switch문
			 * 
			 * if문
			 * - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
			 * - else if(조건식) {}: 다수의 조건이 필요할 때 if뒤에 추가한다.
			 * - else{} : 조건식 이외의 경우를 위해 추가한다.
			 * 
			 */

				int a = 4;
				
				if(a == 1){
					System.out.println(" a == 1");
				}else if (a==2){
					System.out.println("a == 2");
				}else if(a==3){
					System.out.println("a == 3");
				}else{
				System.out.println("else");
				}
				// 조건중 true면 바로 실행후 끝 false면 다음 조건문으로. if문은 무조건 조건문 중 하나만 실행.
				

				// if뒤에 조건을 추가하고 싶으면 else if 써야함. 만약 if만 계속오면 조건문 둘다 실행됨.
				if (a<10){
					System.out.println("a가 10보다 작다.");
				}if(a <20){ //if가 아닌 else if로 바꿔써야한다.
					System.out.println("a가 20보다 작다.");
				}

				// 점수가 60이상이면 합격 아니면 불합격
				int score = 80;

				if (score<=60){
					System.out.println("불합격");
				}else if (60<=score){ 
					System.out.println("합격");
				}

				/* 또는
				 * 	 if (score<=60){
				      System.out.println("불합격");
			         }else { 
			       	System.out.println("합격");
			}
				 */

				// 점수에 등급을 부여하는 프로그램
				score = 80;
				String grade = null;
		//자바에서의 null: 참조형 타입의 기본값 - > 변수를 초기화하지 않아도 자동으로 초기화됨. 이때 자동으로 초기화되는 값이 기본값.
				/*
				 * 기본값
				 * boolean = false
				 * 나머지 = 0
				 */
				
				if(90 <= score && score <=100){
					grade = "A";
				}else if(80 <= score ){
					grade = "B";
				}else if(70 <= score){
					grade = "C";
				}else if(60 <= score ){
					grade = "D";
				}else{
					grade = "F";
				}
				System.out.println(grade);
				// 90미만인지 확인안하는 이유 if(90 <= score && score <=100) grade = "A";가 이미 false라 다음 조건문으로 넘어간것이기 때문임

				score = 90;
				grade = null;

				//중첩 IF문

				if(90 <= score && score <=100){
					grade = "A";
					if(97 <= score){
						grade += "+";
					}else if(score <=93){
						grade += "-";
					}
				}

				else if(80 <= score){
					grade = "B";
					if(87<= score){
						grade += "+";
					} else if(score <= 83){
						grade += "-";
					}
				}

				else if(70 <= score){
					grade = "C";
					if(77<= score){
						grade += "+";
					} else if(score <= 73){
						grade += "-";
					}
				}

				else if(60 <= score){
					grade = "D";
					if(67<= score){
						grade += "+";
					} else if(score <= 63){
						grade += "-";
					}
				}else{
					grade = "F";
				}
				System.out.println(grade);


				/*
				 * switch문
				 *  - switch(int/String타입의 값){case 1: break;}
				 *  - 조건식의 결과는 정수와 문자열만 (JDK1.7부터 문자열 허용) 허용한다.
				 *  - 조건식과 일치하는 case문 이후의 문장을 수행한다.
				 */


				a = 30;

				switch(a){
				case 10: // a라는 변수가 10인경우에 실행
					System.out.println("a==10");
					break; // 스위치 문을 빠져나옴

				case 20:
					System.out.println("a==20");
					break;

				default: // if문의 else와 같은 기능
					System.out.println("default");

				}

				// 주어진 월에 해당하는 계절을 출력
				int month = 10; //1~12;
				String season = null;

				switch(month){
				case 3:
				case 4:
				case 5:
					season = "봄";

					break; // 스위치 문을 빠져나옴

				case 6:
				case 7:
				case 8:
					season = "여름";

					break;

				case 9:
				case 10:
				case 11:
					season = "가을";

					break;

				case 12:
				case 1:
				case 2:
					season = "겨울";

					break;
				}

				System.out.println(season);

			score = 90;
			grade = null;
			
			switch(score / 10){
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			case 5:
				grade = "E";
				break;
				
			default:
				grade = "F";
				break;
			}

			System.out.println(grade);

			// 숫자를 입력받아 그 숫자가 0인지 0이아닌지 출력

			Scanner sc = new Scanner(System.in);
			System.out.println("숫자를 입력해주세요>");
			int num = Integer.parseInt(sc.nextLine());
			String result = "0";
			
			switch(num){
			case 0:
				result ="0이다";
				break;
				
				default:
				result = "NOT 0";
				break;
			}
			System.out.println(result);
			
			
			// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지
			System.out.println("숫자를 입력해주세요옹>");
			int num2 = Integer.parseInt(sc.nextLine());
			int result1 = num % 2 ;

			
			switch(result1){
			case 0:
				System.out.println("짝수");
				break;
				
			case 1:
				System.out.println("홀수");
				break;
				
			}
			
			// 점수 3개를 입력받아 합계, 평균, 평균에 대한 등급 출력
			System.out.println("점수1을 입력해주세요옹>");
			int score1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("점수2을 입력해주세요옹>");
			int score2 = Integer.parseInt(sc.nextLine());
			
			System.out.println("점수3을 입력해주세요옹>");
			int score3 = Integer.parseInt(sc.nextLine());
			
			int sum = score1 + score2 + score3;
			double avg = sum / 3.0;
			// 반올림이 하고싶으면 double avg = Math.round(sum / 3.0 * 10) /10.0;
			if(avg<= 90 && avg>=100){
				grade = "A";}
				else if(80<=avg)
				{
					grade="B";
							
				}else if(70<=avg){
					grade = "C";
				}else if(60<=avg){
					grade = "D";
					
				}else{
					grade = "F";
				}
			
			System.out.println("점수의 합계는"+sum+"점수의 평균은"+avg+"평균에 대한 등급은"+grade);
				
			// 1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로  - 작은것부터 출력해주세요


			int random1 =(int)(Math.random()*100)+1;
		    System.out.println("랜덤1값은"+random1);
		    int random2 =(int)(Math.random()*100)+1;
		    System.out.println("랜덤2값은"+random2);
		    int random3 =(int)(Math.random()*100)+1;
		    System.out.println("랜덤3값은"+random3);
		int aa=0;
		int bb=0;
		int cc=0;


		if (random1 < random2 && random1 < random3) {
			 aa= random1;
			 if(random2<random3){
				 bb= random2;
				 cc= random3;
			 }else if(random3<random2){
				 bb = random3;
				 cc =  random2;
			 }
		}

		else if( random2< random1 && random2< random3){
			aa= random2;
			 if(random1<random3){
				 bb= random1;
				 cc= random3;
			 }else if(random3<random1){
				 bb = random3;
				 cc= random1;
			 }   
		}

		else if( random3 < random2 && random3 < random1){
			aa =random3;
			 if(random1<random2){
				 bb= random1;
				 cc=random2;
			 }else if(random2<random1){
				 bb = random2;
				 cc= random1;
			 }
		}

		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);

		/* 쓰엥님 코드
		 * 
		 *  if(random > random2){
		   int temp = random1;
		   random1= random2;
		   random2 = temp;
			}
			
			if(random1 >  randpm3){
				int temp = random1;
				random1= random3;
				random3 = temp;
			}
			if(random2>randpm3){
				int temp =  random2;
				random2 = random3;
				random3 = temp;
			}
			 Systemp.out.println(random1 + " <" + random2 + "<"+ radom3);
		*/
		}
		}