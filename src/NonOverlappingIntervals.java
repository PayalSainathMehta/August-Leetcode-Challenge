import java.util.Arrays;

/*
 * Return minimum number of intervals you need to remove to make others non-overlapping
 */
public class NonOverlappingIntervals {
	
	public static int remove(int[][] intervals) {
		if(intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]); //ascending sort as per end times
		int end = intervals[0][1];
		int count = 1; //this one we keeping for sure
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] >= end) { //check overlapping starts
				end = intervals[i][1];
				count++;
			}	
		}
		return intervals.length - count;
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1,2},{2,3},{1,3},{3,4},{4,5},{2,5}};
		System.out.println(remove(intervals));
	}
}
