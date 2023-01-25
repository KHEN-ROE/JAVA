package edu.mission;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mission08_1 {//오류가 있는 코드

//	public static void main(String[] args) {
//		try (FileInputStream fi = new FileInputStream("input.txt");)
//			 {
//			try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {
//				String str;
//				while((str = br.readLine()) != null) {
//					System.out.println(str);
//				} str.split(str)
//				ArrayList<String> list = new ArrayList<String>();
//				
//				
//				} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static ArrayList<String> readNumbers() {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {

			ArrayList<String> list = new ArrayList<String>();

			String str;
			while((str = br.readLine()) != null) {
				System.out.printf("%30s\n", str);
				list.add(str);
			}				
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Integer> reverseNumber(String str) {

		String[] sa = str.split("");
		
		ArrayList<Integer> ret = new ArrayList<>();
		for (int i = sa.length -1 ; 0 <= i ; i--) {
			ret.add(Integer.parseInt(sa[i]));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
		// 먼저 데이터를 읽으들여서 배열로 만든다.
		ArrayList<String> strArr = readNumbers();
		if (strArr == null) {
			System.out.println("Error");
			return;
		}
		
		// 각 배열 데이터를 모두 잘라서 역순으로 숫자 배열로 만든다.
		ArrayList<Integer> arr1 = reverseNumber(strArr.get(0));	// { 5, 4, 3, 2, 1 }
		ArrayList<Integer> arr2 = reverseNumber(strArr.get(1)); // { 6, 7, 8, 9 }
		
		// 두 배열을 더한다.	==> arr1이 arr2보다 개수가 많다고 가정
		if (arr1.size() < arr2.size() ) {
			ArrayList<Integer> temp = arr1;
			arr1 = arr2;
			arr2 = temp;		
		}
		int add = 0;
		for (int i = 0 ; i < arr2.size(); i++) {
			int sum = arr1.get(i) + arr2.get(i) + add;
			if (10 <= sum) 	add = 1;
			else			add = 0;
			arr1.set(i, sum % 10);
		}
		
		// 출력한다.
		String result = "";
		for (int i = arr1.size() -1 ;0 <= i ; i--) {
			//System.out.print(arr1.get(i));
			result += arr1.get(i);
		}
		System.out.printf("%30s\n", result);
	}
}
