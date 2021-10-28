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
	   
	   //회원탈퇴
	   public int outmember() { //추가
		      System.out.println("회원탈퇴를 진행하시겠습니까?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.memberout(Controller.loginUser.get("MEM_ID"),Controller.loginUser.get("MEM_TYPE"));
		         
		         if(result>=2){
		            System.out.println("회원탈퇴가 정상적으로 이루어졌습니다");
		            return View.HOME;
		         }else{
		            System.out.println("회원탈퇴에 실패하였습니다");         
		         }
		      }
		      return View.MYINFO;
		   }
	   
	   //개인회원 메뉴
	   public static int albaMenu() {
	      System.out
	            .println("1.이력서작성 2.채용공고 3.후기게시판 4.공지게시판 5.자주묻는 질문  6.마이페이지 7.로그아웃");
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
	   //기업회원 메뉴-수정
	   public static int comMenu() {

	      System.out.println("1.채용공고작성 2.채용정보 3.인재정보 4.후기게시판 5.공지게시판 6.자주묻는 질문  7.마이페이지 8.로그아웃");
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
	   //관리자 메뉴
	   public static int managerMenu() {
	      System.out
	            .println("1.인재정보 2.후기게시판 3.공지게시판 4.채용공고 5.회원관리 6.자주묻는 질문 7.1:1상담 8.로그아웃");
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

	   //후기목록
	   public int boardreview() { // 후기게시판
	      List<Map<String, Object>> boardlist = boardDao.getReboard();
	      System.out.println("==========================================");
	      System.out.println("번호\t제목\t작성자\t등록일");
	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------");
	         System.out.println(board.get("REVIEW_NO") + "\t"
	               + board.get("REVIEW_TITLE") + "\t"
	               + board.get("ALBA_NAME")
	               + "\t" + board.get("REVIEW_REG"));
	      }
	      System.out.println("=====================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("2")) { // 알바이면
	         System.out.println("1.조회 2.후기작성 0.메뉴로 돌아가기 ");
	      }

	      else if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            || Controller.loginUser.get("MEM_TYPE").equals("1")) {// 기업.매니저면
	         System.out.println("1.조회  0.메뉴로");
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
	   // 후기 조회
	   public int getreview() { 
	      System.out.print("조회하실 글 번호를 선택하세요: ");
	      number = ScanUtil.nextInt();
	      Map<String, Object> board = boardDao.getre(number);

	      System.out.println("----------------------------------");
	      System.out.println("번호 : \t" + board.get("REVIEW_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("제목 : \t" + board.get("REVIEW_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("내용 : \t" + board.get("REVIEW_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("작성자 : \t" + board.get("ALBA_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("등록일: \t" + board.get("REVIEW_REG"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("2")
	            && Controller.loginUser.get("MEM_ID").equals(
	                  board.get("MEM_ID"))) {// 알바 리뷰조회

	         System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.EDITREVIEW;
	         case 2:
	            return View.DELREVIEW;

	         }
	      }

	      else if (Controller.loginUser.get("MEM_TYPE").equals("3")) { // 매니저 리뷰조회
	         System.out.println("1.삭제2.목록으로 돌아가기");
	         if (ScanUtil.nextInt() == 1) {
	            return View.DELREVIEW;
	         }
	      }
	      // 기업&지 글아닌 알바
	      System.out.println("목록으로 돌아가시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         return View.BOARDREVIEW;

	      }

	      return View.GETREVIEW;
	   }
	   // 후기작성
	   public int writereview() { 
	      System.out.println("=============알바 후기 작성==============");
	      System.out.print("제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("내용: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.writere(title, content,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("게시글이 등록되었습니다");
	      } else {
	         System.out.println("게시글 등록에 실패하였습니다");
	      }
	      return View.BOARDREVIEW;
	   }
	   // 후기 수정
	   public int editreview() { 
	      System.out.print("제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("내용: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.reagain(title, content, number);
	      if (result > 0) {
	         System.out.println("게시글이 수정되었습니다");
	      } else {
	         System.out.println("게시글 수정에 실패하였습니다");
	      }
	      return View.BOARDREVIEW;

	   }
	   // 후기 삭제
	   public int delreview() { 
	      System.out.println("정말 게시물을 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.redelete(number);
	         if (result > 0) {
	            System.out.println("게시물을 삭제하였습니다");
	         } else {
	            System.out.println("게시물 삭제에 실패하였습니다");
	         }
	      }
	      return View.BOARDREVIEW;

	   }
	   //마이페이지
	   public int mypage() {
	      if (Controller.loginUser.get("MEM_TYPE").equals("2")) {//개인회원
	         System.out
	               .println("1.내 이력서 2.개인정보 관리 3.내가 찜한 공고 4.1:1문의 5.메인메뉴로 돌아가기");
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
	      } else {//기업회원 혹은 관리자-수정
	         System.out
	               .println("1.나의 채용공고 2.나에게 온 지원서 확인 3.관심이력서 조회 4.개인정보관리 5.1:1상담게시판 6.메인메뉴 돌아가기");
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
	   //이력서 목록
	   public int boardrsm() { //추가
		      System.out.println("===============인재 정보==============");
		      System.out.println("번호\t제목\t작성자\t작성일");
		       List<Map<String, Object>> boardlist=boardDao.rsmboard();
		       for(Map<String, Object>board:boardlist){
		          System.out.println("--------------------------------------------------");
		          System.out.println(board.get("RESUME_NO")+"\t"+board.get("RESUME_TITLE")+"\t"+board.get("ALBA_NAME")+"\t"+board.get("RESUME_DATE"));
		       }
		       System.out.println("========================================");
		       System.out.println("1.조회  2.분류별조회  3.메인메뉴로 돌아가기");
		       int input = ScanUtil.nextInt();
		       switch (input) {
		       case 1:
		    	   return View.GETRSM;
		       case 2:
		    	   return View.RSMFILTER;

		       }
		       return View.MAINMENU;
		     }
		     
	   //이력서 필터
	   public int resumefilter() {
	       System.out.println("분류별 조회를 위한 항목을 골라주세요.");
	        System.out.println("1.지역별 조회 2.성별 조회 3.우대별 조회 4.메뉴로 돌아가기 ");
	     
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
	    //이력서 필터링-지역별
	    public int rsmfilteraddr() {
	       System.out.println("[지역 분류]\n서울\t경기\t인천\t강원\t충남\t대전\n"
	             + "충북\t부산\t울산\t대구\t경북\t경남\n"
	             + "전남\t광주\t전북\t제주");
	       System.out.println("지역을 입력하세요. ex)서울\n: ");
	       String region = ScanUtil.nextLine();
	       List<Map<String, Object>> boardlist = boardDao.rsmfilteraddr(region);
	       System.out.println("==========================================");
	       System.out.println("번호\t제목\t작성자명\t등록일");
	       for (Map<String, Object> board : boardlist) {
	          System.out.println("----------------------------------");
	          System.out.println(board.get("RESUME_NO") + "\t"
	                + board.get("RESUME_TITLE") + "\t"
	                + board.get("ALBA_NAME") + "\t" 
	                + board.get("RESUME_DATE"));
	       }
	       System.out.println("=====================================");

	       System.out.println("1.조회 2. 전체 이력서 목록으로 돌아가기 ");
	       if(ScanUtil.nextInt()==1){
	          return View.GETRSM;
	       }
	  
	       return View.BOARDRSM;
	    }
	    //이력서필터링-성별
	  	public int rsmfiltergen() {
	  	    System.out.println("조회할 성별을 입력하세요.(남or여):");
	        String gender = ScanUtil.nextLine();
	        List<Map<String, Object>> boardlist = boardDao.rsmfiltergen(gender);
	        System.out.println("==========================================");
	        System.out.println("번호\t제목\t작성자명\t등록일");
	        for (Map<String, Object> board : boardlist) {
	           System.out.println("----------------------------------");
	           System.out.println(board.get("RESUME_NO") + "\t"
	                 + board.get("RESUME_TITLE") + "\t"
	                 + board.get("ALBA_NAME") + "\t" 
	                 + board.get("RESUME_DATE"));
	        }
	        System.out.println("=====================================");

	        System.out.println("1.조회 2. 전체 이력서 목록으로 돌아가기 ");
	        if(ScanUtil.nextInt()==1){
	           return View.GETRSM;
	        }
	   
	        return View.BOARDRSM;
	     }
	    //이력서 필터링-우대조건별
	  	public int rsmfilterpre() {
	  		System.out.println("[우대조건 분류]\n대학생:13\t장애:14\t중장년:15\t청소년:16\t주부:17");
	  	       System.out.println("우대조건번호를 입력하세요:");
	  	       int prefer  = ScanUtil.nextInt();
	  	       List<Map<String, Object>> boardlist = boardDao.rsmfilterpre(prefer);
	  	       System.out.println("==========================================");
	  	       System.out.println("번호\t제목\t작성자명\t등록일");
	  	       for (Map<String, Object> board : boardlist) {
	  	          System.out.println("----------------------------------");
	  	          System.out.println(board.get("RESUME_NO") + "\t"
	  	                + board.get("RESUME_TITLE") + "\t"
	  	                + board.get("ALBA_NAME") + "\t" 
	  	                + board.get("RESUME_DATE"));
	  	       }
	  	       System.out.println("=====================================");

	  	       System.out.println("1.조회 2. 전체 이력서 목록으로 돌아가기 ");
	  	       if(ScanUtil.nextInt()==1){
	  	          return View.GETRSM;
	  	       }
	  	  
	  	       return View.BOARDRSM;
	  	} 
	    
	    
	   
	   //나의이력서 목록
	   static List<Map<String, Object>> list = null;

	   public int myrsm() {
	      list = boardDao.myResume(Controller.loginUser.get("MEM_ID"));
	      int count = 1;
	      for (int i = 0; i < list.size(); i++) {
	         list.get(i).put("RESUME_NUM", count);
	         count++;
	      }
	      System.out.println("==================나의 이력서================");
	      System.out.println("번호\t제목\t작성일");
	      for (Map<String, Object> map : list) {
	         System.out.println("------------------------------------------");
	         System.out.println(map.get("RESUME_NUM") + "\t"
	               + map.get("RESUME_TITLE") + "\t" + map.get("RESUME_DATE"));
	      }
	      System.out.println("=========================================");
	      System.out.println("1.조회 2.메인 메뉴로 돌아가기");
	      if (ScanUtil.nextInt() == 1) {
	         return View.GETMYRSM;
	      }
	      return View.MAINMENU;

	   }
	   //작성 이력서 목록
	   static int getrsmnum=0;
	   public int getrsm() {//추가
	      System.out.print("조회할 글 번호를 선택하세요: ");
	      getrsmnum=ScanUtil.nextInt();
	      Map<String, Object>map=boardDao.rsmget(getrsmnum);
	      System.out.println("=====================================================");
	      System.out.println("번호:\t"+map.get("RESUME_NO"));
	      System.out.println("제목:\t"+map.get("RESUME_TITLE"));
	      System.out.println("내용:\t"+map.get("RESUME_CON"));
	      System.out.println("우대조건:\t"+map.get("JOB_NAME"));
	      System.out.println("작성일:\t"+map.get("RESUME_DATE"));
	      System.out.println("=====================================================");
	      
	      if(Controller.loginUser.get("MEM_TYPE").equals("1")){
	         System.out.println("1.관심이력서 등록 2.목록으로 돌아가기");
	         if(ScanUtil.nextInt()==1){
	            return View.LIKERSM;
	         }
	      }else{
	         System.out.println("1.이력서 삭제하기 2.목록으로 돌아가기");
	         if(ScanUtil.nextInt()==1){
	            return View.DELLIKERSM;
	         }
	      }
	      
	      return View.BOARDRSM;
	   }
	   
	 //이력서 작성
	   public int writersm() {
	      System.out.println("===================이력서===================");
	      System.out.print("이력서 제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.println("이력서 내용: ");
	      String content = ScanUtil.nextLine();
	      System.out.println("대학생:13\t장애:14\t중장년:15\t청소년:16\t주부:17");
	      System.out.print("우대사항 :");
	      String jobCode = ScanUtil.nextLine();
	      int result = boardDao.rsmwrite(title, content, jobCode,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("이력서 작성을 완료하였습니다");
	      } else {
	         System.out.println("이력서 작성에 실패하였습니다");
	      }
	      return View.MAINMENU;
	   }
	   
	   public int likersm() { //추가
		      System.out.println("해당 이력서를 관심목록에 추가하시겠습니까?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.rsmlike(getrsmnum,Controller.loginUser.get("MEM_ID"));
		         if(result>0){
		            System.out.println("관심 이력서 목록에 추가하였습니다");
		         }else{
		            System.out.println("관심 이력서 추가에 실패하였습니다");
		         }
		         return View.BOARDRSM;
		      }
		         
		      return View.BOARDRSM;
		   }

		   public int dellikersm() { //추가
		      System.out.println("해당 이력서를 내가 찜한 목록에서 삭제하시겠습니까?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.likersmdel(dellikenum);
		         if(result>0){
		            System.out.println("내가 찜한 목록에서 삭제하였습니다");
		         }else{
		            System.out.println("삭제에 실패하였습니다");
		         }
		      }
		      
		      return View.BOARDLIKERSM;
		   }
		   
		   List<Map<String, Object>> likersmlist=null;
		   static Object dellikenum=0;
		   public int boardlikersm() { //추가
		      System.out.println("=====================내가 찜한 이력서==================");
		      System.out.println("번호\t제목\t작성자\t작성일");
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
		      System.out.println("1.상세조회 2.마이페이지로 돌아가기");
		      if(ScanUtil.nextInt()==1){
		         return View.GETLIKERSM;
		      }
		      return View.MYPAGE;
		   }

		   public int getlikersm() {  //추가
		      System.out.print("조회할 이력서를 선택하세요: ");
		      int number=ScanUtil.nextInt();
		      System.out.println("=================================================");
		      for(int i=0;i<likersmlist.size();i++){
		         if(likersmlist.get(i).get("LIKERSMNUM").equals(number)){
		            System.out.println("번호:\t"+likersmlist.get(i).get("LIKERSMNUM"));
		            System.out.println("제목:\t"+likersmlist.get(i).get("RESUME_TITLE"));
		            System.out.println("내용:\t"+likersmlist.get(i).get("RESUME_CON"));
		            System.out.println("작성자:\t"+likersmlist.get(i).get("ALBA_NAME"));
		            System.out.println("우대조건:\t"+likersmlist.get(i).get("JOB_NAME"));
		            System.out.println("작성일:\t"+likersmlist.get(i).get("RESUME_DATE"));
		            dellikenum=likersmlist.get(i).get("RESUME_NO");
		         }
		      }
		      System.out.println("=================================================");
		      System.out.println("1.삭제 2.뒤로 돌아가기");
		      if(ScanUtil.nextInt()==1){
		         return View.DELLIKERSM;
		      }
		      
		      return View.BOARDLIKERSM;
		   }
		
		   //지원
		   public int applyrec() { 
		      
		      System.out.println("해당공고에 지원하시겠습니까?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         list = boardDao.myResume(Controller.loginUser.get("MEM_ID"));
		         int count = 1;
		         for (int i = 0; i < list.size(); i++) {
		            list.get(i).put("RESUME_NUM", count);
		            count++;
		         }
		         System.out.println("==================나의 이력서================");
		         System.out.println("번호\t제목\t작성일");
		         for (Map<String, Object> map : list) {
		            System.out.println("------------------------------------------");
		            System.out.println(map.get("RESUME_NUM") + "\t"
		                  + map.get("RESUME_TITLE") + "\t" + map.get("RESUME_DATE"));
		         }
		         System.out.println("=========================================");
		         Object resumeno=0;
		         System.out.print("지원할 이력서를 선택하세요: ");
		         int rsmnum=ScanUtil.nextInt();
		         for(int i=0;i<list.size();i++){
		            if(list.get(i).get("RESUME_NUM").equals(rsmnum)){
		               resumeno=list.get(i).get("RESUME_NO");
		            }
		         }
		      
		         int result=boardDao.recapply(resumeno,go);
		         if(result>0){
		            System.out.println("지원을 완료하였습니다");
		         }else{
		            System.out.println("지원에 실패하였습니다");
		         }
		         
		      }
		      return View.BOARDREC;
		   }
		   //지원 확인(기업회원)
		   List<Map<String, Object>>applylist=null;
		   public int checkapply() {
		      System.out.println("==============내게 온 이력서============");
		      System.out.println("번호\t제목\t작성자\t공고제목");
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
		      System.out.println("1.상세조회 2.마이페이지로 돌아가기 ");
		      if(ScanUtil.nextInt()==1){
		         return View.GETAPPLY;
		      }
		      return View.MYPAGE;
		   }
		   
		   //지원 확인-이력서 상세조회
		   static Object applynum=0;
		   static Object recruitnum=0;
		   public int getapply() {
		      System.out.print("조회할 이력서 번호 선택: ");
		      int number=ScanUtil.nextInt();
		      for(int i=0;i<applylist.size();i++){
		         if(applylist.get(i).get("APPLYNUM").equals(number)){
		            System.out.println("----------------------------------------");
		            System.out.println("번호:\t"+applylist.get(i).get("APPLYNUM"));
		            System.out.println("----------------------------------------");
		            System.out.println("제목:\t"+applylist.get(i).get("RESUME_TITLE"));
		            System.out.println("----------------------------------------");
		            System.out.println("내용:\t"+applylist.get(i).get("RESUME_CON"));
		            System.out.println("----------------------------------------");
		            System.out.println("작성자:\t"+applylist.get(i).get("ALBA_NAME"));
		            System.out.println("----------------------------------------");
		            System.out.println("우대사항:\t"+applylist.get(i).get("JOB_NAME"));
		            System.out.println("----------------------------------------");
		            System.out.println("작성일:\t"+applylist.get(i).get("RESUME_DATE"));
		            System.out.println("----------------------------------------");
		            System.out.println("공고제목:\t"+applylist.get(i).get("RECRUIT_TITLE"));
		            System.out.println("----------------------------------------");
		            applynum=applylist.get(i).get("RESUME_NO");
		            recruitnum=applylist.get(i).get("RECRUIT_NO");
		         }
		      }
		         System.out.println("1.삭제 2.목록으로 돌아가기");
		         if(ScanUtil.nextInt()==1){
		            return View.DELAPPLY;
		         }return View.CHECKAPPLY;
		      }
		      
		   
		   //나에게 온 이력서 삭제
		   public int delapply() {
		      System.out.println("내게 온 이력서 목록에서 삭제하시겠습니까?(Y/N)");
		      if(ScanUtil.nextLine().equals("Y")){
		         int result=boardDao.applydel(applynum,recruitnum);
		         if(result>0){
		            System.out.println("지원목록에서 이력서를 삭제하였습니다");
		         }else{
		            System.out.println("이력서 삭제에 실패하였습니다");
		         }
		      }
		      return View.CHECKAPPLY;
		   }


		   
	   //이력서 조회
	   Object selectNum = 0;

	   public int getmyrsm() {
	      System.out.print("조회하실 글번호를 선택하세요: ");
	      int number = ScanUtil.nextInt();

	      for (int i = 0; i < list.size(); i++) {
	         if (list.get(i).get("RESUME_NUM").equals(number)) {
	            selectNum = list.get(i).get("RESUME_NO");
	            System.out.println("----------------------------------");
	            System.out.println("번호 : \t" + list.get(i).get("RESUME_NUM"));
	            System.out.println("----------------------------------");
	            System.out.println("제목 : \t" + list.get(i).get("RESUME_TITLE"));
	            System.out.println("----------------------------------");
	            System.out.println("내용 : \t" + list.get(i).get("RESUME_CON"));
	            System.out.println("----------------------------------");
	            System.out.println("우대사항 : \t" + list.get(i).get("JOB_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("작성자 : \t" + list.get(i).get("ALBA_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("등록일: \t" + list.get(i).get("RESUME_DATE"));
	            System.out.println("----------------------------------");

	         }

	      }
	      System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");
	      switch (ScanUtil.nextInt()) {
	      case 1:
	         return View.EDITRSM;
	      case 2:
	         return View.DELRSM;

	      }
	      return View.MYRSM;

	   }
	   //이력서 수정
	   public int editrsm() {
	      System.out.println("제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.println("내용: ");
	      String content = ScanUtil.nextLine();
	      System.out.print("대학생:13\t장애:14\t중장년:15\t청소년:16\t주부:17\n우대사항: ");
	      String jobCode = ScanUtil.nextLine();
	      int result = boardDao.againresume(title, content, jobCode, selectNum);
	      if (result > 0) {
	         System.out.println("이력서가 수정되었습니다");
	      } else {
	         System.out.println("이력서 수정에 실패하였습니다");
	      }

	      return View.MYRSM;

	   }
	   //이력서 삭제
	   public int delrsm() {
	      System.out.println("이력서를 정말 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.deleteresume(selectNum);
	         if (result > 0) {
	            System.out.println("이력서가 삭제되었습니다");
	         } else {
	            System.out.println("이력서 삭제에 실패하였습니다");
	         }
	      }
	      return View.MYRSM;

	   }
	   //나의 정보
	   public int myinfo() {
	      System.out.println("1.비밀번호 변경 2.상세정보 변경 3.회원탈퇴 4.마이페이지로 돌아가기");
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

	   // 공고 조회
	   public int getrec() {
	      System.out.print("조회하실 공고 번호를 선택하세요: ");
	      int input = ScanUtil.nextInt();
	      Map<String, Object> board = boardDao.getrec(input);
	      System.out.println("----------------------------------");
	      System.out.println("번호 : \t" + board.get("RECRUIT_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("제목 : \t" + board.get("RECRUIT_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("근무처명 : \t" + board.get("COMPANY_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("공고등록일 : " + board.get("RECRUIT_START"));
	      System.out.println("----------------------------------");
	      System.out.println("공고마감일 : " + board.get("RECRUIT_END"));
	      System.out.println("----------------------------------");
	      System.out.println("근무지 주소 : " + board.get("WORK_ADDR"));
	      System.out.println("----------------------------------");
	      System.out.println("근무시간 : \t" + board.get("WORK_TIME"));
	      System.out.println("----------------------------------");
	      System.out.println("근무기간 : \t" + board.get("WORK_TERM"));
	      System.out.println("----------------------------------");
	      System.out.println("시급 : \t" + board.get("WORK_PAY"));
	      System.out.println("----------------------------------");
	      System.out.println("담당업무 : \t" + board.get("WORK_JOB"));
	      System.out.println("----------------------------------");
	      System.out.println("근무지 전화 : " + board.get("WORK_TEL"));
	      System.out.println("----------------------------------");
	      System.out.println("업종 : \t" + board.get("JOB_NAME"));
	      System.out.println("----------------------------------");
	      go=board.get("RECRUIT_NO");
	      // 관리자의 경우 공고 삭제 가능
	      if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            || Controller.loginUser.get("MEM_ID").equals(
	                  board.get("MEM_ID"))) {
	         System.out.println("1.삭제 2.목록으로 돌아가기");
	         if (ScanUtil.nextInt() == 1) {
	            return View.DELREC;
	         }
	      } else if (Controller.loginUser.get("MEM_TYPE").equals("2")) {
	         System.out.println("1.관심공고 등록 2.지원하기 3.목록으로 돌아가기");
	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.LIKEREC;
	         case 2:
	            return View.APPLYREC;
	         }
	      } else {
	         System.out.println("목록으로 돌아가시겠습니까?(Y/N)");
	         if (!ScanUtil.nextLine().equals("Y")) {
	            return View.GETREC;
	         }
	      }
	      return View.BOARDREC;
	   }
	   //관심공고 등록
	   public int likerec() {
	      System.out.println("해당 공고를 관심목록에 등록할까요?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {

	         int result = boardDao.addlike(go,
	               Controller.loginUser.get("MEM_ID"));
	         if (result > 0) {
	            System.out.println("공고를 내 관심목록에 추가하였습니다");
	            return View.BOARDREC;
	         } else {
	            System.out.println("관심목록 추가에 실패하였습니다");
	         }
	      }
	      return View.GETREC;

	   }
	   //관심공고 목록
	   List<Map<String, Object>> likelist = null;

	   public int boardlikerec() {
	      System.out.println("===========내가 찜한 공고==========");
	      likelist=null;
	      likelist = boardDao.recuritlike(Controller.loginUser.get("MEM_ID"));
	      int count = 1;
	      for (int i = 0; i < likelist.size(); i++) {
	         likelist.get(i).put("LIKE_NUM", count);
	         count++;
	      }
	      System.out.println("번호\t제목\t고용주\t채용마감일");
	      for (Map<String, Object> map : likelist) {
	         System.out.println("------------------------------------------");
	         System.out.println(map.get("LIKE_NUM") + "\t"
	               + map.get("RECRUIT_TITLE") + "\t" + map.get("COMPANY_NAME")
	               + "\t" + map.get("RECRUIT_END"));
	      }
	      System.out.println("======================================");
	      System.out.println("1.상세조회 2.마이페이지로 돌아가기");
	      if (ScanUtil.nextInt() == 1) {
	         return View.GETLIKE;
	      }
	      return View.MYPAGE;
	   }
	   //관심공고 상세보기
	   static Object likenumber = 0;

	   public int getlike() {
	      System.out.println("조회할 글 번호를 선택하세요: ");
	      int selectLike = ScanUtil.nextInt();
	      for (int i = 0; i < likelist.size(); i++) {
	         if (likelist.get(i).get("LIKE_NUM").equals(selectLike)) {
	            likenumber = likelist.get(i).get("RECRUIT_NO");
	            System.out.println("----------------------------------");
	            System.out.println("번호 : \t" + likelist.get(i).get("LIKE_NUM"));
	            System.out.println("----------------------------------");
	            System.out.println("제목 : \t"
	                  + likelist.get(i).get("RECRUIT_TITLE"));
	            System.out.println("----------------------------------");
	            System.out.println("근무처명 : \t"
	                  + likelist.get(i).get("COMPANY_NAME"));
	            System.out.println("----------------------------------");
	            System.out.println("공고등록일 : "
	                  + likelist.get(i).get("RECRUIT_START"));
	            System.out.println("----------------------------------");
	            System.out.println("공고마감일 : "
	                  + likelist.get(i).get("RECRUIT_END"));
	            System.out.println("----------------------------------");
	            System.out.println("근무지 주소 : "
	                  + likelist.get(i).get("WORK_ADDR"));
	            System.out.println("----------------------------------");
	            System.out.println("근무시간 : \t"
	                  + likelist.get(i).get("WORK_TIME"));
	            System.out.println("----------------------------------");
	            System.out.println("근무기간 : \t"
	                  + likelist.get(i).get("WORK_TERM"));
	            System.out.println("----------------------------------");
	            System.out.println("시급 : \t" + likelist.get(i).get("WORK_PAY"));
	            System.out.println("----------------------------------");
	            System.out.println("담당업무 : \t"
	                  + likelist.get(i).get("WORK_JOB"));
	            System.out.println("----------------------------------");
	            System.out.println("근무지 전화 : "
	                  + likelist.get(i).get("WORK_TEL"));
	            System.out.println("----------------------------------");
	         
	            System.out.println("1.삭제 2.목록으로 돌아가기");
	         }
	      }
	      if (ScanUtil.nextInt() == 1) {
	         return View.DELLIKE;
	      }
	      return View.BOARDLIKEREC;

	   }
	   //관심공고 삭제
	   public int dellike() {
	      System.out.println("찜한 공고를 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.deletelike(likenumber,Controller.loginUser.get("MEM_ID"));
	         if (result > 0) {
	            System.out.println("찜 목록에서 삭제하였습니다");
	         } else {
	            System.out.println("삭제에 실패하였습니다");
	         }
	      }
	      return View.BOARDLIKEREC;

	   }
	   //개인정보 변경
	   public int changedetail() {
	      System.out.println("주소: ");
	      String addr = ScanUtil.nextLine();
	      System.out.println("연락처('-'제외): ");
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
	         System.out.println("상세정보를 변경하였습니다");
	      } else {
	         System.out.println("상세정보 변경에 실패하였습니다");
	      }
	      return View.MYINFO;
	   }
	   //비밀번호 변경(유효성검사 포함)
	   public int changepw() {
	      String pw = null;
	      Matcher m = null;
	      String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$";
	      Pattern p = Pattern.compile(regex);
	      p = Pattern.compile(regex);
	      do {
	         System.out.print("변경할 비밀번호: ");
	         pw = ScanUtil.nextLine();
	         m = p.matcher(pw);
	         if (m.equals(false)) {
	            System.out.println("최소 8자리에 숫자, 문자, 특수문자 각각 1개 이상 포함해야 합니다");
	         }
	      } while (m.equals(false));
	      int result = boardDao.changepw(pw, Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("비밀번호가 변경되었습니다");
	      } else {
	         System.out.println("비밀번호 변경에 실패하였습니다");
	      }
	      return View.MYINFO;

	   }
	   // 1:1 상담 게시판
	   public int boardinq() { 

	      List<Map<String, Object>> boardlist = boardDao.inquireboard();

	      System.out.println("==========================================");
	      System.out.println("번호\t제목\t\t작성자 ID");

	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------------");
	         System.out.println(board.get("INQ_NO") + "\t"
	               + board.get("INQ_TITLE") + "\t" + board.get("MEM_ID")
	               + "\t");
	      }
	      System.out.println("=========================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {
	         System.out.println("1.조회 2.되돌아가기");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETINQ;
	         }
	      }

	         else {

	            System.out.println("1.조회  2.1:1상담글 작성 3. 되돌아가기");

	            switch (ScanUtil.nextInt()) {
	            case 1:
	               return View.GETINQ;
	            case 2:
	               return View.WRITEINQ;

	            }

	         }
	      return View.MAINMENU;
	   }
	      
	      
	   //1:1문의 조회
	   public int getinq() {
	       System.out.println("조회할 글 번호를 입력해주세요.");
	       number = ScanUtil.nextInt();
	       Map<String, Object> board = boardDao.getinq(number);
	       
	       //1:1문의에서 자기글이 아닌데 조회되는 부분 수정 **********************************************
	       if((!(Controller.loginUser.get("MEM_TYPE").equals("3"))&&!(board.get("MEM_ID").equals(Controller.loginUser.get("MEM_ID"))))){
	          System.out.println("조회할 수 없습니다.");
	             return View.BOARDINQ;
	       }
	       System.out.println("----------------------------------");
	       System.out.println("번호 : \t" + board.get("INQ_NO"));
	       System.out.println("----------------------------------");
	       System.out.println("1:1제목 : \t" + board.get("INQ_TITLE"));
	       System.out.println("----------------------------------");
	       System.out.println("1:1내용 : \t" + board.get("INQ_CON"));
	       System.out.println("----------------------------------");
	       // 답변 null일 경우 수정완**********************************************************************************************************
	       if(!(board.get("INQ_ANS")==null)){
	 
	       System.out.println("1:1답변 : \t" + board.get("INQ_ANS"));
	       System.out.println("----------------------------------");
	     
	       }else{
	          System.out.println("1:1답변:\t아직 답변이 달리지 않았습니다.");
	          System.out.println("----------------------------------");
	       }
	          
	       
	       if (board.get("MEM_ID").equals(Controller.loginUser.get("MEM_ID"))) {
	          System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");
	          int input = ScanUtil.nextInt();
	          switch (input) {
	          case 1:
	             return View.EDITINQ; //수정화면으로 가는거 수정완***********************
	          case 2:
	             return View.DELINQ;
	          }
	          
	          
	       } else {
	          Map<String, Object> boards = boardDao.getinq(number);
	          if(board.get("INQ_ANS")==null){ //답변완료되었으면 답변 못하게 수정완***********************************
	             System.out.println("1.답변 2.목록으로 돌아가기");
	             if (ScanUtil.nextInt() == 1) {
	                return View.ANSINQ;
	             }    
	          }
	         
	       }
	       
	       System.out.println("목록으로 돌아가시겠습니까?(Y/N)");
	       if (ScanUtil.nextLine().equals("Y")) {
	          return View.BOARDINQ;

	       }
	       return View.BOARDINQ;

	    }

	   //1:1문의 작성
	   public int writeinq() {
	      System.out.println("=============1:1 상담 작성==============");
	      System.out.print("제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("내용: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.writeinq(title, content,
	            Controller.loginUser.get("MEM_ID"));
	      if (result > 0) {
	         System.out.println("게시글이 등록되었습니다");
	      } else {
	         System.out.println("게시글 등록에 실패하였습니다");
	      }
	      return View.BOARDINQ;
	   }
	   
	   //1:1 상담글 수정
	   public int editinq() { 
	      System.out.print("수정할 제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("수정할 내용: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.inqagain(title, content, number);
	      if (result > 0) {
	         System.out.println("게시글이 수정되었습니다");
	      } else {
	         System.out.println("게시글 수정에 실패하였습니다");
	      }
	      return View.BOARDINQ;
	   }
	   // 매니저가 답변
	   public int ansinq() {
	      System.out.println("=============1:1 상담 답변==============");
	      System.out.print("답변: ");
	      String anw = ScanUtil.nextLine();
	      int result = boardDao.inqanw(number, anw,
	            Controller.loginUser.get("MEM_ID")); //
	      if (result > 0) {
	         System.out.println("답변이 완료되었습니다.");
	      } else {
	         System.out.println("답변을 실패하였습니다.");
	      }
	      return View.BOARDINQ;
	   }
	   // 공지 게시판
	   public int boardnote() {
	      List<Map<String, Object>> boardlist = boardDao.getNoboard();
	      System.out.println("=============================================================");
	      System.out.println("번호\t제목\t\t\t작성자\t등록일");
	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------------------------------");
	         System.out.println(board.get("NOTICE_NO") + "\t"
	               + board.get("NOTICE_TITLE") + "\t"        
	               + board.get("MANAGER_NAME") + "\t"
	               + board.get("NOTICE_DATE"));
	      }
	      System.out.println("==============================================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) { // 매니저면
	         System.out.println("1.조회 2.공지작성  0.메뉴로");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.GETNOTE;
	         case 2:
	            return View.WRITENOTE;

	         }

	      }

	      else {// 알바 기업임
	         System.out.println("1.조회 0.메뉴로 돌아가기 ");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETNOTE;
	         }
	      }
	      return View.MAINMENU;
	   }

	   static int num = 0;
	// 공지 작성
	   public int writenote() { 
	      System.out.println("=============공지 작성==============");

	      System.out.println("공지사항 제목:");
	      String noticetitle = ScanUtil.nextLine();
	      System.out.println("공지사항 내용:");
	      String noticecontent = ScanUtil.nextLine();

	      int result = boardDao.noticewrite(noticetitle, noticecontent,
	            Controller.loginUser.get("MANAGER_ID"));

	      if (result > 0) {
	         System.out.println("게시글이 등록되었습니다");
	      } else {
	         System.out.println("게시글 등록에 실패하였습니다");
	      }

	      return View.BOARDNOTE;

	   }

	   public int getnote() { // 공지조회
	      System.out.print("조회하실 글 번호를 선택하세요: ");
	      number = ScanUtil.nextInt();

	      Map<String, Object> board = boardDao.getno(number);
	      System.out.println("----------------------------------");
	      System.out.println("번호 : \t" + board.get("NOTICE_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("제목 : \t" + board.get("NOTICE_TITLE"));
	      System.out.println("----------------------------------");
	      System.out.println("내용 : \t" + board.get("NOTICE_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("작성자 : \t" + board.get("MANAGER_NAME"));
	      System.out.println("----------------------------------");
	      System.out.println("등록일: \t" + board.get("NOTICE_DATE"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")
	            && Controller.loginUser.get("MANAGER_ID").equals(
	                  board.get("MANAGER_ID"))) {
	         System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");
	         int input = ScanUtil.nextInt();
	         switch (input) {
	         case 1:
	            return View.EDITNOTE;
	         case 2:
	            return View.DELNOTE;
	         }

	      } else {
	         System.out.println("목록으로 돌아가시겠습니까?(Y/N)");
	         if (ScanUtil.nextLine().equals("Y")) {
	            return View.BOARDNOTE;
	         }
	      }
	      return View.BOARDNOTE;
	   }

	   public int editnote() { // 공지수정

	      System.out.print("제목: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("내용: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.noagain(title, content, number);
	      if (result > 0) {
	         System.out.println("게시글이 수정되었습니다");
	      } else {
	         System.out.println("게시글 수정에 실패하였습니다");
	      }
	      return View.BOARDNOTE;

	   }

	   public int delnote() { // 공지삭제
	      System.out.println("정말 게시물을 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.nodelete(number);
	         if (result > 0) {
	            System.out.println("게시물을 삭제하였습니다");
	         } else {
	            System.out.println("게시물 삭제에 실패하였습니다");
	         }
	      }
	      return View.BOARDNOTE;
	   }

	   public int boardqna() {
	      List<Map<String, Object>> boardlist = boardDao.getQnaboard();
	      System.out.println("==========================================");
	      System.out.println("번호\t자주묻는질문");

	      for (Map<String, Object> board : boardlist) {

	         System.out.println("----------------------------------");
	         System.out.println(board.get("QNA_NO") + "\t"
	               + board.get("QNA_CON") + "\t");
	      }

	      System.out.println("=====================================");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {// 매니저면
	         System.out.println("1.조회 2. 자주묻는 글 작성  0.메뉴로 돌아가기");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.GETQNA;
	         case 2:
	            return View.WRITEQNA;

	         }

	      } else { // 알바.기업이면
	         System.out.println("1.조회 0.메뉴로 돌아가기 ");
	         if (ScanUtil.nextInt() == 1) {
	            return View.GETQNA;
	         }
	      }
	      return View.MAINMENU;

	   }

	   public int getqna() { // 자주묻는질문 조회
	      System.out.print("조회하실 글 번호를 선택하세요: ");
	      number = ScanUtil.nextInt();

	      Map<String, Object> board = boardDao.getQna(number);
	      System.out.println("----------------------------------");
	      System.out.println("번호 : \t" + board.get("QNA_NO"));
	      System.out.println("----------------------------------");
	      System.out.println("자주묻는 질문  : \t" + board.get("QNA_CON"));
	      System.out.println("----------------------------------");
	      System.out.println("답변 : \t" + board.get("QNA_ANSWER"));
	      System.out.println("----------------------------------");

	      if (Controller.loginUser.get("MEM_TYPE").equals("3")) {
	         System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");

	         switch (ScanUtil.nextInt()) {
	         case 1:
	            return View.EDITQNA;
	         case 2:
	            return View.DELQNA;

	         }
	      } else {
	         System.out.println("목록으로 돌아가시겠습니까?(Y/N)");
	         if (!ScanUtil.nextLine().equals("Y")) {
	            return View.GETQNA;
	         }

	      }
	      return View.BOARDQNA;

	   }

	   public int writeqna() { // 자주묻는 질문작성

	      System.out.println("=============자주묻는 질문 작성==============");
	      System.out.println("자주묻는 질문:");
	      String q = ScanUtil.nextLine();
	      System.out.println("답변:");
	      String a = ScanUtil.nextLine();

	      int result = boardDao.qnawrite(q, a);
	      System.out.println(result);
	      if (result > 0) {
	         System.out.println("게시글이 등록되었습니다");
	      } else {
	         System.out.println("게시글 등록에 실패하였습니다");
	      }

	      return View.BOARDQNA;

	   }

	   public int editqna() { // 자주묻는 질문 수정
	      System.out.print("자주묻는질문: ");
	      String title = ScanUtil.nextLine();
	      System.out.print("답변: ");
	      String content = ScanUtil.nextLine();
	      int result = boardDao.qnaagain(title, content, number);
	      if (result > 0) {
	         System.out.println("게시글이 수정되었습니다");
	      } else {
	         System.out.println("게시글 수정에 실패하였습니다");
	      }
	      return View.BOARDQNA;
	   }

	   public int delqna() { // 자주묻는 질문 삭제

	      System.out.println("정말 게시물을 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.qnadelete(number);
	         if (result > 0) {
	            System.out.println("게시물을 삭제하였습니다");
	         } else {
	            System.out.println("게시물 삭제에 실패하였습니다");
	         }
	      }
	      return View.BOARDQNA;
	   }

	   public int delinq() {
	      System.out.println("정말 문의을 삭제하시겠습니까?(Y/N)");
	      if (ScanUtil.nextLine().equals("Y")) {
	         int result = boardDao.inqdelete(number);
	         if (result > 0) {
	            System.out.println("게시물을 삭제하였습니다");
	         } else {
	            System.out.println("게시물 삭제에 실패하였습니다");
	         }
	      }
	      return View.BOARDINQ;
	   }

	   public int meminfo() { // 회원관리
	      System.out.println("1.일반회원정보 2.기업회원정보 3.메뉴으로 되돌아가기 ");

	      switch (ScanUtil.nextInt()) {
	      case 1:
	         return View.ALBAINFO;
	      case 2:
	         return View.COMINFO;

	      }
	      System.out.println("메뉴로 돌아가시겠습니까?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.MAINMENU;
	      }
	      return View.MAINMENU;

	   }

	   public int albainfo() { // 알바회원정보조회
	      List<Map<String, Object>> boardlist = boardDao.albainfo();
	      System.out
	            .println("==================================================================================");
	      System.out
	            .println("    아이디\t\t비밀번호\t\tTYPE\t이름\t생년월일\t\t\t주소\t\t연락처\t\t\t성별");
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

	      System.out.println("1.되돌아가기 2.메인메뉴로 돌아가기");
	      if (ScanUtil.nextInt() == 1) {
	         return View.MEMINFO;
	      }

	      System.out.println("메인메뉴로 돌아가시겠습니까?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.ALBAINFO;
	      }

	      return View.MAINMENU;

	   }

	   public int cominfo() { // 기업회원정보조회
	      List<Map<String, Object>> boardlist = boardDao.cominfo();
	      System.out
	            .println("==================================================================================");
	      System.out
	            .println("아이디\t\t비밀번호\t\tTYPE\t업체명\t\t대표자이름\t\t본사주소\t\t\t\t\t본사전화번호");
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

	      System.out.println("1.되돌아가기 2.메인메뉴로 돌아가기");
	      if (ScanUtil.nextInt() == 1) {
	         return View.MEMINFO;
	      }

	      System.out.println("메인메뉴로 돌아가시겠습니까?(Y/N)");
	      if (!ScanUtil.nextLine().equals("Y")) {
	         return View.COMINFO;
	      }

	      return View.MAINMENU;

	   }
	   
	   //공고 목록
	    public int boardrec() {
	        List<Map<String, Object>> boardlist = boardDao.getRecruitboard();
	        System.out.println("==========================================");
	        System.out.println("번호\t공고 제목\t업체명\t등록일");
	        for (Map<String, Object> board : boardlist) {

	           System.out.println("----------------------------------");
	           System.out.println(board.get("RECRUIT_NO") + "\t"
	                 + board.get("RECRUIT_TITLE") + "\t"
	                 + board.get("COMPANY_NAME") + "\t"
	                 + board.get("RECRUIT_START"));
	        }
	        System.out.println("=====================================");

	        System.out.println("1.조회  2.분류별 조회 3.메뉴로 돌아가기 ");
	    
	        switch (ScanUtil.nextInt()) {
	        case 1:
	           return View.GETREC;
	        case 2:   
	          return View.RECRUITFILTER;
	        }
	        return View.MAINMENU;
	     }
	    
	    //공고 필터링
	    public int recruitfilter() {
	       System.out.println("분류별 조회를 위한 항목을 골라주세요.");
	        System.out.println("1.지역별 조회 2.업종별 조회 3.근무시간별 조회 4.기간별 조회 5.메뉴로 돌아가기 ");
	     
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
	    //공고 필터링-지역별
	    public int recfilteraddr() {
	       System.out.println("[지역 분류]\n서울\t경기\t인천\t강원\t충남\t대전\n"
	             + "충북\t부산\t울산\t대구\t경북\t경남\n"
	             + "전남\t광주\t전북\t제주");
	       System.out.println("지역을 입력하세요. ex)서울\n: ");
	       String region = ScanUtil.nextLine();
	       List<Map<String, Object>> boardlist = boardDao.recfilteraddr(region);
	       System.out.println("==========================================");
	       System.out.println("번호\t제목\t업체명\t등록일");
	       for (Map<String, Object> board : boardlist) {
	          System.out.println("----------------------------------");
	          System.out.println(board.get("RECRUIT_NO") + "\t"
	                + board.get("RECRUIT_TITLE") + "\t"
	                + board.get("COMPANY_NAME") + "\t" 
	                + board.get("RECRUIT_START"));
	       }
	       System.out.println("=====================================");

	       System.out.println("1.조회 2. 전체 채용공고 목록으로 돌아가기 ");
	       if(ScanUtil.nextInt()==1){
	          return View.GETREC;
	       }
	  
	       return View.BOARDREC;
	    }

	    //공고 필터링-업종별
	    public int recfilterjob() {
	       System.out.println("[업종코드 목록]\n외식/음료:1\t유통/판매:2\t문화/생활:3\t서비스:4\n"
	            + "사무/회계:5\t상담/영업:6\t생산/건설:7\tIT/인터넷:8\n"
	            + "교육/강사:9\t디자인/미디어:10\t운전/배달:11\t병원/연구:12");
	       System.out.println("업종코드를 입력하세요:");
	       int jobcode = ScanUtil.nextInt();
	          List<Map<String, Object>> boardlist = boardDao.recfilterjob(jobcode);
	          System.out.println("==========================================");
	          System.out.println("번호\t제목\t업체명\t등록일");
	          for (Map<String, Object> board : boardlist) {
	             System.out.println("----------------------------------");
	             System.out.println(board.get("RECRUIT_NO") + "\t"
	                   + board.get("RECRUIT_TITLE") + "\t"
	                   + board.get("COMPANY_NAME") + "\t" 
	                   + board.get("RECRUIT_START"));
	          }
	          System.out.println("=====================================");

	          System.out.println("1. 조회 2. 전체 채용공고 목록으로 돌아가기 ");
	          if(ScanUtil.nextInt()==1){
	             return View.GETREC;
	          }
	          return View.BOARDREC;
	       }
	    //공고 필터링-시간별    
	    public int recfiltertime() {
	       System.out.println("[근무시간 구분]\n오전 : 06:00~12:00\t오후 : 12:00~22:00\t야간 : 22:00~06:00");
	        System.out.println("희망 시간대를 선택하세요.(오전:1\t오후:2\t야간:3");
	        int worktime = ScanUtil.nextInt();
	          List<Map<String, Object>> boardlist = boardDao.recfiltertime(worktime);
	           System.out.println("==========================================");
	           System.out.println("번호\t제목\t업체명\t등록일");
	           for (Map<String, Object> board : boardlist) {
	              System.out.println("----------------------------------");
	              System.out.println(board.get("RECRUIT_NO") + "\t"
	                    + board.get("RECRUIT_TITLE") + "\t"
	                    + board.get("COMPANY_NAME") + "\t" 
	                    + board.get("RECRUIT_START"));
	           }
	           System.out.println("=====================================");

	           System.out.println("1. 조회 2. 전체 채용공고 목록으로 돌아가기 ");
	           if(ScanUtil.nextInt()==1){
	              return View.GETREC;
	           }      
	           return View.BOARDREC;
	        }
	    //공고 필터링-기간별 
	   public int recfilterterm() {
	      System.out.println("[근무기간 구분]\n단기 : 0개월 1일~1개월 미만 \t중기 : 1개월 이상 ~6개월 미만\t장기 : 6개월 이상");
	       System.out.println("희망 근무기간을 선택하세요.(단기:1\t중기:2\t장기:3)");
	       int workterm = ScanUtil.nextInt();
	         List<Map<String, Object>> boardlist = boardDao.recfilterterm(workterm);
	          System.out.println("==========================================");
	          System.out.println("번호\t제목\t업체명\t등록일");
	          for (Map<String, Object> board : boardlist) {
	             System.out.println("----------------------------------");
	             System.out.println(board.get("RECRUIT_NO") + "\t"
	                   + board.get("RECRUIT_TITLE") + "\t"
	                   + board.get("COMPANY_NAME") + "\t" 
	                   + board.get("RECRUIT_START"));
	          }
	          System.out.println("=====================================");

	          System.out.println("1. 조회 2. 전체 채용공고 목록으로 돌아가기 ");
	          if(ScanUtil.nextInt()==1){
	             return View.GETREC;
	          }      
	          return View.BOARDREC;
	       }
	  
	    //공고 등록
	    public int writerec(){
	       System.out.println("=============채용공고 작성==============");
	       System.out.println("제목:");
	       String recruittitle = ScanUtil.nextLine();
	       System.out.println("근무지 주소:");
	       String workaddr = ScanUtil.nextLine();
	       System.out.println("근무시간('00:00~00:00'형태로 입력):");
	       String worktime = ScanUtil.nextLine();
	       System.out.println("근무기간('_개월_일' 형태로 입력):");
	       String workterm = ScanUtil.nextLine();
	       System.out.println("시급:");
	       String workpay = ScanUtil.nextLine();
	       System.out.println("담당업무:");
	       String workjob = ScanUtil.nextLine();
	       System.out.println("공고마감일('YYYY/MM/DD' 형태로 입력):");
	       String recruitend = ScanUtil.nextLine();
	       System.out.println("근무지전화번호(')'혹은'-'포함\n예시)042)881-1234:");
	       String worktel = ScanUtil.nextLine();
	       System.out.println("[업종코드 목록]\n외식/음료:1\t유통/판매:2\t문화/생활:3\t서비스:4\n"
	                   + "사무/회계:5\t상담/영업:6\t생산/건설:7\tIT/인터넷:8\n"
	                   + "교육/강사:9\t디자인/미디어:10\t운전/배달:11\t병원/연구:12");
	       System.out.println("업종코드:");
	       int jobcode = ScanUtil.nextInt();
	       
	       int result=boardDao.writeRecruit(recruittitle,workaddr,worktime,workterm,workpay,workjob,recruitend,
	             worktel,jobcode,Controller.loginUser.get("MEM_ID"));
	       if(result>0){
	          System.out.println("채용공고가 등록되었습니다");
	       }
	       else{
	          System.out.println("채용공고 등록에 실패하였습니다");
	       }
	       return View.BOARDREC;
	    }
	    //내가 쓴 공고 목록
	    static List<Map<String, Object>> myreclist=null;
	    public int myrec() {
	     myreclist=boardDao.myrec(Controller.loginUser.get("MEM_ID"));
	     int count=1;
	     for(int i=0;i<myreclist.size();i++){
	       myreclist.get(i).put("RECRUIT_NUM",count);
	       count++;
	     }
	     System.out.println("==================나의 채용공고================");
	     System.out.println("번호\t제목\t등록일");
	     for(Map<String, Object>map:myreclist){
	        System.out.println("------------------------------------------");
	        System.out.println(map.get("RECRUIT_NUM")+"\t"+map.get("RECRUIT_TITLE")+"\t"+map.get("RECRUIT_START"));
	     }
	     System.out.println("=========================================");
	     System.out.println("1.조회 2.메인 메뉴로 돌아가기");
	  if(ScanUtil.nextInt()==1){
	     return View.GETMYREC;
	  }
	           return View.MAINMENU;
	    }
	    //내가 쓴 공고 조회
	    Object choiceNum=0;
	    public int getmyrec() {
	       System.out.print("조회하실 글번호를 선택하세요: ");
	       int myrecnumber=ScanUtil.nextInt();
	       
	        for(int i=0;i<myreclist.size();i++){
	          if(myreclist.get(i).get("RECRUIT_NUM").equals(myrecnumber)){
	             choiceNum=myreclist.get(i).get("RECRUIT_NO");
	               System.out.println("----------------------------------");
	               System.out.println("번호 : \t"+myreclist.get(i).get("RECRUIT_NUM"));
	               System.out.println("----------------------------------");
	               System.out.println("제목 : \t"+myreclist.get(i).get("RECRUIT_TITLE"));
	               System.out.println("----------------------------------");
	               System.out.println("근무처명 : \t"+ myreclist.get(i).get("COMPANY_NAME"));
	               System.out.println("----------------------------------");
	               System.out.println("공고등록일 : "+ myreclist.get(i).get("RECRUIT_START"));
	               System.out.println("----------------------------------");
	               System.out.println("공고마감일 : "+ myreclist.get(i).get("RECRUIT_END"));
	               System.out.println("----------------------------------");
	               System.out.println("근무지 주소 : "+ myreclist.get(i).get("WORK_ADDR"));
	               System.out.println("----------------------------------");
	               System.out.println("근무시간 : \t"+ myreclist.get(i).get("WORK_TIME"));
	               System.out.println("----------------------------------");
	               System.out.println("근무기간 : \t"+ myreclist.get(i).get("WORK_TERM"));
	               System.out.println("----------------------------------");
	               System.out.println("시급 : \t"+ myreclist.get(i).get("WORK_PAY"));
	               System.out.println("----------------------------------");
	               System.out.println("담당업무 : \t"+ myreclist.get(i).get("WORK_JOB"));
	               System.out.println("----------------------------------");
	               System.out.println("근무지 전화 : "+ myreclist.get(i).get("WORK_TEL"));
	               System.out.println("----------------------------------");
	               System.out.println("업종 : \t"+myreclist.get(i).get("JOB_NAME"));
	               System.out.println("----------------------------------");
	          }
	             
	          }
	        System.out.println("1.수정 2.삭제 3.목록으로 돌아가기");
	        switch(ScanUtil.nextInt()){
	        case 1: return View.EDITREC;
	        case 2: return View.DELREC;
	        }
	        return View.MYREC;
	     }
	    
	    //공고 수정
	    public int editrec() {
	       System.out.println("제목:");
	        String recruittitle = ScanUtil.nextLine();
	        System.out.println("근무지:");
	        String workaddr = ScanUtil.nextLine();
	        System.out.println("근무시간:");
	        String worktime = ScanUtil.nextLine();
	        System.out.println("근무기간('_개월_일' 형태로 입력):");
	        String workterm = ScanUtil.nextLine();
	        System.out.println("시급:");
	        String workpay = ScanUtil.nextLine();
	        System.out.println("담당업무:");
	        String workjob = ScanUtil.nextLine();
	        System.out.println("[업종코드 목록]\n외식/음료:01\t유통/판매:02\t문화/생활:03\t서비스:04\n"
	             + "사무/회계:05\t상담/영업:06\t생산/건설:07\tIT/인터넷:08\n"
	             + "교육/강사:09\t디자인/미디어:10\t운전/배달:11\t병원/연구:12");
	        System.out.println("업종코드:");
	        int jobcode = ScanUtil.nextInt();
	        System.out.println("근무지전화번호:");
	        String worktel = ScanUtil.nextLine();
	        System.out.println("공고마감일:");
	        String recruitend = ScanUtil.nextLine();
	                     
	        int result=boardDao.recruitagain(recruittitle,workaddr,worktime,workterm,workpay,workjob,
	              jobcode,worktel,recruitend,choiceNum);
	        if(result>0){
	           System.out.println("채용공고가 수정되었습니다");
	        }
	        else{
	           System.out.println("채용공고 수정에 실패하였습니다");
	        }
	        return View.MYREC;
	    }
	    
	    //공고 삭제
	    public int delrec() {
	       System.out.println("채용공고를 정말 삭제하시겠습니까?(Y/N)");
	       if(ScanUtil.nextLine().equals("Y")){
	          int result=boardDao.deleterecruit(number);
	          if(result>0){
	             System.out.println("채용공고가 삭제되었습니다");
	          }else{
	             System.out.println("채용공고 삭제에 실패하였습니다");
	          }
	       }
	       return View.BOARDREC;
	    }
	    
	    

