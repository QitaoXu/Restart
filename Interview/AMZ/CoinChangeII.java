package Interview.AMZ;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount + 1];
        
        dp[0] = 1;
        
        for (int coin : coins) {
            
            for (int sum = coin; sum < amount + 1; sum++) {
                 
                dp[sum] += dp[sum - coin];
            }
        }
        
        return dp[amount];
    }
}