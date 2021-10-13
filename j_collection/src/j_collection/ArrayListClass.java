package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {
	public static void main(String[] args){
		/*
		 * List, 
		 * Map(���������Ҷ� �����ϰ� ���� Ű�� ������ ����. ������ Ű�� ���� ���� ����), 
		 * Set(�ߺ��� ���� ������� ����, �� ���x) 
		 * = >�������̽�
		 * 
		 * ArrayListClass�� ��ӹ��� �޼����
		 * boolean add(Object obj): ������ ��ġ�� ��ü�� �߰� �� ���� ���θ� ��ȯ�Ѵ�.
		 * ->Object obj Ÿ�Կ� ������� �Ķ���Ϳ� ���尡��. ���ʴ�� �����
		 * void add(int index, Object obj): ������ ��ġ�� ��ü�� �߰��Ѵ�.
		 * -> ������ �ε����� ���� ����
		 * Object set(int index, Object obj) : ������ ��ġ�� ��ü�� ���� �� ���� ��ü�� ��ȯ�Ѵ�.
		 * -> �����ϴ� �޼���.
		 * Object get(int index): ������ ��ġ�� ��ü�� ��ȯ�Ѵ�.
		 * -> ����� ���� ������� �޼���. �Ķ���ͷ� ������ �ε����� ���� ��ȯ
		 * int size(): ����� ��ü�� ���� ��ȯ�Ѵ�.
		 * -> �迭�� length() �� ������ ���
		 * Object remove(int index): ������ ��ġ�� ��ü�� �����Ѵ�.
		 * ->�Ķ���ͷ� ������ �ε����� ���� ����
		 * 
		 */
		
		ArrayList sample = new ArrayList(); //������ ��������->�ƹ��ų� ���尡��
		sample.add("abc"); //0���ε����� �����
		sample.add(100); //1���ε����� �����
		sample.add(new Scanner(System.in)); //2���ε����� �����
		//�̷��� Ÿ�� �������ϰ� �� ��������� ���� ������. �÷��� ���� ������ ������.
		
		// ������ <> ���. �ȿ��� ��ü(Ŭ����)�� �� �� ����
		/* ����Ŭ����
		 * byte: Byte
		 * short: Short
		 * int: Integer
		 * float: Float
		 * double : Double
		 * char: Character
		 * boolean: Boolean
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>(); //������ ����-> ������ �͸� ���尡��
		list.add(10);
	//	list.add("abc"); �����Ͽ��� �߻�.
		list.add(new Integer(20)); //������ �̷��� �����ؾ��ϴµ�. ����Ŭ������ �ڵ����� ����ȯ�Ǿ �׳� �⺻��Ÿ���� 10�� �Է��ص� ������ ����
		System.out.println(list.add(30)); //����� true -> ������ �ߵ�
		System.out.println(list);
		
		list.add(1,40);
		System.out.println(list); //������ ����Ǿ� �ִ� �ε����� ���������� ���� ����. ���ִ� �ε����� �����ϸ� ������ �ε������� ��ĭ�� �з�����
		
		Integer before = list.set(2, 50); //������ ����ִ� 2�� �ε��� �� ���
		System.out.println(before);
		System.out.println(list);
		
		int get = list.get(2); // ����ȯ�Ǵϱ� Integer get ��� int �ᵵ��. �����δ� integer Ÿ����
		System.out.println(get);
		
	/*	for(int i=0; i<list.size(); i++){
			System.out.println(i+ ":"+list.get(i));
			
			list.remove(i);
		} */
		// array.list���̴� �����Ѹ�ŭ �پ��� ������ 4���� �ƴ϶� 2�� ��µ�. 
		// ������ ���� �����ϱ� ���� for���� ������ �Ųٷ� �����鼭 �;���.
		
		for(int i= list.size()-1; i>=0; i--){
			System.out.println(i + ":"+ list.remove(i));
		}
		System.out.println(list);
		
		
		//list�� 1~100������ �������� 10�� �������ּ���
		
		for(int i=0; i<10; i++){
			int num = (int)(Math.random()*100)+1;
			list.add(num);
		}
		System.out.println(list);
		
		//list�� ����� ���� �հ�� ����� �����ּ���
		
		int sum=0; //���� �ʱ�ȭ �ϱ�,,,,,,
		double avg=0;
		for(int i=0; i<list.size(); i++){
			sum += list.get(i);	
		}
		avg= (double) sum /list.size(); //sum�� list.size()��� int���̱� ������ �Ҽ������� ������ �Ҷ�� double�� ����ȯ�ؾ���
		System.out.println("�հ�:"+sum+"���:"+avg);
		
		//list���� �ּҰ��� �ִ밪�� �����ּ���
		int min=list.get(0);
		int max = list.get(0);
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i)<min){
				min=list.get(i);
			}if(list.get(i)>max){
				max=list.get(i);
			}
		}
		
		System.out.println("�ִ밪:"+max+" �ּҰ�:"+min);
		
		//list�� ������������ �������ּ���
		//(��������)
		for(int i=0; i<list.size()-1; i++){
			min = i;	
			for(int j=i+1; j<list.size(); j++){
				if(list.get(j)<list.get(min)){
					min=j;
			}
			}
			int temp = list.get(i);
			//���Կ������� ������ �ݵ�� ���������� ������ list.get(i) = list.get(min) �ȵǴ°ſ��� ��
			list.set(i, list.get(min));
			list.set(min, temp);
			
		}
		System.out.println(list);
		
		
		//2���� ����Ʈ ����
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>(); // ��ü���� ctrl+1
		
		list = new ArrayList<Integer>(); //1���� ArrayList
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		System.out.println(list2); // [ [10,20,30,]]
		
		list = new ArrayList<Integer>(); //1���� ArrayList
		list.add(40);
		list.add(50);
		list2.add(list);
		System.out.println(list2); // [[10,20,30,], [40,50]]
		
		//2���� ����Ʈ �� ������
		list.get(0);
		list2.get(0).get(0); //list2.get(0) �� ArrayList2 �迭�� ������ arr[0][0]
		
		for(int i=0; i<list.size(); i++){
			ArrayList<Integer> a1 = list2.get(i);
			for(int j=0; j<a1.size(); j++){
				System.out.println(a1.get(j));
			}
		}
		
		// 3�� 5���� �հ� ���
		// �л� 3���� 5���� ���� 0~100���� ������ ������ 2���� ArrayList�� ����
		
		ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>(); //2���� ArrayList
		
		//�л��� ������ ArrayList//1����

		for(int i =0; i<3; i++){
			ArrayList<Integer> student = new ArrayList<Integer>();
			for(int j=0; j<5; j++){
				student .add((int)(Math.random()*101));
			}
			s.add(student);
		}
		

		System.out.println(s);
		
		
		//�л�1,2,3�� �հ� ���
		ArrayList<Integer> sums = new ArrayList<>();
		ArrayList<Double> avgs = new ArrayList<>();
		
		for(int i =0; i<s.size(); i++){
			sum=0;
			ArrayList<Integer> score = s.get(i);
			
			for(int j = 0; j<7; j++){
				sum+= score.get(i);
				
			}
			sums.add(sum);
			
			avgs.add((double)sum / score.size());
		}
		System.out.println(sum);
		System.out.println("�հ��:"+sums+"�����: "+avgs);
		
		
	/*	int sum1=0;
		for(int i=0; i<5; i++){
			sum1+=s.get(0).get(i);
		}
		int sum2=0;
		for(int i=0; i<5; i++){
			sum2+=s.get(1).get(i);
		}
		int sum3=0;
		for(int i=0; i<5; i++){
			sum3+=s.get(2).get(i);
		}*/
		
		
		
		}
	
		
	}


