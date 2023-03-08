package dataStructure;

import java.util.Scanner;

public class SimpleObjectChainHashTester {
	 static Scanner stdIn = new Scanner(System.in);

	 //--- 데이터(회원번호＋이름) ---//
	 static class Data {
	     static final int NO   = 1;        // 번호를 읽어 들일까요?
	     static final int NAME = 2;        // 이름을 읽어 들일까요?

	     private Integer no;                      // 회원번호(키값)
	     private String  name;                    // 이름

	     //--- 키값 ---//
	     Integer keyCode() {
	         return no;
	     }

	     //--- 문자열 표현을 반환 ---//
	     public String toString() {
	         return name;
	     }

	 }

	 //--- 메뉴 열거형 ---//
	 enum Menu {
	     ADD(      "추가"),
	     REMOVE(   "삭제"),
	     SEARCH(   "검색"),
	     DUMP(     "표시"),
	     TERMINATE("종료");

	     private final String message;            // 표시할 문자열

	     static Menu MenuAt(int idx) {            // 순서가 idx번째인 열거를 반환
	         for (Menu m : Menu.values())
	             if (m.ordinal() == idx)
	                 return m;
	         return null;
	     }

	     Menu(String string) {                // 생성자(constructor)
	         message = string;
	     }

	     String getMessage() {                // 표시할 문자열을 반환
	         return message;
	     }
	 }

	 //--- 메뉴 선택 ---//
	 static Menu SelectMenu() {
	     int key;
	     do {
	         for (Menu m : Menu.values())
	             System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
	         System.out.print(" : ");
	         key = stdIn.nextInt();
	     } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

	     return Menu.MenuAt(key);
	 }

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     Menu menu;                                
	     SimpleObject3 data = null;
	     SimpleObjectChainHash hash = new SimpleObjectChainHash(13); //테이블 생성

	     do {
	         switch (menu = SelectMenu()) {
	          case ADD :                               // 추가
	        	  	 System.out.println("추가할 번호 입력");
		        	 String no = sc.next();			        				     
	            	 System.out.println("추가할 이름 입력");
	            	 String name = sc.next();
	                 data = new SimpleObject3(no, name);

	                  hash.add(data, SimpleObject3.NO_ORDER);
	                  break;

	          case REMOVE :                       // 삭제

//	                  hash.remove(temp.keyCode());
	                  break;

	          case SEARCH :                       // 검색
	
//	                  Data t = hash.search(temp.keyCode());
//	                  if (t != null)
//	                      System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
//	                 else
	                      System.out.println("해당 데이터가 없습니다.");
	                  break;

	          case DUMP :                            // 표시
	                  hash.dump();
	                  break;
	         }
	     } while (menu != Menu.TERMINATE);
	 }
	}