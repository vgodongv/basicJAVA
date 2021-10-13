package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Map(Ű�� ���� �޾Ƽ� ����)�� ��ӹ޾� ����. Map�� �����ϰ� ���� Ű�� ����. �ε������ ������ ���������ʾƼ� ������ ����
		 * 
		 * Object put(Object key, Object value) : ������ Ű�� ���� �����Ѵ�. �Ű�� � ���� �����Ұ��ΰ�
		 * Object remove(Object key) : ������ Ű�� ����� ���� �����Ѵ�. Ű�� ���� ������
		 * Object get(Object key): ������ Ű�� ��(������ null)�� ��ȯ�Ѵ�.
		 * Set keySet(): ����� ��� Ű�� Set���� ��ȯ�Ѵ�.
		 * 
		 */
		
		//Map�� ����Ϸ��� ���� ��ü�� �����ؾ��Ѵ�. Ű�� ���׸� ���� ���׸� �ΰ� ����. ���� Ÿ�� Object�� ���־�
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("age", 10);
		map.put("name", "ȫ�浿");
		map.put("date", new Date()); // new Date()�� ��¥�� ǥ���ϱ����� ��ü
		
		System.out.println(map); // �ؽøʿ��� ������� ������ ���� ������ ������ ������� ��µ��� ����
		
		//hashmap ����
		map.put("name", "�̼���"); // ���� Ű�� ����Ͽ� ���� �־��ָ� ������ �ִ� ���� �����. �ϳ��� Ű�� �ϳ��� ���� ������ �� �ֱ� ������ !!!!!!!!!!!!!!!!!!!
		System.out.println(map);
		
		//�� ����
		map.remove("age"); //�����ϰ���� Ű�� �Ѱ��ָ��
		System.out.println(map);
		
		//���� ���
		Object value = map.get("name"); // ������ ���� Ű�� �Է��ϸ��. ���׸��� ObjectŸ������ �����߱⶧���� Object������ ����
		System.out.println(value);
		
		//���� value���� �޾Ƽ� String�޼��带 ����ϰ� �ʹٸ�? ����ȯ ���ָ��
		
//		System.out.println(value.substring(0,1));
//		System.out.println((String)value.substring(0,1)); �̷��� ����ȯ�ϸ� value.substring(0,1)�� ����ȯ�ϴ°Ŷ� ����
		System.out.println(((String)value).substring(0,1));
		
//		�ٵ� ����Ҷ����� ����ȯ�ϱ� �������ϱ� ���ʿ� ���������� ����ȯ
		String str = (String)map.get("name");
		
//		���Ű�� set�� ���·� ����. Set<String> ������ Ű ���׸��� String���� �����ؼ�
		Set<String> keys = map.keySet(); // ��� Ű�� ���Ե�
		
//		���� for�� set, ����Ʈ, �迭 �� �� : �ڿ� ��. :�տ��� set, ����Ʈ, �迭 ��� ���� �������� ������ ���� ��. 
//		keys���� ���� ������ ������ �����ϰ� �ٽ� �����ϴ� ���. �ٲ����� for�� ����
		for(String key : keys){ 
			System.out.println(key + " : "+ map.get(key));
		}
		
//		map�� ���� ���̺��� ������ ǥ���Ҷ� �ַ� ��� 
		
//		JOBS ���̺�
		
//		�� �ϳ� �����ϱ�. ���� ���� 4��. �÷����� Ű���ǰ� �÷����� ������ ���̵�

		HashMap<String, Object> job = new HashMap<String, Object>();
		job.put("JOb_ID", "AD_PRES");
		job.put("JOB_TITLE", "President");
		job.put("MIN_SALARY", 20080);
		job.put("MAX_SALARY", 40000);
		
//		�� ������ ���� ����Ʈ�� ����
		ArrayList<HashMap<String, Object>> jobs = new ArrayList<HashMap<String, Object>>();
		jobs.add(job);
		System.out.println(job);
		
//		�� �ϳ��� ���� -> �ؽ� �� ���� ����. �׳� ��� put�ϸ� �����°���.
		job = new HashMap<>();
		job.put("JOB_ID", "AD+VP");
		job.put("JOB_TITLE", "AdminStration Vice President");
		job.put("MIN_SALARY", 15000);
		job.put("MAX_SALARY", 30000);
		
		jobs.add(job);
		System.out.println(job);
		
		
		
//		�� �ϳ� ����
		HashMap<String, Object> LPROD = new HashMap<String, Object>();
		LPROD.put("LPROD_ID", 1);
		LPROD.put("LPROD_GU", "p101");
		LPROD.put("LPROD_NM", "��ǻ����ǰ");
		
//		2 ����Ʈ ����
		ArrayList<HashMap<String, Object>> LP = new ArrayList<HashMap<String, Object>>();
		LP.add(LPROD);
		System.out.println(LPROD);
		
		LPROD = new HashMap<>();
		LPROD.put("LPROD_ID", 2);
		LPROD.put("LPROD_GU", "p102");
		LPROD.put("LPROD_NM", "������ǰ");
		
		LP.add(LPROD);
		System.out.println(LPROD);
		
		LPROD = new HashMap<>();
		LPROD.put("LPROD_ID", 3);
		LPROD.put("LPROD_GU", "p103");
		LPROD.put("LPROD_NM", "����ĳ�־�");
		
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
		
		/* �� ������ �ݺ������� �����
		 
		for(int i=0; i< LP.size(); i++){
		System.out.print(LP.get(i).get("LPROD_GU"));
		System.out.print("\t"+LP.get(i).get("LPROD_NM"));
		System.out.print("\t"+LP.get(i).get("LPROD_ID"));
	    System.out.println();
        }
        
        */
		
	
	}
}