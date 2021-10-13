package j_collection;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;


public class Board {
public static void main(String[] args) {
		
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고.
		 * 조회, 등록(글쓰기), 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(pk) 제목, 내용, 작성자, 작성일
		 * 
		 * 목록에서는 조회(게시물 번호 입력받고 번호, 작성자, 작성일, 제목 , 내용 이름 알려줌), 등록, 종료 기능
		 * 조회 눌러서 상세화면에서는 수정(제목과 내용), 삭제, 목록 기능
		 * 
		 */
	
		
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		Date date1 = new Date();
		
		System.out.println("[게시판]");
		System.out.println("====================================");
		System.out.println("번호\t제목\t작성자\t내용\t작성일");
		System.out.println("====================================");
		HashMap<String, Object> LPROD = new HashMap<String, Object>();
		 String title;
		 String writer;
		 String date;
		 String text;
		 int num=0;
		 ArrayList<HashMap<String, Object>> LP = new ArrayList<HashMap<String, Object>>();
		
		 int input=0;
		 System.out.println("1.조회 \t2.등록 \t3.종료");
			select1: while(true){
				 
					input= ScanUtil.nextInt();
					switch(input){
					case 1:
						int inputt;
						System.out.println("조회할 글 번호를 입력해주세요");
						inputt= ScanUtil.nextInt();
						
						System.out.println("작성일: "+LP.get(inputt-1).get("작성일"));
						System.out.println("제목: "+LP.get(inputt-1).get("제목"));
						System.out.println("작성자: "+LP.get(inputt-1).get("작성자"));
						System.out.println("내용: "+LP.get(inputt-1).get("내용"));
						
						String str1="";
						String str2="";
					
						int inputtt = 0;
						act : while(true){
							System.out.println("1.수정\t2.삭제\t3.목록");
							inputtt = ScanUtil.nextInt();
							switch (inputtt){
							case 1:
								
								System.out.println("변경할 제목을 입력해주세요:");
								str2 =ScanUtil.nextLine();
								LPROD.put("제목", str2);
								
								System.out.println("변경할 내용을 입력해주세요:");
								str1 =ScanUtil.nextLine();
								LPROD.put("내용", str1);
								System.out.println("변경이 완료되었습니다.");

								break;   
							        
								
							case 2:
								
								break;
							case 3:
								break act;
							
							}
				
						}
						System.out.println("1.조회 \t2.등록 \t3.종료");
						break;
						
					case 2:
						  num=0;
						
							 System.out.println("제목 입력:");
							 title= ScanUtil.nextLine();
					
							 System.out.println("작성자 입력:");
							writer= ScanUtil.nextLine();
							
							 System.out.println("내용 입력:");
							 text = ScanUtil.nextLine();
							 System.out.println();
							
							 LPROD = new HashMap<>();
							 
							LPROD.put("작성자", writer);
							LPROD.put("제목", title);
							LPROD.put("내용",text);
							LPROD.put("작성일", format.format(date1));
							LPROD.put("번호", num);

							LP.add(LPROD);
							
							System.out.println(LP);
						System.out.println("작성하신 게시글이 등록되었습니다.");
							System.out.println("====================================");
						
							System.out.println("번호\t제목\t작성자\t내용\t작성일");
							System.out.println("====================================");
						
						
						
						for(int i=LP.size(); i>= 0; i--){
							num++;
							System.out.print((num)+"\t");
							System.out.print(LP.get(i).get("제목"));
							System.out.print("\t"+LP.get(i).get("작성자"));
							System.out.print("\t"+LP.get(i).get("내용"));
							System.out.print("\t"+LP.get(i).get("작성일"));
							System.out.println();
							
						    
					        }
						 System.out.println("1.조회 \t2.등록 \t3.종료");
						break ;
					case 3:
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
		
	}
					
			}
			
			
	}
	
	
	

}
