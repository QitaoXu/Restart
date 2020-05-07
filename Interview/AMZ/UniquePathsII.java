package Interview.AMZ;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int[][] grid = obstacleGrid;
        
        if (grid == null || grid.length == 0)
            return 0; 
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        
        boolean exists = false;
        
        for (int i = 0; i < m; i++) {
            
            if (grid[i][0] == 1) {
                exists = true;
            }
            
            dp[i][0] = exists == true ? 0 : 1;
        }
        
        exists = false;
        
        for (int j = 0; j < n; j++) {
            
            if (grid[0][j] == 1) {
                exists = true;
            }
            
            dp[0][j] = exists == true ? 0 : 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                if (grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
        
    }
}