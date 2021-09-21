package c.statement;

import java.util.Scanner;

public class ConditionalStatement {


		public static void main(String[] args) {
			/*
			 * ���ǹ�
			 * - if��
			 * - switch��
			 * 
			 * if��
			 * - if(���ǽ�){} : ���ǽ��� ����� true�̸� ������ ������ �����Ѵ�.
			 * - else if(���ǽ�) {}: �ټ��� ������ �ʿ��� �� if�ڿ� �߰��Ѵ�.
			 * - else{} : ���ǽ� �̿��� ��츦 ���� �߰��Ѵ�.
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
				// ������ true�� �ٷ� ������ �� false�� ���� ���ǹ�����. if���� ������ ���ǹ� �� �ϳ��� ����.
				

				// if�ڿ� ������ �߰��ϰ� ������ else if �����. ���� if�� ��ӿ��� ���ǹ� �Ѵ� �����.
				if (a<10){
					System.out.println("a�� 10���� �۴�.");
				}if(a <20){ //if�� �ƴ� else if�� �ٲ����Ѵ�.
					System.out.println("a�� 20���� �۴�.");
				}

				// ������ 60�̻��̸� �հ� �ƴϸ� ���հ�
				int score = 80;

				if (score<=60){
					System.out.println("���հ�");
				}else if (60<=score){ 
					System.out.println("�հ�");
				}

				/* �Ǵ�
				 * 	 if (score<=60){
				      System.out.println("���հ�");
			         }else { 
			       	System.out.println("�հ�");
			}
				 */

				// ������ ����� �ο��ϴ� ���α׷�
				score = 80;
				String grade = null;
		//�ڹٿ����� null: ������ Ÿ���� �⺻�� - > ������ �ʱ�ȭ���� �ʾƵ� �ڵ����� �ʱ�ȭ��. �̶� �ڵ����� �ʱ�ȭ�Ǵ� ���� �⺻��.
				/*
				 * �⺻��
				 * boolean = false
				 * ������ = 0
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
				// 90�̸����� Ȯ�ξ��ϴ� ���� if(90 <= score && score <=100) grade = "A";�� �̹� false�� ���� ���ǹ����� �Ѿ���̱� ������

				score = 90;
				grade = null;

				//��ø IF��

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
				 * switch��
				 *  - switch(int/StringŸ���� ��){case 1: break;}
				 *  - ���ǽ��� ����� ������ ���ڿ��� (JDK1.7���� ���ڿ� ���) ����Ѵ�.
				 *  - ���ǽİ� ��ġ�ϴ� case�� ������ ������ �����Ѵ�.
				 */


				a = 30;

				switch(a){
				case 10: // a��� ������ 10�ΰ�쿡 ����
					System.out.println("a==10");
					break; // ����ġ ���� ��������

				case 20:
					System.out.println("a==20");
					break;

				default: // if���� else�� ���� ���
					System.out.println("default");

				}

				// �־��� ���� �ش��ϴ� ������ ���
				int month = 10; //1~12;
				String season = null;

				switch(month){
				case 3:
				case 4:
				case 5:
					season = "��";

					break; // ����ġ ���� ��������

				case 6:
				case 7:
				case 8:
					season = "����";

					break;

				case 9:
				case 10:
				case 11:
					season = "����";

					break;

				case 12:
				case 1:
				case 2:
					season = "�ܿ�";

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

			// ���ڸ� �Է¹޾� �� ���ڰ� 0���� 0�̾ƴ��� ���

			Scanner sc = new Scanner(System.in);
			System.out.println("���ڸ� �Է����ּ���>");
			int num = Integer.parseInt(sc.nextLine());
			String result = "0";
			
			switch(num){
			case 0:
				result ="0�̴�";
				break;
				
				default:
				result = "NOT 0";
				break;
			}
			System.out.println(result);
			
			
			// ���ڸ� �Է¹޾� �� ���ڰ� Ȧ������ ¦������
			System.out.println("���ڸ� �Է����ּ����>");
			int num2 = Integer.parseInt(sc.nextLine());
			int result1 = num % 2 ;

			
			switch(result1){
			case 0:
				System.out.println("¦��");
				break;
				
			case 1:
				System.out.println("Ȧ��");
				break;
				
			}
			
			// ���� 3���� �Է¹޾� �հ�, ���, ��տ� ���� ��� ���
			System.out.println("����1�� �Է����ּ����>");
			int score1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("����2�� �Է����ּ����>");
			int score2 = Integer.parseInt(sc.nextLine());
			
			System.out.println("����3�� �Է����ּ����>");
			int score3 = Integer.parseInt(sc.nextLine());
			
			int sum = score1 + score2 + score3;
			double avg = sum / 3.0;
			// �ݿø��� �ϰ������ double avg = Math.round(sum / 3.0 * 10) /10.0;
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
			
			System.out.println("������ �հ��"+sum+"������ �����"+avg+"��տ� ���� �����"+grade);
				
			// 1~100 ������ ������ ���� 3�� �߻���Ű�� ������������  - �����ͺ��� ������ּ���


			int random1 =(int)(Math.random()*100)+1;
		    System.out.println("����1����"+random1);
		    int random2 =(int)(Math.random()*100)+1;
		    System.out.println("����2����"+random2);
		    int random3 =(int)(Math.random()*100)+1;
		    System.out.println("����3����"+random3);
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

		/* ������ �ڵ�
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