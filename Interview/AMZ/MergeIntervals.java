package Interview.AMZ;
import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> results = new ArrayList<int[]>(); 
        
        int[] last = null; 
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] != interval2[0] ? interval1[0] - interval2[0] : interval1[1] - interval2[1];
            }
        });
        
        for (int[] interval : intervals) {
            
            if (last == null || last[1] < interval[0]) {
                results.add(interval);
                last = interval;
            }
            
            else {
                last[1] = Math.max(interval[1], last[1]);
            }
            
        }
        
        return results.toArray(new int[results.size()][]);
    }
}