package Interview.AMZ;

import java.util.*; 

public class MedianOfSlidingWindow {
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        }); 
        
        List<Double> res = new ArrayList<Double>(); 
        
        for (int i = 0; i < nums.length; i++) {
            
            if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            }
            else {
                minHeap.offer(nums[i]);
            }
            
            balance(maxHeap, minHeap);
            
            if (i >= k) {
                
                if (nums[i - k] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k]);
                } 
                
                else {
                    minHeap.remove(nums[i - k]);
                }
                
                balance(maxHeap, minHeap);
            }
            
            if (i >= k - 1) {
                if (k % 2 == 1)
                    res.add(maxHeap.peek() / 1.0);
                else {
                    res.add(maxHeap.peek() / 2.0 + minHeap.peek() / 2.0);
                }
            }
            
        }
        
        double[] ans = new double[res.size()]; 
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
    
    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        
        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
}