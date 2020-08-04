
public class PowerOfFour{
	 
	public static boolean isPowerOfFour(int n) {
		if(n == 0)
			return false;
		
		return (n > 0) && ((n & (n - 1)) == 0) && (n % 3 == 1); 
		//for power of 4 or any power of 2 we just add one more check)( n % (n - 1) == 1)
		
 }
	
	public static void main(String[] args) {
		int n = 56;
		System.out.println(isPowerOfFour(n));
	}

}
