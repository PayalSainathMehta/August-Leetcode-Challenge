import java.util.Arrays;

public class CheckerBoard {
	
	public static void checkerboard(int n){
		    for (int i = 0; i <= n; i++) {
		        char first = 'B';
		        char second= 'W';
		        if (i % 2 == 0) {
		            first = 'W';
		            second = 'B';
		        }
		        for (int j = 0; j < n; j++) {
		            if (j % 2 == 0) {
		                System.out.print(first);
		            } else {
		                System.out.print(second);
		            }
		        }
		        System.out.println("");
		    }
	}
	public static void main(String[] args) {
	   checkerboard(5);
	}
}
