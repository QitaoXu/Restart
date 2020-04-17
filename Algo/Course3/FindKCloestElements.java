package Algo.Course3;

public class FindKCloestElements {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        
        int left = lastPosLessThanTarget(A, target); 
        int right = left + 1; 
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                res[i] = A[left];
                left -= 1;
            }
            
            else {
                res[i] = A[right];
                right += 1;
            }
        }
        
        return res;
    }
    
    private boolean isLeftCloser(int[] nums, int target, int left, int right) {
        
        if (left < 0)
            return false;
            
        if (right >= nums.length) 
            return true; 
            
        if (target - nums[left] != nums[right] - target)
            return target - nums[left] < nums[right] - target;
            
        return true;
    }
    
    private int lastPosLessThanTarget(int[] nums, int target) {
        
        int start = 0, end = nums.length - 1; 
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            if (nums[mid] < target) {
                start = mid;
            }
            
            else {
                end = mid;
            }
        }
        
        if (nums[end] < target) 
            return end;
            
        if (nums[start] < target) 
            return start;
            
        return -1;
    }
}