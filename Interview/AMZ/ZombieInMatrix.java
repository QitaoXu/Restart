package Interview.AMZ;

import java.util.*; 

public class ZombieInMatrix {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here
        
        int walls = 0; 
        int m = grid.length, n = grid[0].length;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    walls += 1;
                    
                if (grid[i][j] == 1) {
                    queue.offer(i * n + j);
                    visited.add(i * n + j);
                }
            }
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int days = 0;
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            days++;
            for (int i = 0; i < size; i++) {
                
                int node = queue.poll(); 
                int x = node / n; 
                int y = node % n; 
                
                for (int direction = 0; direction < 4; direction++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction]; 
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 2)
                        continue;
                        
                    if (visited.contains(nx * n + ny))
                        continue;
                        
                    grid[nx][ny] = 1; 
                    queue.offer(nx * n + ny);
                    visited.add(nx * n + ny);
                }
            }
            
        }
        
        return visited.size() == n * m - walls ? days - 1 : -1;
    }
}