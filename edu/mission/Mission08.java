package edu.mission;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Mission08 {

	public static void main(String[] args) {
		//20자리 이상의 큰 정수는 long형 데이터를 넘어서기 때문에 바로 연산할 수 없다. 한 가지 방법으로 모든 자리 수의 데이터를
		//byte형 배열로 분리해서 더하는 방법을 사용할 수 있다. 아래 예와 같은 방법으로 두 수(12345, 6789)를 텍스트파일(input,txt)
		//로부터 읽어서 결과를 텍스트 파일(output.txt)에 출력하는 메서드를 작성하라
		//연산 예) 12345 + 6789 -> {5,4,3,2,1} + {9,8,7,6}
		//					  -> {14,12,10,8,1}->4,3,1,9,1->19134
		//FileOutputStream 사용하여 txt 파일에 출력
		//ArrayList - 데이터 자르기
		//루프 - 순회하며 한 글자씩 출력
		try(FileInputStream fi = new FileInputStream("input.txt");
				FileOutputStream fo = new FileOutputStream("output.txt")){
			int c=0;
			while((c=fi.read())!=-1){
				fo.write(c);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
