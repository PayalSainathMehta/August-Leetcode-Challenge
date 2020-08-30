import java.util.ArrayList;
import java.util.List;

class PancakeSort {
    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        for (int n = A.length; n > 0; --n) {
            int index = find(A, n); //get the index to flip
            flip(A, index);  //reverse everything in between
            flip(A, n - 1); //put to end
            result.add(index + 1); //add
            result.add(n);//add
        }
        return result;
    }

    public static int find(int[] A, int target){
        for(int i = 0; i < A.length; i++)
            if(A[i] == target)
                return i;
        return -1;
    }
    public static void flip(int[] A, int k) {
        for (int i = 0, j = k; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] A = {3,2,4,1};
        System.out.println(pancakeSort(A).toString());
    }
}