package e_oop.score2;

public class Score {

	public static void main(String[] args) {
	    String[] studentNames = {"강나영","강동환","강태영","곽지훈","김서윤","김영훈","김진석","김충신","박슬기",
	            "박채린","손영태","손형흔","안정연","이선우","이수보","이주홍","이중호","임현정","장유진","정신애",
	            "조수경","조하영","조혜민","허민정","박지은"};
	      
	      
	        
	      System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차\t");
	      Student a = new Student(); // a객체 생성
	      for(int i=0; i<25; i++){
	      
	          
	         System.out.println(studentNames[i]+"\t"+a.kor()+"\t"+a.eng()+"\t"+a.math()+"\t"+a.sum()+"\t"+a.avg()+"\t"+a.rank());
	         
	      }

	      
	      System.out.println("과목합계\t"+a.subsum());
	      System.out.println("과목평균\t");

	      
	      }
	   }