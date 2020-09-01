import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        if(s.length() == 0 || s == null)
            return -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(!map.containsKey(current))
                map.put(current, i); //add index
            else
                map.put(current, -1); //invalidate
        }

        int min = Integer.MAX_VALUE;
        for(char c: map.keySet()){
            if(map.get(c) > -1  && map.get(c) < min)
                min = map.get(c);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        String s  = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
