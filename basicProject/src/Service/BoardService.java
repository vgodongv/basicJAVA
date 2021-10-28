package Service;

public class BoardService {
	 private BoardService() {
	   }

	   private static BoardService instance;

	   public static BoardService getInstance() {
	      if (instance == null) {
	         instance = new BoardService();
	      }
	      return instance;
	   }

	   BoardDao boardDao = BoardDao.getInstance();
	   
	   //ȸ��Ż��
	   public int outmember() { //�߰�
		      System.out.println("ȸ��Ż�� �����Ͻðڽ��ϱ�?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.memberout(Controller.loginUser.get("MEM_ID"),Controller.loginUser.get("MEM_TYPE"));
		         
		         if(result>=2){
		            System.out.println("ȸ��Ż�� ���������� �̷�������ϴ�");
		            return View.HOME;
		         }else{
		            System.out.println("ȸ��Ż�� �����Ͽ����ϴ�");         
		         }
		      }
		      return View.MYINFO;
		   }
	   
	   //����ȸ�� �޴�
	   public static int albaMenu() {
	      System.out
	            .println("1.�̷¼��ۼ� 2.ä����� 3.�ı�Խ��� 4.�����Խ��� 5.���ֹ��� ����  6.���������� 7.�α׾ƿ�");
	      int input = ScanUtil.nextInt();
	      switch (input) {
	      case 1:
	         return View.WRITERSM;
	      case 2:
	         return View.BOARDREC;
	      case 3:
	         return View.BOARDREVIEW;
	      case 4:
	         return View.BOARDNOTE;
	      case 5:
	         return View.BOARDQNA;
	      case 6:
	         return View.MYPAGE;
	      }
	      return View.LOGOUT;
	   }
	   //���ȸ�� �޴�-����
	   public static int comMenu() {

	      System.out.println("1.ä������ۼ� 2.ä������ 3.�������� 4.�ı�Խ��� 5.�����Խ��� 6.���ֹ��� ����  7.���������� 8.�α׾ƿ�");
	      int input = ScanUtil.nextInt();
	      switch (input) {
	      case 1:
	         return View.WRITEREC;
	      case 2:
	    	  return View.BOARDREC;
	      case 3:
	    	  return View.BOARDRSM;
	      case 4:	  
	         return View.BOARDREVIEW;
	      case 5:
	         return View.BOARDNOTE;
	      case 6:
	         return View.BOARDQNA;
	      case 7:
	         return View.MYPAGE;
	      }
	      return View.LOGOUT;
	   }
	   //������ �޴�
	   public static int managerMenu() {
	      System.out
	            .println("1.�������� 2.�ı�Խ��� 3.�����Խ��� 4.ä����� 5.ȸ������ 6.���ֹ��� ���� 7.1:1��� 8.�α׾ƿ�");
	      int input = ScanUtil.nextInt();
	      switch (input) {
	      case 1:return View.BOARDRSM;
	      case 2:
	         return View.BOARDREVIEW;
	      case 3:
	         return View.BOARDNOTE;
	      case 4:
	    	  return View.BOARDREC;
	      case 5:
	         return View.MEMINFO;
	      case 6:
	         return View.BOARDQNA;
	      case 7:
	         return View.BOARDINQ;
	      }
	      return View.LOGOUT;
	   }

	   static int number = 0;

	   //�ı���
	   public int boardreview() { // �ı�Խ���
	      List<Map<String, Object>> boardlist = boardDao.getReboard();
	      System.out.println("==========================================");
	      System.out.println("��ȣ\t����\t�ۼ���\t�����");
	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------");
	         System.out.println(board.get("REVIEW_NO") + "\t"
	               + board.get("REVIEW_TITLE") + "\t"
	               + board.get("ALBA_NAME")
	               + "\t" + board.get("REVIEW_REG"));
	      }
	      System.out.println("=====================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("2")) { // �˹��̸�
	         System.out.println("1.��ȸ 2.�ı��ۼ� 0.�޴��� ���ư��� ");
	      }

