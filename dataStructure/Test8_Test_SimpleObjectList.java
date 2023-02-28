package dataStructure;

import java.util.Comparator;
import java.util.Scanner;

//import Chap8_List.SimpleLinkedList.Menu;

class SimpleObject {
//	리스트 노드에 정수가 아닌 객체를 저장한다.
//	객체들의 데이터는 스트링으로 저장한다.
//	리스트 객체들은 이름 순서로 하고 이름이 같으면 회원번호 순서로 정렬한다.
	
	public SimpleObject(){
		
	}
	
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	// --- 데이터를 읽어 들임 ---//
//	void scanData(String guide, int sw) {
//		
//		System.out.println(guide + "할 데이터를 입력하세요."+ sw);
//		
//		if ((sw & NO) == NO) { //& 는 bit 연산자임 
//			System.out.print("번호: ");
//			no = kb.nextInt();
//		}
//		if ((sw & NAME) == NAME) {
//			System.out.print("이름: ");
//			name = stdIn.next();
//		}
//	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	//인스턴스 생성하여 번수에 저장
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no)>0 ) ? 1 : (d1.no.compareTo(d2.no)<0 ) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node1 {
	SimpleObject data;
	Node1 link;
	
	public Node1(SimpleObject element) {
		link = null;
		data = element;
	}
}

class LinkedList1 {
	Node1 first;
	
	public LinkedList1() {
		first = null;
	}
	
	public boolean Delete(SimpleObject element) //delete the element
	{
		
		
		
		return false;
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}
	
	//comparator 있어야할 거 같은데
	public void Add(SimpleObject element) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
	{
		
		
		Node1 newNode = new Node1(element);
		Node1 p = first, q= null;
		if(p==null) {
			first = newNode;
		}
		while(p!=null) {
			if(p.data > element) {
				
			}
		}
		
	}
	
	public boolean Search(SimpleObject data) { // 전체 리스트를 순서대로 출력한다.
		
		
		return false;
	}
}

public class Test8_Test_SimpleObjectList {

	 enum Menu {
	        Add( "삽입"),
	        Delete( "삭제"),
	        Show( "인쇄"),
	        Search( "검색"),
	        Exit( "종료");

	        private final String message;                // 표시할 문자열

	        static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
	            for (Menu m : Menu.values())
	                if (m.ordinal() == idx)
	                    return m;
	            return null;
	        }

	        Menu(String string) {                        // 생성자(constructor)
	            message = string;
	        }

	        String getMessage() {                        // 표시할 문자열을 반환
	            return message;
	        }
	    }

	    //--- 메뉴 선택 ---//
	    static Menu SelectMenu() {
			try (Scanner sc = new Scanner(System.in)) {
				int key;
				do {
				    for (Menu m : Menu.values()) {
				        System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				        if ((m.ordinal() % 3) == 2 &&
				              m.ordinal() != Menu.Exit.ordinal())
				            System.out.println();
				    }
				    System.out.print(" : ");
				    key = sc.nextInt();
				} while (key < Menu.Add.ordinal() || 
				                                    key > Menu.Exit.ordinal());
				return Menu.MenuAt(key);
			}
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴 
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		SimpleObject data = null;
		System.out.println("inserted");
	     l.Show();		
	        do {
	            switch (menu = SelectMenu()) {	             
	             case Add :                           // 머리노드 삽입
	            	 System.out.println("추가할 번호 입력");
	            	 String num = sc.next();
	            	 data = num;
	            	 System.out.println("추가할 이름 입력");
	            	 String name = sc.next();
	    	         l.Add(data);            
	                     break;
	                     
	             case Delete :    
	            	// 머리 노드 삭제
	            	 System.out.println("삭제할 번호 입력 : ");
	            	 String num1 = sc.next();
	            	 System.out.println("삭제할 이름 입력 : ");
	            	 String name1 = sc.next();
	            	 boolean result = l.Delete(data);
	            	 
	            	 System.out.println("삭제된 데이터는 " + num);
	                    break;
	                    
	             case Show :                           // 꼬리 노드 삭제
	                    l.Show();
	                    break;
	                    
	             case Search :                           // 회원 번호 검색
	            	 	System.out.println("검색할 번호 입력 : ");
	            	 	String num2 = sc.next();
	  	                boolean result1 = l.search();
	                    if (result1 == false)
	                        System.out.println("검색 값 = " + n + "데이터가 없습니다.");
	                    else
	                        System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
	                     break;
	             case Exit :                           // 꼬리 노드 삭제
	                    break;
	            }
	        } while (menu != Menu.Exit);
	    }
}
