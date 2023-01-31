package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Fruit implements Comparable<Fruit> {//comparable 인터페이스는 자바에서 기본제공하는 인터페이스
	    private String name;
	    private int price;
	    public Fruit(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }
	
	    @Override
	    public String toString() {
	        return "<" + name + ", " + price + ">";
	    }
	
	//	@Override
		public int compareTo(Fruit o) {//이름끼리 비교? 가격 끼리 비교? 둘 중하나 정하고. 이름이 같으면 가격끼리 비교 이런식으로
		//추상메소드 구현할 부분
			if(this.name.compareTo(o.name)<0) { //this는 수신객체
				return 1;
			}
			else if(this.name.compareTo(o.name)>0) {
				return -1;
			}
			else {
				return 0;
			}
			
			
		}
		public int getPrice() {
			return price;
		}
	}


public class Chap3_ObjectArraySort {
		public static void main(String[] args) {
	//	String[] s = { "sort", "string", "array" };
	//	Arrays.sort(s);
	//	Arrays.sort(s, Comparator.naturalOrder());//오름차순
	//	Arrays.sort(s, Comparator.reverseOrder());//내림차순
		
		/*
		Arrays.sort(s, new Comparator<String>() {//익명클래스
		    @Override
		    public int compare(String o1, String o2) {
		        return o2.compareTo(o1);            // 내림차순으로 정렬
		    }
		});
		*/
	//	s = Arrays.stream(s).sorted().toArray(String[]::new);	//stream에서 처리
	//	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
	//	Collections.sort(Arrays.asList(s));//스트링을 리스트로 만들고 리스트로 정렬. 만약 배열로 바꾸려면 toarray.
		Fruit[] arr = {//객체 배열
		        new Fruit("사과", 200),//배열의 원소가 객체 - 실무에서 많이 씀
		        new Fruit("키위", 500),
		        new Fruit("오렌지", 200),
		        new Fruit("바나나", 50),
		        new Fruit("수박", 880),
		        new Fruit("체리", 10)
		};
		
//	    System.out.println(arr);
	    System.out.println("정렬전::");
	    for (Fruit city : arr)//배열을 for each문 사용해서 출력
	    	System.out.print(" " + city);//정렬 전의 배열 출력
	    
		Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //여기서 정렬을 한다.
																//Fruit에 compareTo()가 있어도 람다식 우선 적용
																//즉 price를 오름차순으로 정렬
		//람다식 -  익명클래스, 객체생성, 메소드오버라이딩 및 구현 한번에
		//배열을 정렬. 근데 매개 변수 a,b 가 뭐지?
		
	//    int count = arr.length;
	//    for (int i = 0; i < count; i++)
	//    	for (int j = i +1; j < count; j++) {
	//    		if (arr[i].compareTo(arr[j]) > 0)
	//    		{
	//    			Fruit temp; temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	//    		}
	//    	}
	    System.out.println();
	    System.out.println("정렬후::");
	    for (Fruit city : arr)
	    	System.out.print(" " + city);//정렬 된 배열 출력
	
		ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));//정렬된 arr배열을 매개변수로 받아서 lst1에 저장
																		 //배열을 리스트로 변환한 것
		ArrayList<Fruit> lst2 = new ArrayList<Fruit>();//새로운 객체 리스트 생성
		lst2.add(new Fruit("복숭아", 200));
		lst2.add(new Fruit("포도", 300));
		lst2.add(new Fruit("참외", 100));
		lst2.add(new Fruit("딸기", 50));
		lst2.add(new Fruit("블루베리", 500));
		lst2.add(new Fruit("구지뽕", 300));
		System.out.println();
		Collections.sort(lst2, (a,b) -> a.getPrice() - b.getPrice());
		System.out.println("새로운 리스트2::");
	    for (Fruit city : lst2)
	    	System.out.print(" " + city);//새로운 객체 리스트 2 출력
	//    Arrays.sort(lst2);//
