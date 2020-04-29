package Interview.AMZ;
import java.util.*; 

public class MergeKSortedIntervals {

    class Interval {
        int start; 
        int end; 

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Item implements Comparable<Item> {
    
        Interval interval;
        int index; 
        int order;
        
        public Item (Interval interval, int index, int order) {
            this.interval = interval;
            this.index = index;
            this.order = order;
        }
        
        @Override
        public int compareTo(Item that) {
            if (this.interval.start != that.interval.start)
                return this.interval.start - that.interval.start;
                
            else if (this.interval.end != that.interval.end) 
                return this.interval.end - that.interval.end;
                
            else 
                return this.index - that.index;
        }
    }

    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        // write your code here
        
        if (intervals == null || intervals.size() == 0)
            return null;
        
        mergeByHeap(intervals);
        return mergeHelper(intervals, 0, intervals.size() - 1);
    }
    
    private List<Interval> mergeByHeap(List<List<Interval>> intervals) {
        PriorityQueue<Item> queue = new PriorityQueue<Item>();
        
        for (int i = 0; i < intervals.size(); i++) {
            
            if (intervals.get(i) == null || intervals.get(i).size() == 0) 
                continue; 
                
            queue.offer(new Item(intervals.get(i).get(0), i, 0));
        }
        
        List<Interval> results = new ArrayList<Interval>(); 
        Interval last = null;
        
        while (!queue.isEmpty()) {
            
            Item item = queue.poll();
            
            if (last == null || last.end < item.interval.start) {
                results.add(item.interval);
                last = item.interval;
            }
            
            else {
                last.end = Math.max(last.end, item.interval.end);
            }
            
            if (item.order == intervals.get(item.index).size() - 1)
                continue;
                
            queue.offer(new Item(intervals.get(item.index).get(item.order + 1), item.index, item.order + 1));
        }
        
        return results;
    }

    private List<Interval> mergeHelper(List<List<Interval>> intervals, int start, int end) {
        
        if (start >= end) 
            return intervals.get(start);
            
        int mid = start + (end - start) / 2; 
        
        List<Interval> intervals1 = mergeHelper(intervals, start, mid);
        List<Interval> intervals2 = mergeHelper(intervals, mid + 1, end);
        
        return mergeTwoIntervalLists(intervals1, intervals2);
    }
    
    private List<Interval> mergeTwoIntervalLists(List<Interval> intervals1, List<Interval> intervals2) {
        
        List<Interval> intervals = new ArrayList<Interval>();
        
        int i = 0, j = 0; 
        
        Interval last = null;
        
        while (i < intervals1.size() && j < intervals2.size()) {
            
            if (isLeftIntervalSmaller(intervals1.get(i), intervals2.get(j))) {
                
                mergeTwoIntervals(last, intervals1.get(i), intervals);
                last = intervals.get(intervals.size() - 1);
                i++;
            }
            
            else {
                mergeTwoIntervals(last, intervals2.get(j), intervals);
                last = intervals.get(intervals.size() - 1);
                j++;
            }
            
        }
        
        while (i < intervals1.size()) {
            mergeTwoIntervals(last, intervals1.get(i), intervals);
            last = intervals.get(intervals.size() - 1);
            i++;
        }
        
        while (j < intervals2.size()) {
            mergeTwoIntervals(last, intervals2.get(j), intervals);
            last = intervals.get(intervals.size() - 1);
            j++;
        }
        
        return intervals;
        
        
    }
    
    private void mergeTwoIntervals(Interval last, Interval curt, List<Interval> intervals) {
        
        if (last == null || last.end < curt.start) {
            intervals.add(curt);
            last = curt;
        }
        
        else {
            last.end = Math.max(last.end, curt.end);
        }
    }
    
    private boolean isLeftIntervalSmaller(Interval a, Interval b) {
        
        if (a.start != b.start) 
            return a.start < b.start;
            
        return a.end < b.end;
    }
}