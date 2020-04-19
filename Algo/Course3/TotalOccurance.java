package Algo.Course3; 

public class TotalOccurance {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int firstPos = firstPos(A, target);
        int lastPos = lastPos(A, target);
        
        if (firstPos == -1 || lastPos == -1) {
            return 0;
        }
        
        return lastPos - firstPos + 1;
    }
    
    private int firstPos(int[] nums, int target) {
        
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
        
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
    
    private int lastPos(int[] nums, int target) {
        
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
        
        if (nums[end] == target) {
            return end;
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        return -1;
    }
}