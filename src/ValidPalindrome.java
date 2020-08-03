
public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
		//above line replaces all chars which are not alphanumeric to nothing. basically removes them
		if(s.isEmpty()) return true; //valid cause empty
		int n = s.length();
		for(int i = 0; i <= n/2; i++) //check 0th with last, 1st with second last, so on..
			if(s.charAt(i) != s.charAt(n - i - 1))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}
