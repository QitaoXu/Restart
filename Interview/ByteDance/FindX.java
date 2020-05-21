package Interview.ByteDance;

public class FindX {

    public int findX(int[] nums) {

        
        int start = 0, end = nums.length - 1;
        
        int target = nums[nums.length - 1];
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            if (nums[mid] <= target)
                
                end = mid;
                
            else if (nums[mid] > target)
                
                start = mid;

        }
    
            
        if (nums[end] <= target)
            
            return end;

        if (nums[start] <= target)
            return start;

        return -1;
        
    }
}