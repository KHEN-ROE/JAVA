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
	public int compareTo(Fruit o) {
	//추상메소드 구현할 부분
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
	
    System.out.println(arr);
    System.out.println("정렬전::");
    for (Fruit city : arr)//배열을 for each문 사용해서 출력
    	System.out.print(" " + city);
	Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice()); //Fruit에 compareTo()가 있어도 람다식 우선 적용
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
    	System.out.print(" " + city);

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr));//정렬된 arr배열을 매개변수로 받아서 lst1에 저장
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	System.out.println();
	System.out.println("새로운 리스트2::");
    for (Fruit city : lst2)
    	System.out.print(" " + city);
//    Arrays.sort(lst2);
    Collections.sort(lst2);
	System.out.println();
	System.out.println("새로운 리스트2::");
    for (Fruit city : lst2)
    	System.out.print(" " + city);
    
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();//iterator 사용해서 lst 1 2 합치고 lst3에 대입
	
	Iterator<Fruit> iter1 = lst1.iterator();
	Iterator<Fruit> iter2 = lst2.iterator();
	Fruit data1 = iter1.next();
	Fruit data2 = iter2.next();
    	//구현할 부분
	System.out.println();
    System.out.println("merge:: ");
    for ( Fruit city: lst3)
    	System.out.print(city+ " ");
    Fruit newFruit = new Fruit("참외", 100);
    //binary search
    Comparator<Fruit> cc = new Comparator<Fruit>() {//익명클래스 사용, 객체 생성하여 cc에 대입
        public int compare(Fruit u1, Fruit u2) {
          return u1.compareTo(u2);//Fruit에 있는 메소드 호출
        }
      };
     int res = cc.compare(data1, newFruit);
     if (res > 0)
    	 System.out.println("\ndata1 > newFruit\n");
      /*
    System.out.println();
    int result = Collections.binarySearch(lst3, newFruit, cc);
		System.out.println("\nCollections.binarySearch() 조회결과::" + lst3.get(result));
	*/

	Fruit [] fa = new Fruit[lst3.size()];
	fa = lst3.toArray(fa);//lst3(list)를 배열로 만들어서 fa에 대입
    int result3 = Arrays.binarySearch(fa, newFruit, cc);//이 메소드 쓸려고 리스트를 배열로 바꾼것(fa 객체에서 newFruit를 찾는데 cc와 비교하라
	System.out.println("\nArrays.binarySearch() 조회결과::" + lst3.get(result3));
	/*
	int result2 = binSearch(fa, lst3.size(), newFruit);
	System.out.println("\nbinSearch() 조회결과:" + lst3.get(result2));
	*/
	}
	// 교재 109 실습3-4 페이지 참조하여 구현. 비교연산자 부분 바꿔야함
	static int binSearch(Fruit[]a, int n, Fruit f) {
	//구현할 부분
	}
}

