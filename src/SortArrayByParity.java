import java.util.Arrays;

public class SortArrayByParity {
	
	static void swap(int i, int j, int[] A) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	static int[] sortArrayByParity(int[] A) {
		if(A.length == 0 || A == null)
			return new int[0];
		int n = A.length;
		int left = 0;
		int right = n - 1;
		while(left < right) {
			if(A[left] % 2 == 1) { //odd
				swap(left, right, A);
				right = right - 1;
			}
			else //even - leave as is, as we want even ahead.
				left = left + 1;
		}
		return A;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(a)));
	}
}
