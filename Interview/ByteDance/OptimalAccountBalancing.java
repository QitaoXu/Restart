package Interview.ByteDance;

import java.util.*; 

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        
        
        Map<Integer, Integer> balances = new HashMap<Integer, Integer>(); 
        
        for (int[] t : transactions) {
            
            balances.put(t[0], balances.getOrDefault(t[0], 0) - t[2]);
            balances.put(t[1], balances.getOrDefault(t[1], 0) + t[2]);
        }
        
        int len = 0; 
        int[] account = new int[balances.size()];
        
        for (int balance : balances.values()) {
            
            if (balance == 0)
                continue;
            account[len++] = balance;
        }
        
        if (len == 0)
            return 0;
        
        int[] dp = new int[1 << len]; 
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        
        for (int i = 1; i < dp.length; i++) {
            
            int sum = 0, count = 0; 
            
            for (int j = 0; j < len; j++) {
                
                if ((1 << j & i) != 0) {
                    
                    sum += account[j];
                    count += 1;
                }
            }
            
            if (sum == 0) {
                dp[i] = count - 1; 
                
                for (int j = 1; j < i; j++) {
                    
                    if (((j & i) == j) && dp[j] + dp[i - j] < dp[i]) {
                        dp[i] = dp[j] + dp[i - j];
                    }
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}