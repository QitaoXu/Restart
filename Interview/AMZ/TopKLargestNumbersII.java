package Interview.AMZ; 

import java.util.*;

public class TopKLargestNumbersII {
    
    PriorityQueue<Integer> minHeap;
    int k;
    /*
    * @param k: An integer
    */public TopKLargestNumbersII(int k) {
        // do intialization if necessary
        this.minHeap = new PriorityQueue<Integer>();
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        
        List<Integer> res = new ArrayList<Integer>();
        
        while (!minHeap.isEmpty()) {
            
            res.add(minHeap.poll());
        }
        
        for (int num : res) {
            minHeap.offer(num);
        }
        
        int start = 0, end = minHeap.size() - 1; 
        
        while (start < end) {
            
            int temp = res.get(start);
            res.set(start, res.get(end));
            res.set(end, temp);
            
            start++;
            end--;
        }
        
        return res;
    }
}