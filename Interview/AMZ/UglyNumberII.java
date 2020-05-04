package Interview.AMZ;

import java.util.*; 


public class UglyNumberII {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); 
        Set<Long> set = new HashSet<Long>();
        minHeap.offer(1L); 
        set.add(1L);
        
        int[] times = {2, 3, 5};
        
        for (int i = 0; i < n - 1; i++) {
            
            long num = minHeap.poll();
            
            for (int time : times) {
                
                if (set.contains(time * num))
                    continue;
                    
                minHeap.offer(time * num);
                set.add(time * num);
            }
            
        }
        
        return minHeap.peek().intValue();
    }
}