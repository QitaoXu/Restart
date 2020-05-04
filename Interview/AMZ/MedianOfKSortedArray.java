package Interview.AMZ;

public class MedianOfKSortedArray {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        // write your code here
        
        if (nums == null || nums.length == 0 || nums.length == 1 && nums[0].length == 0)
            return 0.0;
        
        int n = 0; 
        
        for (int[] num : nums) {
            n += num.length;
        }
        
        if (n % 2 == 0) {
            return findKth(nums, n / 2) / 2.0 + findKth(nums, n / 2 + 1) / 2.0;
        }
        else {
            return findKth(nums, n / 2 + 1) / 1.0;
        }
    }
    
    private int findKth(int[][] numsArray, int k) {
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        for (int[] nums : numsArray) {
            
            if (nums == null || nums.length == 0)
                continue;
            
            start = Math.min(start, nums[0]);
            end = Math.max(end, nums[nums.length - 1]);
        }
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            if (countSmallerOrEqual(numsArray, mid) < k) {
                start = mid;
            }
            
            else {
                end = mid;
            }
        }
    
        if (countSmallerOrEqual(numsArray, start) >= k) 
            return start;
            
        return end;
        
        
    }
    
    private int countSmallerOrEqual(int[][] numsArray, int target) {
        
        int res = 0; 
        
        for (int[] nums : numsArray) {
            
            if (nums == null || nums.length == 0)
                continue;
            
            res += countSmallerOrEqualHelper(nums, target);
        }
        
        return res;
    }
    
    private int countSmallerOrEqualHelper(int[] nums, int target) {
        
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] <= target) {
                start = mid;
            }
            
            else {
                end = mid;
            }
        }
        
        if (nums[start] > target)
            return start;
            
        if (nums[end] > target) 
            return end;
            
        return nums.length;
        
    }
}