package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Map(키와 값을 받아서 저장)을 상속받아 구현. Map은 저장하고 싶은 키를 저장. 인덱스라는 개념이 존재하지않아서 순서도 없음
		 * 
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다. 어떤키로 어떤 값을 저장할것인가
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다. 키도 같이 삭제됨
		 * Object get(Object key): 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet(): 저장된 모든 키를 Set으로 반환한다.
		 * 
		 */
		
		//Map을 사용하려면 먼저 객체를 생성해야한다. 키의 제네릭 값에 제네릭 두개 지정. 값의 타입 Object로 자주씀
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date()); // new Date()는 날짜를 표현하기위한 객체
		
		System.out.println(map); // 해시맵에는 순서라는 개념이 없기 때문에 저장한 순서대로 출력되지 않음
		
		//hashmap 수정
		map.put("name", "이순신"); // 같은 키를 사용하여 값을 넣어주면 기존에 있던 값을 덮어씌움. 하나의 키에 하나의 값만 저장할 수 있기 때문에 !!!!!!!!!!!!!!!!!!!
		System.out.println(map);
		
		//값 제거
		map.remove("age"); //삭제하고싶은 키를 넘겨주면됨
		System.out.println(map);
		
		//값을 얻기
		Object value = map.get("name"); // 얻고싶은 값의 키를 입력하면됨. 제네릭을 Object타입으로 지정했기때문에 Object변수에 저장
		System.out.println(value);
		
		//만약 value값을 받아서 String메서드를 사용하고 싶다면? 형변환 해주면됨
		
//		System.out.println(value.substring(0,1));
//		System.out.println((String)value.substring(0,1)); 이렇게 형변환하면 value.substring(0,1)를 형변환하는거라 에러
		System.out.println(((String)value).substring(0,1));
		
//		근데 사용할때마다 형변환하기 귀찮으니까 애초에 꺼낼때부터 형변환
		String str = (String)map.get("name");
		
//		모든키를 set의 형태로 리턴. Set<String> 이유는 키 제네릭은 String으로 지정해서
		Set<String> keys = map.keySet(); // 모든 키가 담기게됨
		
//		향상된 for문 set, 리스트, 배열 등 이 : 뒤에 옴. :앞에는 set, 리스트, 배열 등에서 값을 꺼냈을때 저장할 변수 옴. 
//		keys에서 값을 꺼내서 변수에 저장하고 다시 실행하는 방식. 다꺼내면 for문 종료
		for(String key : keys){ 
			System.out.println(key + " : "+ map.get(key));
		}
		
//		map은 보통 테이블의 구조를 표현할때 주로 사용 
		
//		JOBS 테이블
		
//		행 하나 저장하기. 행의 값은 4개. 컬럼명이 키가되고 컬럼값이 저장할 값이됨

		HashMap<String, Object> job = new HashMap<String, Object>();
		job.put("JOb_ID", "AD_PRES");
		job.put("JOB_TITLE", "President");
		job.put("MIN_SALARY", 20080);
		job.put("MAX_SALARY", 40000);
		
//		행 저장한 것을 리스트에 저장
		ArrayList<HashMap<String, Object>> jobs = new ArrayList<HashMap<String, Object>>();
		jobs.add(job);
		System.out.println(job);
		
//		행 하나더 저장 -> 해시 맵 새로 생성. 그냥 계속 put하면 덮어씌우는거임.
		job = new HashMap<>();
		job.put("JOB_ID", "AD+VP");
		job.put("JOB_TITLE", "AdminStration Vice President");
		job.put("MIN_SALARY", 15000);
		job.put("MAX_SALARY", 30000);
		
		jobs.add(job);
		System.out.println(job);
		
		
		
//		행 하나 저장
		HashMap<String, Object> LPROD = new HashMap<String, Object>();
		LPROD.put("LPROD_ID", 1);
		LPROD.put("LPROD_GU", "p101");
		LPROD.put("LPROD_NM", "컴퓨터제품");
		
//		2 리스트 생성
		ArrayList<HashMap<String, Object>> LP = new ArrayList<HashMap<String, Object>>();
		LP.add(LPROD);
		System.out.println(LPROD);
		
		LPROD = new HashMap<>();
		LPROD.put("LPROD_ID", 2);
		LPROD.put("LPROD_GU", "p102");
		LPROD.put("LPROD_NM", "전자제품");
		
		LP.add(LPROD);
		System.out.println(LPROD);
		
		LPROD = new HashMap<>();
		LPROD.put("LPROD_ID", 3);
		LPROD.put("LPROD_GU", "p103");
		LPROD.put("LPROD_NM", "여성캐주얼");
		
		LP.add(LPROD);
		System.out.println(LP);
		
		
	/*	Set<String> key = LPROD.keySet();
		for(String keyy : key){ 
			System.out.println(keyy + " : "+ LPROD.get(keyy));
		}*/
		
		Set<String> key = LPROD.keySet();
		for(String keyy : key){ 
			System.out.print(keyy + "\t");
		}
		
		
		System.out.println();
		System.out.printf(LP.get(0).get("LPROD_GU")+"\t"+"\t"+LP.get(0).get("LPROD_NM")+"\t"+"\t"+LP.get(0).get("LPROD_ID"));
		System.out.println();
		System.out.printf(LP.get(1).get("LPROD_GU")+"\t"+"\t"+LP.get(1).get("LPROD_NM")+"\t"+"\t"+LP.get(1).get("LPROD_ID"));
		System.out.println();
		System.out.printf(LP.get(2).get("LPROD_GU")+"\t"+"\t"+LP.get(2).get("LPROD_NM")+"\t"+"\t"+LP.get(2).get("LPROD_ID"));
		
		System.out.println();
		
		/* 위 문장을 반복문으로 만들면
		 
		for(int i=0; i< LP.size(); i++){
		System.out.print(LP.get(i).get("LPROD_GU"));
		System.out.print("\t"+LP.get(i).get("LPROD_NM"));
		System.out.print("\t"+LP.get(i).get("LPROD_ID"));
	    System.out.println();
        }
        
        */
		
	
	}
}