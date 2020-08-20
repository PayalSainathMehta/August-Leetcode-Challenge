import java.util.Set;
import java.util.HashSet;

public class GoatLatin {
	private static Set<Character> vowels =
            new HashSet<Character>() {
                {
                    add('a');
                    add('e');
                    add('i');
                    add('o');
                    add('u');
                    add('A');
                    add('E');
                    add('I');
                    add('O');
                    add('U');
                }
            };
	 public static String toGoatLatin(String S) {
		 String suff = "";
		 StringBuilder sb = new StringBuilder();
		 
		 for(String token: S.split(" ")) {
			 suff += "a"; //a , then aa, then aaa
			 if(!vowels.contains(token.charAt(0))) //consonants
				 token = token.substring(1) + token.charAt(0);
			 
			 //irrespective of whether vowel or consonant, append it
			 sb.append(token).append("ma").append(suff).append(' ');
		 }
		 sb.deleteCharAt(sb.length() - 1); //removed extra space
		 return sb.toString();
     }
	 
	 public static void main(String[] args) {
		String s = "I speak Goat Latin";
		System.out.println(toGoatLatin(s));
	}
}
