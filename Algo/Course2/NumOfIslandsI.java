package Algo.Course2;
import java.util.*;

public class NumOfIslandsI {

    public int numIslands(boolean[][] grid) {
        // write your code here
        
        if (grid == null || grid.length == 0)
            return 0; 
            
        int m = grid.length, n = grid[0].length; 
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    count += 1;
                }
                
            }
        }
        
        return count;
    }
    
    private void bfs(boolean[][] grid, int startX, int startY) {
        
        int m = grid.length, n = grid[0].length; 
        
        int start = startX * n + startY; 
        
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        queue.offer(start);
        grid[startX][startY] = false;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                int point = queue.poll(); 
                int px = point / n;
                int py = point % n;
                
                for (int direction = 0; direction < 4; direction++) {
                    int nx = px + dx[direction];
                    int ny = py + dy[direction];
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == false)
                        continue;
                        
                    queue.offer(nx * n + ny);
                    grid[nx][ny] = false;
                }
            }
        }
        
    }

    public int numIslandsWithoutChange(boolean[][] grid) {
        // write your code here
        
        if (grid == null || grid.length == 0)
            return 0; 
            
        int m = grid.length, n = grid[0].length; 
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == true && visited[i][j] == false) {
                    bfsWithoutChange(grid, i, j, visited);
                    count += 1;
                }
                
            }
        }
        
        return count;
    }
    
    private void bfsWithoutChange(boolean[][] grid, int startX, int startY, boolean[][] visited) {
        
        int m = grid.length, n = grid[0].length; 
        
        int start = startX * n + startY; 
        
        Queue<Integer> queue = new LinkedList<Integer>(); 
        
        queue.offer(start);
        visited[startX][startY] = true;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                int point = queue.poll(); 
                int px = point / n;
                int py = point % n;
                
                for (int direction = 0; direction < 4; direction++) {
                    int nx = px + dx[direction];
                    int ny = py + dy[direction];
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == false)
                        continue;
                        
                    if (visited[nx][ny])
                        continue;
                        
                    queue.offer(nx * n + ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
}