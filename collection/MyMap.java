package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyMap {
	
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1,"laptop");
		map.put(2,"mobile");
		map.put(3,"tablet");
		map.put(4,"desktop");
		
		String device = map.get(3);
		System.out.println(device);
		
		Set<Integer> set = map.keySet();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			String value = map.get(key);
			System.out.println(key+" : "+value);
		}
		
		Student s1 = new Student("asha",123);
		Student s2 = new Student("akash",143);
		Student s3 = new Student("venu",523);
		Student s4 = new Student("kalyan",173);
		Student s5 = new Student("rahul",823);
		
		
		Map<Integer,String> m = new HashMap<>();
		m.put(s1.getRoll(),s1.getName());
		m.put(s2.getRoll(),s2.getName());
		m.put(s3.getRoll(),s3.getName());
		m.put(s4.getRoll(),s4.getName());
		m.put(s5.getRoll(),s5.getName());
		
		System.out.println();
		System.out.println(getStudentName(853,m));
		
		
	}
	
	public static String getStudentName(int roll,Map<Integer,String> m) {
		if(m.containsKey(roll)) {
			return m.get(roll);
		}
		
		return "No records found";
	} 

}