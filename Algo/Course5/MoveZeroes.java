package Algo.Course5; 

public class MoveZeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        
        if (nums == null || nums.length == 0)
            return;
            
        int left = 0;
        int right = 0; 
        
        while (right < nums.length) {
            
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            
            right++;
        }
    }
}