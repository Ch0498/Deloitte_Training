package jansec;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class setop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		int x;
		int y;
		
		x = 25; y = 52;
		boolean check = x==y;
		System.out.println(check);
		
		
		Set<Integer> set1 = new HashSet<Integer>();
		
		set1.add(34);
		set1.add(54);
		set1.add(34);
		set1.add(58);
		System.out.println(set1);
		
		ArrayList<Integer> arl1 = new ArrayList<Integer>();
		
		arl1.add(45);
		arl1.add(445);
		
		
		
		System.out.println(arl1);
		
		
		
		
		
		
	}

}
