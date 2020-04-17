package Algo.Course1;

public class LognestPalindromicSubsequence {

    public int getLongestPalindromicSunsequence(String s) {

        if (s.length() == 0) 
            return 0; 

        if (s.length() == 1) 
            return 1; 

        int n = s.length();
        int[][] dp = new int[n][n]; 

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; 

            if (i + 1 < n) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
            }
        }

        for (int length = 3; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1; 

                if (s.charAt(left) != s.charAt(right)) {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }

                else {
                    dp[left][right] = dp[left + 1][right - 1] + 2; 
                }
            }
        }

        int res = 0; 

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] > res) 
                    res = dp[i][j];
            }
        }

        return res;
    }
}