import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashSet {
	
	private List<Integer>[] container = null;
	private int cap = 1000;
	private double lf = 0.75; //when list is 75% full, we rehash
	private int count = 0;
	public HashSet() {
		container = new LinkedList[cap];
	}
	

	public boolean contains(int key) {
		int hash = key % cap;
		List<Integer> list = container[hash];
		if(list != null) {
			Iterator<Integer> itr = list.iterator();
			while(itr.hasNext())
				if(itr.next() == key)
					return true;
		}
		return false;
	}
	
	
	public void remove(int key) {
		int hash = key % cap;
		List<Integer> list = container[hash];
		if(list != null) {
			Iterator<Integer> itr = list.iterator();
			while(itr.hasNext())
				if(itr.next() == key)
				{
					itr.remove();
					--count;
				}
		}
	}
	
	public void add(int key) {
		if(contains(key)) return;
		if(cap * lf == count) {
			count = 0;
			cap = cap * 2;
			List<Integer>[] oldC = container;
			container = new LinkedList[cap];
			for(int i = 0; i < oldC.length; i++) {
				List<Integer> list = oldC[i];
				
			}
			
		}
		int hash = key % cap;
		if(container[hash] == null)
			container[hash] = new LinkedList<Integer>();
		container[hash].add(key);
		count++;
	}
}
