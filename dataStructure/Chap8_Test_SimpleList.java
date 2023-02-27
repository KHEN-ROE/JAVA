package dataStructure;

//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Scanner;

//import Chap8_List.SimpleLinkedList.Menu;

class Node {
	int data;
	Node link; //Node 타입의 변수(link) 선언
	
	//생성자
	public Node(int element) { 
		link = null;
		data=element;
	}
}

class LinkedList {
	
	Node first;
	
	public LinkedList() {
		first = null;
	}
	
	
	public boolean Delete(int element) //delete the element
	{
		//링크를 끊는 걸 구현.
		//element와 비교해서 존재하면 p가 가르키는 node 삭제
//		Node newNode = new Node(element);
		Node p = first, q = null;
		while(p != null) {
			if(p.data == element) { //일치하면
				if(q==null) { //element가 머리 노드면
					first = p.link; //p.~~ 인 이유 : Node가 참조 타입임. 즉 p는 참조변수임
				}else { //element가 머리 노드 아닐 때
					q.link = p.link;
				}
				return true;
			}
			q=p;
			p=p.link;
		}
		return false; // element 못 찾으면
		
	}
	
	public void Add(int element) //임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다 
	{
		Node newNode = new Node(element);
//		this.first = newNode;
		Node p = first, q = null; // 이러면 p가 null이 됨. 따라서 데이터 삽입 불가. q는 꼬리라서 null?
		if(p==null) {
			first = newNode;
		}
		while(p != null) {
			if(p.data > element) { //p.data가 더 크면
				newNode.link=p;
//				q.link = newNode;
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
	public boolean Search(int data) {
	    Node current = first;
	    while (current != null) {
	        if (current.data == data) {
	            return true;
	        }
	        current = current.link;
	    }
	    return false;
	}

	
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		//while loop 돌려서 출력.
		
		    Node current = first;
		    while (current != null) {
		        System.out.print(current.data + " ");
		        current = current.link;
		    }
		    System.out.println();
	}
}

public class Chap8_Test_SimpleList {
	enum Menu {
      Add("삽입"),
      Delete("삭제"),
      Show("인쇄"),
      Search("검색"),
      Exit("종료");

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
	LinkedList l = new LinkedList();
	Scanner sc = new Scanner(System.in);
	int data = 0;
	System.out.println("inserted");
		l.Show();		
	      do {
	          switch (menu = SelectMenu()) {	             
	           case Add :                           // 머리노드 삽입
	  	         double d = Math.random();
	  	         data = (int) (d * 50);
	  	         l.Add(data);            
	                   break;
	           case Delete :                          // 머리 노드 삭제
	          	 int num = sc.nextInt();
	          	 boolean result = l.Delete(num);
	          	 if(result) System.out.println("삭제된 데이터는 " + num);
	          	 else System.out.println("데이터 없음");
	                 	break;
	           case Show :                           // 꼬리 노드 삭제
	                  l.Show();
	                  break;
	           case Search :                           // 회원 번호 검색
	       		int n = sc.nextInt();
	              boolean result1 = l.Search(n);
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
