package e_oop.score;

public class Score {

	public static void main(String[] args) {
		  String[] studentNames = {"강나영","강동환","강태영","곽지훈","김서윤","김영훈","김진석","김충신","박슬기",
		            "박채린","손영태","손형흔","안정연","이선우","이수보","이주홍","이중호","임현정","장유진","정신애",
		            "조수경","조하영","조혜민","허민정","박지은"};
		      
		      Student[] students = new Student[studentNames.length]; // 25명의 학생 정보를 저장할 공간만듬
		         
		      for(int i=0; i<25; i++){
		         Student student = new Student(); // 객체생성. 25개가 메모리에 저장됨. 25명의 학생정보만듬
		         
		         student.kor = (int)(Math.random()*101);
		         student.eng = (int)(Math.random()*101);
		         student.math = (int)(Math.random()*101);
		         student.name = studentNames[i];
		         student.rank =1;   
		           students[i] = student;
		         
		      }
		   

		      // 성적처리 프로그램을 완성해주세요.
		      
		      
		      //합계, 평균
		      for(int i=0; i<students.length; i++){
		         students[i].sum=students[i].kor+students[i].eng+students[i].math;
		         students[i].avg=Math.round(students[i].sum/3.0 *100) / 100.0;
		         //double도 된다는뒝?
		      }

		      // 석차구하기
		      for(int i=0; i<students.length; i++){
		         for(int j=0; j<students.length; j++){ //j가 0이아니라 i면 안되는 이유는? 
		            if(students[i].avg<students[j].avg)
		               students[i].rank++;
		         }
		      }

		      //석차별로 정렬
		      for(int i=0; i<students.length-1; i++)
		      {
		         int min=i;
		         for(int j=i+1; j<students.length; j++){
		            if(students[j].rank<students[min].rank){
		               min=j;}
		            
		         }
		         Student temp = students[i];
		         students[i]=students[min];
		         students[min]=temp;
		         
		      }

		      // 과목별 합계, 평균
		      
		      int[] subsum =new int[3];
		      double[] subavg= new double[3];
		      
		      for(int i=0; i<students.length; i++){
		         subsum[0]+=students[i].kor;
		         subsum[1]+=students[i].eng;
		         subsum[2]+=students[i].math;
		      }
		      for(int i=0; i<subavg.length; i++){
		         subavg[i]=Math.round((double)subsum[i]/students.length *100)/100.0;
		      }
		      
		      
		      System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차\t");
		      for(int i=0; i<students.length; i++){
		         System.out.println(studentNames[i]+"\t"+students[i].kor+"\t"+students[i].eng+"\t"+students[i].math+"\t"+students[i].sum+"\t"+
		      students[i].avg+"\t"+students[i].rank);
		      }
		      System.out.println("과목합계\t"+subsum[0]+"\t"+subsum[1]+"\t"+subsum[2]);
		      System.out.println("과목평균\t"+subavg[0]+"\t"+subavg[1]+"\t"+subavg[2]);
		   }

		}