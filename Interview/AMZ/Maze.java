package Interview.AMZ;

import java.util.*; 

public class Maze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        if (maze == null || maze.length == 0) 
            return false;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0}; 
        
        int m = maze.length;
        int n = maze[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>(); 
        boolean[][] visited = new boolean[m][n]; 
        
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                int[] node = queue.poll();
                if (node[0] == destination[0] && node[1] == destination[1]) {
                    return true;
                }
                
                for (int direction = 0; direction < 4; direction++) {
                    int nx = node[0];
                    int ny = node[1]; 
                    
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