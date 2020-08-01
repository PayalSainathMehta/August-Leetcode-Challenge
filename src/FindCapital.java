
public class FindCapital {
	
	public static boolean detectCapitalUse(String word) {
        if(word.length() == 0 || word == null)
        	return false;
        int n = word.length();
        if(n == 1)
        	return true;
        char first =  word.charAt(0);
        char second = word.charAt(1);
        if(Character.isUpperCase(first) && Character.isUpperCase(second)) {
        	for(int i = 2; i < n; i++)
        		if(Character.isLowerCase(word.charAt(i)))
        			return false;
        }
        else {
        	for(int i = 1; i < n; i++)
        		if(Character.isUpperCase(word.charAt(i)))
        			return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		String s = "Caps";
		System.out.println(detectCapitalUse(s));
	}
}
