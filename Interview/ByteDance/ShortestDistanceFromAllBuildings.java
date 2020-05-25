package Interview.ByteDance; 

import java.util.*; 

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        
        
        int buildings = 0; 
        int res = Integer.MAX_VALUE;
        boolean found = false;
        
        int m = grid.length, n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1)
                    buildings++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 0) {
                    
                    boolean[][] visited = new boolean[m][n];
                    int distance = bfs(grid, i, j, visited, buildings);
                    
                    if (distance != -1) {
                        found = true;
                        res = Math.min(res, distance);
                    }
                }
            }
        }
        
        return found == true ? res : -1;
    }
    
    private int bfs(int[][] grid, int i, int j, boolean[][] visited, int buildings) {
        
        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true; 
        
        int visitedBuildings = 0; 
        int count = 0; 
        int res = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            count++;
            
            for (int index = 0; index < size; index++) {
                
                int[] curt = queue.poll(); 
                
                for (int d = 0; d < 4; d++) {
                    
                    int nx = curt[0] + dx[d];
                    int ny = curt[1] + dy[d];
                    
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n 
                        || grid[nx][ny] == 2 || visited[nx][ny] == true)
                        continue;
                    
                    visited[nx][ny] = true;
                    if (grid[nx][ny] == 1) {
                        visitedBuildings++;
                        res += count;
                    }
                    
                    if (grid[nx][ny] == 0) {
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        
        return buildings == visitedBuildings ? res : -1;
    }
}