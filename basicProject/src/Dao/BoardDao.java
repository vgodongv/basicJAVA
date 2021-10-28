package Dao;

import java.util.ArrayList;
import java.util.Map;

import Util.JDBCUtil;

public class BoardDao {
	private BoardDao(){}
    private static BoardDao instance;
    public static BoardDao getInstance() {
       if(instance==null){
          instance=new BoardDao();
       }
       return instance;
    }
    
    JDBCUtil jdbc=JDBCUtil.getInstance();
    //후기목록
    public List<Map<String, Object>> getReboard() {
    String sql="SELECT A.REVIEW_NO,A.REVIEW_TITLE, A.REVIEW_CON, A.REVIEW_REG,B.ALBA_NAME"
          +"    FROM REVIEW A"
          +"    LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
          +"   ORDER BY A.REVIEW_NO DESC ";
    return jdbc.selectList(sql);
    
    }
    //후기 조회
    public Map<String, Object> getre(int number) {
       String sql="SELECT A.REVIEW_NO,A.REVIEW_TITLE, A.REVIEW_CON, A.REVIEW_REG,B.ALBA_NAME,B.MEM_ID"
             +"    FROM REVIEW A"
             +"    LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
             +"   WHERE A.REVIEW_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(number);
       return jdbc.selectOne(sql,list);
    }
    //후기 작성
    public int writere(String title, String content,Object user) {
       String sql="INSERT INTO REVIEW VALUES((SELECT NVL(MAX(REVIEW_NO),0)+1 FROM REVIEW)"
             + " ,?"
             + " ,?"
             + " ,SYSDATE"
             +"  ,(SELECT MEM_ID FROM ALBA WHERE ALBA.MEM_ID=?))";
       ArrayList<Object> list = new ArrayList<>();
       list.add(title);
       list.add(content);
       list.add(user);
       return jdbc.update(sql, list);
     }
    //후기 수정
    public int reagain(String title,String content,int number) {
       String sql="UPDATE REVIEW SET REVIEW_TITLE=?,REVIEW_CON=?,REVIEW_REG=SYSDATE WHERE REVIEW_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(title);
       list.add(content);
       list.add(number);
       
       return jdbc.update(sql, list);
     }
    //후기 삭제
    public int redelete(int number) {
       String sql="DELETE FROM REVIEW WHERE REVIEW_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(number);
       return jdbc.update(sql, list);
    }
    //이력서 작성
    public int rsmwrite(String title, String content, String jobCode,Object userId) {
    String sql="INSERT INTO RESUME VALUES((SELECT NVL(MAX(RESUME_NO),0)+1 FROM RESUME)"
             + " ,?"
             + " ,?"
             + " ,(SELECT MEM_ID FROM ALBA WHERE ALBA.MEM_ID=?)"
             + " ,?"
             + " ,SYSDATE)"; 
    
    ArrayList<Object> list = new ArrayList<>();
    list.add(title);
    list.add(content);
    list.add(jobCode);
    list.add(userId);
   
    
    return jdbc.update(sql, list);
    
    }
    //나의 이력서 목록
    public List<Map<String, Object>> myResume(Object userId) {
       String sql="SELECT A.RESUME_NO,A.RESUME_TITLE, A.RESUME_CON, A.RESUME_DATE, B.ALBA_NAME,C.JOB_NAME"
             +"    FROM RESUME A"
             +"    LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
             +"    LEFT OUTER JOIN JOB C ON A.JOB_CODE=C.JOB_CODE"
             +"   WHERE A.MEM_ID=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(userId);
       return jdbc.selectList(sql,list);
       
    }
    //이력서 수정
    public int againresume(String title, String content, String jobCode,
          Object selectNum) {
       String sql="UPDATE RESUME SET RESUME_TITLE=?,RESUME_CON=?,JOB_CODE=?,RESUME_DATE=SYSDATE WHERE RESUME_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(title);
       list.add(content);
       list.add(jobCode);
       list.add(selectNum);
       return jdbc.update(sql, list);   
    }
    //이력서 삭제
    public int deleteresume(Object selectNum) {
       String sql="DELETE FROM RESUME WHERE RESUME_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(selectNum);
       return jdbc.update(sql, list);
       
    }
 
