package Algo.Course2;
import java.util.*;
public class MazeI {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
        
        int m = maze.length; 
        int n = maze[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
         
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        visited[start[0]][start[1]] = true;
        queue.offer(start); 
        
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll(); 
                if (point[0] == destination[0] && point[1] == destination[1])
                    return true;
                
                for (int direction = 0; direction < 4; direction++) {
                    int nx = point[0], ny = point[1];
                    
                    while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                        
                        nx += dx[direction];
                        ny += dy[direction];
                    }
                    
                    nx -= dx[direction];
                    ny -= dy[direction];
                    
                    if (!visited[nx][ny]) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return false;
    }
    
}