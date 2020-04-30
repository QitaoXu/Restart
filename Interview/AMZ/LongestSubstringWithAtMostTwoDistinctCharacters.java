package Interview.AMZ;

import java.util.*; 

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        
        if (s == null || s.length() == 0) 
            return 0;
            
        int left = 0, right = 0; 
        int res = 0; 
        
        Map<Character, Integer> map = new HashMap<Character, Integer>(); 
        
        for (right = 0; right < s.length(); right++) {
            
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            
            while (left < right && map.size() > 2) {
                
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1); 
                
                if (map.get(lc) == 0) 
                    map.remove(lc);
                left++;
            }
            
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}