    //공고 작성
        public int writeRecruit(String recruittitle,String workaddr,String worktime,String workterm,String workpay,String workjob,String recruitend,
              String worktel,int jobcode,Object user){
           String sql="INSERT INTO RECRUIT VALUES((SELECT NVL(MAX(RECRUIT_NO),0)+1 FROM RECRUIT)"
                     + " ,?"
                     + " ,?"
                     + " ,?"
                     + " ,?"
                     + " ,?"
                     + " ,?"
                     + " ,(SELECT MEM_ID FROM OWNER WHERE OWNER.MEM_ID=?)"
                     + " ,?"
                     + " ,?"
                     + " ,SYSDATE"
                     +"  ,?)";
               List<Object> list = new ArrayList<>();
               list.add(workaddr);
               list.add(worktime);
               list.add(workterm);
               list.add(workpay);
               list.add(workjob);
               list.add(recruitend);
               list.add(user);
               list.add(worktel);
               list.add(jobcode);
               list.add(recruittitle);
           return jdbc.update(sql, list);
        }

         //공고 조회
         public Map<String, Object> getrec(int input) {
              String sql="SELECT A.RECRUIT_NO,A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START,"
                   + " TO_CHAR(A.RECRUIT_END,'YYYY/MM/DD') AS RECRUIT_END, A.WORK_ADDR, A.WORK_TIME, A.WORK_TERM, A.WORK_PAY, A.WORK_JOB,"
                   + " A.WORK_TEL, C.JOB_NAME,A.MEM_ID"
                   + "    FROM RECRUIT A"
                   + "   LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
                   + "   LEFT OUTER JOIN JOB C ON A.JOB_CODE=C.JOB_CODE"
                   + "   WHERE A.RECRUIT_NO=?";
              ArrayList<Object> list = new ArrayList<>();
              list.add(input);
              return jdbc.selectOne(sql,list);
           }
    //좋아요 공고 추가
         public int addlike(Object go,Object userId) {
          String sql="INSERT INTO LIKE_RECRUIT VALUES(?,?)";
          ArrayList<Object> list = new ArrayList<>();
          list.add(go);
          list.add(userId);
          return jdbc.update(sql, list);
          
       }
       //좋아요 공고  목록
       public List<Map<String, Object>> recuritlike(Object userId) {
           String sql="SELECT A.RECRUIT_NO,B.RECRUIT_TITLE, B.MEM_ID, B.RECRUIT_START, B.RECRUIT_END,"
                   + "       B.WORK_ADDR, B.WORK_TIME, B.WORK_TERM, B.WORK_PAY, B.WORK_JOB,"
                   + "        B.WORK_TEL, D.COMPANY_NAME"
                   + "   FROM LIKE_RECRUIT A"
                   + "   LEFT OUTER JOIN RECRUIT B ON A.RECRUIT_NO=B.RECRUIT_NO"
                   + "   LEFT OUTER JOIN ALBA C ON A.MEM_ID=C.MEM_ID"
                   + "   LEFT OUTER JOIN OWNER D ON D.MEM_ID=B.MEM_ID"
                   + "  WHERE A.MEM_ID=?";
             ArrayList<Object> list = new ArrayList<>();
             list.add(userId);
             return jdbc.selectList(sql,list);
                   
             
          }
       //좋아요 공고 삭제
       public int deletelike(Object likenumber,Object userId) {
          String sql="DELETE FROM LIKE_RECRUIT WHERE RECRUIT_NO=? AND MEM_ID=? ";
          ArrayList<Object> list = new ArrayList<>();
          list.add(likenumber);
          list.add(userId);
          return jdbc.update(sql, list);
       }
       //비밀번호 변경
       public int changepw(String pw,Object userId) {
          String sql="UPDATE MEMBER SET MEM_PW=? WHERE MEM_ID=?";
          ArrayList<Object> list = new ArrayList<>();
          list.add(pw);
          list.add(userId);
          return jdbc.update(sql, list);
       }
       //일반회원 상세정보변경
       public int detailchangeAlba(String albaAddr, String albaHp, Object userId) {
       String sql="UPDATE ALBA SET ALBA_ADDR=?,ALBA_HP=? WHERE MEM_ID=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(albaAddr);
       list.add(albaHp);
       list.add(userId);
       return jdbc.update(sql,list);
       }
     //기업회원 상세정보변경
       public int detailchangeOwner(String addr, String hp,Object userId) {
          String sql="UPDATE OWNER SET COMPANY_ADDR=?,COMPANY_TEL=? WHERE MEM_ID=?";
          ArrayList<Object> list = new ArrayList<>();
          list.add(addr);
          list.add(hp);
          list.add(userId);
          return jdbc.update(sql, list);
          
       }
    
       
        public List<Map<String, Object>> inquireboard() { //1:1상담 게시판
             String sql = "SELECT INQ_NO, INQ_TITLE, MEM_ID  FROM INQUIRE  ";
          

             return jdbc.selectList(sql); 
          }

