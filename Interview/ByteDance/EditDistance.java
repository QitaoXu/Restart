package Interview.ByteDance;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length() , word2.length());
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; 
        
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        
        return dp[m][n];
    }

    public int minDistanceWithRollingArray(String word1, String word2) {
        
        if (word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        
        int m = word1.length(), n = word2.length(); 
        int[][] dp = new int[2][n + 1];
        
        int old = 0, now = 0; 
        
        for (int i = 0; i < m + 1; i++) {
            old = now;
            now = 1 - now;
            
            for (int j = 0; j < n + 1; j++) {
                
                if (i == 0) {
                    dp[now][j] = j;
                    continue;
                }
                
                if (j == 0) {
                    dp[now][j] = i;
                    continue;
                }
                   
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[now][j] = dp[old][j - 1];
                
                else 
                    dp[now][j] = Math.min(dp[old][j - 1], Math.min(dp[now][j - 1], dp[old][j])) + 1;
            }
        }
        
        return dp[now][n];
        
    }
}