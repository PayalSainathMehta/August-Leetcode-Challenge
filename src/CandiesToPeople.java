import java.util.Arrays;

public class CandiesToPeople {
	public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int candies_given = 1;
        int people = 0;
        while(candies > 0){
            result[people++ % num_people] += Math.min(candies_given, candies); //0,1,2,3,0,1,2,3.....
            candies -= candies_given;
            candies_given++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int candies = 10;
		int people = 3;
		System.out.println(Arrays.toString(distributeCandies(candies, people)));
	}
}
