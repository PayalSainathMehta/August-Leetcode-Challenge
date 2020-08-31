public class MinimumTimeToVisitAllPoints {

    public static int minSeconds(int[][] points){
        if(points.length == 0 || points == null)
            return 0;
        //this is simply manhattan distance.
        int seconds = 0;
        int[] prev = points[0];
        for(int i = 1; i < points.length; i++){
            int[] next = points[i];
            //Math.abs(y1 - x1 + y2 - x2) for all points
            //add distance to seconds.
            int xMove = Math.abs(next[0] - prev[0]);
            int yMove = Math.abs(next[1] - prev[1]);
            seconds += Math.max(xMove, yMove);
            prev = points[i];
        }
        return seconds;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(minSeconds(points));
    }
}