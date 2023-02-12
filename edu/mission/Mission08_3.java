package edu.mission;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mission08_3 {//큰 수 더하기 제출용

	private static ArrayList<ArrayList<Integer>> numArr = new ArrayList<>();//ArrayList 객체 생성. numArr참조변수에 인스턴스의 주솟값 저장. 제네릭으로 정수형태의 ArrayList를 또 받는다

	public static boolean readNumber() { //boolean타입을 반환하는 메소드 선언. input.txt를 읽어오는 메소드임
		String str;		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));) {

			for (int i = 0 ; i < 2 ; i++) {//2번만 도는 이유? 두 수를 더하려고?
				
				numArr.add(new ArrayList<Integer>());//참조변수를 이용해서 add메소드에 접근하고, ArrayList에 매개변수로 받은 값을 추가한다. 매개변수로 ArrayList 객체를 생성해서 전달?
				
				str = br.readLine();//참조변수 br을 이용해 readLine 메소드에 접근한다. input.txt에 있는 걸 한 줄씩 읽어서 String 타입의 str변수에 저장한다
				if (str == null)	return false; //input.txt에 아무것도 없으면 false 리턴
				System.out.println("input.txt에 있는 수 : "+str);
				
				String[] arr = str.split("");//str에 저장돼있는 input.txt의 값들을 하나씩 자름. 그걸 arr배열에 대입
//				for(String arr1 : arr) {
//					System.out.println(arr1);
//				}
				
				for (int j = arr.length - 1 ; j>=0 ; j--) {//거꾸로 출력하기 위한 반복문
					numArr.get(i).add(Integer.parseInt(arr[j]));//get(i)로 문자열을 가져온다. arr을 역순으로만든다. String 타입을 int형으로 변환한다. 그걸 ArrayList에 저장한다. 이제 숫자들이 역순으로 저장됐다
				}
			}
			System.out.println("잘라서 거꾸로 만든 리스트 : "+numArr);
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	public static void main(String[] args) {
		// 두 숫자 읽어서 배열로 입력
		if (readNumber() == false) { //input.txt파일 읽는 readNumber 메소드 호출. catch에 해당되면 Error 출력
			System.out.println("Error");
			return;
		}
		
		// 자리수가 큰 배열을 0번째로 설정
		int dif = numArr.get(0).size() - numArr.get(1).size();//size는 배열의 크기를 의미.
//		System.out.println("dif : "+dif);
		if (dif < 0) {//numArr.get(1)이 더 클 때
			ArrayList<Integer> tArr = numArr.get(0); //get(0)를 tArr에 대입
			numArr.set(0, numArr.get(1));//0번지를 numArr.get(1)으로 세팅
			numArr.set(1, tArr);//1번지를 numArr.get(0)으로 세팅. 즉, 자리를 바꿔주는 것임
			dif = Math.abs(dif);//절댓값으로 설정
		}
		// 두 배열 더하기
		int olrim = 0;
		for (int i = 0 ; i < numArr.get(1).size() ; i++) {//작은 자릿수만큼 반복
			int sum = numArr.get(0).get(i) + numArr.get(1).get(i) + olrim;//의미? get(0) 중에서 작은 자릿수 만큼 가져온다. + get(1)에서 get(1)의 개수만큼 가저온다. 둘을 더하여 sum에 저장
//			System.out.println("sum : "+sum);
			numArr.get(0).set(i, sum % 10); // 더한 값을 10으로 나눈 나머지를 numArr의 0번지에 저장한다.
//			System.out.println("sum"+numArr);
			if (sum >= 10)	olrim = 1; //더해서 10넘어가면 올림
			else			olrim = 0;	
		}
		System.out.println("두 배열을 더했을 때 : "+numArr);
		
		//이하의 코드는 맨 앞자리가 10이 넘어갈 때 올려주기 위한 코드
		if (olrim == 1) {//올림이 1일 때 
			if (numArr.get(0).size() == numArr.get(1).size()) {//numArr.get(0) 과 get(1)의 크기가 같으면
				numArr.get(0).add(1);//0번지에 1을 추가한다. 여기서 1은 그냥 정수 1
			}
			else {//numArr.get(0)과 get(1)의 크기가 다르면
				for (int i = numArr.get(1).size(); i < numArr.get(0).size(); i++) {//초깃값을 get(1)의 크기로 설정, get(0)의 크기와 같아지면 중단. 즉 19999 + 9999 면 한번만 실행
					int sum = numArr.get(0).get(i) + olrim;//get(0)에 작은 자릿 수 만큼 가져오고 olrim을 더한다. get(0)의 마지막 번지에 있는 숫자 가져오고 거기다 orlim을 더한다
					System.out.println("get0,1 다를 때 합 : "+sum);
					numArr.get(0).set(i, sum % 10);//ArrayList의 0번지에 합을 10으로 나눈 나머지 저장
					if (sum >= 10)	olrim = 1;//합이 10 넘어가면 올림에 1대입
					else			olrim = 0;//합이 0이 안 넘어가면 olrim을 0으로 만들어줘야한다. 안그러면 1이 자꾸 추가됨	
				}
			}
			//자리수가 넘어가면 1을 한번 더 더해줘야 하므로 이 코드 필요
			if (olrim ==1) numArr.get(0).add(1);
			
		}
		// 결과 출력하기
		System.out.println("=========================");
		System.out.print("두 수를 더한 값 : ");
		for (int i = numArr.get(0).size() - 1 ; i>=0 ; i--) {//역순으로 출력하기 위한 초깃값.
			System.out.print(numArr.get(0).get(i));
		}
	}
}
