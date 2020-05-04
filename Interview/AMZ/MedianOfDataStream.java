package Interview.AMZ;
import java.util.*;

public class MedianOfDataStream {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int numOfElements;

    /** initialize your data structure here. */
    public MedianOfDataStream() {
        
        this.minHeap = new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
        
        this.numOfElements = 0;
    }
    
    public void addNum(int num) {
        
        if (maxHeap.size() == 0 || num <= maxHeap.peek())
            maxHeap.offer(num);
        
        else
            minHeap.offer(num);
        balance();
        
        numOfElements++;
        
    }
    
    private void balance() {
        
        while (maxHeap.size() < minHeap.size()) {
            
            maxHeap.offer(minHeap.poll());
        }
        
        while (minHeap.size() < maxHeap.size() - 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        
        return numOfElements % 2 == 1 ? maxHeap.peek() / 1.0 : maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        
    }
}