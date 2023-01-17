package com.ruby.java.abstraction;

abstract class Employee {//추상 클래스를 사용하면 객체 못 만듦
	String name;
	int salary;

	public abstract void calcSalary();//추상 메소드. {}가 생략됨
	public abstract void calcBonus();
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {//추상 메소드를 모두 구현하면 그냥 클래스이며 객체를 만들 수 있다, 하나라도 빠지면 여전히 추상 클래스이며 객체를 만들 수 없다.
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}

}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class HRSTest {//public 클래스는 하나만 있어야한다. 한 파일에서 여러개 클래스 쓰려면 public클래스와 메인메소드는 맨 마지막에 작성
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		s.calcSalary();
		c.calcSalary();
		d.calcSalary();
	}

}
