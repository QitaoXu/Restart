package Interview.BB;

import java.util.*; 

public class TriangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        
        int[] nums = S; 
        
        int count = 0; 
        
        if (nums == null || nums.length <= 2)
            return count; 
            
        Arrays.sort(nums);
        
        for (int i = 2; i < nums.length; i++) {
            
            int left = 0, right = i - 1;
            
            while (left < right) {
                
                if (nums[left] + nums[right] > nums[i]) {
                    
                    count += right - left;
                    right -= 1;
                }
                
                else {
                    left += 1;
                }
                
            }
        }
        
        return count;
    }
}