          public int writeinq(String title, String content, Object user) { //1:1 상담 작성
             String sql= "INSERT INTO INQUIRE(INQ_NO,INQ_TITLE,INQ_CON, MEM_ID) VALUES((SELECT NVL(MAX(TO_NUMBER(INQ_NO)),0)+1 FROM INQUIRE)"
                   + " ,?"
                   + " ,?"
                   +"  ,?)";
             ArrayList<Object> list = new ArrayList<Object>();
             list.add(title);
             list.add(content);
             list.add(user);
             return jdbc.update(sql, list);
          }


          public Map<String, Object> getinq(int number) { //1:1상담게시판 조회
              String sql="SELECT INQ_NO, INQ_TITLE, INQ_CON, INQ_ANS, MEM_ID, MANAGER_ID FROM INQUIRE WHERE INQ_NO=?  ";
                         
                   ArrayList<Object> list = new ArrayList<>();
                   list.add(number);
                   return jdbc.selectOne(sql,list);   
          }


          public int inqanw(int num, String anw, Object object) { //1:1상담 답변
             String sql= "UPDATE INQUIRE SET INQ_ANS=?, MANAGER_ID=? WHERE INQ_NO=? ";
             ArrayList<Object> list = new ArrayList<Object>();
             
             
             list.add(anw);
             list.add(object);
             list.add(num);
             
             return jdbc.update(sql, list);
          }


