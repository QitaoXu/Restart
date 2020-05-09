package Interview.ByteDance;

import java.util.*;

public class HouseRobberII {
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        int[] A1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] A2 = Arrays.copyOfRange(nums, 1, nums.length);
        
        return Math.max(houseRobber(A1), houseRobber(A2));
        
    }
    
    private int houseRobber(int[] nums) {
        
       if (nums == null || nums.length == 0)
            return 0;
        
        if (nums.length == 1)
            return nums[0];
        
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        
        for (int i = 2; i < nums.length + 1; i++) {
            
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        
        return dp[dp.length - 1];
    }
}