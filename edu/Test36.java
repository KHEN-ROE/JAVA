package edu;

public class Test36 {

	public static void main(String[] args) {
		char letter='A';
//		int n=(int)letter;
//		System.out.println(letter+1);
		char[]alphabet=new char[26];
		
		for(int i=0; i<alphabet.length; i++) {
			alphabet[i]=(char)(letter+i);
			 
		}
		System.out.println(alphabet); //여기서 바로 출력하면 안되나? 
		
//		for(char c : alphabet) { //이걸 왜 한번 더 쓰는 것인지?
//			System.out.print(c+" ");
//		}
		
	}

}
