package e_oop.score2;

public class Score {

	public static void main(String[] args) {
	    String[] studentNames = {"������","����ȯ","���¿�","������","�輭��","�迵��","������","�����","�ڽ���",
	            "��ä��","�տ���","������","������","�̼���","�̼���","����ȫ","����ȣ","������","������","���ž�",
	            "������","���Ͽ�","������","�����","������"};
	      
	      
	        
	      System.out.println("�̸�\t����\t����\t����\t�հ�\t���\t����\t");
	      Student a = new Student(); // a��ü ����
	      for(int i=0; i<25; i++){
	      
	          
	         System.out.println(studentNames[i]+"\t"+a.kor()+"\t"+a.eng()+"\t"+a.math()+"\t"+a.sum()+"\t"+a.avg()+"\t"+a.rank());
	         
	      }

	      
	      System.out.println("�����հ�\t"+a.subsum());
	      System.out.println("�������\t");

	      
	      }
	   }