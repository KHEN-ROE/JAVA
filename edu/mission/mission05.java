package edu.mission;

public class mission05 {
	
	public static int[] merge(int[]a, int[]b) {
		int[] c = new int[a.length+b.length];
		
		for(int i=0; i<a.length; i++) {
			c[i]=a[i];
		}
		
		for (int i = 0; i < b.length; i++) {
	        c[i + b.length] = b[i];
	    }
		
		java.util.Arrays.sort(c);
		
		return c;
		
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8};
		
		int [] merge = merge(a,b);
		
		for (int i : merge) {//
	        System.out.print(i);
	    }
		
	}

}
