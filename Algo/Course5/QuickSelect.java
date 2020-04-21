package Algo.Course5; 

public class QuickSelect {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        
        if (start >= end) 
            return nums[start];
        
        int left = start, right = end; 
        int pivot = nums[start + (end - start) / 2]; 
        
        while (left <= right) {
            
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right]; 
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        }
        
        else if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        
        return nums[right + 1];
        
    }
}