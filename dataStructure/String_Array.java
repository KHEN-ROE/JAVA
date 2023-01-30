package dataStructure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class String_Array {

	public static void main(String[] args) {

	    try {

	      // 파일 읽어서 string 객체를 정렬하는 프로그램 구성
	      Path input = Paths.get("a1.txt");//현재 패키지가 경로가 됨

	      byte[] bytes = Files.readAllBytes(input); //File 클래스의 readAllBytes 메소드 접근.파라미터로 input
	      System.out.println("== readAllBytes ==");
	      System.out.println(new String(bytes));
	      // ------------------- 추가한 코드
	      // file 입출력 + String 처리 + 정렬 코딩
	      String s = new String(bytes);
	      System.out.println("s = " + s);
	      String [] sa = s.split(" |\n"); // split(" |\n") - " " 혹은 \n을 만나면 자름 regular expression
		  
	      String temp = "";//대문자 먼저 나오고 소문자 단어가 길다고 큰 숫자가 아니고. 첫번째 글자부터 비교한다. 첫번째가 빠르면 작다. 대문자가 작고 소문자가 크다
	      for(int i=0; i<sa.length; i++) {
	    	  for(int j= i+1; j<sa.length; j++) {
	    		  if(sa[i].compareTo(sa[j])>0) {
	    			  temp = sa[i];
	    			  sa[i]=sa[j];
	    			  sa[i]=temp;
	  
	    		  }
	    	  }
	      }
	      
	      // ---------------------------

	      int bufferSize = 10240;
	      String b = " ";
	      ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
	      for (String sx : sa) {
	    	  System.out.println(" " + sx);
	    	  buffer.put(sx.getBytes());
	    	  buffer.put(b.getBytes());
	      }
		 
	      FileOutputStream file = new FileOutputStream("c.txt");
	      FileChannel channel = file.getChannel();
	      
	      //byte로 한 글자씩 받은 다음에 공백에서 잘라서 정렬? 리턴 값은 -1, 0, 1. 비교를 하라. 비교해서 바꾸고
	      //
	      
	      channel.write(buffer);
	      file.close();
	      //정렬하는걸 완성해서 c파일에 출력하라

	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	  }

}
