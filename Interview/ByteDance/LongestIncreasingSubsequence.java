package Interview.ByteDance; 

import java.util.*; 

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1); 
        dp[0] = 0; 
        int res = 0;
        
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < i; j++) {
                
                if (nums[i - 1] > nums[j - 1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}