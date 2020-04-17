package Algo.Course1;

public class LongestPalindromicSubstring {

    public String getLongestPalindromicSubstring(String s) {

        if (s == null || s.length() == 0)
            return "";

        int n = s.length(); 
        boolean[][] dp = new boolean[n][n]; 

        for (int i = 0; i < n; i++) {
            dp[i][i] = true; 

            if (i >= 1) {
                dp[i][i - 1] = true;
            }
        }

        int start = 0, end = 0, longest = 1; 

        for (int diff = 1; diff < n; diff++) {
            for (int left = 0; left < n - diff; left++) {
                int right = left + diff; 

                dp[left][right] = s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1];

                if (dp[left][right] && (diff + 1) > longest) {
                    start = left; 
                    end = right;
                    longest = diff + 1;
                }
            }
        }

        return s.substring(start, end + 1);

    }
}