package com.ruby.java.ch12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static long test01() {
		
		long start = System.currentTimeMillis();
		try (FileInputStream fi = new FileInputStream("text.txt");) {
			int ch;
			while(0 <= (ch = fi.read())) {
				System.out.println(ch + ":" + (char)ch);
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	public static long test02() {
		
		long start = System.currentTimeMillis();
		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));) {
			int ch;
			while(0 <= (ch = br.read())) {
				System.out.println(ch + ":" + (char)ch);
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}
	
	public static long test03() {
		
		long start = System.currentTimeMillis();
		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));) {
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}		
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static void main(String[] args) {

		System.out.println("-->test01 : 1byte씩 읽어서 출력");//한글을 1byte로 읽으니 깨져서 출력됨
		long t1 = test01();
		
		System.out.println("-->test02 : 1글자씩 읽어서 출력");//1byte 읽는 것과 1글자 읽는 것이 무슨 차이? 영어를 제외한 모든 글자는 2byte.
		long t2 = test02();

		System.out.println("-->test03 : 1줄씩 읽어서 출력");//한 줄씩 읽는걸 많이 씀
		long t3 = test03();
		
		System.out.println("=".repeat(30));
		System.out.printf("test01():FileReader:1char :%dms\n", t1);
		System.out.println("=".repeat(30));
		System.out.printf("test02():FileReader:1char :%dms\n", t2);
		System.out.println("=".repeat(30));
		System.out.printf("test03():FileReader:1line :%dms\n", t3);
		System.out.println("=".repeat(30));
		System.out.println("Done");
	}
}
