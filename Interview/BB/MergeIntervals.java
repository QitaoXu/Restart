package Interview.BB;

import java.util.*; 

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> results = new ArrayList<>(); 
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] a, int[] b) {
                
                if (a[0] != b[0])
                    return a[0] - b[0];
                
                return a[1] - b[1];
            }
        }); 
        
        int[] last = null;
        
        for (int[] interval : intervals) {
            
            if (last == null || last[1] < interval[0]) {
                
                results.add(interval);
                last = interval;
                
            }
            
            else {
                
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        
        return results.toArray(new int[results.size()][]);
        
    }
}