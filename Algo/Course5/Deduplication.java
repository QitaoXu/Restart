package Algo.Course5;
import java.util.*;
public class Deduplication {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        
        if (nums == null || nums.length == 0) 
            return 0; 
            
        Arrays.sort(nums);
        
        int len = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        
        return len + 1;
    }
}