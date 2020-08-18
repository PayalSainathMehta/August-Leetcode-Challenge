import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersConsecutiveDifference {
	
	public static int[] numsSameConsecDiff(int N, int K) {
		//N is length of number
		//K is difference between digits
		if(N == 1) //if single digit numbers
			return new int[] {0,1,2,3,4,5,6,7,8,9};
		List<Integer> result = new ArrayList<>();
		for(int num = 1; num < 10; num++) {//leading digit can be 1-9 //build tree
			dfs(N-1, num, K, result);//keep calling for N-1 until N = 0
		}
        return result.stream().mapToInt(i -> i).toArray();
	}
	
	public static void dfs(int N, int num, int K, List<Integer> result) {
		if(N == 0) {
			result.add(num); //when N is 0, we simply add the existing num
			return;
		}
		int last_digit = num % 10; //form tree
		if(last_digit + K < 10) // keep adding K and subtracting K
			dfs(N - 1, num * 10 + last_digit + K, K, result);
		if(K > 0 && last_digit - K >= 0)
			dfs(N - 1, num * 10 + last_digit - K, K, result);
	}
	
	
	/*
	 * EXAMPLE TREE suppose N = 3, K = 7
	 * 
	 *       1    2     7     8     9  
	 *      /    /     /     /     /
	 *     18   29   70    81    92
	 *    /    /     /    /     /
	 *   181  292   707  818   929
	 */
	
	
	public static void main(String[] args) {
		int n = 3;
		int k = 7;
		System.out.println(Arrays.toString(numsSameConsecDiff(n, k)));
	}
}
