import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByFactor {

    //HINT: YOU HAVE DEBUGGED THIS ONCE, ITS EASY.
    int[] parent;

    int get(int x){
        return parent[x] == x ? x : (parent[x] = get(parent[x])) ;
    }

    void add(int x, int y){
        parent[get(x)] = parent[get(y)];
    }

    public int largestComponentSize(int[] A) {
        int max = 0;
        for(int ele: A)
            max = Math.max(ele, max); //find largest element , here 63
        parent = new int[max+1]; //parent will have largest + 1 length so here 64
        for(int i = 1; i <= max; i++)
            parent[i] = i; // parent[2] = 2 , parent[63] = 63..and so on initially

        for(int ele: A) //pick element
            for(int j = (int)Math.sqrt(ele); j >= 2; j--) //find factor
                if(ele % j == 0){ //if factor
                    add(ele, j); //set parent
                    add(ele, ele/j); //set parent of factor too
                }

        //Now we will use hashmap to get number of groups
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        int result = 0;

        for(int ele: A){
            int j = get(ele); //get parent of element. chaining happens here!
            if(!map.containsKey(j))  //no one claimed previously
                map.put(j, 1);
            else
                map.put(j, map.get(j) + 1); //done already
            result = Math.max(result, map.get(j)); //set res to max of two.
        }
        return result;
    }

    public static void main(String[] args) {
        LargestComponentSizeByFactor obj = new LargestComponentSizeByFactor();
        int[] A = {20,50,9,63};
        System.out.println(obj.largestComponentSize(A));
    }
}