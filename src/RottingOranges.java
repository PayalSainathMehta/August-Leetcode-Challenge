import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static int returnDays(int[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		int count_fresh = 0;
		int days = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		/*
		 * Our logic - ignore empty cells
		 * add rotten orange cell position to queue x,y
		 * add fresh to count
		 */
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 2)
					queue.offer(new int[] {i, j});
				else if(grid[i][j] == 1)
					count_fresh++;
			}
		}
		
		if(count_fresh == 0) //we never had fresh oranges to begin with
			return 0;
		while(!queue.isEmpty() && count_fresh > 0) {
			days++;
			int size = queue.size();
			int dirs[][] = {{0,1},{1,0},{-1,0},{0,-1}};
			for(int i = 0; i < size; i++) {
				int current[] = queue.poll();
				for(int dir[]: dirs) {
					int x = current[0] + dir[0];
					int y = current[1] + dir[1];
					//ignore if out of bounds or already rotten or empty
					if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 2 || grid[x][y] == 0)
						continue;
					grid[x][y] = 2; //make rotten
					count_fresh--; //reduce count of fresh
					queue.offer(new int[] {x, y}); //add to queue
				}
				
			}
		}
		return count_fresh == 0 ? days : -1;
		
	}
	
	
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(returnDays(grid));
	}
}
