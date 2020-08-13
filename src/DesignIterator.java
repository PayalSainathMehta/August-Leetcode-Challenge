import java.util.LinkedList;
import java.util.Queue;

public class DesignIterator {
	Queue<String> queue = new LinkedList<>();
	public DesignIterator(String characters, int combinationLength) {
	    generateSubstring(characters, combinationLength, 0, new StringBuilder());
	}
	
	private void generateSubstring(String s, int len, int start, StringBuilder sb) {
		if(len == 0) { //allowed length exhausted, so just add to queue
			queue.offer(sb.toString());
			return;
		}
		
		for(int i = start; i <= s.length() - len; i++) { //pick only remaining characters
			sb.append(s.charAt(i));
			generateSubstring(s, len - 1, i + 1, sb); //recursive call
			sb.deleteCharAt(sb.length() - 1); //backtrack
		}
	}
	    
	public String next() {
	    return queue.poll();
	}
	
	public boolean hasNext() {
	    return !queue.isEmpty();
	}
}

// input is ["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]
// 			[["abc",2],[],[],[],[],[],[]]
// output is [null,"ab",true,"ac",true,"bc",false]