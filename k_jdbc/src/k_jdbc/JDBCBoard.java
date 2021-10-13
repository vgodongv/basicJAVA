package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCBoard {
	public static void main(String[] args) {
		//게시판 테이블을 사용해서 게시판을 만들어주세요.
		new JDBCBoard().start();
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private void start() {
		while(true){
//			프로그램 시작하면 목록부터 나와야함. 쿼리작성
			String sql = "SELECT A.BOARD_NO"
					+ "        , A.TITLE"
					+ "        , B.MEM_NAME AS USER_NAME"  //사용자이름 멤버테이블에서 가져옴
					+ "        , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE" // 날짜는 'MM/DD' 문자형식으로 바꿔서 가져옴
					+ "     FROM TB_JDBC_BOARD A"
					+ "     LEFT OUTER JOIN MEMBER B ON A.USER_ID = B.MEM_ID"
					// 메인이되는 테이블(게시판)먼저 적고 LEFT조인
					+ "    ORDER BY A.BOARD_NO DESC";
			
			List<Map<String, Object>> boardList = jdbc.selectList(sql);
			
			System.out.println("==================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			for(Map<String, Object> board : boardList){
				System.out.println("----------------------------------");
				System.out.println(board.get("BOARD_NO")
						+ "\t" + board.get("TITLE")
						+ "\t" + board.get("USER_NAME")
						+ "\t" + board.get("REG_DATE"));
			}
			System.out.println("==================================");
			
			System.out.print("1.조회  2.등록  0.종료>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	private void read() {
		System.out.print("조회할 게시물 번호>");
		int boardNo = ScanUtil.nextInt();
		
//		데이터베이스 테이블에서 번호가 일치하는걸 쿼리로 작성, 조회해서 해당하는 게시물 가져옴
		String sql = "SELECT A.BOARD_NO"
				+ "        , A.TITLE"
				+ "        , A.CONTENT"
				+ "        , B.MEM_NAME AS USER_NAME"
				+ "        , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "     FROM TB_JDBC_BOARD A"
				+ "     LEFT OUTER JOIN MEMBER B ON A.USER_ID = B.MEM_ID" 
				+ "    WHERE A.BOARD_NO = ?";
		ArrayList<Object> param = new ArrayList<>();
		param.add(boardNo);
		Map<String, Object> board = jdbc.selectOne(sql, param);
		System.out.println("===============================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("-------------------------------");
		System.out.println("작성자\t: " + board.get("USER_NAME"));
		System.out.println("-------------------------------");
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("-------------------------------");
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("-------------------------------");
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("===============================");
		
		System.out.print("1.수정  2.삭제  0.목록>");
		int input = ScanUtil.nextInt();
		switch (input) { //어떤게시물을 삭제하고 수정할지 -> 게시물번호를 파라미터로 넘겨줌
		case 1:
			update(boardNo);
			break;
		case 2:
			delete(boardNo);
			break;
		}
	}

	private void delete(int boardNo) {
		System.out.print("정말 삭제하시겠습니까?(Y/N)>");
		if(ScanUtil.nextLine().equals("Y")){
			String sql = "DELETE FROM TB_JDBC_BOARD"
					+ "    WHERE BOARD_NO = ?";
			ArrayList<Object> param = new ArrayList<>();
			param.add(boardNo);
			if(0 < jdbc.update(sql, param)){
				System.out.println("게시글이 삭제되었습니다.");
			}else{
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
		}
	}

	private void update(int boardNo) {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		String sql = "UPDATE TB_JDBC_BOARD"
				+ "      SET TITLE = ?"
				+ "        , CONTENT = ?"
				+ "    WHERE BOARD_NO = ?";
		ArrayList<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		if(0 < jdbc.update(sql, param)){
			System.out.println("게시글이 수정되었습니다.");
		}else{
			System.out.println("게시글 수정에 실패하였습니다.");
		}
	}

	private void insert() {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("아이디>");
		String userId = ScanUtil.nextLine();
		
//		입력받은것을 등록하기 위해 INSERT 쿼리작성
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "   VALUES ("
				+ "          (SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
//				게시판테이블에서 번호의 MAX값. 글이하나도없으면 NULL이아닌 0이나오도록 NVL사용하고 1부터시작하기위해 +1
				+ "        , ?"
				+ "        , ?"
				+ "        , ?"
				+ "        , SYSDATE)";  // SYSDATE쓰면 자동으로 현재날짜 INSERT
		
//		INSERT 쿼리 ?에 들어갈 값 넘겨주기
		ArrayList<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(userId);
		if(0 < jdbc.update(sql, param)){//update메서드의 리턴되는 값이 1이여야 등록이 잘된것이므로 이렇게 조건을 만들어줌
			System.out.println("게시글이 등록되었습니다.");
		}else{
			System.out.println("게시글 등록에 실패하였습니다.");
		}
	}

}






