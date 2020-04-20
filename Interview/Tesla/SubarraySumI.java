package Interview.Tesla;
import java.util.*; 

public class SubarraySumI {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        
        Map<Integer, Integer> prefixSumToIndex = new HashMap<Integer, Integer>(); 
        
        prefixSumToIndex.put(0, 0); 
        int prefixSum = 0;
        List<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        res.add(-1);
        
        for (int i = 0; i < nums.length; i++) {
            
            prefixSum += nums[i]; 
            
            if (prefixSumToIndex.keySet().contains(prefixSum)) {
                res.set(0, prefixSumToIndex.get(prefixSum));
                res.set(1, i);
                return res;
            }
            
            prefixSumToIndex.put(prefixSum, i + 1);
        }
        
        res.set(0, -1);
        res.set(1, -1);
        
        return res;
        
    }
}