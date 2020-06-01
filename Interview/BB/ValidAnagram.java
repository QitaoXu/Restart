package Interview.BB;

import java.util.*; 

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> sourceHash = new HashMap<Character, Integer>();
        Map<Character, Integer> targetHash = new HashMap<Character, Integer>(); 
        
        for (int i = 0; i < s.length(); i++) {
            
            sourceHash.put(s.charAt(i), sourceHash.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int j = 0; j < t.length(); j++) {
            
            targetHash.put(t.charAt(j), targetHash.getOrDefault(t.charAt(j), 0) + 1);
        }
        
        return sourceHash.equals(targetHash);
    }
}