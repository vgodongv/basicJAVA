package i_api;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		// ���ڸ� �Է¹޾� �Է¹��� ���ڿ� 3�ڸ� ���� �޸�(,)�� �ٿ� ������ּ���
				// 123,456,789 
				
				System.out.println("���ڸ� �Է����ּ���");
				Scanner sc = new Scanner(System.in);
				String number = sc.nextLine();
				String number2="";
				
				int count =0;
				for(int i = number.length()-1; i>=0; i--){
					// ���ڸ� �Է¹ް� �ڿ������� ���ڸ�������. 
					number2 = number.charAt(i) + number2;
					count ++;
					if(count % 3 == 0 && count != number.length()){
						number2 = ","+ number2;
					}
					
				}
					System.out.println(number2);
				
			}

		}
