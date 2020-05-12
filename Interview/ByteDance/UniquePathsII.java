package Interview.ByteDance;

public class UniquePathsII {

    public int uniquePaths(int[][] grid) {
        
        if (grid == null || grid.length == 0)
             return 0; 
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[2][n];
        
        int old = 0, now = 0;
        boolean rowExistsObstacle = false;
        boolean colExistsObstacle = false;
        
        for (int i = 0; i < m; i++) {
            old = now; 
            now = 1 - old;
            for (int j = 0; j < n; j++) {
                
                if (i == 0) {
                    
                    if (grid[i][j] == 1)
                        rowExistsObstacle = true;
                    dp[now][j] = grid[i][j] == 1 || rowExistsObstacle == true ? 0 : 1;
                }
                
                if (j == 0) {
                    
                    if (grid[i][j] == 1)
                        colExistsObstacle = true;
                    dp[now][j] = grid[i][j] == 1 || colExistsObstacle == true ? 0 : 1;
                }
                
                if (i > 0 && j > 0)
                    dp[now][j] = grid[i][j] == 1 ? 0 : dp[old][j] + dp[now][j - 1];
                
            }
        }
        
        return dp[now][n - 1];
    }
}