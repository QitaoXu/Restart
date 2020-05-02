package Interview.AMZ; 
import java.util.*;

public class CoinChangeI {
    public int coinChange(int[] coins, int amount) {
        
        if (coins == null || coins.length == 0 || amount == 0)
            return 0; 
        
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i < amount + 1; i++) {
            
            for (int coin : coins) {
                
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}