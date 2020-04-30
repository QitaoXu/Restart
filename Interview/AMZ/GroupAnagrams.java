package Interview.AMZ; 

import java.util.*; 

public class GroupAnagrams {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        
        List<List<String>> results = new ArrayList<>();
        
        if (strs == null || strs.length == 0) 
            return results;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            
            String key = getKey(word); 
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(word);
        }
        
        for (List<String> list : map.values()) {
            
            results.add(list);
        }
        
        return results;
        
    }
    
    private String getKey(String s) {
        
        char[] sa = s.toCharArray();
        
        Arrays.sort(sa);
        
        String key = new String(sa);
        
        return key;
    }
}