          public int inqagain(String title, String content, int number) { //1:1상담 수정
                String sql="UPDATE INQUIRE SET INQ_TITLE=?,INQ_CON=? WHERE INQ_NO=?";
                   ArrayList<Object> list = new ArrayList<>();
                   list.add(title);
                   list.add(content);
                   list.add(number);
                   
                   return jdbc.update(sql, list);
          }


          

    

public List<Map<String, Object>> getNoboard() { //공지게시판 전체
  String sql="SELECT A.NOTICE_NO,A.NOTICE_TITLE, A.NOTICE_CON, A.NOTICE_DATE,B.MANAGER_NAME"
            +"    FROM NOTICE A"
            +"    LEFT OUTER JOIN MANAGER B ON A.MANAGER_ID=B.MANAGER_ID"
            +"   ORDER BY A.NOTICE_NO DESC ";
      return jdbc.selectList(sql);
}

public Map<String, Object> getno(int number) { //공지조회
 String sql="SELECT A.NOTICE_NO,A.NOTICE_TITLE, A.NOTICE_CON, A.NOTICE_DATE, B.MANAGER_ID, B.MANAGER_NAME"
            +"    FROM NOTICE A"
            +"    LEFT OUTER JOIN MANAGER B ON A.MANAGER_ID=B.MANAGER_ID"
            +"   WHERE A.NOTICE_NO=?";
      ArrayList<Object> list = new ArrayList<>();
      list.add(number);
      return jdbc.selectOne(sql,list);       
}

public int noagain(String title, String content, int number) { //공지수정
 String sql="UPDATE NOTICE SET NOTICE_TITLE=?,NOTICE_CON=?,NOTICE_DATE=SYSDATE WHERE NOTICE_NO=?";
   ArrayList<Object> list = new ArrayList<>();
   list.add(title);
   list.add(content);
   list.add(number);
   
   return jdbc.update(sql, list);
}

public int nodelete(int number) { //공지삭제
  String sql="DELETE FROM NOTICE WHERE NOTICE_NO=?";
      ArrayList<Object> list = new ArrayList<>();
      list.add(number);
      return jdbc.update(sql, list);
}


public int noticewrite(String title, String content, Object user) { //공지 작성 

String sql= "INSERT INTO NOTICE VALUES((SELECT NVL(MAX(NOTICE_NO),0)+1 FROM NOTICE)"
          + " ,?"
          + " ,?"
          + " ,SYSDATE"
          +"  ,(SELECT MANAGER_ID FROM MANAGER WHERE MANAGER.MANAGER_ID=?))";
ArrayList<Object> list = new ArrayList<Object>();
list.add(title);
list.add(content);
list.add(user);
return jdbc.update(sql, list);

}



public List<Map<String, Object>> getQnaboard() { //자주묻는 게시판
  String sql="SELECT QNA_NO, QNA_CON, QNA_ANSWER "
             +"    FROM QNA";
  
       return jdbc.selectList(sql);
}

public Map<String, Object> getQna(int number) { //자주묻는 질문 조회
 
  String sql="SELECT QNA_NO, QNA_CON, QNA_ANSWER "
             +"    FROM QNA"
             +"   WHERE QNA_NO=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(number);
       
       return jdbc.selectOne(sql,list);       
}

public int qnaagain(String title, String content, int number) { //자주묻는 질문 수정
  String sql="UPDATE QNA SET QNA_CON=?, QNA_ANSWER=? WHERE QNA_NO=?";
    ArrayList<Object> list = new ArrayList<>();
    list.add(title);
    list.add(content);
    list.add(number);
    
    return jdbc.update(sql, list);
}

public int qnadelete(int number) { //자주묻는 질문 삭제
 String sql= "DELETE FROM QNA WHERE QNA_NO=?";
  ArrayList<Object> list = new ArrayList<>();
    list.add(number);
    return jdbc.update(sql, list);
}

public int qnawrite(String q, String a) { //자주묻는 질문 작성
 String sql= "INSERT INTO QNA VALUES((SELECT NVL(MAX(QNA_NO),0)+1 FROM QNA)"
       + " ,?"
       + " ,?)";
 ArrayList<Object> list = new ArrayList<Object>();
 list.add(q);
 list.add(a);

return jdbc.update(sql, list);
}
public int inqdelete(int number) {
 String sql="DELETE FROM INQUIRE WHERE INQ_NO=?";
 ArrayList<Object> list = new ArrayList<>();
 list.add(number);
 return jdbc.update(sql, list);
 
}
public List<Map<String, Object>> albainfo() { //알바회원정보조회
  String sql="SELECT A.MEM_ID, A.MEM_PW, A.MEM_TYPE, B.ALBA_NAME, B.ALBA_BIR, B.ALBA_ADDR, B.ALBA_HP, B.ALBA_GENDER"
              +"    FROM MEMBER A"
              +"    LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
              +"   WHERE A.MEM_TYPE= '2'";
  
  return jdbc.selectList(sql);
  
}

public List<Map<String, Object>> cominfo() { //기업회원정보조회
  String sql="SELECT A.MEM_ID, A.MEM_PW, A.MEM_TYPE, B.COMPANY_NAME, B.COMPANY_OWNER, B.COMPANY_ADDR, B.COMPANY_TEL"
              +"    FROM MEMBER A"
              +"    LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
              +"   WHERE A.MEM_TYPE= '1'";
  
  return jdbc.selectList(sql);
}
	//지원 등록
	 public int recapply(Object resumeno, int go) { //추가
	 String sql="INSERT INTO APPLY VALUES((SELECT NVL(MAX(APPLY_NO),0)+1 FROM APPLY),?,?)";
	 ArrayList<Object> list = new ArrayList<>();
	 list.add(resumeno);
	 list.add(go);
	 return jdbc.update(sql, list);
	 }
	 	//공고목록
	 public List<Map<String, Object>> getRecruitboard() {
   String sql="SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START"       
         + "     FROM RECRUIT A"
         + "   LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
         + "  ORDER BY RECRUIT_NO DESC";
      return jdbc.selectList(sql);
 }
//공고 필터링
public List<Map<String, Object>> getRecruitFilter() {
  
String sql="SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START"       
        + "     FROM RECRUIT A"
        + "   LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
        + "  ORDER BY RECRUIT_NO DESC"
        + "  WHERE RECRUIT_NO DESC";
     return jdbc.selectList(sql);   
}
//지역별 공고필터
public List<Map<String, Object>> recfilteraddr(String region) {
   String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START"       
            + "     FROM RECRUIT A"
            + "     LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
            + "    WHERE SUBSTR(A.WORK_ADDR,1,2) = ? "
            + "    ORDER BY RECRUIT_NO DESC";
           ArrayList<Object> list = new ArrayList<>();
           list.add(region);
   return jdbc.selectList(sql,list);
}
//업종별 공고필터
public List<Map<String, Object>> recfilterjob(int jobcode) {
  String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START"       
            + "     FROM RECRUIT A"
            + "     LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
            + "    WHERE JOB_CODE = ? "
            + "    ORDER BY RECRUIT_NO DESC";
           ArrayList<Object> list = new ArrayList<>();
           list.add(jobcode);
   return jdbc.selectList(sql,list);   
}
//시간별 공고필터
  public List<Map<String, Object>> recfiltertime(int worktime) {
     if(worktime==1){
     String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TIME"       
           + "      FROM RECRUIT A"
           + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
           + "      WHERE TO_NUMBER(SUBSTR(WORK_TIME,1,2))>=6"
           + "       AND TO_NUMBER(SUBSTR(WORK_TIME,1,2))<=12"
           + "      ORDER BY RECRUIT_NO DESC";
     return jdbc.selectList(sql);   
  }else if(worktime==2){
     String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TIME"       
           + "      FROM RECRUIT A"
           + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
           + "      WHERE TO_NUMBER(SUBSTR(WORK_TIME,1,2))>=12"
           + "       AND TO_NUMBER(SUBSTR(WORK_TIME,1,2))<22"
           + "      ORDER BY RECRUIT_NO DESC";
     return jdbc.selectList(sql);   
  }else{
     String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TIME"       
           + "      FROM RECRUIT A"
           + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
           + "      WHERE TO_NUMBER(SUBSTR(WORK_TIME,1,2))>=22"
           + "       AND TO_NUMBER(SUBSTR(WORK_TIME,1,2))<6"
           + "      ORDER BY RECRUIT_NO DESC";
     return jdbc.selectList(sql);   
  }
  }
  //기간별 공고필터
  public List<Map<String, Object>> recfilterterm(int workterm) {
     if(workterm==1){
        String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TERM"       
              + "      FROM RECRUIT A"
              + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
              + "      WHERE TO_NUMBER(SUBSTR(WORK_TERM,1,1))=0"
              + "      ORDER BY RECRUIT_NO DESC";
        return jdbc.selectList(sql);   
     }else if(workterm==2){
        String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TERM"       
              + "      FROM RECRUIT A"
              + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
              + "      WHERE TO_NUMBER(SUBSTR(WORK_TERM,1,1))>0"
              + "       AND TO_NUMBER(SUBSTR(WORK_TERM,1,1))<6"
              + "      ORDER BY RECRUIT_NO DESC";
        return jdbc.selectList(sql);   
     }else{
        String sql = "SELECT A.RECRUIT_NO, A.RECRUIT_TITLE, B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START, A.WORK_TERM"       
              + "      FROM RECRUIT A"
              + "      LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
              + "      WHERE TO_NUMBER(SUBSTR(WORK_TERM,1,1))>=6"
              + "      ORDER BY RECRUIT_NO DESC";
        return jdbc.selectList(sql);   
     }
  }
  
