package Interview.AMZ;
import java.util.*; 

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        
        int res = 0; 
        
        boolean[][] visited = new boolean[m][n]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    
                    int island = bfs(grid, i, j, visited); 
                    res = Math.max(res, island);
                }
            }
        }
        
        return res;
    }
    
    private int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>(); 
        
        queue.offer(x * n + y);
        set.add(x * n + y);
        visited[x][y] = true; 
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while(!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                int node = queue.poll(); 
                int cx = node / n;
                int cy = node % n; 
                
                for (int j = 0; j < 4; j++) {
                    
                    int nx = cx + dx[j];
                    int ny = cy + dy[j]; 
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) 
                        continue;
                    
                    if (set.contains(nx * n + ny))
                        continue;
                    
                    queue.offer(nx * n + ny);
                    set.add(nx * n + ny);
                    visited[nx][ny] = true;
                }
            }
        }
        
        return set.size();
    }
}