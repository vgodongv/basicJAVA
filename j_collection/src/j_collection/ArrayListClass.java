package j_collection;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {
	public static void main(String[] args){
		/*
		 * List, 
		 * Map(값을저장할때 저장하고 싶은 키를 가지고 저장. 때문에 키와 값을 같이 저장), 
		 * Set(중복된 값이 저장되지 않음, 잘 사용x) 
		 * = >인터페이스
		 * 
		 * ArrayListClass를 상속받은 메서드들
		 * boolean add(Object obj): 마지막 위치에 객체를 추가 후 성공 여부를 반환한다.
		 * ->Object obj 타입에 상관없이 파라미터에 저장가능. 차례대로 저장됨
		 * void add(int index, Object obj): 지정된 위치에 객체를 추가한다.
		 * -> 지정한 인덱스에 값을 저장
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * -> 수정하는 메서드.
		 * Object get(int index): 지정된 위치의 객체를 반환한다.
		 * -> 저장된 값을 얻기위한 메서드. 파라미터로 지정한 인덱스의 값을 반환
		 * int size(): 저장된 객체의 수를 반환한다.
		 * -> 배열의 length() 랑 동일한 기능
		 * Object remove(int index): 지정된 위치의 객체를 제거한다.
		 * ->파라미터로 지정한 인덱스의 값을 삭제
		 * 
		 */
		
		ArrayList sample = new ArrayList(); //제내릭 지정안함->아무거나 저장가능
		sample.add("abc"); //0번인덱스에 저장됨
		sample.add(100); //1번인덱스에 저장됨
		sample.add(new Scanner(System.in)); //2번인덱스에 저장됨
		//이렇게 타입 지정안하고 막 집어넣으면 뺄때 문제임. 컬렉션 사용시 제내릭 사용권장.
		
		// 제내릭 <> 사용. 안에는 객체(클래스)만 올 수 있음
		/* 래퍼클래스
		 * byte: Byte
		 * short: Short
		 * int: Integer
		 * float: Float
		 * double : Double
		 * char: Character
		 * boolean: Boolean
		 */
		
		ArrayList<Integer> list = new ArrayList<Integer>(); //제내릭 지정-> 지정한 것만 저장가능
		list.add(10);
	//	list.add("abc"); 컴파일에러 발생.
		list.add(new Integer(20)); //원래는 이렇게 저장해야하는데. 래퍼클래스는 자동으로 형변환되어서 그냥 기본형타입인 10만 입력해도 문제가 없음
		System.out.println(list.add(30)); //결과값 true -> 저장이 잘됨
		System.out.println(list);
		
		list.add(1,40);
		System.out.println(list); //기존에 저장되어 있던 인덱스에 범위에서만 저장 가능. 값있는 인덱스에 저장하면 기존의 인덱스값은 한칸씩 밀려나감
		
		Integer before = list.set(2, 50); //기존에 들어있던 2번 인덱스 값 출력
		System.out.println(before);
		System.out.println(list);
		
		int get = list.get(2); // 형변환되니까 Integer get 대신 int 써도됨. 실제로는 integer 타입임
		System.out.println(get);
		
	/*	for(int i=0; i<list.size(); i++){
			System.out.println(i+ ":"+list.get(i));
			
			list.remove(i);
		} */
		// array.list길이는 삭제한만큼 줄어들기 때문에 4번이 아니라 2번 출력됨. 
		// 때문에 값을 제거하기 위해 for문을 돌릴때 거꾸로 돌리면서 와야함.
		
		for(int i= list.size()-1; i>=0; i--){
			System.out.println(i + ":"+ list.remove(i));
		}
		System.out.println(list);
		
		
		//list에 1~100사이의 랜덤값을 10개 저장해주세요
		
		for(int i=0; i<10; i++){
			int num = (int)(Math.random()*100)+1;
			list.add(num);
		}
		System.out.println(list);
		
		//list에 저장된 값의 합계와 평균을 구해주세요
		
		int sum=0; //변수 초기화 하기,,,,,,
		double avg=0;
		for(int i=0; i<list.size(); i++){
			sum += list.get(i);	
		}
		avg= (double) sum /list.size(); //sum과 list.size()모두 int형이기 때문에 소수점까지 나오게 할라면 double로 형변환해야함
		System.out.println("합계:"+sum+"평균:"+avg);
		
		//list에서 최소값과 최대값을 구해주세요
		int min=list.get(0);
		int max = list.get(0);
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i)<min){
				min=list.get(i);
			}if(list.get(i)>max){
				max=list.get(i);
			}
		}
		
		System.out.println("최대값:"+max+" 최소값:"+min);
		
		//list를 오름차순으로 정렬해주세요
		//(선택정렬)
		for(int i=0; i<list.size()-1; i++){
			min = i;	
			for(int j=i+1; j<list.size(); j++){
				if(list.get(j)<list.get(min)){
					min=j;
			}
			}
			int temp = list.get(i);
			//대입연산자의 왼쪽은 반드시 변수여야함 때문에 list.get(i) = list.get(min) 안되는거였슴 ㅠ
			list.set(i, list.get(min));
			list.set(min, temp);
			
		}
		System.out.println(list);
		
		
		//2차원 리스트 생성
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>(); // 객체생성 ctrl+1
		
		list = new ArrayList<Integer>(); //1차원 ArrayList
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		System.out.println(list2); // [ [10,20,30,]]
		
		list = new ArrayList<Integer>(); //1차원 ArrayList
		list.add(40);
		list.add(50);
		list2.add(list);
		System.out.println(list2); // [[10,20,30,], [40,50]]
		
		//2차원 리스트 값 꺼내기
		list.get(0);
		list2.get(0).get(0); //list2.get(0) 이 ArrayList2 배열로 따지면 arr[0][0]
		
		for(int i=0; i<list.size(); i++){
			ArrayList<Integer> a1 = list2.get(i);
			for(int j=0; j<a1.size(); j++){
				System.out.println(a1.get(j));
			}
		}
		
		// 3명 5과목 합계 평균
		// 학생 3명의 5과목에 대한 0~100점의 랜덤한 점수를 2차원 ArrayList에 저장
		
		ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>(); //2차원 ArrayList
		
		//학생을 저장할 ArrayList//1차원

		for(int i =0; i<3; i++){
			ArrayList<Integer> student = new ArrayList<Integer>();
			for(int j=0; j<5; j++){
				student .add((int)(Math.random()*101));
			}
			s.add(student);
		}
		

		System.out.println(s);
		
		
		//학생1,2,3의 합계 평균
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
		System.out.println("합계는:"+sums+"평균은: "+avgs);
		
		
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


