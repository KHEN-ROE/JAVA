package com.ruby.java.abstraction;

import com.ruby.java.abstraction.IphoneMessenger;
import com.ruby.java.abstraction.Messenger;

public class MessengerTest {

	public static void main(String[] args) {
		
		IphoneMessenger iphone = new IphoneMessenger();
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);

	}

}


