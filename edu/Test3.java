package edu;

public class Test3 {

	public static void main(String[] args) {
		byte age;
		short point;
		int price;
		long totalSales;
		char c1=97;//아스키 코드값으로 저장됨. char에 숫자 대입하면 아스키 코드값 저장
		
		age=23;
		point=32000;
		price=3500000;
		totalSales=2147483648L;
		
		System.out.println(age);
		System.out.println(point);
		System.out.println(price);
		System.out.println(totalSales);
		System.out.println(c1);
	}

}
