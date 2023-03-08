package dataStructure;

import java.util.Comparator;

import dataStructure.ChainHash.Node;


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
			return (d1.name.compareTo(d2.name) > 0) ? 1 : (d1.name.compareTo(d2.name) < 0) ? -1 : 0;
		}
	}

}

public class SimpleObjectChainHash<V> {
	
	class Node3<V> { //이거를 그냥 내부 클래스로 선언해야 될 거 같은데??
		SimpleObject3 data;

		SimpleObjectChainHash<V>.Node3<V> next;
		SimpleObjectChainHash<V>.Node3<V> data1;
		
//		//생성자0
//		public Node3() {
//			this.data = null;
//			this.next = null;
//		}
		
		//생성자1
		public Node3(SimpleObject3 data) {
			this.data = data;
			this.next = null;
		}
		
		//생성자2
		public Node3(SimpleObject3 data, SimpleObjectChainHash<V>.Node3<V> next) {
			this.data = data;
			this.next = next;
		}

		public Node3(SimpleObjectChainHash<V>.Node3<V> p, SimpleObjectChainHash<V>.Node3<V> node3) {
			this.data1 = p;
			this.next = node3;
		}
	
		 //--- 키의 해시값을 반환 ---//hashcode() 함수 사용?
//	    public int hashCode() {
//	    	SimpleObject3 so = this.data;
//			 int number = Integer.parseInt(so.getNo());
//			 
//			 return hashValue(number);
//	    } 
	}
	
	//필드
	int size; //해시 테이블 크기
	Node3<V> [] table; //SimpleObject 저장할 해시 테이블
	
	//생성자
	public SimpleObjectChainHash(int capacity) {
		 try {
	         table = new Node3[capacity];
	         this.size = capacity;
	     } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없는 경우
	         this.size = 0;
	     }
		 
	}
	
	//해시코드값 리턴
	public int hashValue(SimpleObject3 so) {
		//String str = so.getNo();
		//int intValue2 = Integer.parseInt(str); 이게 방법 1 밑에가 방법 2
		 int intValue = so.hashCode(); //모든 객체는 해시코드가 있다
	     return intValue % size;
	 }
	
	//--- 요소 검색(데이터를 반환) ---//
	 public SimpleObject3 search(SimpleObject3 element, Comparator<? super SimpleObject3> c) { //반환하는 타입? SimpleObject3이 맞는거 같은데
		 int hash = hashValue(element); //hashValue(element)는 해당 객체의 해시코드 값
		 Node3<V> p = table[hash]; 
		 
		 while (p != null) {
	         if (c.compare(element, p.data)==0) { 
	        	 return p.data;
	         }
	    	 p = p.next; //p.next는 simpleobject3 타입이고, p는 simpleobjectchainHash 타입이다
	     }
		 return null;
	 }
	 
	 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
	 public void add(SimpleObject3 element, Comparator<? super SimpleObject3> c) { //데이터가 안들어가는 상황. 제네릭 다 지우고 해볼까..
		 Node3 newNode = new Node3(element);
		 int hash = hashValue(element);
		 Node3<V> p = table[hash]; // 현재 테이블이 null
		 
		 if(p == null) {
			 table[hash] = newNode;
		 }
		 while(p != null) {
			 if (c.compare(element, p.data)==0) {
				 System.out.println("이미 등록된 데이터");
			 }
			 p = p.next;
		 }
		 Node3<V> temp = new Node3<V>(p, table[hash]); //새로운 노드 만들어서 삽입
	     table[hash] = temp;                   // 테이블에 노드 삽입
	 }
	 
	 //--- 해시 테이블을 덤프(dump) ---//
	 public void dump() {
	     for (int i = 0; i < size; i++) {
	         Node3<V> p = table[i];
	         System.out.printf("%02d  ", i);
	         while (p != null) {
	             System.out.printf("→ (%s)  ",p.data);
	             p = p.next;
	         }
	         System.out.println();
	     }
	 }
	 
}