	      else if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            || Controller.loginUser.get("MEM_TYPE").equals("1")) {// ���.�Ŵ�����
	         System.out.println("1.��ȸ  0.�޴���");
	      }

	      int input = ScanUtil.nextInt();
	      switch (input) {
	      case 1:
	         return View.GETREVIEW;
	      case 2:
	         return View.WRITEREVIEW;

	      }

	      return View.MAINMENU;

	   }
	   // �ı� ��ȸ
	   public int getreview() { 
	      System.out.print("��ȸ�Ͻ� �� ��ȣ�� �����ϼ���: ");
	      number = ScanUtil.nextInt();
	      Map<String, Object> board = boardDao.getre(number);

	      System.out.println("----------------------------------");
	      System.out.println("��ȣ : \t" + board.get("REVIEW_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("REVIEW_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("REVIEW_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("�ۼ��� : \t" + board.get("ALBA_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("�����: \t" + board.get("REVIEW_REG"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("2")
	            && Controller.loginUser.get("MEM_ID").equals(
	                  board.get("MEM_ID"))) {// �˹� ������ȸ

	         System.out.println("1.���� 2.���� 3.������� ���ư���");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.EDITREVIEW;
	         case 2:
	            return View.DELREVIEW;

	         }
	      }

	      else if (Controller.loginUser.get("MEM_TYPE").equals("3")) { // �Ŵ��� ������ȸ
	         System.out.println("1.����2.������� ���ư���");
	         if (ScanUtil.nextInt() == 1) {
	            return View.DELREVIEW;
	         }
	      }
	      // ���&�� �۾ƴ� �˹�
	      System.out.println("������� ���ư��ðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         return View.BOARDREVIEW;

	      }

	      return View.GETREVIEW;
	   }
	   // �ı��ۼ�
	   public int writereview() { 
	      System.out.println("=============�˹� �ı� �ۼ�==============");
	      System.out.print("����: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("����: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.writere(title, content,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("�Խñ��� ��ϵǾ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�");
	      }
	      return View.BOARDREVIEW;
	   }
	   // �ı� ����
	   public int editreview() { 
	      System.out.print("����: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("����: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.reagain(title, content, number);
	      if (result > 0) {
	         System.out.println("�Խñ��� �����Ǿ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ������ �����Ͽ����ϴ�");
	      }
	      return View.BOARDREVIEW;

	   }
	   // �ı� ����
	   public int delreview() { 
	      System.out.println("���� �Խù��� �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.redelete(number);
	         if (result > 0) {
	            System.out.println("�Խù��� �����Ͽ����ϴ�");
	         } else {
	            System.out.println("�Խù� ������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.BOARDREVIEW;

	   }
	   //����������
	   public int mypage() {
	      if (Controller.loginUser.get("MEM_TYPE").equals("2")) {//����ȸ��
	         System.out
	               .println("1.�� �̷¼� 2.�������� ���� 3.���� ���� ���� 4.1:1���� 5.���θ޴��� ���ư���");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.MYRSM;
	         case 2:
	            return View.MYINFO;
	         case 3:
	            return View.BOARDLIKEREC;
	         case 4:
	            return View.BOARDINQ;
	         }
	      } else {//���ȸ�� Ȥ�� ������-����
	         System.out
	               .println("1.���� ä����� 2.������ �� ������ Ȯ�� 3.�����̷¼� ��ȸ 4.������������ 5.1:1���Խ��� 6.���θ޴� ���ư���");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.MYREC;
	         case 2: return View.CHECKAPPLY;
	         case 3:
	        	 return View.BOARDLIKERSM; 
	         case 4:
	            return View.MYINFO;
	         case 5:
	            return View.BOARDINQ;

	         }
	      }
	      return View.MAINMENU;
	   }
	   //�̷¼� ���
	   public int boardrsm() { //�߰�
		      System.out.println("===============���� ����==============");
		      System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
		       List<Map<String, Object>> boardlist=boardDao.rsmboard();
		       for(Map<String, Object>board:boardlist){
		          System.out.println("--------------------------------------------------");
		          System.out.println(board.get("RESUME_NO")+"\t"+board.get("RESUME_TITLE")+"\t"+board.get("ALBA_NAME")+"\t"+board.get("RESUME_DATE"));
		       }
		       System.out.println("========================================");
		       System.out.println("1.��ȸ  2.�з�����ȸ  3.���θ޴��� ���ư���");
		       int input = ScanUtil.nextInt();
		       switch (input) {
		       case 1:
		    	   return View.GETRSM;
		       case 2:
		    	   return View.RSMFILTER;

		       }
		       return View.MAINMENU;
		     }
		     
	   //�̷¼� ����
	   public int resumefilter() {
	       System.out.println("�з��� ��ȸ�� ���� �׸��� ����ּ���.");
	        System.out.println("1.������ ��ȸ 2.���� ��ȸ 3.��뺰 ��ȸ 4.�޴��� ���ư��� ");
	     
	        switch (ScanUtil.nextInt()) {
	        case 1:
	           return View.RSMFILTER_ADDR;
	        case 2:
	           return View.RSMFILTER_GEN;
	        case 3:
	           return View.RSMFILTER_PRE;
	        }
	        return View.BOARDRSM;
	  }
	    //�̷¼� ���͸�-������
	    public int rsmfilteraddr() {
	       System.out.println("[���� �з�]\n����\t���\t��õ\t����\t�泲\t����\n"
	             + "���\t�λ�\t���\t�뱸\t���\t�泲\n"
	             + "����\t����\t����\t����");
	       System.out.println("������ �Է��ϼ���. ex)����\n: ");
	       String region = ScanUtil.nextLine();
	       List<Map<String, Object>> boardlist = boardDao.rsmfilteraddr(region);
	       System.out.println("==========================================");
	       System.out.println("��ȣ\t����\t�ۼ��ڸ�\t�����");
	       for (Map<String, Object> board : boardlist) {
	          System.out.println("----------------------------------");
	          System.out.println(board.get("RESUME_NO") + "\t"
	                + board.get("RESUME_TITLE") + "\t"
	                + board.get("ALBA_NAME") + "\t" 
	                + board.get("RESUME_DATE"));
	       }
	       System.out.println("=====================================");

	       System.out.println("1.��ȸ 2. ��ü �̷¼� ������� ���ư��� ");
	       if(ScanUtil.nextInt()==1){
	          return View.GETRSM;
	       }
	  
	       return View.BOARDRSM;
	    }
	    //�̷¼����͸�-����
	  	public int rsmfiltergen() {
	  	    System.out.println("��ȸ�� ������ �Է��ϼ���.(��or��):");
	        String gender = ScanUtil.nextLine();
	        List<Map<String, Object>> boardlist = boardDao.rsmfiltergen(gender);
	        System.out.println("==========================================");
	        System.out.println("��ȣ\t����\t�ۼ��ڸ�\t�����");
	        for (Map<String, Object> board : boardlist) {
	           System.out.println("----------------------------------");
	           System.out.println(board.get("RESUME_NO") + "\t"
	                 + board.get("RESUME_TITLE") + "\t"
	                 + board.get("ALBA_NAME") + "\t" 
	                 + board.get("RESUME_DATE"));
	        }
	        System.out.println("=====================================");

	        System.out.println("1.��ȸ 2. ��ü �̷¼� ������� ���ư��� ");
	        if(ScanUtil.nextInt()==1){
	           return View.GETRSM;
	        }
	   
	        return View.BOARDRSM;
	     }
	    //�̷¼� ���͸�-������Ǻ�
	  	public int rsmfilterpre() {
	  		System.out.println("[������� �з�]\n���л�:13\t���:14\t�����:15\tû�ҳ�:16\t�ֺ�:17");
	  	       System.out.println("������ǹ�ȣ�� �Է��ϼ���:");
	  	       int prefer  = ScanUtil.nextInt();
	  	       List<Map<String, Object>> boardlist = boardDao.rsmfilterpre(prefer);
	  	       System.out.println("==========================================");
	  	       System.out.println("��ȣ\t����\t�ۼ��ڸ�\t�����");
	  	       for (Map<String, Object> board : boardlist) {
	  	          System.out.println("----------------------------------");
	  	          System.out.println(board.get("RESUME_NO") + "\t"
	  	                + board.get("RESUME_TITLE") + "\t"
	  	                + board.get("ALBA_NAME") + "\t" 
	  	                + board.get("RESUME_DATE"));
	  	       }
	  	       System.out.println("=====================================");

	  	       System.out.println("1.��ȸ 2. ��ü �̷¼� ������� ���ư��� ");
	  	       if(ScanUtil.nextInt()==1){
	  	          return View.GETRSM;
	  	       }
	  	  
	  	       return View.BOARDRSM;
	  	} 
	    
	    
	   
	   //�����̷¼� ���
	   static List<Map<String, Object>> list = null;

	   public int myrsm() {
	      list = boardDao.myResume(Controller.loginUser.get("MEM_ID"));
	      int count = 1;
	      for (int i = 0; i < list.size(); i++) {
	         list.get(i).put("RESUME_NUM", count);
	         count++;
	      }
	      System.out.println("==================���� �̷¼�================");
	      System.out.println("��ȣ\t����\t�ۼ���");
	      for (Map<String, Object> map : list) {
	         System.out.println("------------------------------------------");
	         System.out.println(map.get("RESUME_NUM") + "\t"
	               + map.get("RESUME_TITLE") + "\t" + map.get("RESUME_DATE"));
	      }
	      System.out.println("=========================================");
	      System.out.println("1.��ȸ 2.���� �޴��� ���ư���");
	      if (ScanUtil.nextInt() == 1) {
	         return View.GETMYRSM;
	      }
	      return View.MAINMENU;

	   }
	   //�ۼ� �̷¼� ���
	   static int getrsmnum=0;
	   public int getrsm() {//�߰�
	      System.out.print("��ȸ�� �� ��ȣ�� �����ϼ���: ");
	      getrsmnum=ScanUtil.nextInt();
	      Map<String, Object>map=boardDao.rsmget(getrsmnum);
	      System.out.println("=====================================================");
	      System.out.println("��ȣ:\t"+map.get("RESUME_NO"));
	      System.out.println("����:\t"+map.get("RESUME_TITLE"));
	      System.out.println("����:\t"+map.get("RESUME_CON"));
	      System.out.println("�������:\t"+map.get("JOB_NAME"));
	      System.out.println("�ۼ���:\t"+map.get("RESUME_DATE"));
	      System.out.println("=====================================================");
	      
	      if(Controller.loginUser.get("MEM_TYPE").equals("1")){
	         System.out.println("1.�����̷¼� ��� 2.������� ���ư���");
	         if(ScanUtil.nextInt()==1){
	            return View.LIKERSM;
	         }
	      }else{
	         System.out.println("1.�̷¼� �����ϱ� 2.������� ���ư���");
	         if(ScanUtil.nextInt()==1){
	            return View.DELLIKERSM;
	         }
	      }
	      
	      return View.BOARDRSM;
	   }
	   
	 //�̷¼� �ۼ�
	   public int writersm() {
	      System.out.println("===================�̷¼�===================");
	      System.out.print("�̷¼� ����: ");
	      String title = ScanUtil.nextLine();
	      System.out.println("�̷¼� ����: ");
	      String content = ScanUtil.nextLine();
	      System.out.println("���л�:13\t���:14\t�����:15\tû�ҳ�:16\t�ֺ�:17");
	      System.out.print("������ :");
	      String jobCode = ScanUtil.nextLine();
	      int result = boardDao.rsmwrite(title, content, jobCode,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("�̷¼� �ۼ��� �Ϸ��Ͽ����ϴ�");
	      } else {
	         System.out.println("�̷¼� �ۼ��� �����Ͽ����ϴ�");
	      }
	      return View.MAINMENU;
	   }
	   
	   public int likersm() { //�߰�
		      System.out.println("�ش� �̷¼��� ���ɸ�Ͽ� �߰��Ͻðڽ��ϱ�?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.rsmlike(getrsmnum,Controller.loginUser.get("MEM_ID"));
		         if(result>0){
		            System.out.println("���� �̷¼� ��Ͽ� �߰��Ͽ����ϴ�");
		         }else{
		            System.out.println("���� �̷¼� �߰��� �����Ͽ����ϴ�");
		         }
		         return View.BOARDRSM;
		      }
		         
		      return View.BOARDRSM;
		   }

		   public int dellikersm() { //�߰�
		      System.out.println("�ش� �̷¼��� ���� ���� ��Ͽ��� �����Ͻðڽ��ϱ�?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.likersmdel(dellikenum);
		         if(result>0){
		            System.out.println("���� ���� ��Ͽ��� �����Ͽ����ϴ�");
		         }else{
		            System.out.println("������ �����Ͽ����ϴ�");
		         }
		      }
		      
		      return View.BOARDLIKERSM;
		   }
		   
		   List<Map<String, Object>> likersmlist=null;
		   static Object dellikenum=0;
		   public int boardlikersm() { //�߰�
		      System.out.println("=====================���� ���� �̷¼�==================");
		      System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
		      likersmlist=boardDao.likersmboard(Controller.loginUser.get("MEM_ID"));
		      int count=1;
		      for(int i=0;i<likersmlist.size();i++){
		         likersmlist.get(i).put(("LIKERSMNUM"),count);
		         count++;
		      }
		      
		      for(Map<String, Object>board:likersmlist){
		         System.out.println("----------------------------------------------------");
		         System.out.println(board.get("LIKERSMNUM")+"\t"+board.get("RESUME_TITLE")+"\t"+board.get("ALBA_NAME")+"\t"+board.get("RESUME_DATE"));      
		      }
		      System.out.println("======================================================");
		      System.out.println("1.����ȸ 2.������������ ���ư���");
		      if(ScanUtil.nextInt()==1){
		         return View.GETLIKERSM;
		      }
		      return View.MYPAGE;
		   }

		   public int getlikersm() {  //�߰�
		      System.out.print("��ȸ�� �̷¼��� �����ϼ���: ");
		      int number=ScanUtil.nextInt();
		      System.out.println("=================================================");
		      for(int i=0;i<likersmlist.size();i++){
		         if(likersmlist.get(i).get("LIKERSMNUM").equals(number)){
		            System.out.println("��ȣ:\t"+likersmlist.get(i).get("LIKERSMNUM"));
		            System.out.println("����:\t"+likersmlist.get(i).get("RESUME_TITLE"));
		            System.out.println("����:\t"+likersmlist.get(i).get("RESUME_CON"));
		            System.out.println("�ۼ���:\t"+likersmlist.get(i).get("ALBA_NAME"));
		            System.out.println("�������:\t"+likersmlist.get(i).get("JOB_NAME"));
		            System.out.println("�ۼ���:\t"+likersmlist.get(i).get("RESUME_DATE"));
		            dellikenum=likersmlist.get(i).get("RESUME_NO");
		         }
		      }
		      System.out.println("=================================================");
		      System.out.println("1.���� 2.�ڷ� ���ư���");
		      if(ScanUtil.nextInt()==1){
		         return View.DELLIKERSM;
		      }
		      
		      return View.BOARDLIKERSM;
		   }
		
		   //����
		   public int applyrec() { 
		      
		      System.out.println("�ش���� �����Ͻðڽ��ϱ�?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         list = boardDao.myResume(Controller.loginUser.get("MEM_ID"));
		         int count = 1;
		         for (int i = 0; i < list.size(); i++) {
		            list.get(i).put("RESUME_NUM", count);
		            count++;
		         }
		         System.out.println("==================���� �̷¼�================");
		         System.out.println("��ȣ\t����\t�ۼ���");
		         for (Map<String, Object> map : list) {
		            System.out.println("------------------------------------------");
		            System.out.println(map.get("RESUME_NUM") + "\t"
		                  + map.get("RESUME_TITLE") + "\t" + map.get("RESUME_DATE"));
		         }
		         System.out.println("=========================================");
		         Object resumeno=0;
		         System.out.print("������ �̷¼��� �����ϼ���: ");
		         int rsmnum=ScanUtil.nextInt();
		         for(int i=0;i<list.size();i++){
		            if(list.get(i).get("RESUME_NUM").equals(rsmnum)){
		               resumeno=list.get(i).get("RESUME_NO");
		            }
		         }
		      
		         int result=boardDao.recapply(resumeno,go);
		         if(result>0){
		            System.out.println("������ �Ϸ��Ͽ����ϴ�");
		         }else{
		            System.out.println("������ �����Ͽ����ϴ�");
		         }
		         
		      }
		      return View.BOARDREC;
		   }
		   //���� Ȯ��(���ȸ��)
		   List<Map<String, Object>>applylist=null;
		   public int checkapply() {
		      System.out.println("==============���� �� �̷¼�============");
		      System.out.println("��ȣ\t����\t�ۼ���\t��������");
		      applylist=boardDao.applycheck(Controller.loginUser.get("MEM_ID"));      
		      int count=1;
		      for(int i=0;i<applylist.size();i++){
		         applylist.get(i).put("APPLYNUM",count);
		         count++;
		      }
		      
		      for(Map<String, Object>board:applylist){
		         System.out.println("----------------------------------------------------");
		         System.out.println(board.get("APPLYNUM")+"\t"+board.get("RESUME_TITLE")+"\t"+board.get("ALBA_NAME")+"\t"+board.get("RECRUIT_TITLE"));      
		      }
		      System.out.println("----------------------------------------------------");
		      System.out.println("1.����ȸ 2.������������ ���ư��� ");
		      if(ScanUtil.nextInt()==1){
		         return View.GETAPPLY;
		      }
		      return View.MYPAGE;
		   }
		   
		   //���� Ȯ��-�̷¼� ����ȸ
		   static Object applynum=0;
		   static Object recruitnum=0;
		   public int getapply() {
		      System.out.print("��ȸ�� �̷¼� ��ȣ ����: ");
		      int number=ScanUtil.nextInt();
		      for(int i=0;i<applylist.size();i++){
		         if(applylist.get(i).get("APPLYNUM").equals(number)){
		            System.out.println("----------------------------------------");
		            System.out.println("��ȣ:\t"+applylist.get(i).get("APPLYNUM"));
		            System.out.println("----------------------------------------");
		            System.out.println("����:\t"+applylist.get(i).get("RESUME_TITLE"));
		            System.out.println("----------------------------------------");
		            System.out.println("����:\t"+applylist.get(i).get("RESUME_CON"));
		            System.out.println("----------------------------------------");
		            System.out.println("�ۼ���:\t"+applylist.get(i).get("ALBA_NAME"));
		            System.out.println("----------------------------------------");
		            System.out.println("������:\t"+applylist.get(i).get("JOB_NAME"));
		            System.out.println("----------------------------------------");
		            System.out.println("�ۼ���:\t"+applylist.get(i).get("RESUME_DATE"));
		            System.out.println("----------------------------------------");
		            System.out.println("��������:\t"+applylist.get(i).get("RECRUIT_TITLE"));
		            System.out.println("----------------------------------------");
		            applynum=applylist.get(i).get("RESUME_NO");
		            recruitnum=applylist.get(i).get("RECRUIT_NO");
		         }
		      }
		         System.out.println("1.���� 2.������� ���ư���");
		         if(ScanUtil.nextInt()==1){
		            return View.DELAPPLY;
		         }return View.CHECKAPPLY;
		      }
		      
		   
		   //������ �� �̷¼� ����
		   public int delapply() {
		      System.out.println("���� �� �̷¼� ��Ͽ��� �����Ͻðڽ��ϱ�?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.applydel(applynum,recruitnum);
		         if(result>0){
		            System.out.println("������Ͽ��� �̷¼��� �����Ͽ����ϴ�");
		         }else{
		            System.out.println("�̷¼� ������ �����Ͽ����ϴ�");
		         }
		      }
		      return View.CHECKAPPLY;
		   }


		   
	   //�̷¼� ��ȸ
	   Object selectNum = 0;

	   public int getmyrsm() {
	      System.out.print("��ȸ�Ͻ� �۹�ȣ�� �����ϼ���: ");
	      int number = ScanUtil.nextInt();

	      for (int i = 0; i < list.size(); i++) {
	         if (list.get(i).get("RESUME_NUM").equals(number)) {
	            selectNum = list.get(i).get("RESUME_NO");
	            System.out.println("----------------------------------");
	            System.out.println("��ȣ : \t" + list.get(i).get("RESUME_NUM"));
	            System.out.println("----------------------------------");
	            System.out.println("���� : \t" + list.get(i).get("RESUME_TITLE"));
	            System.out.println("----------------------------------");
	            System.out.println("���� : \t" + list.get(i).get("RESUME_CON"));
	            System.out.println("----------------------------------");
	            System.out.println("������ : \t" + list.get(i).get("JOB_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("�ۼ��� : \t" + list.get(i).get("ALBA_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("�����: \t" + list.get(i).get("RESUME_DATE"));
	            System.out.println("----------------------------------");

	         }

	      }
	      System.out.println("1.���� 2.���� 3.������� ���ư���");
	      switch (ScanUtil.nextInt()) {
	      case 1:
	         return View.EDITRSM;
	      case 2:
	         return View.DELRSM;

	      }
	      return View.MYRSM;

	   }
	   //�̷¼� ����
	   public int editrsm() {
	      System.out.println("����: ");
	      String title = ScanUtil.nextLine();
	      System.out.println("����: ");
	      String content = ScanUtil.nextLine();
	      System.out.print("���л�:13\t���:14\t�����:15\tû�ҳ�:16\t�ֺ�:17\n������: ");
	      String jobCode = ScanUtil.nextLine();
	      int result = boardDao.againresume(title, content, jobCode, selectNum);
	      if (result > 0) {
	         System.out.println("�̷¼��� �����Ǿ����ϴ�");
	      } else {
	         System.out.println("�̷¼� ������ �����Ͽ����ϴ�");
	      }

	      return View.MYRSM;

	   }
	   //�̷¼� ����
	   public int delrsm() {
	      System.out.println("�̷¼��� ���� �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.deleteresume(selectNum);
	         if (result > 0) {
	            System.out.println("�̷¼��� �����Ǿ����ϴ�");
	         } else {
	            System.out.println("�̷¼� ������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.MYRSM;

	   }
	   //���� ����
	   public int myinfo() {
	      System.out.println("1.��й�ȣ ���� 2.������ ���� 3.ȸ��Ż�� 4.������������ ���ư���");
	      switch (ScanUtil.nextInt()) {
	      case 1:
	         return View.CHANGEPW;
	      case 2:
	         return View.CHANGEDETAIL;
	      case 3:
	          return View.OUTMEMBER;   
	      }
	      return View.MYPAGE;

	   }


	   
	   static Object go = 0;

	   // ���� ��ȸ
	   public int getrec() {
	      System.out.print("��ȸ�Ͻ� ���� ��ȣ�� �����ϼ���: ");
	      int input = ScanUtil.nextInt();
	      Map<String, Object> board = boardDao.getrec(input);
	      System.out.println("----------------------------------");
	      System.out.println("��ȣ : \t" + board.get("RECRUIT_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("RECRUIT_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("�ٹ�ó�� : \t" + board.get("COMPANY_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("�������� : " + board.get("RECRUIT_START"));
	      System.out.println("----------------------------------");
	      System.out.println("�������� : " + board.get("RECRUIT_END"));
	      System.out.println("----------------------------------");
	      System.out.println("�ٹ��� �ּ� : " + board.get("WORK_ADDR"));
	      System.out.println("----------------------------------");
	      System.out.println("�ٹ��ð� : \t" + board.get("WORK_TIME"));
	      System.out.println("----------------------------------");
	      System.out.println("�ٹ��Ⱓ : \t" + board.get("WORK_TERM"));
	      System.out.println("----------------------------------");
	      System.out.println("�ñ� : \t" + board.get("WORK_PAY"));
	      System.out.println("----------------------------------");
	      System.out.println("������ : \t" + board.get("WORK_JOB"));
	      System.out.println("----------------------------------");
	      System.out.println("�ٹ��� ��ȭ : " + board.get("WORK_TEL"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("JOB_NAME"));
	      System.out.println("----------------------------------");
	      go=board.get("RECRUIT_NO");
	      // �������� ��� ���� ���� ����
	      if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            || Controller.loginUser.get("MEM_ID").equals(
	                  board.get("MEM_ID"))) {
	         System.out.println("1.���� 2.������� ���ư���");
	         if (ScanUtil.nextInt() == 1) {
	            return View.DELREC;
	         }
	      } else if (Controller.loginUser.get("MEM_TYPE").equals("2")) {
	         System.out.println("1.���ɰ��� ��� 2.�����ϱ� 3.������� ���ư���");
	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.LIKEREC;
	         case 2:
	            return View.APPLYREC;
	         }
	      } else {
	         System.out.println("������� ���ư��ðڽ��ϱ�?(Y/N)");
	         if (!ScanUtil.nextLine().equals("Y")) {
	            return View.GETREC;
	         }
	      }
	      return View.BOARDREC;
	   }
	   //���ɰ��� ���
	   public int likerec() {
	      System.out.println("�ش� ���� ���ɸ�Ͽ� ����ұ��?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {

	         int result = boardDao.addlike(go,
	               Controller.loginUser.get("MEM_ID"));
	         if (result > 0) {
	            System.out.println("���� �� ���ɸ�Ͽ� �߰��Ͽ����ϴ�");
	            return View.BOARDREC;
	         } else {
	            System.out.println("���ɸ�� �߰��� �����Ͽ����ϴ�");
	         }
	      }
	      return View.GETREC;

	   }
	   //���ɰ��� ���
	   List<Map<String, Object>> likelist = null;

	   public int boardlikerec() {
	      System.out.println("===========���� ���� ����==========");
	      likelist=null;
	      likelist = boardDao.recuritlike(Controller.loginUser.get("MEM_ID"));
	      int count = 1;
	      for (int i = 0; i < likelist.size(); i++) {
	         likelist.get(i).put("LIKE_NUM", count);
	         count++;
	      }
	      System.out.println("��ȣ\t����\t�����\tä�븶����");
	      for (Map<String, Object> map : likelist) {
	         System.out.println("------------------------------------------");
	         System.out.println(map.get("LIKE_NUM") + "\t"
	               + map.get("RECRUIT_TITLE") + "\t" + map.get("COMPANY_NAME")
	               + "\t" + map.get("RECRUIT_END"));
	      }
	      System.out.println("======================================");
	      System.out.println("1.����ȸ 2.������������ ���ư���");
	      if (ScanUtil.nextInt() == 1) {
	         return View.GETLIKE;
	      }
	      return View.MYPAGE;
	   }
	   //���ɰ��� �󼼺���
	   static Object likenumber = 0;

	   public int getlike() {
	      System.out.println("��ȸ�� �� ��ȣ�� �����ϼ���: ");
	      int selectLike = ScanUtil.nextInt();
	      for (int i = 0; i < likelist.size(); i++) {
	         if (likelist.get(i).get("LIKE_NUM").equals(selectLike)) {
	            likenumber = likelist.get(i).get("RECRUIT_NO");
	            System.out.println("----------------------------------");
	            System.out.println("��ȣ : \t" + likelist.get(i).get("LIKE_NUM"));
	            System.out.println("----------------------------------");
	            System.out.println("���� : \t"
	                  + likelist.get(i).get("RECRUIT_TITLE"));
	            System.out.println("----------------------------------");
	            System.out.println("�ٹ�ó�� : \t"
	                  + likelist.get(i).get("COMPANY_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("�������� : "
	                  + likelist.get(i).get("RECRUIT_START"));
	            System.out.println("----------------------------------");
	            System.out.println("�������� : "
	                  + likelist.get(i).get("RECRUIT_END"));
	            System.out.println("----------------------------------");
	            System.out.println("�ٹ��� �ּ� : "
	                  + likelist.get(i).get("WORK_ADDR"));
	            System.out.println("----------------------------------");
	            System.out.println("�ٹ��ð� : \t"
	                  + likelist.get(i).get("WORK_TIME"));
	            System.out.println("----------------------------------");
	            System.out.println("�ٹ��Ⱓ : \t"
	                  + likelist.get(i).get("WORK_TERM"));
	            System.out.println("----------------------------------");
	            System.out.println("�ñ� : \t" + likelist.get(i).get("WORK_PAY"));
	            System.out.println("----------------------------------");
	            System.out.println("������ : \t"
	                  + likelist.get(i).get("WORK_JOB"));
	            System.out.println("----------------------------------");
	            System.out.println("�ٹ��� ��ȭ : "
	                  + likelist.get(i).get("WORK_TEL"));
	            System.out.println("----------------------------------");
	         
	            System.out.println("1.���� 2.������� ���ư���");
	         }
	      }
	      if (ScanUtil.nextInt() == 1) {
	         return View.DELLIKE;
	      }
	      return View.BOARDLIKEREC;

	   }
	   //���ɰ��� ����
	   public int dellike() {
	      System.out.println("���� ���� �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.deletelike(likenumber,Controller.loginUser.get("MEM_ID"));
	         if (result > 0) {
	            System.out.println("�� ��Ͽ��� �����Ͽ����ϴ�");
	         } else {
	            System.out.println("������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.BOARDLIKEREC;

	   }
	   //�������� ����
	   public int changedetail() {
	      System.out.println("�ּ�: ");
	      String addr = ScanUtil.nextLine();
	      System.out.println("����ó('-'����): ");
	      String hp = ScanUtil.nextLine();
	      int result = 0;
	      if (Controller.loginUser.get("MEM_TYPE").equals("2")) {
	         result = boardDao.detailchangeAlba(addr, hp,
	               Controller.loginUser.get("MEM_ID"));
	      } else {
	         result = boardDao.detailchangeOwner(addr, hp,
	               Controller.loginUser.get("MEM_ID"));
	      }

	      if (result > 0) {
	         System.out.println("�������� �����Ͽ����ϴ�");
	      } else {
	         System.out.println("������ ���濡 �����Ͽ����ϴ�");
	      }
	      return View.MYINFO;
	   }
	   //��й�ȣ ����(��ȿ���˻� ����)
	   public int changepw() {
	      String pw = null;
	      Matcher m = null;
	      String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
	      Pattern p = Pattern.compile(regex);
	      p = Pattern.compile(regex);
	      do {
	         System.out.print("������ ��й�ȣ: ");
	         pw = ScanUtil.nextLine();
	         m = p.matcher(pw);
	         if (m.equals(false)) {
	            System.out.println("�ּ� 8�ڸ��� ����, ����, Ư������ ���� 1�� �̻� �����ؾ� �մϴ�");
	         }
	      } while (m.equals(false));
	      int result = boardDao.changepw(pw, Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("��й�ȣ�� ����Ǿ����ϴ�");
	      } else {
	         System.out.println("��й�ȣ ���濡 �����Ͽ����ϴ�");
	      }
	      return View.MYINFO;

	   }
	   // 1:1 ��� �Խ���
	   public int boardinq() { 

	      List<Map<String, Object>> boardlist = boardDao.inquireboard();

	      System.out.println("==========================================");
	      System.out.println("��ȣ\t����\t\t�ۼ��� ID");

	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------------");
	         System.out.println(board.get("INQ_NO") + "\t"
	               + board.get("INQ_TITLE") + "\t" + board.get("MEM_ID")
	               + "\t");
	      }
	      System.out.println("=========================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {
	         System.out.println("1.��ȸ 2.�ǵ��ư���");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETINQ;
	         }
	      }

	         else {

	            System.out.println("1.��ȸ  2.1:1���� �ۼ� 3. �ǵ��ư���");

	            switch (ScanUtil.nextInt()) {
	            case 1:
	               return View.GETINQ;
	            case 2:
	               return View.WRITEINQ;

	            }

	         }
	      return View.MAINMENU;
	   }
	      
	      
	   //1:1���� ��ȸ
	   public int getinq() {
	       System.out.println("��ȸ�� �� ��ȣ�� �Է����ּ���.");
	       number = ScanUtil.nextInt();
	       Map<String, Object> board = boardDao.getinq(number);
	       
	       //1:1���ǿ��� �ڱ���� �ƴѵ� ��ȸ�Ǵ� �κ� ���� **********************************************
	       if((!(Controller.loginUser.get("MEM_TYPE").equals("3"))&&!(board.get("MEM_ID").equals(Controller.loginUser.get("MEM_ID"))))){
	          System.out.println("��ȸ�� �� �����ϴ�.");
	             return View.BOARDINQ;
	       }
	       System.out.println("----------------------------------");
	       System.out.println("��ȣ : \t" + board.get("INQ_NO"));
	       System.out.println("----------------------------------");
	       System.out.println("1:1���� : \t" + board.get("INQ_TITLE"));
	       System.out.println("----------------------------------");
	       System.out.println("1:1���� : \t" + board.get("INQ_CON"));
	       System.out.println("----------------------------------");
	       // �亯 null�� ��� ������**********************************************************************************************************
	       if(!(board.get("INQ_ANS")==null)){
	 
	       System.out.println("1:1�亯 : \t" + board.get("INQ_ANS"));
	       System.out.println("----------------------------------");
	     
	       }else{
	          System.out.println("1:1�亯:\t���� �亯�� �޸��� �ʾҽ��ϴ�.");
	          System.out.println("----------------------------------");
	       }
	          
	       
	       if (board.get("MEM_ID").equals(Controller.loginUser.get("MEM_ID"))) {
	          System.out.println("1.���� 2.���� 3.������� ���ư���");
	          int input = ScanUtil.nextInt();
	          switch (input) {
	          case 1:
	             return View.EDITINQ; //����ȭ������ ���°� ������***********************
	          case 2:
	             return View.DELINQ;
	          }
	          
	          
	       } else {
	          Map<String, Object> boards = boardDao.getinq(number);
	          if(board.get("INQ_ANS")==null){ //�亯�Ϸ�Ǿ����� �亯 ���ϰ� ������***********************************
	             System.out.println("1.�亯 2.������� ���ư���");
	             if (ScanUtil.nextInt() == 1) {
	                return View.ANSINQ;
	             }    
	          }
	         
	       }
	       
	       System.out.println("������� ���ư��ðڽ��ϱ�?(Y/N)");
	       if (ScanUtil.nextLine().equals("Y")) {
	          return View.BOARDINQ;

	       }
	       return View.BOARDINQ;

	    }

	   //1:1���� �ۼ�
	   public int writeinq() {
	      System.out.println("=============1:1 ��� �ۼ�==============");
	      System.out.print("����: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("����: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.writeinq(title, content,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("�Խñ��� ��ϵǾ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�");
	      }
	      return View.BOARDINQ;
	   }
	   
	   //1:1 ���� ����
	   public int editinq() { 
	      System.out.print("������ ����: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("������ ����: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.inqagain(title, content, number);
	      if (result > 0) {
	         System.out.println("�Խñ��� �����Ǿ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ������ �����Ͽ����ϴ�");
	      }
	      return View.BOARDINQ;
	   }
	   // �Ŵ����� �亯
	   public int ansinq() {
	      System.out.println("=============1:1 ��� �亯==============");
	      System.out.print("�亯: ");
	      String anw = ScanUtil.nextLine();
	      int result = boardDao.inqanw(number, anw,
	            Controller.loginUser.get("MEM_ID")); //
	      if (result > 0) {
	         System.out.println("�亯�� �Ϸ�Ǿ����ϴ�.");
	      } else {
	         System.out.println("�亯�� �����Ͽ����ϴ�.");
	      }
	      return View.BOARDINQ;
	   }
	   // ���� �Խ���
	   public int boardnote() {
	      List<Map<String, Object>> boardlist = boardDao.getNoboard();
	      System.out.println("=============================================================");
	      System.out.println("��ȣ\t����\t\t\t�ۼ���\t�����");
	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------------------------------");
	         System.out.println(board.get("NOTICE_NO") + "\t"
	               + board.get("NOTICE_TITLE") + "\t"        
	               + board.get("MANAGER_NAME") + "\t"
	               + board.get("NOTICE_DATE"));
	      }
	      System.out.println("==============================================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) { // �Ŵ�����
	         System.out.println("1.��ȸ 2.�����ۼ�  0.�޴���");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.GETNOTE;
	         case 2:
	            return View.WRITENOTE;

	         }

	      }

	      else {// �˹� �����
	         System.out.println("1.��ȸ 0.�޴��� ���ư��� ");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETNOTE;
	         }
	      }
	      return View.MAINMENU;
	   }

	   static int num = 0;
	// ���� �ۼ�
	   public int writenote() { 
	      System.out.println("=============���� �ۼ�==============");

	      System.out.println("�������� ����:");
	      String noticetitle = ScanUtil.nextLine();
	      System.out.println("�������� ����:");
	      String noticecontent = ScanUtil.nextLine();

	      int result = boardDao.noticewrite(noticetitle, noticecontent,
	            Controller.loginUser.get("MANAGER_ID"));

	      if (result > 0) {
	         System.out.println("�Խñ��� ��ϵǾ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�");
	      }

	      return View.BOARDNOTE;

	   }

	   public int getnote() { // ������ȸ
	      System.out.print("��ȸ�Ͻ� �� ��ȣ�� �����ϼ���: ");
	      number = ScanUtil.nextInt();

	      Map<String, Object> board = boardDao.getno(number);
	      System.out.println("----------------------------------");
	      System.out.println("��ȣ : \t" + board.get("NOTICE_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("NOTICE_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("���� : \t" + board.get("NOTICE_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("�ۼ��� : \t" + board.get("MANAGER_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("�����: \t" + board.get("NOTICE_DATE"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            && Controller.loginUser.get("MANAGER_ID").equals(
	                  board.get("MANAGER_ID"))) {
	         System.out.println("1.���� 2.���� 3.������� ���ư���");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.EDITNOTE;
	         case 2:
	            return View.DELNOTE;
	         }

	      } else {
	         System.out.println("������� ���ư��ðڽ��ϱ�?(Y/N)");
	         if (ScanUtil.nextLine().equals("Y")) {
	            return View.BOARDNOTE;
	         }
	      }
	      return View.BOARDNOTE;
	   }

	   public int editnote() { // ��������

	      System.out.print("����: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("����: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.noagain(title, content, number);
	      if (result > 0) {
	         System.out.println("�Խñ��� �����Ǿ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ������ �����Ͽ����ϴ�");
	      }
	      return View.BOARDNOTE;

	   }

	   public int delnote() { // ��������
	      System.out.println("���� �Խù��� �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.nodelete(number);
	         if (result > 0) {
	            System.out.println("�Խù��� �����Ͽ����ϴ�");
	         } else {
	            System.out.println("�Խù� ������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.BOARDNOTE;
	   }

	   public int boardqna() {
	      List<Map<String, Object>> boardlist = boardDao.getQnaboard();
	      System.out.println("==========================================");
	      System.out.println("��ȣ\t���ֹ�������");

	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------");
	         System.out.println(board.get("QNA_NO") + "\t"
	               + board.get("QNA_CON") + "\t");
	      }

	      System.out.println("=====================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {// �Ŵ�����
	         System.out.println("1.��ȸ 2. ���ֹ��� �� �ۼ�  0.�޴��� ���ư���");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.GETQNA;
	         case 2:
	            return View.WRITEQNA;

	         }

	      } else { // �˹�.����̸�
	         System.out.println("1.��ȸ 0.�޴��� ���ư��� ");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETQNA;
	         }
	      }
	      return View.MAINMENU;

	   }

	   public int getqna() { // ���ֹ������� ��ȸ
	      System.out.print("��ȸ�Ͻ� �� ��ȣ�� �����ϼ���: ");
	      number = ScanUtil.nextInt();

	      Map<String, Object> board = boardDao.getQna(number);
	      System.out.println("----------------------------------");
	      System.out.println("��ȣ : \t" + board.get("QNA_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("���ֹ��� ����  : \t" + board.get("QNA_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("�亯 : \t" + board.get("QNA_ANSWER"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {
	         System.out.println("1.���� 2.���� 3.������� ���ư���");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.EDITQNA;
	         case 2:
	            return View.DELQNA;

	         }
	      } else {
	         System.out.println("������� ���ư��ðڽ��ϱ�?(Y/N)");
	         if (!ScanUtil.nextLine().equals("Y")) {
	            return View.GETQNA;
	         }

	      }
	      return View.BOARDQNA;

	   }

	   public int writeqna() { // ���ֹ��� �����ۼ�

	      System.out.println("=============���ֹ��� ���� �ۼ�==============");
	      System.out.println("���ֹ��� ����:");
	      String q = ScanUtil.nextLine();
	      System.out.println("�亯:");
	      String a = ScanUtil.nextLine();

	      int result = boardDao.qnawrite(q, a);
	      System.out.println(result);
	      if (result > 0) {
	         System.out.println("�Խñ��� ��ϵǾ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ��Ͽ� �����Ͽ����ϴ�");
	      }

	      return View.BOARDQNA;

	   }

	   public int editqna() { // ���ֹ��� ���� ����
	      System.out.print("���ֹ�������: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("�亯: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.qnaagain(title, content, number);
	      if (result > 0) {
	         System.out.println("�Խñ��� �����Ǿ����ϴ�");
	      } else {
	         System.out.println("�Խñ� ������ �����Ͽ����ϴ�");
	      }
	      return View.BOARDQNA;
	   }

	   public int delqna() { // ���ֹ��� ���� ����

	      System.out.println("���� �Խù��� �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.qnadelete(number);
	         if (result > 0) {
	            System.out.println("�Խù��� �����Ͽ����ϴ�");
	         } else {
	            System.out.println("�Խù� ������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.BOARDQNA;
	   }

	   public int delinq() {
	      System.out.println("���� ������ �����Ͻðڽ��ϱ�?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.inqdelete(number);
	         if (result > 0) {
	            System.out.println("�Խù��� �����Ͽ����ϴ�");
	         } else {
	            System.out.println("�Խù� ������ �����Ͽ����ϴ�");
	         }
	      }
	      return View.BOARDINQ;
	   }

	   public int meminfo() { // ȸ������
	      System.out.println("1.�Ϲ�ȸ������ 2.���ȸ������ 3.�޴����� �ǵ��ư��� ");

	      switch (ScanUtil.nextInt()) {
	      case 1:
	         return View.ALBAINFO;
	      case 2:
	         return View.COMINFO;

	      }
	      System.out.println("�޴��� ���ư��ðڽ��ϱ�?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.MAINMENU;
	      }
	      return View.MAINMENU;

	   }

	   public int albainfo() { // �˹�ȸ��������ȸ
	      List<Map<String, Object>> boardlist = boardDao.albainfo();
	      System.out
	            .println("==================================================================================");
	      System.out
	            .println("    ���̵�\t\t��й�ȣ\t\tTYPE\t�̸�\t�������\t\t\t�ּ�\t\t����ó\t\t\t����");
	      for (Map<String, Object> board : boardlist) {

	         System.out
	               .println("--------------------------------------------------------------------------");
	         System.out.println(board.get("MEM_ID") + "\t" + board.get("MEM_PW")
	               + "\t" + board.get("MEM_TYPE") + "\t"
	               + board.get("ALBA_NAME") + "\t" + board.get("ALBA_BIR")
	               + "\t" + board.get("ALBA_ADDR") + "\t\t\t"
	               + board.get("ALBA_HP") + "\t\t" + board.get("ALBA_GENDER"));
	      }
	      System.out
	            .println("==================================================================================");

	      System.out.println("1.�ǵ��ư��� 2.���θ޴��� ���ư���");
	      if (ScanUtil.nextInt() == 1) {
	         return View.MEMINFO;
	      }

	      System.out.println("���θ޴��� ���ư��ðڽ��ϱ�?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.ALBAINFO;
	      }

	      return View.MAINMENU;

	   }

	   public int cominfo() { // ���ȸ��������ȸ
	      List<Map<String, Object>> boardlist = boardDao.cominfo();
	      System.out
	            .println("==================================================================================");
	      System.out
	            .println("���̵�\t\t��й�ȣ\t\tTYPE\t��ü��\t\t��ǥ���̸�\t\t�����ּ�\t\t\t\t\t������ȭ��ȣ");
	      for (Map<String, Object> board : boardlist) {

	         System.out
	               .println("--------------------------------------------------------------------------");
	         System.out.println(board.get("MEM_ID") + "\t" + board.get("MEM_PW")
	               + "\t" + board.get("MEM_TYPE") + "\t"
	               + board.get("COMPANY_NAME") + "\t"
	               + board.get("COMPANY_OWNER") + "\t\t"
	               + board.get("COMPANY_ADDR") + "\t\t"
	               + board.get("COMPANY_TEL"));
	      }
	      System.out
	            .println("==================================================================================");

	      System.out.println("1.�ǵ��ư��� 2.���θ޴��� ���ư���");
	      if (ScanUtil.nextInt() == 1) {
	         return View.MEMINFO;
	      }

	      System.out.println("���θ޴��� ���ư��ðڽ��ϱ�?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.COMINFO;
	      }

	      return View.MAINMENU;

	   }
	   
	   //���� ���
	    public int boardrec() {
	        List<Map<String, Object>> boardlist = boardDao.getRecruitboard();
	        System.out.println("==========================================");
	        System.out.println("��ȣ\t���� ����\t��ü��\t�����");
	        for (Map<String, Object> board : boardlist) {

	           System.out.println("----------------------------------");
	           System.out.println(board.get("RECRUIT_NO") + "\t"
	                 + board.get("RECRUIT_TITLE") + "\t"
	                 + board.get("COMPANY_NAME") + "\t"
	                 + board.get("RECRUIT_START"));
	        }
	        System.out.println("=====================================");

	        System.out.println("1.��ȸ  2.�з��� ��ȸ 3.�޴��� ���ư��� ");
	    
	        switch (ScanUtil.nextInt()) {
	        case 1:
	           return View.GETREC;
	        case 2:   
	          return View.RECRUITFILTER;
	        }
	        return View.MAINMENU;
	     }
	    
	    //���� ���͸�
	    public int recruitfilter() {
	       System.out.println("�з��� ��ȸ�� ���� �׸��� ����ּ���.");
	        System.out.println("1.������ ��ȸ 2.������ ��ȸ 3.�ٹ��ð��� ��ȸ 4.�Ⱓ�� ��ȸ 5.�޴��� ���ư��� ");
	     
	        switch (ScanUtil.nextInt()) {
	        case 1:
	           return View.RECFILTER_ADDR;
	        case 2:
	           return View.RECFILTER_JOB;
	        case 3:
	           return View.RECFILTER_TIME;
	        case 4:
	           return View.RECFILTER_TERM;
	        }
	        return View.BOARDREC;
	  }
	    //���� ���͸�-������
	    public int recfilteraddr() {
	       System.out.println("[���� �з�]\n����\t���\t��õ\t����\t�泲\t����\n"
	             + "���\t�λ�\t���\t�뱸\t���\t�泲\n"
	             + "����\t����\t����\t����");
	       System.out.println("������ �Է��ϼ���. ex)����\n: ");
	       String region = ScanUtil.nextLine();
	       List<Map<String, Object>> boardlist = boardDao.recfilteraddr(region);
	       System.out.println("==========================================");
	       System.out.println("��ȣ\t����\t��ü��\t�����");
	       for (Map<String, Object> board : boardlist) {
	          System.out.println("----------------------------------");
	          System.out.println(board.get("RECRUIT_NO") + "\t"
	                + board.get("RECRUIT_TITLE") + "\t"
	                + board.get("COMPANY_NAME") + "\t" 
	                + board.get("RECRUIT_START"));
	       }
	       System.out.println("=====================================");

	       System.out.println("1.��ȸ 2. ��ü ä����� ������� ���ư��� ");
	       if(ScanUtil.nextInt()==1){
	          return View.GETREC;
	       }
	  
	       return View.BOARDREC;
	    }

	    //���� ���͸�-������
	    public int recfilterjob() {
	       System.out.println("[�����ڵ� ���]\n�ܽ�/����:1\t����/�Ǹ�:2\t��ȭ/��Ȱ:3\t����:4\n"
	            + "�繫/ȸ��:5\t���/����:6\t����/�Ǽ�:7\tIT/���ͳ�:8\n"
	            + "����/����:9\t������/�̵��:10\t����/���:11\t����/����:12");
	       System.out.println("�����ڵ带 �Է��ϼ���:");
	       int jobcode = ScanUtil.nextInt();
	          List<Map<String, Object>> boardlist = boardDao.recfilterjob(jobcode);
	          System.out.println("==========================================");
	          System.out.println("��ȣ\t����\t��ü��\t�����");
	          for (Map<String, Object> board : boardlist) {
	             System.out.println("----------------------------------");
	             System.out.println(board.get("RECRUIT_NO") + "\t"
	                   + board.get("RECRUIT_TITLE") + "\t"
	                   + board.get("COMPANY_NAME") + "\t" 
	                   + board.get("RECRUIT_START"));
	          }
	          System.out.println("=====================================");

	          System.out.println("1. ��ȸ 2. ��ü ä����� ������� ���ư��� ");
	          if(ScanUtil.nextInt()==1){
	             return View.GETREC;
	          }
	          return View.BOARDREC;
	       }
	    //���� ���͸�-�ð���    
	    public int recfiltertime() {
	       System.out.println("[�ٹ��ð� ����]\n���� : 06:00~12:00\t���� : 12:00~22:00\t�߰� : 22:00~06:00");
	        System.out.println("��� �ð��븦 �����ϼ���.(����:1\t����:2\t�߰�:3");
	        int worktime = ScanUtil.nextInt();
	          List<Map<String, Object>> boardlist = boardDao.recfiltertime(worktime);
	           System.out.println("==========================================");
	           System.out.println("��ȣ\t����\t��ü��\t�����");
	           for (Map<String, Object> board : boardlist) {
	              System.out.println("----------------------------------");
	              System.out.println(board.get("RECRUIT_NO") + "\t"
	                    + board.get("RECRUIT_TITLE") + "\t"
	                    + board.get("COMPANY_NAME") + "\t" 
	                    + board.get("RECRUIT_START"));
	           }
	           System.out.println("=====================================");

	           System.out.println("1. ��ȸ 2. ��ü ä����� ������� ���ư��� ");
	           if(ScanUtil.nextInt()==1){
	              return View.GETREC;
	           }      
	           return View.BOARDREC;
	        }
	    //���� ���͸�-�Ⱓ�� 
	   public int recfilterterm() {
	      System.out.println("[�ٹ��Ⱓ ����]\n�ܱ� : 0���� 1��~1���� �̸� \t�߱� : 1���� �̻� ~6���� �̸�\t��� : 6���� �̻�");
	       System.out.println("��� �ٹ��Ⱓ�� �����ϼ���.(�ܱ�:1\t�߱�:2\t���:3)");
	       int workterm = ScanUtil.nextInt();
	         List<Map<String, Object>> boardlist = boardDao.recfilterterm(workterm);
	          System.out.println("==========================================");
	          System.out.println("��ȣ\t����\t��ü��\t�����");
	          for (Map<String, Object> board : boardlist) {
	             System.out.println("----------------------------------");
	             System.out.println(board.get("RECRUIT_NO") + "\t"
	                   + board.get("RECRUIT_TITLE") + "\t"
	                   + board.get("COMPANY_NAME") + "\t" 
	                   + board.get("RECRUIT_START"));
	          }
	          System.out.println("=====================================");

	          System.out.println("1. ��ȸ 2. ��ü ä����� ������� ���ư��� ");
	          if(ScanUtil.nextInt()==1){
	             return View.GETREC;
	          }      
	          return View.BOARDREC;
	       }
	  
	    //���� ���
	    public int writerec(){
	       System.out.println("=============ä����� �ۼ�==============");
	       System.out.println("����:");
	       String recruittitle = ScanUtil.nextLine();
	       System.out.println("�ٹ��� �ּ�:");
	       String workaddr = ScanUtil.nextLine();
	       System.out.println("�ٹ��ð�('00:00~00:00'���·� �Է�):");
	       String worktime = ScanUtil.nextLine();
	       System.out.println("�ٹ��Ⱓ('_����_��' ���·� �Է�):");
	       String workterm = ScanUtil.nextLine();
	       System.out.println("�ñ�:");
	       String workpay = ScanUtil.nextLine();
	       System.out.println("������:");
	       String workjob = ScanUtil.nextLine();
	       System.out.println("��������('YYYY/MM/DD' ���·� �Է�):");
	       String recruitend = ScanUtil.nextLine();
	       System.out.println("�ٹ�����ȭ��ȣ(')'Ȥ��'-'����\n����)042)881-1234:");
	       String worktel = ScanUtil.nextLine();
	       System.out.println("[�����ڵ� ���]\n�ܽ�/����:1\t����/�Ǹ�:2\t��ȭ/��Ȱ:3\t����:4\n"
	                   + "�繫/ȸ��:5\t���/����:6\t����/�Ǽ�:7\tIT/���ͳ�:8\n"
	                   + "����/����:9\t������/�̵��:10\t����/���:11\t����/����:12");
	       System.out.println("�����ڵ�:");
	       int jobcode = ScanUtil.nextInt();
	       
	       int result=boardDao.writeRecruit(recruittitle,workaddr,worktime,workterm,workpay,workjob,recruitend,
	             worktel,jobcode,Controller.loginUser.get("MEM_ID"));
	       if(result>0){
	          System.out.println("ä����� ��ϵǾ����ϴ�");
	       }
	       else{
	          System.out.println("ä����� ��Ͽ� �����Ͽ����ϴ�");
	       }
	       return View.BOARDREC;
	    }
	    //���� �� ���� ���
	    static List<Map<String, Object>> myreclist=null;
	    public int myrec() {
	     myreclist=boardDao.myrec(Controller.loginUser.get("MEM_ID"));
	     int count=1;
	     for(int i=0;i<myreclist.size();i++){
	       myreclist.get(i).put("RECRUIT_NUM",count);
	       count++;
	     }
	     System.out.println("==================���� ä�����================");
	     System.out.println("��ȣ\t����\t�����");
	     for(Map<String, Object>map:myreclist){
	        System.out.println("------------------------------------------");
	        System.out.println(map.get("RECRUIT_NUM")+"\t"+map.get("RECRUIT_TITLE")+"\t"+map.get("RECRUIT_START"));
	     }
	     System.out.println("=========================================");
	     System.out.println("1.��ȸ 2.���� �޴��� ���ư���");
	  if(ScanUtil.nextInt()==1){
	     return View.GETMYREC;
	  }
	           return View.MAINMENU;
	    }
	    //���� �� ���� ��ȸ
	    Object choiceNum=0;
	    public int getmyrec() {
	       System.out.print("��ȸ�Ͻ� �۹�ȣ�� �����ϼ���: ");
	       int myrecnumber=ScanUtil.nextInt();
	       
	        for(int i=0;i<myreclist.size();i++){
	          if(myreclist.get(i).get("RECRUIT_NUM").equals(myrecnumber)){
	             choiceNum=myreclist.get(i).get("RECRUIT_NO");
	               System.out.println("----------------------------------");
	               System.out.println("��ȣ : \t"+myreclist.get(i).get("RECRUIT_NUM"));
	               System.out.println("----------------------------------");
	               System.out.println("���� : \t"+myreclist.get(i).get("RECRUIT_TITLE"));
	               System.out.println("----------------------------------");
	               System.out.println("�ٹ�ó�� : \t"+ myreclist.get(i).get("COMPANY_NAME"));
	               System.out.println("----------------------------------");
	               System.out.println("�������� : "+ myreclist.get(i).get("RECRUIT_START"));
	               System.out.println("----------------------------------");
	               System.out.println("�������� : "+ myreclist.get(i).get("RECRUIT_END"));
	               System.out.println("----------------------------------");
	               System.out.println("�ٹ��� �ּ� : "+ myreclist.get(i).get("WORK_ADDR"));
	               System.out.println("----------------------------------");
	               System.out.println("�ٹ��ð� : \t"+ myreclist.get(i).get("WORK_TIME"));
	               System.out.println("----------------------------------");
	               System.out.println("�ٹ��Ⱓ : \t"+ myreclist.get(i).get("WORK_TERM"));
	               System.out.println("----------------------------------");
	               System.out.println("�ñ� : \t"+ myreclist.get(i).get("WORK_PAY"));
	               System.out.println("----------------------------------");
	               System.out.println("������ : \t"+ myreclist.get(i).get("WORK_JOB"));
	               System.out.println("----------------------------------");
	               System.out.println("�ٹ��� ��ȭ : "+ myreclist.get(i).get("WORK_TEL"));
	               System.out.println("----------------------------------");
	               System.out.println("���� : \t"+myreclist.get(i).get("JOB_NAME"));
	               System.out.println("----------------------------------");
	          }
	             
	          }
	        System.out.println("1.���� 2.���� 3.������� ���ư���");
	        switch(ScanUtil.nextInt()){
	        case 1: return View.EDITREC;
	        case 2: return View.DELREC;
	        }
	        return View.MYREC;
	     }
	    
	    //���� ����
	    public int editrec() {
	       System.out.println("����:");
	        String recruittitle = ScanUtil.nextLine();
	        System.out.println("�ٹ���:");
	        String workaddr = ScanUtil.nextLine();
	        System.out.println("�ٹ��ð�:");
	        String worktime = ScanUtil.nextLine();
	        System.out.println("�ٹ��Ⱓ('_����_��' ���·� �Է�):");
	        String workterm = ScanUtil.nextLine();
	        System.out.println("�ñ�:");
	        String workpay = ScanUtil.nextLine();
	        System.out.println("������:");
	        String workjob = ScanUtil.nextLine();
	        System.out.println("[�����ڵ� ���]\n�ܽ�/����:01\t����/�Ǹ�:02\t��ȭ/��Ȱ:03\t����:04\n"
	             + "�繫/ȸ��:05\t���/����:06\t����/�Ǽ�:07\tIT/���ͳ�:08\n"
	             + "����/����:09\t������/�̵��:10\t����/���:11\t����/����:12");
	        System.out.println("�����ڵ�:");
	        int jobcode = ScanUtil.nextInt();
	        System.out.println("�ٹ�����ȭ��ȣ:");
	        String worktel = ScanUtil.nextLine();
	        System.out.println("��������:");
	        String recruitend = ScanUtil.nextLine();
	                     
	        int result=boardDao.recruitagain(recruittitle,workaddr,worktime,workterm,workpay,workjob,
	              jobcode,worktel,recruitend,choiceNum);
	        if(result>0){
	           System.out.println("ä����� �����Ǿ����ϴ�");
	        }
	        else{
	           System.out.println("ä����� ������ �����Ͽ����ϴ�");
	        }
	        return View.MYREC;
	    }
	    
	    //���� ����
	    public int delrec() {
	       System.out.println("ä����� ���� �����Ͻðڽ��ϱ�?(Y/N)");
	       if(ScanUtil.nextLine().equals("Y")){
	          int result=boardDao.deleterecruit(number);
	          if(result>0){
	             System.out.println("ä����� �����Ǿ����ϴ�");
	          }else{
	             System.out.println("ä����� ������ �����Ͽ����ϴ�");
	          }
	       }
	       return View.BOARDREC;
	    }
	    
	    

