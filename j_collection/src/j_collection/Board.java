package j_collection;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {
public static void main(String[] args) {
		
		/*
		 * ArrayList�� HashMap�� ����� �Խ��� ���̺��� �����.
		 * ��ȸ, ���(�۾���), ����, ������ ������ �Խ����� ������ּ���.
		 * 
		 * ��ȣ(pk) ����, ����, �ۼ���, �ۼ���
		 * 
		 * ��Ͽ����� ��ȸ(�Խù� ��ȣ �Է¹ް� ��ȣ, �ۼ���, �ۼ���, ���� , ���� �̸� �˷���), ���, ���� ���
		 * ��ȸ ������ ��ȭ�鿡���� ����(����� ����), ����, ��� ���
		 * 
		 */
	
		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date date1 = new Date();
		
		System.out.println("[�Խ���]");
		System.out.println("====================================");
		System.out.println("��ȣ\t����\t�ۼ���\t����\t�ۼ���");
		System.out.println("====================================");
		HashMap<String, Object> LPROD = new HashMap<String, Object>();
		 String title;
		 String writer;
		 String date;
		 String text;
		 int num=0;
		 ArrayList<HashMap<String, Object>> LP = new ArrayList<HashMap<String, Object>>();
		
		 int input=0;
		 System.out.println("1.��ȸ \t2.��� \t3.����");
			select1: while(true){
				 
					input= ScanUtil.nextInt();
					switch(input){
					case 1:
						int inputt;
						System.out.println("��ȸ�� �� ��ȣ�� �Է����ּ���");
						inputt= ScanUtil.nextInt();
						
						System.out.println("�ۼ���: "+LP.get(inputt-1).get("�ۼ���"));
						System.out.println("����: "+LP.get(inputt-1).get("����"));
						System.out.println("�ۼ���: "+LP.get(inputt-1).get("�ۼ���"));
						System.out.println("����: "+LP.get(inputt-1).get("����"));
						
						String str1="";
						String str2="";
					
						int inputtt = 0;
						act : while(true){
							System.out.println("1.����\t2.����\t3.���");
							inputtt = ScanUtil.nextInt();
							switch (inputtt){
							case 1:
								
								System.out.println("������ ������ �Է����ּ���:");
								str2 =ScanUtil.nextLine();
								LPROD.put("����", str2);
								
								System.out.println("������ ������ �Է����ּ���:");
								str1 =ScanUtil.nextLine();
								LPROD.put("����", str1);
								System.out.println("������ �Ϸ�Ǿ����ϴ�.");

								break;   
							        
								
							case 2:
								
								break;
							case 3:
								break act;
							
							}
				
						}
						System.out.println("1.��ȸ \t2.��� \t3.����");
						break;
						
					case 2:
						  num=0;
						
							 System.out.println("���� �Է�:");
							 title= ScanUtil.nextLine();
					
							 System.out.println("�ۼ��� �Է�:");
							writer= ScanUtil.nextLine();
							
							 System.out.println("���� �Է�:");
							 text = ScanUtil.nextLine();
							 System.out.println();
							
							 LPROD = new HashMap<>();
							 
							LPROD.put("�ۼ���", writer);
							LPROD.put("����", title);
							LPROD.put("����",text);
							LPROD.put("�ۼ���", format.format(date1));
							LPROD.put("��ȣ", num);

							LP.add(LPROD);
							
							System.out.println(LP);
						System.out.println("�ۼ��Ͻ� �Խñ��� ��ϵǾ����ϴ�.");
							System.out.println("====================================");
						
							System.out.println("��ȣ\t����\t�ۼ���\t����\t�ۼ���");
							System.out.println("====================================");
						
						
						
						for(int i=LP.size(); i>= 0; i--){
							num++;
							System.out.print((num)+"\t");
							System.out.print(LP.get(i).get("����"));
							System.out.print("\t"+LP.get(i).get("�ۼ���"));
							System.out.print("\t"+LP.get(i).get("����"));
							System.out.print("\t"+LP.get(i).get("�ۼ���"));
							System.out.println();
							
						    
					        }
						 System.out.println("1.��ȸ \t2.��� \t3.����");
						break ;
					case 3:
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
		
	}
					
			}
			
			
	}
	
	
	

}
