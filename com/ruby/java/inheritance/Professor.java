package com.ruby.java.inheritance;

public class Professor extends Person {
//	private String name;
//	private int age;
	private String subject;
	
	public Professor() {
		
	}
	public Professor(String name, int age, String subject) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.subject=subject;
		System.out.println("Professoer(name, age, subject) 생성자 실행");
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name=name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age=age;
//	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String toString() {
		return super.toString()+" : "+this.subject;//
	}
}
