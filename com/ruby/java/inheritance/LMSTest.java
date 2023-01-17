package com.ruby.java.inheritance;

public class LMSTest {
	public static void main(String[] args) {
		Employee e = new Employee("노우권", 27, "코딩");
		Professor p = new Professor("손흥민", 30, "토트넘");
		Student s = new Student("호날두", 38, "컴공");

//		e.setName("오정임");
//		e.setAge(47);
//		e.setDept("입학처");
//
//		p.setName("김푸름");
//		p.setAge(52);
//		p.setSubject("빅데이터");
//
//		s.setName("김유빈");
//		s.setAge(20);
//		s.setMajor("컴퓨터과학");

		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}
}
