package Interview.AMZ; 

import java.util.*; 

public class MinimumArrayStringCoverage {
    /**
     * @param tagList: The tag list.
     * @param allTags: All the tags.
     * @return: Return the answer
     */
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        // Write your code here
        
        if (allTags == null || allTags.length == 0)
            return -1;
            
        if (tagList == null || tagList.length == 0)
            return 0;
        
        Set<String> set = new HashSet<String>();
        for (String tag : tagList)
            set.add(tag);
        
        Map<String, Integer> source = new HashMap<String, Integer>(); 
        
        int left = 0, right = 0; 
        
        int res = Integer.MAX_VALUE;
        
        for (left = 0; left < allTags.length; left++) {
            
            while (right < allTags.length && set.size() > source.size()) {
                if (set.contains(allTags[right]))
                    source.put(allTags[right], source.getOrDefault(allTags[right], 0) + 1);
                right++;
            }
            
            if (set.size() == source.size()) {
                res = Math.min(res, right - left);
            }
            
            if (set.contains(allTags[left])) {
                source.put(allTags[left], source.get(allTags[left]) - 1); 
                if (source.get(allTags[left]) == 0) 
                    source.remove(allTags[left]);
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
        
    }

    public int getMinimumStringArray2(String[] tagList, String[] allTags) {
        // Write your code here
        
        if (allTags == null || allTags.length == 0)
            return -1;
            
        if (tagList == null || tagList.length == 0)
            return 0;
        
        Set<String> set = new HashSet<String>();
        for (String tag : tagList)
            set.add(tag);
        
        Map<String, Integer> source = new HashMap<String, Integer>(); 
        
        int left = 0, right = 0; 
        
        int res = Integer.MAX_VALUE;
        
        for (right = 0; right < allTags.length; right++) {
            
            if (!set.contains(allTags[right]))
                continue;
            
            source.put(allTags[right], source.getOrDefault(allTags[right], 0) + 1);
            
            while (left < right && source.size() == set.size()) {
                
                if (source.size() == set.size())
                    res = Math.min(right - left + 1, res);
                
                if (set.contains(allTags[left])) {
                    source.put(allTags[left], source.get(allTags[left]) - 1);
                    if (source.get(allTags[left]) == 0)
                        source.remove(allTags[left]);
                }
                
                left++;
            }
            
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
        
    }
}