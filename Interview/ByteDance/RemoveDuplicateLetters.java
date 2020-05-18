package Interview.ByteDance; 

import java.util.*; 


public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        
        Stack<Character> stack = new Stack<Character>(); 
        
        Set<Character> seen = new HashSet<Character>(); 
        
        Map<Character, Integer> lastOccurence = new HashMap<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurence.put(s.charAt(i), i);
        }
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i); 
            
            if (!seen.contains(c)) {
                
                while (!stack.isEmpty() && c < stack.peek() && lastOccurence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                
                stack.push(c);
                seen.add(c);
            }
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (Character c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}