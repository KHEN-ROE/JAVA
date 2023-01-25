package edu.mission;

import java.util.ArrayList;

public class Mission08_4 {//지박사 코드
    public static void main(String[] args) {
        int num1 = 12345;
        int num2 = 6789;
        ArrayList<Byte> list1 = new ArrayList<Byte>();
        ArrayList<Byte> list2 = new ArrayList<Byte>();
        ArrayList<Byte> result = new ArrayList<Byte>();
        
        // Split num1 into bytes and add to list1
        char[] chars1 = Integer.toString(num1).toCharArray();
        for (char c : chars1) {
            list1.add((byte) Character.getNumericValue(c));
        }
        
        // Split num2 into bytes and add to list2
        char[] chars2 = Integer.toString(num2).toCharArray();
        for (char c : chars2) {
            list2.add((byte) Character.getNumericValue(c));
        }
        
        // Add the two lists and store result in result
        int carry = 0;
        int maxLength = Math.max(list1.size(), list2.size());
        for (int i = 0; i < maxLength; i++) {
            int sum = carry;
            if (i < list1.size()) {
                sum += list1.get(i);
            }
            if (i < list2.size()) {
                sum += list2.get(i);
            }
            carry = sum / 10;
            result.add((byte) (sum % 10));
        }
        if (carry > 0) {
            result.add((byte) carry);
        }
        
        // Print the result
        for (byte b : result) {
            System.out.print(b);
        }
    }
}