package e_oop.score;

public class Score {

	public static void main(String[] args) {
		  String[] studentNames = {"������","����ȯ","���¿�","������","�輭��","�迵��","������","�����","�ڽ���",
		            "��ä��","�տ���","������","������","�̼���","�̼���","����ȫ","����ȣ","������","������","���ž�",
		            "������","���Ͽ�","������","�����","������"};
		      
		      Student[] students = new Student[studentNames.length]; // 25���� �л� ������ ������ ��������
		         
		      for(int i=0; i<25; i++){
		         Student student = new Student(); // ��ü����. 25���� �޸𸮿� �����. 25���� �л���������
		         
		         student.kor = (int)(Math.random()*101);
		         student.eng = (int)(Math.random()*101);
		         student.math = (int)(Math.random()*101);
		         student.name = studentNames[i];
		         student.rank =1;   
		           students[i] = student;
		         
		      }
		   

		      // ����ó�� ���α׷��� �ϼ����ּ���.
		      
		      
		      //�հ�, ���
		      for(int i=0; i<students.length; i++){
		         students[i].sum=students[i].kor+students[i].eng+students[i].math;
		         students[i].avg=Math.round(students[i].sum/3.0 *100) / 100.0;
		         //double�� �ȴٴµ�?
		      }

		      // �������ϱ�
		      for(int i=0; i<students.length; i++){
		         for(int j=0; j<students.length; j++){ //j�� 0�̾ƴ϶� i�� �ȵǴ� ������? 
		            if(students[i].avg<students[j].avg)
		               students[i].rank++;
		         }
		      }

		      //�������� ����
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

		      // ���� �հ�, ���
		      
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
		      
		      
		      System.out.println("�̸�\t����\t����\t����\t�հ�\t���\t����\t");
		      for(int i=0; i<students.length; i++){
		         System.out.println(studentNames[i]+"\t"+students[i].kor+"\t"+students[i].eng+"\t"+students[i].math+"\t"+students[i].sum+"\t"+
		      students[i].avg+"\t"+students[i].rank);
		      }
		      System.out.println("�����հ�\t"+subsum[0]+"\t"+subsum[1]+"\t"+subsum[2]);
		      System.out.println("�������\t"+subavg[0]+"\t"+subavg[1]+"\t"+subavg[2]);
		   }

		}