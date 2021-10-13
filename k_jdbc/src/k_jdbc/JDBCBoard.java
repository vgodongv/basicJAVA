package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCBoard {
	public static void main(String[] args) {
		//�Խ��� ���̺��� ����ؼ� �Խ����� ������ּ���.
		new JDBCBoard().start();
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private void start() {
		while(true){
//			���α׷� �����ϸ� ��Ϻ��� ���;���. �����ۼ�
			String sql = "SELECT A.BOARD_NO"
					+ "        , A.TITLE"
					+ "        , B.MEM_NAME AS USER_NAME"  //������̸� ������̺��� ������
					+ "        , TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE" // ��¥�� 'MM/DD' ������������ �ٲ㼭 ������
					+ "     FROM TB_JDBC_BOARD A"
					+ "     LEFT OUTER JOIN MEMBER B ON A.USER_ID = B.MEM_ID"
					// �����̵Ǵ� ���̺�(�Խ���)���� ���� LEFT����
					+ "    ORDER BY A.BOARD_NO DESC";
			
			List<Map<String, Object>> boardList = jdbc.selectList(sql);
			
			System.out.println("==================================");
			System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
			for(Map<String, Object> board : boardList){
				System.out.println("----------------------------------");
				System.out.println(board.get("BOARD_NO")
						+ "\t" + board.get("TITLE")
						+ "\t" + board.get("USER_NAME")
						+ "\t" + board.get("REG_DATE"));
			}
			System.out.println("==================================");
			
			System.out.print("1.��ȸ  2.���  0.����>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("���α׷��� ����Ǿ����ϴ�.");
				System.exit(0);
			}
		}
	}

	private void read() {
		System.out.print("��ȸ�� �Խù� ��ȣ>");
		int boardNo = ScanUtil.nextInt();
		
//		�����ͺ��̽� ���̺��� ��ȣ�� ��ġ�ϴ°� ������ �ۼ�, ��ȸ�ؼ� �ش��ϴ� �Խù� ������
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
		System.out.println("��ȣ\t: " + board.get("BOARD_NO"));
		System.out.println("-------------------------------");
		System.out.println("�ۼ���\t: " + board.get("USER_NAME"));
		System.out.println("-------------------------------");
		System.out.println("�ۼ���\t: " + board.get("REG_DATE"));
		System.out.println("-------------------------------");
		System.out.println("����\t: " + board.get("TITLE"));
		System.out.println("-------------------------------");
		System.out.println("����\t: " + board.get("CONTENT"));
		System.out.println("===============================");
		
		System.out.print("1.����  2.����  0.���>");
		int input = ScanUtil.nextInt();
		switch (input) { //��Խù��� �����ϰ� �������� -> �Խù���ȣ�� �Ķ���ͷ� �Ѱ���
		case 1:
			update(boardNo);
			break;
		case 2:
			delete(boardNo);
			break;
		}
	}

	private void delete(int boardNo) {
		System.out.print("���� �����Ͻðڽ��ϱ�?(Y/N)>");
		if(ScanUtil.nextLine().equals("Y")){
			String sql = "DELETE FROM TB_JDBC_BOARD"
					+ "    WHERE BOARD_NO = ?";
			ArrayList<Object> param = new ArrayList<>();
			param.add(boardNo);
			if(0 < jdbc.update(sql, param)){
				System.out.println("�Խñ��� �����Ǿ����ϴ�.");
			}else{
				System.out.println("�Խñ� ������ �����Ͽ����ϴ�.");
			}
		}
	}

	private void update(int boardNo) {
		System.out.print("����>");
		String title = ScanUtil.nextLine();
		System.out.print("����>");
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
			System.out.println("�Խñ��� �����Ǿ����ϴ�.");
		}else{
			System.out.println("�Խñ� ������ �����Ͽ����ϴ�.");
		}
	}

	private void insert() {
		System.out.print("����>");
		String title = ScanUtil.nextLine();
		System.out.print("����>");
		String content = ScanUtil.nextLine();
		System.out.print("���̵�>");
		String userId = ScanUtil.nextLine();
		
//		�Է¹������� ����ϱ� ���� INSERT �����ۼ�
		String sql = "INSERT INTO TB_JDBC_BOARD"
				+ "   VALUES ("
				+ "          (SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
//				�Խ������̺��� ��ȣ�� MAX��. �����ϳ��������� NULL�̾ƴ� 0�̳������� NVL����ϰ� 1���ͽ����ϱ����� +1
				+ "        , ?"
				+ "        , ?"
				+ "        , ?"
				+ "        , SYSDATE)";  // SYSDATE���� �ڵ����� ���糯¥ INSERT
		
//		INSERT ���� ?�� �� �� �Ѱ��ֱ�
		ArrayList<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(userId);
		if(0 < jdbc.update(sql, param)){//update�޼����� ���ϵǴ� ���� 1�̿��� ����� �ߵȰ��̹Ƿ� �̷��� ������ �������
			System.out.println("�Խñ��� ��ϵǾ����ϴ�.");
		}else{
			System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�.");
		}
	}

}






