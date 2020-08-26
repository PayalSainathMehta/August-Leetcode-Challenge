import java.util.ArrayList;
import java.util.List;

public class FizzBuzzWithoutMod {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0)
            return result;
        // we are going to do this without % operator
        for(int i = 1, fizz = 0, buzz = 0;i <= n; i++){
            //increment both but reset to 0 when they meet condition
            fizz++;
            buzz++;
            if(fizz == 3 && buzz == 5)
            {
                result.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            }
            else if(i % 3 == 0){
                result.add("Fizz");
                fizz = 0;
            }
            else if(i % 5 == 0){
                result.add("Buzz");
                buzz = 0;
            }
            else
                result.add(Integer.toString(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n).toString());
    }
}
