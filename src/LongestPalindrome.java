
public class LongestPalindrome {
	
	public static int longest(String s) {
		int length = 0;
		int count[] = new int[128]; //this because small and CAPS letters - store ascii value
		for(char c: s.toCharArray()) { //c = 'a' then count[97] = 1
			if(++count[c] == 2) {
				length += 2;
				count[c] = 0;
			}
		}	
		return length == s.length() ? length : length + 1;
	}
	
	
	public static void main(String[] args) {
		String s = "abcmAddame";
		System.out.println(longest(s)); //abcmaddame
	}
}
