package dataStructure;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject1 {
	/*
	 * 1. SimpleObject을 list로 만든다
	 * 
	 * 2. circular doubly linked list
	 * 
	 * 3. head node를 갖고 있다
	 */

	String sno; // 회원번호
	String sname; // 이름

	// 생성자
	public SimpleObject1(String sno, String sname) {
		this.sno = sno;
		this.sname = sname;
	}

	// 번호 검색용 생성자 - search 메소드 용
	public SimpleObject1(String sno) {
		this.sno = sno;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + sno + ") " + sname;
	}

	private static class NoOrderComparator implements Comparator<SimpleObject1> {
		@Override
		public int compare(SimpleObject1 o1, SimpleObject1 o2) {
			return (o1.sno.compareTo(o2.sno) > 0) ? 1 : (o1.sno.compareTo(o2.sno) < 0) ? -1 : 0;
		}
	}
	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject1> NO_ORDER = new NoOrderComparator();

	

	private static class NameOrderComparator implements Comparator<SimpleObject1> {
		@Override
		public int compare(SimpleObject1 o1, SimpleObject1 o2) {
			return o1.sname.compareTo(o2.sname);
		}
	}
	// --- 이름으로 순서를 매기는 comparator ---//
		public static final Comparator<SimpleObject1> NAME_ORDER = new NameOrderComparator();
}

class Node2 {//헤드노드
	SimpleObject1 data; // 데이터
	Node2 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
	Node2 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

	Node2() {
		this.data = null; // 더미노드 만드는 생성자. 더미노드? = 데이터 갖지않는 노드. 삽입,삭제 원활히 처리하기 위해 리스트의 머리에 계속 존재
		llink = rlink = this; // 좌우측 포인터가 자기자신을 가리킴. 첨에 좌우측포인터 모두 null
	}
	
	// --- 생성자(constructor) ---//
	Node2(SimpleObject1 so) { // 새로운 노드 삽입될 때
		this.data = so;
		llink = rlink = this; // this는 sno, sname. 즉 최초에 노드 삽입 시 헤드노드의 llink, rlink 둘다 새로운 노드 가리킴
	}

	Node2(String sno, String sname) { // 이건 언제?
		data = new SimpleObject1(sno, sname);
		llink = rlink = this;
	}

	public int compareNode(Node2 n2) {
		SimpleObject1 so1 = this.data;
		if (SimpleObject1.NO_ORDER.compare(so1, n2.data) < 0)
			return -1;
		else if (SimpleObject1.NO_ORDER.compare(so1, n2.data) > 0)
			return 1;
		else
			return 0;
	}
}

