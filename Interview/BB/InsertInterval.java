package Interview.BB; 

import java.util.*; 

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> intervalList = new ArrayList<>(); 
        
        for (int[] interval : intervals) {
            intervalList.add(interval);
        }
        
        int index = 0; 
        
        while (index < intervalList.size() && intervalList.get(index)[0] < newInterval[0]) {
            index++;
        }
        
        intervalList.add(index, newInterval);
        
        int[] last = null; 
        List<int[]> results = new ArrayList<int[]>();
        
        for (int[] interval : intervalList) {
            
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