package Interview.FB;
import java.util.*; 

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<Integer>();
        
        for (int num : nums1)
            set.add(num);
        
        Set<Integer> resSet = new HashSet<Integer>(); 
        
        for (int num : nums2) {
            
            if (!set.contains(num))
                continue;
            
            else {
                if (resSet.contains(num))
                    continue;
                resSet.add(num);
            }
        }
        
        int[] res = new int[resSet.size()];
        
        int i = 0;
        
        for (int num : resSet) {
            
            res[i++] = num;
        } 
        
        return res;
        
    }
}