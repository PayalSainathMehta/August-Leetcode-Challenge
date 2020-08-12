import java.util.ArrayList;
import java.util.List;

public class PascalTriangle12 {
	//this will return the complete triangle upto n
	public static List<List<Integer>> generate(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		for(int i = 0; i <= n; i++) {  //go for full as we need to print everything
			for(int j = temp.size() - 1; j >= 1; j--) { //will go in only for 1st to last row
				temp.set(j, temp.get(j) + temp.get(j - 1)); //set position similar
			}
			temp.add(1);
			result.add(new ArrayList(temp));
		}
		return result;
	}
	
	
	//this will return nth row
	public static List<Integer> getRow(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(1); //at 0 th column
		for(int i = 1; i <= n; i++) {
			for(int j = i - 1; j >= 1; j--) { //only go in for 1st to second last column
				result.set(j, result.get(j) + result.get(j - 1));
			}
			
			result.add(1); //at last column
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(4).toString());
		System.out.println(getRow(4).toString());
	}
}
