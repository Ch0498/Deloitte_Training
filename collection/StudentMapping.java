package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;




public class StudentMapping {

	 
	public static void main(String args[]) {
	
	Map<Integer, String> map = new HashMap<>(); 
	
	map.put(1,"Dog");
	map.put(2, "Cat");
	map.put(3, "Ball");
	map.put(4, "Apple");
	
	
	Set<Integer> set = map.keySet();
	Iterator<Integer> it = set.iterator();
	
	while(it.hasNext()) {
		
		Integer key = it.next();
		String value = map.get(key);
		System.out.println(key+": "+value);
	}
	
	
	
}
}