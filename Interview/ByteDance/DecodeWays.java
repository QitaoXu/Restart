package Interview.ByteDance;

public class DecodeWays {
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0)
            return 0;
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        char[] sa = s.toCharArray(); 
        dp[1] = sa[0] == '0' ? 0 : 1;
        
        for (int i = 2; i < s.length() + 1; i++) {
            
            if (sa[i - 1] != '0')
                dp[i] += dp[i - 1];
            
            int prevCurt = Integer.parseInt(s.substring(i - 2, i));
            
            if (prevCurt <= 26 && prevCurt >= 10) {
                dp[i] += dp[i - 2];
            }
            
        }
        
        return dp[s.length()];
        
    }
}