package Interview.ByteDance;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0)
            return 0;
        
        String s1 = text1, s2 = text2; 
        
        int m = s1.length(), n = s2.length(); 
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                
                else 
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[m][n];
    }
}