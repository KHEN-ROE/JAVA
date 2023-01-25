package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInputStreamTest {

	private static boolean bPrint = false; //bPrint 변수 선언
	
	public static long test01() {//test01메소드 선언
		
		long start = System.currentTimeMillis();//start 변수를 선언하고, currentTimeMillis 메소드 저장
		try (InputStream is = new FileInputStream("test.dat");) {//현재 실행되고 있는 폴더에서 해당 파일 찾음. "C:/temp/test.dat" - 특정경로 지정. ("..\\..\\test.dat") 이거는 상위폴더, 더 상위폴더 
			int ch;													//외부데이터를 읽어오는 객체 생성
			while(0 <= (ch = is.read())) {//이걸 설명하려니 무슨 뜻인지 모르겠네? 참조변수를 이용하여 힙에 있는 메서드에 접근
				if (bPrint)
					System.out.println(ch);
			}		
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L; //에러처리하려고 long 타입으로 리턴. 만약 정수형이면 그냥 -1
	}

	public static long test02() {
	
		byte[] buffer = new byte[1024];

		long start = System.currentTimeMillis();
		try (InputStream is = new FileInputStream("test.dat");) {
			while(0 <= is.read(buffer)) {
				if (bPrint)
					System.out.println(new String(buffer));
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test03() {
		
		byte[] buffer = new byte[1024];

		long start = System.currentTimeMillis();
		try (InputStream bis = new BufferedInputStream(new FileInputStream("test.dat"));) {//부모가 자식을 대체한다. FileInputStream의 부모 클래스가 InputStream이다
			while(0 <= bis.read(buffer)) {
				if (bPrint)
					System.out.println(new String(buffer));
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}

	public static long test04() {
		
		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			int ch;
			while(0 <= (ch = fr.read())) {
				if (bPrint)
					System.out.println(ch);
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static long test05() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader fr = new FileReader("test.dat");) {
			while(0 <= fr.read(buffer)) {
				if (bPrint)
					System.out.println(buffer.toString());
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}	
	
	public static long test06() {
		
		char[] buffer = new char[1024];

		long start = System.currentTimeMillis();
		try (Reader br = new BufferedReader(new FileReader("test.dat"));) {
			while(0 <= br.read(buffer)) {
				if (bPrint)
					System.out.println(buffer.toString());
			}
			return System.currentTimeMillis() - start;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1L;
	}		
	
	public static long test07() {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		long start = System.currentTimeMillis();
		try (RandomAccessFile raf = new RandomAccessFile("test.dat", "r");
				FileChannel channel = raf.getChannel();) {
			int len;
			while((len = channel.read(buffer)) > 0) {
				if (bPrint)
					System.out.println("-->" + len + ":" + new String(buffer.array(), 0, len, "UTF-8"));
				buffer.clear();
			}
			return System.currentTimeMillis() - start;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	public static void main(String[] args) {

		System.out.println("-->test01");
		long t1 = test01();	// 1byte씩 읽어서 출력
		System.out.println("-->test02");
		long t2 = test02();	// 1024byte 버퍼를 생성해서 출력
		System.out.println("-->test03");
		long t3 = test03(); // BuffueredInputStream 생성해서 출력. 8kb속도로 읽음
		System.out.println("-->test04");
		long t4 = test04(); 
		System.out.println("-->test05");
		long t5 = test05();
		System.out.println("-->test06");
		long t6 = test06();
		System.out.println("-->test07");
		long t7 = test07();

		System.out.printf("test01():FileInputStream:1byte :%dms\n", t1);
		System.out.printf("test02():FileInputStream:buffer:%dms\n", t2);
		System.out.printf("test03():BufferedInputStream   :%dms\n", t3);
		System.out.printf("test04():FileReader:1byte      :%dms\n", t4);
		System.out.printf("test05():FileReader:buffer     :%dms\n", t5);
		System.out.printf("test06():BuffredReader         :%dms\n", t6);
		System.out.printf("test07():FileChannel           :%dms\n", t7);

		System.out.println("Done");
	}
}
