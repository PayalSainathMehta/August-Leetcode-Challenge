import java.util.Random;

public class Rand10usingRand7 {

    public static int rand7() {
        Random r = new Random();
        int res = 0;
        while(res == 0)
            res = r.nextInt(7);
        return res;
    }
    public static int rand10() {
        int k = 10;
        int random = k + 1;
        while(random > k)
            random = 7 * (rand7() - 1) + rand7();
        return random;
    }

    public static void main(String[] args) {
        System.out.println(rand10());
        System.out.println(rand10());
        System.out.println(rand10());
        System.out.println(rand10());
        System.out.println(rand10());
    }
}
