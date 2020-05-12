package Interview.ByteDance;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1; 
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            int x = mid / n;
            int y = mid % n; 
            
            if (matrix[x][y] < target) {
                start = mid;
            }
            
            else if (matrix[x][y] == target)
                return true;
            
            else {
                end = mid;
            }
        }
        
        if (matrix[start / n][start % n] == target)
            return true;
        
        if (matrix[end / n][end % n] == target)
            return true;
        
        return false;
    }
}