package Algo.Course5;

import java.util.*; 

public class KDistinctCharactersAtLeast {
    
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        
        long res = 0;
        
        if (s == null || s.length() < k) {
            return res;
        }
        
        int left = 0;
        char[] sa = s.toCharArray(); 
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        
        for (int right = 0; right < s.length(); right++) {
            
            count.put(sa[right], count.getOrDefault(sa[right], 0) + 1);
            
            while (left <= right && count.keySet().size() >= k) {
                count.put(sa[left], count.get(sa[left]) - 1); 
                
                if (count.get(sa[left]) == 0) {
                    count.remove(sa[left]);
                }
                
                left++;
                
            }
            // ensure exactly since sa[left - 1] is removed from count hash map, count.keySet() == k - 1
            if (count.keySet().size() == k - 1 && left > 0 && !count.keySet().contains(sa[left - 1])) {
                res += left;
            }
        }
        
        return res;
    }
}