class DoubledLinkedList2 {
	private Node2 first; // 머리 포인터(참조하는 곳은 더미노드)

// --- 생성자(constructor) ---//
	public DoubledLinkedList2() {
		first = new Node2(); // dummy(first) 노드를 생성. 더미노드는 데이터 안 가짐.
								// first 는 null이 됨
	}

// --- 리스트가 비어있는가? ---// 즉 더미노드만 있는가?
	public boolean isEmpty() {
		return first.rlink == first; // 더미 노드의 뒤쪽 포인터가 더미노드 가리킴.
	}

// --- 노드를 검색 ---//
	public SimpleObject1 search(SimpleObject1 obj, Comparator<? super SimpleObject1> c) {
		Node2 ptr = first.rlink; // 현재 스캔 중인 노드. 더미노드의 뒤쪽 포인터가 가리키는 노드부터 시작

		while (ptr != first) {
			if (c.compare(obj, ptr.data) == 0) {
				return ptr.data;
			}
			ptr = ptr.rlink;
		}
		return null;
	}

// --- 전체 노드 표시 ---//
	public void show() {
		Node2 current = first.rlink;
		while (current != first) {
			System.out.print(current.data + " ");
			current = current.rlink;
		}
		System.out.println();
	}

// --- 올림차순으로 정렬이 되도록 add ---//
	public void add(SimpleObject1 so, Comparator<? super SimpleObject1> c) {
		Node2 temp = new Node2(so); // 삽입하기 위해서 새로운 노드 만들고 회원번호, 이름을 데이터에 저장
		Node2 current = first.rlink; // first는 처음에 null. 이거는 포인터

		while (current != first && c.compare(temp.data, current.data) >= 0) {//첫 번째 노드가 아니고,
			current = current.rlink; //추가하려는 노드가 현재 노드보다 크거나 같으면 오른쪽(current.rlink)으로 이동하여 다음 노드로 반복.
									//temp가 current 다음에 와야 하는 경우 rlink 참조를 사용하여 current가 다음 노드로 이동
									//temp가 current 이전 또는 동일한 위치에 와야 하는 경우 llink 및 rlink 참조를 사용하여 current 앞에 temp가 삽입
		}

		temp.llink = current.llink;
		temp.rlink = current;
		current.llink.rlink = temp; //current 왼쪽에 있는 노드의 rlink를 reference
		current.llink = temp;

	}

// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(SimpleObject1 obj, Comparator<? super SimpleObject1> c) {
		Node2 p = first.rlink; // 처음 노드부터 시작
		while (p != first && c.compare(p.data, obj) != 0) { // 끝까지 반복 or 노드 찾을 때까지
			p = p.rlink;
		}
		if (p == first) { // 노드 없을 때
			System.out.println("해당 노드가 존재하지 않습니다.");
			return;
		}
		// 노드 삭제
		p.llink.rlink = p.rlink;
		p.rlink.llink = p.llink;
		p.rlink = p.llink = null;
		System.out.println("삭제 완료: " + p.data.toString());
	}

	public DoubledLinkedList2 merge(DoubledLinkedList2 lst2) { // 리스트 병합
		DoubledLinkedList2 lst3 = new DoubledLinkedList2();
		Node2 ai = this.first.rlink, bi = lst2.first.rlink;

		return lst3;
	}
}

public class Chap8_Test_SimpleObjectCircularDList {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc1 = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc1.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Circular Doubley Linked List");
		DoubledLinkedList2 lst1 = new DoubledLinkedList2(); // add, delete, show, search 메소드가 있는 객체. 메소드 호출하려고 객체 생성. +
															// 이게 리스트 본체
		String sno1 = null, sname1 = null; // 회원번호와 이름을 문자열로 선언
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				Scanner sc = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc.next();
				System.out.println(" 회원이름: ");
				sname1 = sc.next();
				SimpleObject1 so = new SimpleObject1(sno1, sname1); // 회원 번호와 이름을 SimpleOject1 생성자에 전달한다. SimpleObject의
																	// this 영역에 회원번호, 이름 저장됨. 참조변수 so가 이것들의 주소값 가짐
				lst1.add(so, SimpleObject1.NO_ORDER); // add 메서드에 회원번호와 이름이 참긴 참조변수,
				break;

			case Delete: // 머리 노드 삭제
				Scanner sc2 = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc2.next();
				System.out.println(" 회원이름: ");
				sname1 = sc2.next();
				SimpleObject1 so2 = new SimpleObject1(sno1, sname1);
				lst1.delete(so2, SimpleObject1.NO_ORDER);
				break;

			case Show:
				lst1.show();
				break;

			case Search: // 회원 번호 검색
				Scanner sc3 = new Scanner(System.in);
				System.out.println(" 회원번호: ");
				sno1 = sc3.next();

				SimpleObject1 so3 = new SimpleObject1(sno1);
				SimpleObject1 result = lst1.search(so3, SimpleObject1.NO_ORDER);
				if (result == null)
					System.out.println("데이터 없음");
				else
					System.out.println("검색 값 = " + sno1 + "데이터가 존재합니다.");

			case Exit:
				break;
			}
		} while (menu != Menu.Exit);
	}
}