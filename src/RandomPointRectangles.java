import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointRectangles{

    private int[][] rects;
    private Random r;
    private int area;
    private TreeMap<Integer, Integer> map;
    public RandomPointRectangles(int[][] rects){
        this.rects = rects;
        area = 0;
        r = new Random();
        map = new TreeMap<>();
        for(int i = 0; i < rects.length; i++){
            //now to get the area we do x2-x1+1 * y2-y1+1 = 5*5 = 25
            area += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            map.put(area, i);
        }
    }

    public int[] pick(){
        int randInt = r.nextInt(area);
        int key = map.higherKey(randInt);
        int rect[] = rects[map.get(key)];
        int x = rect[0] + (key - randInt - 1) % (rect[2] - rect[0] + 1);
        int y = rect[1] + (key - randInt - 1) / (rect[2] - rect[0] + 1);
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[][] rects = {{1,1,5,5}};
        RandomPointRectangles obj = new RandomPointRectangles(rects);
        int[] param_1 = obj.pick();
        System.out.println(Arrays.toString(param_1));
    }
}