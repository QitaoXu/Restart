package Interview.FB; 
import java.util.*;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int prefixSum = 0; 
        Map<Integer, Integer> prefixSumToIndex = new HashMap<Integer, Integer>(); 
        
        prefixSumToIndex.put(prefixSum, 0);
        
        for (int i = 1; i < nums.length + 1; i++) {
            prefixSum += nums[i - 1]; 
            
            if (k != 0) 
                prefixSum = prefixSum % k;
            
            if (prefixSumToIndex.containsKey(prefixSum)) {
                if (i - prefixSumToIndex.get(prefixSum) > 1)
                    return true;
            }
            else {
                prefixSumToIndex.put(prefixSum, i);
            }
        }
        
        return false;
    }
}