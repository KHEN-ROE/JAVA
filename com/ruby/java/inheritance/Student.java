package com.ruby.java.inheritance;

public class Student extends Person{
//	private String name;
//	private int age;
	private String major;
	
	
	public Student() {
		
	}
	public Student(String name, int age, String major) {
//		super.setName(name);
//		super.setAge(age);
		super(name, age);
		this.major=major;
		System.out.println("Student(name, age, major) 생성자 실행");
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
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
//	public String toString() {//메소드 오버라이딩하면 부모 클래스에서 정의된 메소드를 무시하고 오버라이딩해서 재정의한 메소드 출력. 부모클래스에서 정의한 것과 여기서 선언한 것 모두 출력하려면 super사용
//		return "major = " + major;
//	}
	public String toString() {
		return super.toString()+" : "+this.major;//
	}
}
