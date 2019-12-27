package collection;

import java.util.Deque;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class MyDeque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque dq = new LinkedList<Integer>();
		dq.add(1);
		dq.addFirst(2);
		dq.addLast(3);
		System.out.println(dq.offer(4));
		System.out.println(dq.peek())
		;
		System.out.println(dq.peekFirst());
		System.out.println(dq.peekLast());
		System.out.println("Size: " +dq.size());
		System.out.println("Element popped: " +dq.pop());
		
		Iterator<Integer> it = dq.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
		Hashtable<String,String> table = new Hashtable<>();
		table.put("admin", "admin123");
		table.put("user", "user123");
		
		Enumeration<String> enums = table.keys();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();
			String val = table.get(key);
			System.out.println(key+":"+val);
		}
	}

}
