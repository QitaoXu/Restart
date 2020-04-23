package Interview.FB; 
import java.util.*; 

public class MinRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            
            if (s.charAt(i) == ')') {
                
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                }
                
                else {
                    stack.pop();
                }
            }
        }
        
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < s.length(); i++) {
            if (indexesToRemove.contains(i))
                continue;
            
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}