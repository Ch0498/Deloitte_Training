package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MyCollection {

	public static void main(String[] args) {
		
		Vector<String> /*it is a class so V not v*/ v = new Vector<>();
		//Generic are written in between <>
		//used safely in multi threaded operation.
		//this is a collection (corrupted collection).
		
		//ArrayList is used for collection basically as it is very fast but during multi threaded operation Vectors are fine.
		
		v.add("ankit");
		v.add("Computer");
		v.add("laptop");
		v.add("mobile");
		
		System.out.println(v.size())
		;
		
		int len = v.size();
		
		System.out.println();
		
		for(int i = 0; i < len; i++) {
			
			System.out.println(v.get(i));
		}
		
		System.out.println("\n or using enhanced for loop ;)\n");
		
		for(String s : v) {        //enhanced for loop
			System.out.println(s);   
		}
		
		
		Enumeration<String> E = v.elements();
		while(E.hasMoreElements()) {
			System.out.println(E.nextElement());
		}
		
		//enumeration interface has only two methods hasMoreElements and nextElement
		
		
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	
		//this is an interface returned by hasNext() method
	
	
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(23);
		list.add(43);
		list.add(51);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		int sum = 0;
		
		Iterator<Integer> ite = list.iterator();
		
		while (ite.hasNext()) {
			sum += ite.next();
		}
		
		System.out.println("The sum of all the elements is: " +sum);
		
		Collections.sort(list);
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println("\n" +iter.next());
		}
		
		
		Collections.sort(list);
		System.out.println(list);

		List<Student> students = new ArrayList<>();
		students.add(new Student("asha", 321));
		students.add(new Student("dosa", 123));
		students.add(new Student("papad", 435));
		students.add(new Student("vada", 121));
		students.add(new Student("chocolate", 212));
		students.add(new Student("almond", 234));
	
		
		Iterator<Student> sdIt = students.iterator();
		while (sdIt.hasNext()) {
			Student st = sdIt.next();
			System.out.println(st.getName());
		}
		

		Collections.sort(students, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getRoll() - o2.getRoll();
			}
			
		});
		
			
			sdIt = students.iterator();
			while(sdIt.hasNext()) {
				System.out.println(sdIt.next());
			}
			
			System.out.println();
			
			
			Collections.sort(students, new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareTo(o2.getName());
				}
				
			});
			
				
				sdIt = students.iterator();
				while(sdIt.hasNext()) {
					System.out.println(sdIt.next());
				}
				
				System.out.println();
				
				
				Collections.sort(students, new StudentNameSorter());
				sdIt = students.iterator();
				while(sdIt.hasNext()) {
					Student st = sdIt.next();
					System.out.println(st.getName());
				}
	}
			public static void printNamesStartingWithA(List<Student> students) {
				Iterator<Student> sdIt = students.iterator();
				while(sdIt.hasNext()) {
					
					Student s = sdIt.next();
					if(s.getName().startsWith("a")) {
						System.out.println(s);
				}
			}
		}
	
			
			
			/**
			 * public static int getRollNumber(List<Student>list, String studentName) {
			 * return 0;
			 * }
			 */
			
			
	}	
