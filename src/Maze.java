import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(start[0] == destination[0] && start[1] == destination[1])
            return true;
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];
        queue.offer(start);
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;
            if (visited[cur[0]][cur[1]])
                continue;
            visited[cur[0]][cur[1]] = true;
            int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            for(int[] dir: dirs){
                int x = cur[0];
                int y = cur[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x = x + dir[0];
                    y = y + dir[1];
                }
                //Back to validate point
                x = x - dir[0];
                y = y - dir[1];
                queue.offer(new int[] {x, y});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};
        System.out.println(hasPath(maze, start, destination));
    }
}
