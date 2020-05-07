package Interview.AMZ;

import java.util.*; 

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> results = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return results;
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        
        for (int j = 0; j < n; j++) {
            
            dfs(matrix, pacific, 0, j, Integer.MIN_VALUE);
            dfs(matrix, atlantic, m - 1, j, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (pacific[i][j] == true && atlantic[i][j] == true) {
                    
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    results.add(point);
                }
            }
        }
        
        return results;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int x, int y, int height) {
        
        int m = matrix.length, n = matrix[0].length;
        
        if (x < 0 || x >= m || y < 0 || y >= n || height > matrix[x][y] || visited[x][y]) 
            return;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(matrix, visited, nx, ny, matrix[x][y]);
        }
    }
}