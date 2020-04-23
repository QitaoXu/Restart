package Interview.FB; 
import java.util.*; 

public class  RemoveInvalidParentheses{
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> results = new ArrayList<String>();
        
        if (s == null) 
            return results;
        
        if (s.length() == 0 || isValid(s)) {
            results.add(s);
            return results;
        }
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>(); 
        
        queue.offer(s);
        visited.add(s); 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            if (results.size() > 0) 
                return results;
            
            for (int i = 0; i < size; i++) {
                
                String node = queue.poll(); 
                
                for (String neighbor : getNeighbors(node)) {
                    
                    if (visited.contains(neighbor))
                        continue;
                    
                    if (isValid(neighbor))
                        results.add(neighbor);
                    
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
                
            }
            
        }
        
        return results;
        
    }
    
    private List<String> getNeighbors(String s) {
        List<String> neighbors = new ArrayList<String>(); 
        
        for (int i = 0; i < s.length(); i++) {
            
            if (i > 0 && s.charAt(i) == s.charAt(i - 1))
                continue;
            
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;
            
            String neighbor = s.substring(0, i) + s.substring(i + 1);
            
            neighbors.add(neighbor);
        }
        
        return neighbors;
    }
    
    private boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>(); 
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i); 
            
            if (c == '(') 
                stack.push(c);
            
            else if (c == ')') {
                if (!stack.isEmpty()) 
                    stack.pop();
                
                else 
                    return false;
            }
        }
        
        return stack.size() == 0;
    }
    
}