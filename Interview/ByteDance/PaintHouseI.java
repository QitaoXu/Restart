package Interview.ByteDance;

public class PaintHouseI {
    public int minCost(int[][] costs) {
        
        if (costs == null || costs.length == 0)
            return 0;
        
        int n = costs.length; 
        
        int[][] dp = new int[n][3];
        
        for (int color = 0; color < 3; color++) {
            dp[0][color] = costs[0][color];
        }
        
        for (int house = 1; house < n; house++) {
            for (int color = 0; color < 3; color++) {
                
                dp[house][color] = costs[house][color] + 
                    Math.min(dp[house - 1][(color + 1) % 3], dp[house - 1][(color + 2) % 3]);
            }
        }
        
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}