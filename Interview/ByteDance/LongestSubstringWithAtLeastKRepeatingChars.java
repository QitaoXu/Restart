package Interview.ByteDance; 

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingChars {
    public int longestSubstring(String s, int k) {
        
        Map<Character, Integer> counter = getCounter(s);
        
        int left = 0; 
        
        int longest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (counter.get(s.charAt(i)) < k) {
                
                int subLongest = longestSubstring(s.substring(left, i), k);
                longest = Math.max(longest, subLongest);
                left = i + 1;
            }
        }
        
        if (left == 0)
            return s.length();
        
        int subLongest = longestSubstring(s.substring(left, s.length()), k);
        longest = Math.max(longest, subLongest);
        
        return longest;
    }
    
    private Map<Character, Integer> getCounter(String s) {
        
        Map<Character, Integer> counter = new HashMap<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        return counter;
    }
}