   public int rsmwrite1(String title, String content, String jobCode,Object userId) {
        String sql="INSERT INTO RESUME VALUES((SELECT NVL(MAX(RESUME_NO),0)+1 FROM RESUME)"
                 + " ,?"
                 + " ,?"
                 + " ,(SELECT MEM_ID FROM ALBA WHERE ALBA.MEM_ID=?)"
                 + " ,?"
                 + " ,SYSDATE)"; 
        
        ArrayList<Object> list = new ArrayList<>();
        list.add(title);
        list.add(content);
        list.add(userId);
        list.add(jobCode);
        
        return jdbc.update(sql, list);
        }


//내공고 목록
   public List<Map<String, Object>> myrec(Object userId) {
       String sql="SELECT A.RECRUIT_NO,A.RECRUIT_TITLE,B.COMPANY_NAME, TO_CHAR(A.RECRUIT_START,'YYYY/MM/DD') AS RECRUIT_START,"
          + " TO_CHAR(A.RECRUIT_END,'YYYY/MM/DD') AS RECRUIT_END, A.WORK_ADDR, A.WORK_TIME, A.WORK_TERM, A.WORK_PAY, A.WORK_JOB,"
          + " A.WORK_TEL, C.JOB_NAME" 
             +"    FROM RECRUIT A"
             +"    LEFT OUTER JOIN OWNER B ON A.MEM_ID=B.MEM_ID"
             +"    LEFT OUTER JOIN JOB C ON A.JOB_CODE=C.JOB_CODE"
             +"   WHERE A.MEM_ID=?";
       ArrayList<Object> list = new ArrayList<>();
       list.add(userId);
       return jdbc.selectList(sql,list);
       
    }
   
//공고 수정
 public int recruitagain(String recruittitle,String workaddr,String worktime,String workterm,String workpay,String workjob,int jobcode,
       String worktel,String recruitend,Object selectNum){
     String sql="UPDATE RECRUIT"
               + "    SET RECRUIT_TITLE = ?"
               + ",       WORK_ADDR = ?"
               + ",       WORK_TIME = ?"
               + ",       WORK_TERM = ?"
               + ",       WORK_PAY = ?"
               + ",       WORK_JOB = ?"
               + ",       JOB_CODE = ?"
               + ",       WORK_TEL = ?"
               + ",       RECRUIT_END = ?"
           + "  WHERE RECRUIT_NO = ?";
         List<Object> list = new ArrayList<>();
         list.add(recruittitle);
         list.add(workaddr);
         list.add(worktime);
         list.add(workterm);
         list.add(workpay);
         list.add(workjob);
         list.add(jobcode);
         list.add(worktel);
         list.add(recruitend);
         list.add(selectNum);
     return jdbc.update(sql, list);
 }
 
