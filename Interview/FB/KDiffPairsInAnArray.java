package Interview.FB;
import java.util.*;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        
        int count = 0;
        if (k < 0) {
            return count;
        }
        
        if (k == 0) {
            
            Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>(); 
            
            for (int num : nums) {
                numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
                if (numToCount.get(num) == 2) 
                    count++;
            }
        }
        
        else {
            
            Set<Integer> set = new HashSet<Integer>();
            
            for (int num : nums) {
                set.add(num);
            }
            
            for (int num : set) {
                if (set.contains(num + k)) {
                    count++;
                } 
            }
        }
        
        return count;
        
    }
}