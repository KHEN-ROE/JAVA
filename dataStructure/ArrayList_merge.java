package dataStructure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

//10장 Collection, Test01, Test02를 사용

//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\ 
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열만들고 > ArrayList로 바꿔줌 > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장

public class ArrayList_merge {
	/*
	static int binSearch(String[] s, int n, String key) {
		//자료구조 책 페이지 115 코드 사용한다.
	}
	*/
	public static void main(String[] args) {
		try {
			Path input1 = Paths.get("list1.txt"); // 파일1을 먼저 읽어온다
			byte[] bytes1 = Files.readAllBytes(input1); //파일을 읽어와서 배열에 저장한다.
			
			Path input2 = Paths.get("list2.txt"); // 파일 2를 읽어온다
			byte[] bytes2 = Files.readAllBytes(input2); // 파일 2를 읽어와서 배열에 저장
			
			String[] sarray = new String[20]; //20개 짜리 배열을 만든다
			String[] sarray2 = new String[20];//20개 짜리 배열을 만든다
				String s1 = new String(bytes1);// s1 문자열 변수에 배열을 저장한다
				String s2 = new String(bytes2);// s2 문자열 변수에 배열을 저장한다.
				
				System.out.println("s1 = " + s1);
				sarray = s1.split(",");
//				for(int i=0; i<sarray.length; i++) {
//					System.out.println(sarray[i]);
//				}
				System.out.println("s2 = " + s2);
				sarray2 = s2.split(",");
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:
			ArrayList<String> arrayList = new ArrayList<>();
			for (String temp : sarray) {//배열을 문자열로 만들어서
				arrayList.add(temp);//문자열을 리스트에 추가. 즉 배열을 리스트로 바꿈
			}
			ArrayList<String> arrayList2 = new ArrayList<>();
			for (String temp2 : sarray2) {
				arrayList2.add(temp2);
			}
			arrayList.addAll(arrayList2);//arrayList와 arrayList2를 합친것
			Collections.sort(arrayList);
			System.out.println("arrayList : "+arrayList);//이렇게 하니까 정렬되네 ㅋㅋ
			
			// 방법2
			ArrayList<String> list1 = new ArrayList<>(Arrays.asList(sarray));

			ArrayList<String> list2 = new ArrayList<String>(Arrays.asList(sarray2));
			// file2에서 read하여 list1.add()한다.

			//
			System.out.println("collection.sort()::");
			Collections.sort(list1);
			System.out.println("list1::");
			for (String city : list1)
				System.out.print(city + " ");
			
			System.out.println();
			
			System.out.println("list2::");
			Collections.sort(list2);
			for (String city : list2)
				System.out.print(city + " ");
			
			System.out.println();
			
			ArrayList<String> list3 = new ArrayList<String>();

			Iterator<String> iter1 = list1.iterator();//변수에 각 리스트를 가리키는 포인터 할당
			Iterator<String> iter2 = list2.iterator();
			// iterator를 사용하여 merge한다
			String data1 = iter1.next();
			String data2 = iter2.next();
			
			while(iter1.hasNext() && iter2.hasNext()) {
				if(data1.compareTo(data2)<0) {
					list3.add(data1);
					data1 = iter1.next(); //작은 것만 돌고 빠져나감
				}else if(data1.compareTo(data2)>0) {
					list3.add(data2);
					data2 = iter2.next();
				}else {// 비교하여 ==0 이 됐을때. 중복을 허용하지 않으려면?
					list3.add(data1);
					list3.add(data2);
					data1 = iter1.next();
					data2 = iter2.next();
				}
			}
			while(iter1.hasNext()) {
				//비교해서 남는거 같다 붙이기
				list3.add(data1);
				data1 = iter1.next();
			}
			while(iter2.hasNext()) {
				//비교해서 남는거 같다 붙이기
				list3.add(data2);
				data2 = iter2.next();
			}
			
//			System.out.println("data1 = " + data1);
//			System.out.println("data2 =" + data2);
//			
//			data1 = iter1.next();
//			data2 = iter2.next();
//			
//			System.out.println("data1 = " +data1);
//			System.out.println("data2 = " +data2);
			//ArrayList를 merge하는 코드 구현 list3 = list1 + list2(merge)

			// binary search 구현
			// 방법1:
//			Arrays.binarySearch(null, null, null);// ArrayList에는 binarySearch()가 없다.
			// 방법2:
			// int result = Collections.binarySearch(list3, newFruit, cc);

			// 방법3:

			System.out.println();
			System.out.println("merge:: ");
//			Collections.sort(list3);
			for (String city : list3)
				System.out.print(city + " ");
			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			int bufferSize = 10240;
			String b = " ";
			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			for (String sx : list3) {
				System.out.println(" " + sx);
				buffer.put(sx.getBytes());
				buffer.put(b.getBytes());
			}
			buffer.flip();
			FileOutputStream file = new FileOutputStream("d.txt");
			FileChannel channel = file.getChannel();
			channel.write(buffer);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
