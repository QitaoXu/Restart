package Algo.Course3;

public class MountainSequence {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        
        int start = 0, end = nums.length - 1; 
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            if (nums[mid] < nums[mid + 1]) 
                start = mid; 
                
            else 
                end = mid;
        }
        
        return Math.max(nums[start], nums[end]);
    }
}