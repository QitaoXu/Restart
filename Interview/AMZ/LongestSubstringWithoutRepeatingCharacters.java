package Interview.AMZ;
import java.util.*; 

public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        
        if (s == null || s.length() == 0) 
            return 0;
        
        int left = 0, right = 0; 
        
        int res = 1; 
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (right = 0; right < s.length(); right++) {
            
            char rc = s.charAt(right);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            
            while (left < right && map.get(rc) > 1) {
                
                char lc = s.charAt(left);
                map.put(lc, map.get(lc) - 1);
                left++;
            }
            
            res = Math.max(res, right - left + 1);
            
        }
        
        return res;
        
    }
}