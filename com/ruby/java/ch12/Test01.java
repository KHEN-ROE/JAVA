package com.ruby.java.ch12;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {

	public static void main(String[] args) {
		try(FileInputStream fi = new FileInputStream("a.txt");//try with resource 문
				FileOutputStream fo = new FileOutputStream("b.txt");){
			int c=0;
			while((c = fi.read())!=-1) {
				fo.write(c);//한글자씩 가져오는걸 반복하면서 출력
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
