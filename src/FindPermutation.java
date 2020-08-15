import java.util.Arrays;

public class FindPermutation {

	public static int[] findPerm(String s) {
		int n = s.length();
		int[] arr = new int[n + 1];
		//create a sorted array for 1 ..n
		for(int i = 0; i <= n; i++)
			arr[i] = i + 1;
		//find the first occurrence of D and consecutive, keep the window, reverse the nos in the window
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == 'D') {
				int start = i;
				while(i < n && s.charAt(i) == 'D')
					i++;
				reverse(arr, start, i);
			}
		}
		return arr;
	}
	
	static void reverse(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		/*
		 * the above can also be done without extra variable temp
		 * 
		 * arr[start] ^= arr[end];
         * arr[end] ^= arr[start];
         * arr[start] ^= arr[end];
         * 
		 */
		start++;
		end--;
	}
	
	public static void main(String[] args) {
		String s = "DDIIDI";
		System.out.println(Arrays.toString(findPerm(s)));
	}
}
