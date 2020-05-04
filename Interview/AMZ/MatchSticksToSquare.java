package Interview.AMZ;
import java.util.*;

public class MatchSticksToSquare {
    public boolean makesquare(int[] nums) {
        
        if (nums == null || nums.length < 4)
            return false; 
        
        int sum = 0; 
        
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 4 != 0) 
            return false; 
        
        int curtEdgeLength = 0, startIndex = 0, edgeCount = 0; 
        int width = sum / 4;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums); 
        
        for (int num : nums) {
            if (num > width)
                return false;
        }
        
        return dfs(nums, curtEdgeLength, startIndex, edgeCount, width, used);
        
    }
    
    private boolean dfs(int[] nums, 
                        int curtEdgeLength, 
                        int startIndex, 
                        int edgeCount, 
                        int target, 
                        boolean[] used) {
        
        if (edgeCount == 4) {
            
            for (boolean stickUsed : used) {
                if (!stickUsed)
                    return false;
            }
            
            return true;
        }
        
        if (startIndex == nums.length) 
            return false;
        
        for (int index = startIndex; index < nums.length; index++) {
            
            if (used[index])
                continue;
            
            if (nums[index] + curtEdgeLength > target)
                break;
            
            if (nums[index] + curtEdgeLength == target) {
                used[index] = true;
                if (dfs(nums, 0, 0, edgeCount + 1, target, used))
                    return true;
                used[index] = false;
            }
            
            if (nums[index] + curtEdgeLength < target) 
                used[index] = true;
                if (dfs(nums, nums[index] + curtEdgeLength, index + 1, edgeCount, target, used))
                    return true;
                used[index] = false;
                
        }
        
        return false;
        
    }
}