package Algo.Course3; 

public class SearchIn2DMatrixI {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length; 
        
        int start = 0, end = m * n - 1;
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2; 
            
            int x = mid / n; 
            int y = mid % n; 
            
            if (matrix[x][y] < target) {
                start = mid;
            }
            
            else if (matrix[x][y] == target) {
                return true;
            }
            
            else {
                end = mid;
            }
        }
        
        if (matrix[start / n][start % n] == target) {
            return true;
        }
        
        if (matrix[end / n][end % n] == target) {
            return true;
        }
        
        return false;
    }
}