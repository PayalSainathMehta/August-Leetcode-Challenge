import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    //using string builder
    public static String reverseStringUsingStringBuilder(String s){
        if(s.length() == 0 || s == null)
            return s;
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    //without inbuilt reverse function
    public static String reverseStringWithoutSb(String s){
        if(s.length() == 0 || s == null)
            return s;
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; --i)
            sb.append(s.charAt(i));
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "The Daily Byte";
        System.out.println(reverseStringUsingStringBuilder(s));
        System.out.println(reverseStringWithoutSb(s));
    }
}
