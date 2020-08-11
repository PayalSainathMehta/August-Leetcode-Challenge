
public class Hindex {
	public static int calculateHIndexWithSortedArray(int[] citations) {
		//when array is already sorted, the complexity would be O(log(n))
		if(citations.length == 0 || citations == null)
			return 0;
		int n = citations.length;
		int left = 0, right = n - 1;
		while(left <= right) {
			int pivot = left + (right - left) / 2;
			if(citations[pivot] == n - pivot) 
				return citations[pivot];
			else if(citations[pivot] < n - pivot)
				left = pivot + 1;
			else
				right = pivot - 1;
		}
		return n - left;
	}
	
	/*
	 * We could obviously use above approach for an unsorted array by first sorting it and
	 * then applying binary search however the time complexity would be O(n*log(n)).
	 * Here with bucket sort it is O(n)
	 */
	public static int calculateHIndexWithoutSortedArray(int[] citations) {
		//O(n) bucket counting sort
		if(citations.length == 0 || citations == null)
			return 0;
		int n = citations.length;
		int[] buckets = new int[n + 1]; //as we need to access the nth bucket too hence n+1
		for(int c: citations) {
			if(c >= n)
				buckets[n]++;
			else
				buckets[c]++;
		}
		int count = 0;
		for(int i = n; i >= 0; i--) //access from behind as we want largest h-index
		{
			count += buckets[i];
			if(count >= i)
				return i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] citations = {1,3,6,0,5};
		int[] sortedCitations = {0,1,3,5,6};
		System.out.println(calculateHIndexWithSortedArray(sortedCitations));
 		System.out.println(calculateHIndexWithoutSortedArray(citations));
	}
}
