package dataStructure;

import java.util.Comparator;
import java.util.Scanner;

//import Chap8_List.SimpleLinkedList.Menu;

class SimpleObject implements Comparable<SimpleObject> {
	
//	리스트 노드에 정수가 아닌 객체를 저장한다.
//	객체들의 데이터는 스트링으로 저장한다.
//	리스트 객체들은 이름 순서로 하고 이름이 같으면 회원번호 순서로 정렬한다.
	
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	public SimpleObject(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public SimpleObject(String no1) {
		this.no=no1;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

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


	@Override
	public int compareTo(SimpleObject o) {
		if(this.no.compareTo(o.no)>0) {
			return 1;
		}
		else if (this.no.compareTo(o.no)<0) {
			return -1;
		}
		else return 0;
	}
	

//	public boolean equals(SimpleObject o) {
//		if(this.no.compareTo(o.no)==0) return true;
//		else return false;
//	}
	
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
		Node1 p = first, q = null;
		while(p != null) {
			if(p.data.compareTo(element)==0) { //일치하면
				if(q==null) { //element가 머리 노드면
					first = p.link; //p.~~ 인 이유 : Node가 참조 타입임. 즉 p는 참조변수임
				}else { //element가 머리 노드 아닐 때
					q.link = p.link; //q.link 에 null 저장. 즉 링크 끊음
				}
				return true;
			}
			q=p; //오름차순 정렬위한 코드임 디버깅해보면 앎
			p=p.link;
		}
		return false; // element 못 찾으면
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.

	    Node1 current = first;
	    while (current != null) {
	        System.out.print(current.data + " ");
	        current = current.link;
	    }
	    System.out.println();
	}
	
	
	public void Add(SimpleObject element) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
	{
		Node1 newNode = new Node1(element);
		Node1 p = first, q = null;
		if(p==null) {
			first = newNode; //오름차순으로 정렬하려면 비교할 데이터가 필요함. 초깃값 설정해줌
		}
		while(p!=null) {
			if(p.data.compareTo(element)>0) {
				newNode.link=p;
				if(q==null) first = newNode;
				else q.link = newNode;
				break;
			}else {
				q=p;
				p=p.link;
				if(p== null) {
					q.link = newNode;
					break;
				}
			}
		}
	}
	
	public boolean Search(SimpleObject element) { // 전체 리스트를 순서대로 출력한다.
		 Node1 current = first;
		    while (current != null) {
		        if (current.data.compareTo(element)==0) {
		            return true;
		        }
		        current = current.link;
		    }
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
			Scanner sc = new Scanner(System.in);
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
				} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
				
				return Menu.MenuAt(key);
	    }

	public static void main(String[] args) {
       Menu menu;                                // 메뉴 
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
			SimpleObject data = null;
			System.out.println("inserted");
			 	
			    do {
			        switch (menu = SelectMenu()) {	             
			         case Add :                           // 머리노드 삽입
			        	 System.out.println("추가할 번호 입력");
			        	 String no = sc.next();			        				     
		            	 System.out.println("추가할 이름 입력");
		            	 String name = sc.next();
			        	 data = new SimpleObject(no,name);
				         l.Add(data);            
			                 break;
			                 
			         case Delete :    
			        	// 머리 노드 삭제
			        	 System.out.println("삭제할 번호 입력 : ");
			        	 String no1 = sc.next();
			        	 data = new SimpleObject(no1);
//	            	 System.out.println("삭제할 이름 입력 : ");
//	            	 String name1 = sc.nextLine();
			        	 boolean result = l.Delete(data);  
			        	 if (result) System.out.println("삭제된 데이터는 " + no1 + "입니다.");
			        	 else		 System.out.println("데이터없음");
			                break;
			                
			         case Show :                           // 꼬리 노드 삭제
			                l.Show();
			                break;
			                
			         case Search :                           // 회원 번호 검색
			        	 	System.out.println("검색할 번호 입력 : ");
			        	 	String no2 = sc.next();
			        	 	data = new SimpleObject(no2);
			                boolean result1 = l.Search(data); 
			                if (result1 == false)
			                    System.out.println("검색 값 = " + no2 + "데이터가 없습니다.");
			                else
			                    System.out.println("검색 값 = " + no2 + "데이터가 존재합니다.");
			                 break;
			         case Exit :                           // 꼬리 노드 삭제
			                break;
			        }
			    } while (menu != Menu.Exit);
		
		
	}
}
