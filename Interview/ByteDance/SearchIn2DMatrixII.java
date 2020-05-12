package Interview.ByteDance; 

public class SearchIn2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0)
            return false;
        
        if (matrix[0] == null || matrix[0].length == 0)
            return false; 
        
        int m = matrix.length, n = matrix[0].length;
        
        int x = m - 1, y = 0; 
        
        while (x >= 0 && y < n) {
            
            if (matrix[x][y] < target) {
                y++;
            }
            
            else if (matrix[x][y] > target) {
                x--;
            }
            
            else 
                return true;
        }
        
        return false;
    }
}