package Interview.AMZ;

import java.util.*; 

public class TopKLargestNumbers {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        
        for (int num : nums) {
            
            minHeap.offer(num); 
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] res = new int[k]; 
        int i = k - 1;
        
        while (!minHeap.isEmpty()) {
            
            res[i--] = minHeap.poll();
        }
        
        return res;
    }
}