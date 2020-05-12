package Interview.ByteDance;

import java.util.*; 


public class RussianDollEnveLopes {
    public int maxEnvelopes(int[][] envelopes) {
        
        if (envelopes == null || envelopes.length == 0)
            return 0;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] A, int[] B) {
                if (A[0] != B[0])
                    return A[0] - B[0];
                return B[1] - A[1];
            }
        }); 
        
        int[] nums = new int[envelopes.length]; 
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        
        return longestIncreasingSubsequence(nums);
    }
    
    private int longestIncreasingSubsequence(int[] nums) {
        
        int n = nums.length; 
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0; 
        int res = 1;
        for (int i = 1; i < n + 1; i++) {
            
            for (int j = 1; j < i; j++) {
                
                if (nums[j - 1] < nums[i - 1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            res = Math.max(dp[i], res);
        }
        
        return res;
    }
}
