package Interview.ByteDance; 

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length; 
        
        int[][] dp = new int[m][n]; 
        
        dp[0][0] = grid[0][0]; 
        
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
         
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public int minPathSumRollingArray(int[][] grid) {
        
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length; 
        
        int[][] dp = new int[2][n]; 
        int i, j; 
        int old, now = 0; 
        
        for (i = 0; i < m; i++) {
            
            old = now;
            now = 1 - now;
            
            for (j = 0; j < n; j++) {
                
                if (i == 0 && j == 0) {
                    dp[now][j] = grid[i][j];
                    continue;
                }
                
                dp[now][j] = Integer.MAX_VALUE; 
                
                if (i > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[old][j]);
                }
                
                if (j > 0) {
                    dp[now][j] = Math.min(dp[now][j], dp[now][j - 1]);
                }
                
                dp[now][j] += grid[i][j];
            }
        }
        
        return dp[now][n - 1];
        
    }
}