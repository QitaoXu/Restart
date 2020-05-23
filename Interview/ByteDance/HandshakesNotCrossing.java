package Interview.ByteDance; 

public class HandshakesNotCrossing {
    public int numberOfWays(int num_people) {
        
        long mod = (long)1e9 + 7;
        long[] dp = new long[num_people / 2 + 1];
        dp[0] = 1; 
        
        for (int k = 1; k <= num_people / 2; k++) {
            for (int i = 0; i < k; i++) {
                
                dp[k] = (dp[k] + dp[i] * dp[k - i - 1]) % mod;
            }
        }
        
        return (int)dp[num_people / 2];
    }
}