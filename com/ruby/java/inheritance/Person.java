package com.ruby.java.inheritance;

public class Person {
	private final String ssn_ID="123"; //final 변수는 변경불가
	private String name;
	private int age;
	
//	public void_setSsn_ID(String ssn_ID) {
//		this.ssn_ID=ssn_ID;
//	}
	
	public Person() {
		System.out.println("Person 클래스 생성");
	}
//	public Person(String ssn_ID) {
//		this.ssn_ID=ssn_ID;//final값 초기화하고 값을 변경하려면 오류뜸
//	}
	public Person(String name, int age) {
		this.name=name; 
		this.age=age;
		System.out.println("Person 클래스 생성");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}
}
