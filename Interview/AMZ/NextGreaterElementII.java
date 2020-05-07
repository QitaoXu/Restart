package Interview.AMZ;

import java.util.*; 

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length; 
        Stack<Integer> stack = new Stack<>(); 
        
        for (int i = n - 1; i >= 0; i--) {
            
            stack.push(i);
        }
        
        int[] result = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            
            result[i] = -1; 
            
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
                stack.pop();
            
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            
            stack.push(i);
        }
        
        return result;
    }
}