//	    Collections.sort(lst2);//객체 리스트 정렬. 근데 정렬 안 됨
	    
	    
		System.out.println();
	
	    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();//iterator 사용해서 lst 1 2 합치고 lst3에 대입(병합할 리스트)
		
		Iterator<Fruit> iter1 = lst1.iterator();//iter1에 각 리스트를 가리키는 포인터 할당
		Iterator<Fruit> iter2 = lst2.iterator();
		Fruit data1 = iter1.next();//iterator 실행?
		Fruit data2 = iter2.next();
		//지금까지 정리하면 arr배열을 만들어서 가격순으로 정렬했고 그걸 lst1 리스트로 변환. 그리고 새로운 lst2 리스트를 만들고 정렬했다.
		//lst3 리스트를 만들었고 여기다가 lst1과 lst2를 병합해서 넣을 예정. 이때 iterator를 사용한다.
		
	    	//구현할 부분. 여기다가 구현
		while(iter1.hasNext() && iter2.hasNext()) {
			if(data1.compareTo(data2)<0) {
				lst3.add(data1);
				data1 = iter1.next();
			}else if(data1.compareTo(data2)>0) {
				lst3.add(data2);
				data2 = iter2.next();
			}
			else {
				lst3.add(data1);
				data1 = iter1.next();
			}
		}
		while(iter1.hasNext()) {
			lst3.add(data2);
			data1 = iter1.next();
		}
		while(iter2.hasNext()) {
			lst3.add(data2);
			data2 = iter2.next();
		}
//		Collections.sort(lst3);//이름 순으로 정렬
		Collections.sort(lst3, (a,b) -> a.getPrice() - b.getPrice());//람다식으로 정렬
		
		System.out.println();
	    System.out.println("merge:: ");
	    for(Fruit city: lst3)
	    	System.out.print(city+ " ");
	    
	    System.out.println();
	    
	    Fruit newFruit = new Fruit("참외", 100);//새로운 객채생성하고 생성자에 매개변수 전달
	    //binary search
	    Comparator<Fruit> cc = new Comparator<Fruit>() {//익명클래스 사용, 객체 생성하여 cc에 대입
	        public int compare(Fruit u1, Fruit u2) {//compare 메소드 선언하면서 리턴값으로 compareTo메소드 호출
	          return u1.compareTo(u2);//Fruit에 있는 메소드 호출
	        }
	      };
	     int res = cc.compare(data1, newFruit);//res변수에 data1과 newFruit 객체를 비교한 true false값 대입
	     if (res > 0)//res가 참이면
	    	 System.out.println("\ndata1 > newFruit\n");
	      /*
	    System.out.println();
	    int result = Collections.binarySearch(lst3, newFruit, cc);
			System.out.println("\nCollections.binarySearch() 조회결과::" + lst3.get(result));
		*/
	
		Fruit [] fa = new Fruit[lst3.size()];
		fa = lst3.toArray(fa);//lst3(list)를 배열로 만들어서 fa에 대입
	    int result3 = Arrays.binarySearch(fa, newFruit, cc);//이 메소드 쓸려고 리스트를 배열로 바꾼것(fa 객체배열에서 newFruit객체를 찾는데 cc와 비교하라
			if(result3 < 0) System.out.println("error");
			else System.out.println("\nArrays.binarySearch() 조회결과::" + fa[result3]);
		/*
		int result2 = binSearch(fa, lst3.size(), newFruit);
		System.out.println("\nbinSearch() 조회결과:" + lst3.get(result2));
		*/
		}
		// 교재 109 실습3-4 페이지 참조하여 구현. 비교연산자 부분 바꿔야함
		static int binSearch(Fruit[]a, int n, Fruit f) {
		//구현할 부분
			int pl = 0;
			int pr = n-1;
			
			do {
				int pc = (pl + pr)/2;
				if(a[pc].equals(f)) {
					return pc;
				}else if(a[pc].compareTo(f)>0) {
					pl = pc +1;
				}
				else {
					pr = pc -1;
				} 
			}
			while(pl<= pr);
			
			return -1;
			
	
	}
}

