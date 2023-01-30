//2장 스트링 배열 정렬 merge
package dataStructure;
//1차 수업 - 2번째 코딩 실습
//중복이 없는 리스트를 merge하는 버젼

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Templates;

import java.util.Collections;
import java.util.Iterator;
//10장 Collection, Test01, Test02를 사용
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class ArrayListMerge02 { //중복 제거한 코드
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장


	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	static ArrayList<String> removeDuplicate(ArrayList<String> a1) {//ArrayList를 매개변수로 받는다. 여기서는 list1,list2를 받는다
	//구현할 부분 : 리스트에서 중복을 제거한다, 정렬후 호출하는 것을 전제로 구현
		//list를 배열로 만들어 놓고 그 다음 중복 제거
		//list1을 받아서 요소들을 비교해서 같으면 제거를 하라.
		
		ArrayList<String> rlist = new ArrayList<>();//ArrayList 하나 선언한다
		for(String s : a1) {
			if(!rlist.contains(s)) {
				rlist.add(s);
			}
		}
		return rlist;
	
		
		
		
		
	}
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("a1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			
			Path input2 = Paths.get("a2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);
			String s1 = new String(bytes1);
			String s2 = new String(bytes2);		
			System.out.println("s1 = " + s1);
			System.out.println("s2 = " + s2);
			System.out.println();
			String[] sarray1 = s1.split(",|\r\n");// 자바 regex \n으로 검색
			String[] sarray2 = s2.split(",|\r\n");//file에서 enter키는 \r\n으로 해야 분리됨
			for (int i = 0; i <sarray1.length; i++) {
				sarray1[i] = sarray1[i].trim();//trim 은 공백제거
			}
			for (String city : sarray1)
				System.out.print(city + " ");//배열을 문자열로 출력
			System.out.println();

			for (int i = 0; i <sarray2.length; i++) {
				sarray2[i] = sarray2[i].trim();//trim은 , 제거 였나?
			}
			for (String city : sarray2)
				System.out.print(city + " ");//배열을 문자열로 출력
			System.out.println("\n+++++++");
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:배열 사용
			ArrayList<String> list1 = new ArrayList<>();
			for (String temp : sarray1) {//배열을 temp에 하나씩 넣는다
				list1.add(temp);//배열을 문자열로 바꾼다음 다시 리스트에 추가. 즉 배열을 리스트로 바꿈
			}
			// 방법2 ㅡ List 사용
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));//배열을 매개변수로 받아서 asList메소드 이용하여 리스트로 변환. 생성자 매개변수로 배열 전달.이게 더 간결한 방식

			System.out.println("collection.sort()::");
			Collections.sort(list1);//Collection클래스의 sort메소드 이용해 정렬
			System.out.print("list1::");
			for (String city : list1)//list1을 아직 배열로 바꾸지 않은 상태
				System.out.print(city + " ");

			//Arrays.sort(list2, null);
			System.out.println();
			System.out.print("list2::");		
			Collections.sort(list2);//list2를 정렬
			for (String city : list2)//list2를 아직 배열로 바꾸지 않는 상태
				System.out.print(city + " ");
			//정렬된 list에서 중복 제거 코드 1. 이거하고
			
			list1 = removeDuplicate(list1);//중복제거
			list2 = removeDuplicate(list2);//중복제거 됐으나 여전히 리스트임. 배열로 안바꿈
 

			System.out.print("\n" + "list1******");
			for (String city : list1)//중복제거한 리스트 출력
				System.out.print(city + " ");
			System.out.print("\n" + "list2******");
			for (String city : list2)
				System.out.print(city + " ");
			ArrayList<String> list3 = new ArrayList<String>();
			//--------------------- array version: merge에 중복 제거하면 정상 동작함 
			String [] sl1 = new String[list1.size()];//리스트1을 다시 배열로 치환
			String [] sl2 = new String[list2.size()];//리스트2를 다시 배열로 치환
			String [] sl3 = new String[list1.size() + list2.size()];//list 1, 2 합친 크기
			sl1 = list1.toArray(sl1);//toArray메소드 사용하여 리스트를 배열로 치환
			sl2 = list2.toArray(sl2);//배열로 바꾼 상태
			System.out.println();
			for (String city : sl1)
				System.out.print(city + " ");
			System.out.println();
			for (String city : sl2)
				System.out.print(city + " ");
			int px = 0, qx = 0, rx = 0;//인덱스로 쓰려고 선언한 변수
//			int cnt1 = sl1.length, cnt2 = sl2.length;
			//merge하는 부분을 구현: 스트링 배열이 정렬되고 중복이 제거된 경우 2. 이거하고
			
			//sl1 sl2 비교. 각 번지수 비교해서 sl3에 대입. 여기서 sl1,2,3,은 배열임
			while(px<sl1.length && qx<sl2.length) {
				if(sl1[px].compareTo(sl2[qx])<0) {
					sl3[rx++] = sl1[px++];//번지수 증가 시켜서 다시 while문의 조건식으로 돌아간다
				}
				else if(sl1[px].compareTo(sl2[qx])>0) {
					sl3[rx++] = sl2[qx++];
				}
				else {
					sl3[rx++] = sl1[px++];
					qx++;//이건 머지? 초기 조건식 만족시키는 용도?
				}
			}
			while(px<sl1.length) {
				sl3[rx++] = sl1[px++];
			}
			while(qx<sl2.length) {
				sl3[rx++] = sl2[qx++];
			}
			System.out.print("\nsl3 = ");
			for (String city : sl3)
				if(city !=null) {
					System.out.print(city + " ");
				}
				
			// -------------------- list version
			/*
			Iterator<String> iter1 = list1.iterator();
			Iterator<String> iter2 = list2.iterator();
			// iterator를 사용하여 merge하는 코드: 복잡하다. 비추 
			// iterator를 사용하여 merge한다
			String d1=null, d2=null, temp = null;
			int m = 0;
			while(iter1.hasNext() && iter2.hasNext()) {
				if (m == 0) {
				d1 = iter1.next();
				d2 = iter2.next();
				if (temp != null) {
					if (d1.compareTo(temp) == 0) {
						d1 = iter1.next();
						continue;
					}
					else if (d2.compareTo(temp) == 0) {
						d2 = iter2.next();
						continue;
					}else {
						list3.add(temp);
					}
				}
				m = 1;
				}
				if (d1.compareTo(d2)< 0) {
					list3.add(d1);
					d1 = iter1.next();
				}
				if (d1.compareTo(d2) > 0) {
					list3.add(d2);
					d2 = iter2.next();
				}	
				else {
					temp = d1;
					m = 0;
				}
				
			}
			while (iter1.hasNext()) {
				if (d1.compareTo(d2)> 0) {
					list3.add(d2);
					list3.add(d1);
					do {
						d1 = iter1.next();
						list3.add(d1);
					} while(iter1.hasNext());
				} else if (d1.compareTo(d2)< 0) {
					list3.add(d1);
					d1 = iter1.next();
					if (iter1.hasNext())
						continue;
					else
						if (d1.compareTo(d2)<= 0) {
							list3.add(d1);
							break;
						}
						else list3.add(d2);
				} {
					list3.add(d1);
					while (iter1.hasNext()) {
						d1 = iter1.next();
						list3.add(d1);
					}
					break;
				}
			}
			while (iter1.hasNext()) {
				//coding 필요 
			}
			*/
			
			/* 중복을 포함하여 merge하는 코드: 복잡하다. 비추
			String data1=null, data2 = null;
			int mode = 0;
			while (mode >= 0) {
				if (mode == 0) {
				data1 = iter1.next();
				data2 = iter2.next();
				System.out.println("data1 = " + data1);
				System.out.println("data2 = " + data2);
				}
				else if (mode == 1) {
					data1 = iter1.next();
					System.out.println("data1 = " + data1);
				}
				else
					data2 = iter2.next();
				System.out.println("data2 = " + data2);

				if ((data1.compareTo(data2)) <= 0) {

					list3.add(data1);
					if (iter1.hasNext())
					mode = 1;
					else {mode = -1;
					list3.add(data2);
					}
				

				} else if ((data1.compareTo(data2)) > 0) {
					list3.add(data2);
					if (iter2.hasNext())
					mode = 2;
					else {mode = -2;
					list3.add(data1);
					}
				} 
			}
			*/
			
			// binary search 구현
			// 방법1:
			//Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);

			// 방법3:

//			System.out.println();
//			System.out.println("merge:: ");
//			for (String city : list3)
//				System.out.print(city + " ");
//			// ArrayList를 배열로 전환
//			String[] st = list3.toArray(new String[list3.size()]);
//			// binary search 구현
//			// binSearch(st, st.length, "key");
//			// 정렬된 list3을 file에 출력하는 코드 완성
//			System.out.println("\n" + "file에 출력:");
//			int bufferSize = 10240;
//			String b = " ";
//			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
//			for (String sx : list3) {
//				System.out.println(" " + sx);
//				buffer.put(sx.getBytes());
//				buffer.put(b.getBytes());
//			}
//			buffer.flip();
//			FileOutputStream file = new FileOutputStream("c.txt");
//			FileChannel channel = file.getChannel();
//			channel.write(buffer);
//			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
