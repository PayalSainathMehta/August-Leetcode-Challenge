import java.util.Arrays;
import java.util.TreeMap;

public class RightInterval {
    public static int[] findRightInterval(int[][] intervals) {
        if(intervals.length == 1)
            return new int[]{-1};
        int n = intervals.length;
        int[] result = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0; i < n; i++){ // we store start as key and index as value in tm
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < n; i++){
            Integer key = map.ceilingKey(intervals[i][1]); //get the equal to just greater start value
            result[i] = key == null ? -1 : map.get(key);
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }
}
