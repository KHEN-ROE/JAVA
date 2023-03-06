package dataStructure;

import java.util.Comparator;


//체인해시 객체 생성하여 저장하는 버전
class SimpleObject3 {
	//필드
	private String no;
	private String name;
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//생성자
	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	
	// --- 회원번호로 순서를 매기는 comparator ---//
	//인스턴스 생성하여 번수에 저장
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no)>0 ) ? 1 : (d1.no.compareTo(d2.no)<0 ) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}

}

class Node3<V> { //이거를 그냥 내부 클래스로 선언해야 될 거 같은데??
	SimpleObject3 data;
	SimpleObject3 link;
	int size; //해시 테이블 크기
	//생성자
	public Node3(SimpleObject3 data, SimpleObject3 link) {
		this.data = data;
		this.link = link;
	}

	//생성자2
//	public Node3(V p, Node3<V> node) {
//		this.data = p;
//		
//	}
	
	 //--- 키의 해시값을 반환 ---//hashcode, hashvalue 나누지 말고, hashcode() 함수 사용해서 하나로 합쳐야할 것 같은데
    public int hashValue() {
    	SimpleObject3 so = this.data;
		 int number = Integer.parseInt(so.getNo());
		 
	     return number % size;
    }

  
}

public class SimpleObjectChainHash<V> {
	
	//필드
	int size; //해시 테이블 크기
	Node3<V> [] table; //SimpleObject 저장할 해시 테이블
	
	//생성자
	public SimpleObjectChainHash(int capacity) {
		 try {
	         table = new Node3[capacity];
	         this.size = capacity;
	     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
	         this.size = 0;
	     }
		 
	}
	
	
	//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
	 public SimpleObject3 search(SimpleObject3 element, Comparator<? super SimpleObject3> c) { //반환하는 타입? SimpleObject3이 맞는거 같은데
		 int hash = hashValue(element);
		 Node3<V> p = table[hash];
		 
		 while (p != null) {
	         if (c.compare(element, (SimpleObject3) p.data)==0) { //element는 simpleobject 타입이고 p는 V 타입임
	        	 return (SimpleObject3) p.data;
	         }
	    	 p = p.link; 
	     }
		 return null;
	 }
	 
	 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	 public void add(V element, Comparator<? super SimpleObject3> c) {
		 int hash = hashValue(element);
		 Node3<V> p = table[hash];
		 
		 while(p != null) {
			 if (c.compare(element, p.data)==0) {
				 System.out.println("이미 등록된 데이터");
			 }
			 p = p.link;
		 }
		 Node3<V> temp = new Node3<V>(p, table[hash]); //새로운 노드 만들어서 삽입
	     table[hash] = temp;                   // 테이블에 노드 삽입
	 }
	 
	 
}
