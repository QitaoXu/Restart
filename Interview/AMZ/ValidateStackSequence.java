package Interview.AMZ;

import java.util.*; 


public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int n = pushed.length; 
        
        Stack<Integer> stack = new Stack<>(); 
        
        int j = 0; 
        
        for (int x : pushed) {
            
            stack.push(x);
            
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        return j == n;
    }
}