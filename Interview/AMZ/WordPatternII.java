package Interview.AMZ;

import java.util.*;

public class WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        
        Map<Character, String> mapping = new HashMap<>();
        Set<String> used = new HashSet<String>();
        
        return dfs(str, pattern, mapping, used);
    }
    
    private boolean dfs(String s, 
                        String p, 
                        Map<Character, String> mapping, 
                        Set<String> used) {
                        
        
        if (p.length() == 0)
            return s.length() == 0;
            
        char c = p.charAt(0); 
        if (mapping.containsKey(c)) {
            
            String word = mapping.get(c);
            
            if (!s.startsWith(word))
                return false;
                
            else {
                
                return dfs(s.substring(word.length()), p.substring(1), mapping, used);
            }
        }
        
        for (int index = 0; index < s.length(); index++) {
            
            String word = s.substring(0, index + 1);
            
            if (used.contains(word))
                continue;
                
            mapping.put(c, word);
            used.add(word);
            
            if (dfs(s.substring(word.length()), p.substring(1), mapping, used))
                return true;
                
            used.remove(word);
            mapping.remove(c);
            
        }
        
        return false;
    }
}