 //내 공고 삭제
 public int deleterecruit(Object selectNum) {
    String sql="DELETE FROM RECRUIT WHERE RECRUIT_NO=?";
    ArrayList<Object> list = new ArrayList<>();
    list.add(selectNum);
    return jdbc.update(sql, list);
 }
 
 //회원탈퇴
 public int memberout(Object userId, Object memType) {  //추가
    int result = 0;
    String sql=null;
    if (memType.equals("1")) {
       sql = "DELETE FROM OWNER WHERE MEM_ID=?";

    } else {
       sql = "DELETE FROM ALBA WHERE MEM_ID=?";
    }
    ArrayList<Object> list = new ArrayList<>();
    list.add(userId);
    result += jdbc.update(sql, list);
    
    String sql2 = "DELETE FROM MEMBER WHERE MEM_ID=?";
    ArrayList<Object> list2 = new ArrayList<>();
    list2.add(userId);
    result += jdbc.update(sql2, list2);
    return result;
 }
 //이력서 목록
 public List<Map<String, Object>> rsmboard() { 
    String sql="SELECT A.RESUME_NO, A.RESUME_TITLE, B.ALBA_NAME, A.RESUME_DATE"
          + " FROM RESUME A"
          + " LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
          +" ORDER BY 1 DESC";
    return jdbc.selectList(sql);
 }
 //이력서 상세
 public Map<String, Object> rsmget(int getrsmnum) { 
 String sql="SELECT A.RESUME_NO, A.RESUME_TITLE, A.RESUME_CON, B.ALBA_NAME, A.JOB_CODE, A.RESUME_DATE,C.JOB_NAME"
       +"    FROM RESUME A"
       +"  LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
       +"  LEFT OUTER JOIN JOB C ON A.JOB_CODE=C.JOB_CODE"
       +" WHERE A.RESUME_NO=?";
 ArrayList<Object> list = new ArrayList<>();
 list.add(getrsmnum);
 return jdbc.selectOne(sql, list);
 }
 //관심 이력서 추가
 public int rsmlike(int getrsmnum, Object userId) { 
    String sql="INSERT INTO LIKE_RESUME VALUES(?,?)";
    ArrayList<Object> list = new ArrayList<>();
    list.add(userId);
    list.add(getrsmnum);
    
    return jdbc.update(sql, list);
 }
 //관심이력서 목록
 public List<Map<String, Object>> likersmboard(Object userId) { 
    String sql="SELECT A.RESUME_NO, A.RESUME_TITLE, A.RESUME_CON, B.ALBA_NAME, D.JOB_NAME, A.RESUME_DATE"
          +"  FROM RESUME A"
          + " LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
          +" LEFT OUTER JOIN LIKE_RESUME C ON A.RESUME_NO=C.RESUME_NO"
          +" LEFT OUTER JOIN JOB D ON A.JOB_CODE=D.JOB_CODE"
          + " WHERE C.MEM_ID=?";
    ArrayList<Object> list = new ArrayList<>();
    list.add(userId);
    return jdbc.selectList(sql, list);
 }
 //관심이력서 삭제
 public int likersmdel(Object dellikenum) {//추가
    String sql="DELETE FROM LIKE_RESUME WHERE RESUME_NO=?";
    ArrayList<Object> list = new ArrayList<>();
    list.add(dellikenum);
    return jdbc.update(sql, list);
 }
 
