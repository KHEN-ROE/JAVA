package com.ruby.java.inheritance;

public class Employee extends Person {//필드와 메소드를 상속받았음
//	private String name;
//	private int age;
	private String dept;
	
	public Employee() {
		
	}
	public Employee(String name, int age, String dept) {//생성자 오버로딩
//		super.setName(name);
//		super.setAge(age);
		super(name, age);//super()를 메소드 내에서 가장 먼저 선언해야 함. 안그러면 오류
		this.dept=dept;
		System.out.println("Employee(name, age, dept) 생성자 실행");
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
//	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {//Person클래스의 toString메소드 오버라이딩한 것. 여기서 get메소드를 사용하지 않고 name, age필드를 그대로 사용할 수 없다. 이유는 private으로 선언했기 때문
//		return this.getName() + " : " + this.getAge() + " : " + dept;
		return super.toString()+" : "+this.dept;//super는 부모 클래스의 멤버 호출하는 예약어
	}//this를 생략해도 결과는 같다.
}
