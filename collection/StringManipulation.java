package collection;

public class StringManipulation {

	public static void main(String[] args) {
		String str = new String();
		str = "This is a text.";
		String st = new String("This is a line of text");
		System.out.println(str==st);
		
		System.out.println(str.equals(st));
		
		str = st;
		
		System.out.println(str==st);
		System.out.println(str.equals(st));
		
		int len = str.length();
		
		int indexOfC = str.indexOf('t');
		System.out.println(indexOfC);
		
		
		int lastIndexOft = str.lastIndexOf('t');
		System.out.println(lastIndexOft);
		int count = 0;
		for (char c: str.toCharArray()) {
			if(c=='t') {
				System.out.println(count++);
				
				
			}
		}
		System.out.println("t occurs " +count+ "times.");
		
		
		
		locate("text", str);
	}
	
	public static void locate(String word, String line) {
		//report the stat and end index of the word in the line, if present
		/*
		 * 1. Check if the word is present in the line
		 * 2. If not present, display the message
		 * 3. If present, get start index of the word
		 * 4. Compute end index
		 * 5. Display the start and end index.
		 */
		
//		if(line.contains(word)) {
//			int firstIndexOf = line.indexOf(word);
//			int start = firstIndexOf;
//			while (start<firstIndexOf+word.length()) {
//				if(line.charAt(start++))
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head><title>My Web Page</title></head>");
		buffer.append("<body>");
		buffer.append("<h1>This is my web profile</h1>");
		buffer.append("</body></html>");
		
		System.out.println(buffer.toString());
		}
	
	
	
	
	
}
