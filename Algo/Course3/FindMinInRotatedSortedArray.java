package Algo.Course3; 

public class FindMinInRotatedSortedArray {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        
        int start = 0, end = nums.length - 1; 
        int target = nums[nums.length - 1];
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            if (nums[mid] <= target) {
                end = mid;
            }
            
            else {
                start = mid;
            }
        }
        
        return Math.min(nums[start], nums[end]);
    }
}