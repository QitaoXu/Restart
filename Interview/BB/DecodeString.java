package Interview.BB; 

import java.util.*; 

public class DecodeString {
    public String decodeString(String s) {
        
        Stack<Object> stack = new Stack<Object>(); 
        int num = 0;
        
        for (char c : s.toCharArray()) {
            
            if (Character.isDigit(c)) {
                
                num = num * 10 + c - '0';
            }
            
            else if (c == '[') {
                
                stack.push(Integer.valueOf(num));
                num = 0;
            }
            
            else if (c == ']') {
                
                String newStr = popStack(stack);
                Integer count = (Integer)stack.pop(); 
                
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            }
            
            else {
                
                stack.push(String.valueOf(c));
            }
        }
        
        return popStack(stack);
        
    }
    
    private String popStack(Stack<Object> stack) {
        
        Stack<String> buffer = new Stack<String>(); 
        
        while (!stack.isEmpty() && stack.peek() instanceof String) {
            
            buffer.push((String)stack.pop());
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        while (!buffer.isEmpty()) {
            
            sb.append(buffer.pop());
        }
        
        return sb.toString();
    }

}