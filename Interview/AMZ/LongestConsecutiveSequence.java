package Interview.AMZ;

import java.util.*; 

public class LongestConsecutiveSequence {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] nums) {
        // write your code here
        
        Set<Integer> set = new HashSet<>(); 
        
        for (int num : nums) {
            set.add(num);
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            
            int down = nums[i] - 1; 
            
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            
            int up = nums[i] + 1; 
            
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            
            res = Math.max(res, up - down - 1);
        }
        
        return res;
    }
}