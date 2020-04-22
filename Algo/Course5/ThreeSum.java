package Algo.Course5; 

import java.util.*; 

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        
        List<List<Integer>> results = new ArrayList<List<Integer>>(); 
        int[] nums = numbers;
        if (nums == null || nums.length < 3)
            return results;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int target = 0 - nums[i]; 
            
            int start = i + 1, end = nums.length - 1;
            
            while (start < end) {
                
                if (nums[start] + nums[end] < target) {
                    start++;
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                }
                
                else if (nums[start] + nums[end] > target) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                }
                
                else {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]); 
                    res.add(nums[start]);
                    res.add(nums[end]);
                    results.add(res);
                    start++;
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                    end--;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                }
            }
        }
        
        return results;
    }
}