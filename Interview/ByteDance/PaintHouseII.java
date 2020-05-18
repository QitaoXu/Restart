package Interview.ByteDance;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        
        if (costs == null || costs.length == 0)
            return 0;
        
        int n = costs.length;
        int k = costs[0].length; 
        
        int[][] dp = new int[n][k];
        
        for (int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
        }
        
        for (int house = 1; house < n; house++) {
            for (int color = 0; color < k; color++) {
                
                dp[house][color] = Integer.MAX_VALUE;
                
                for (int prevColor = 0; prevColor < k; prevColor++) {
                    
                    if (prevColor == color)
                        continue;
                    
                    dp[house][color] = Math.min(dp[house][color], costs[house][color] + dp[house - 1][prevColor]);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int cost : dp[n - 1]) {
            res = Math.min(res, cost);
        }
        
        return res;
    }

    public int minCostIIWithRollingArray(int[][] costs) {
        
        if (costs == null || costs.length == 0)
            return 0;
        
        int n = costs.length;
        int k = costs[0].length; 
        
        int[][] dp = new int[2][k];
        
        for (int color = 0; color < k; color++) {
            dp[0][color] = costs[0][color];
        }
        
        int old = 0, now = 0;
        for (int house = 1; house < n; house++) {
            old = now;
            now = 1 - now;
            for (int color = 0; color < k; color++) {
                
                dp[now][color] = Integer.MAX_VALUE;
                
                for (int prevColor = 0; prevColor < k; prevColor++) {
                    
                    if (prevColor == color)
                        continue;
                    
                    dp[now][color] = Math.min(dp[now][color], costs[house][color] + dp[old][prevColor]);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int cost : dp[now]) {
            res = Math.min(res, cost);
        }
        
        return res;
    }
}