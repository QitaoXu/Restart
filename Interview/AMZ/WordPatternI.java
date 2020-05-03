package Interview.AMZ;

import java.util.*; 

public class WordPatternI {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        
        String[] tokens = teststr.split(" ");
        
        Map<Character, String> map = new HashMap<>(); 
        Set<String> used = new HashSet<>();
        
        if (tokens.length != pattern.length())
            return false;
        
        for (int i = 0; i < tokens.length; i++) {
            
            String token = tokens[i]; 
            char p = pattern.charAt(i);
            
            if (!map.containsKey(p)) {
                
                if (used.contains(token))
                    return false;
                    
                map.put(p, token);
                used.add(token);
            }
            
            else {
                
                if (!map.get(p).equals(token))
                    return false;
            }
        } 
        
        return true;
        
    }
}