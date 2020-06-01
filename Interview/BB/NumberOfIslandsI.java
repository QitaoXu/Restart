package Interview.BB;

import java.util.*; 

public class NumberOfIslandsI {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0)
            return 0; 
        
        int m = grid.length, n = grid[0].length; 
        
        boolean[][] visited = new boolean[m][n]; 
        
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>(); 
        
        int m = grid.length, n = grid[0].length; 
        
        queue.offer(x * n + y);
        set.add(x * n + y);
        visited[x][y] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            
            int node = queue.poll();
            int cx = node / n;
            int cy = node % n;
            
            for (int i = 0; i < 4; i++) {
                
                int nx = cx + dx[i];
                int ny = cy + dy[i]; 
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == '0') 
                    continue;
                
                if (set.contains(nx * n + ny))
                    continue;
                
                queue.offer(nx * n + ny);
                set.add(nx * n + ny);
                visited[nx][ny] = true;
            }
        }
    }
}