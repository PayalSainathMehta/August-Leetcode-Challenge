import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
	
	public static List<Integer> findDups(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		for(int num: nums) {
			if(nums[Math.abs(num) - 1] < 0)  //seen before hence a dup
				result.add(Math.abs(num));
			nums[Math.abs(num) - 1] *= -1;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,2,3,4,5,4,6};
		System.out.println(findDups(nums).toString());
	}
}