 //지역별 이력서 필터
 public List<Map<String, Object>> rsmfilteraddr(String region) {
	String sql = "SELECT A.RESUME_NO, A.RESUME_TITLE, B.ALBA_NAME, B.ALBA_ADDR, TO_CHAR(A.RESUME_DATE,'YYYY/MM/DD') AS RESUME_DATE"       
          + "     FROM RESUME A"
          + "     LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
          + "    WHERE SUBSTR(B.ALBA_ADDR,1,2) = ? "
          + "    ORDER BY RESUME_NO DESC";
         ArrayList<Object> list = new ArrayList<>();
         list.add(region);
 return jdbc.selectList(sql,list);
 }
 //성별 이력서필터
	public List<Map<String, Object>> rsmfiltergen(String gender) {
	String sql = "SELECT A.RESUME_NO, A.RESUME_TITLE, B.ALBA_NAME, B.ALBA_GENDER, TO_CHAR(A.RESUME_DATE,'YYYY/MM/DD') AS RESUME_DATE"       
          + "     FROM RESUME A"
          + "     LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
          + "    WHERE B.ALBA_GENDER = ? "
          + "    ORDER BY RESUME_NO DESC";
         ArrayList<Object> list = new ArrayList<>();
         list.add(gender);
         return jdbc.selectList(sql,list);
	}
	//우대조건별 이력서필터
	public List<Map<String, Object>> rsmfilterpre(int prefer) {
		String sql = "SELECT A.RESUME_NO, A.RESUME_TITLE, B.ALBA_NAME, C.JOB_NAME, B.JOB_CODE, TO_CHAR(A.RESUME_DATE,'YYYY/MM/DD') AS RESUME_DATE"       
	            + "     FROM RESUME A"
	            + "     LEFT OUTER JOIN ALBA B ON A.MEM_ID=B.MEM_ID"
	            + "     LEFT OUTER JOIN JOB C ON B.JOB_CODE=C.JOB_CODE"
	            + "    WHERE JOB_CODE = ? "
	            + "    ORDER BY RESUME_NO DESC";
	           ArrayList<Object> list = new ArrayList<>();
	           list.add(prefer);
	           return jdbc.selectList(sql,list);
	}
	
	
	public int recapply(Object resumeno, Object lala) { //추가
		   String sql="INSERT INTO APPLY VALUES((SELECT NVL(MAX(APPLY_NO),0)+1 FROM APPLY),?,?)";
		   ArrayList<Object> list = new ArrayList<>();
		   list.add(resumeno);
		   list.add(lala);
		   return jdbc.update(sql, list);
		   
		         
		      
		   }
		   public List<Map<String, Object>> applycheck(Object userId) {
		      String sql="SELECT A.RESUME_NO"
		             +" , A.RESUME_TITLE"
		             +" , A.RESUME_CON"
		            +"  , C.ALBA_NAME" 
		            +"  , J.JOB_NAME" 
		            +"  , A.RESUME_DATE" 
		            +"  , B.RECRUIT_NO"
		            +"  , R.RECRUIT_TITLE " 
		            +"    FROM  RESUME A" 
		            +" LEFT OUTER JOIN ALBA C ON A.MEM_ID=C.MEM_ID" 
		            +" LEFT OUTER JOIN APPLY B ON  A.RESUME_NO = B.RESUME_NO " 
		            +" LEFT OUTER JOIN RECRUIT R ON B.RECRUIT_NO = R.RECRUIT_NO" 
		            +" LEFT OUTER JOIN JOB J ON J.JOB_CODE=A.JOB_CODE" 
		            +"    WHERE R.MEM_ID = ?";
		      ArrayList<Object> list = new ArrayList<>();
		      list.add(userId);
		      return jdbc.selectList(sql, list);
		            
		      
		   }
		   public int applydel(Object applynum, Object recruitnum) {
		   String sql="DELETE FROM APPLY WHERE RESUME_NO=? AND RECRUIT_NO=? ";
		   ArrayList<Object> list = new ArrayList<>();
		   list.add(applynum);
		   list.add(recruitnum);
		   return jdbc.update(sql, list);
		   
		      
		   }
		   
		}
	


 
 
    
    
    
    
    
    
    
    
    
    
    
    
