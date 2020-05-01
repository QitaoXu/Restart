package Interview.AMZ;

import java.util.*; 

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        
        int rowMedian = rows.get(rows.size() / 2);
        int colMedian = cols.get(cols.size() / 2);
        
        return minDistance1D(rows, rowMedian) + minDistance1D(cols, colMedian);
    }
    
    private int minDistance1D(List<Integer> points, int origin) {
        int distance = 0; 
        
        for (int point : points) {
            distance += Math.abs(point - origin);
        }
        
        return distance;
    }
    
    private List<Integer> collectRows(int[][] grid) {
        List<Integer> rows = new ArrayList<Integer>(); 
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (grid[i][j] == 1)
                    rows.add(i);
            }
        }
        
        return rows;
    }
    
    private List<Integer> collectCols(int[][] grid) {
        List<Integer> cols = new ArrayList<Integer>(); 
        
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                
                if (grid[i][j] == 1)
                    cols.add(j);
            }
        }
        
        return cols;
    }
}