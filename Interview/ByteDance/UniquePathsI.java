package Interview.ByteDance; 

public class UniquePathsI {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[2][n]; 
        
        int now = 0, old = 0;
        
        for (int i = 0; i < m; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < n; j++) {
                
                if (i == 0 || j == 0)
                    dp[now][j] = 1; 
                
                else
                    dp[now][j] = dp[old][j] + dp[now][j - 1];
            }
        }
        
        return dp[now][n - 1];
    }
}