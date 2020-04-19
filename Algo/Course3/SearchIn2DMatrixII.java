package Algo.Course3; 

public class SearchIn2DMatrixII {

    public int searchIn2DMatrixII(int[][] matrix, int target) {
        // write your code here
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length, n = matrix[0].length; 
        int x = m - 1, y = 0; 
        int count = 0; 
        
        while (x >= 0 && y <= n - 1) {
            
            if (matrix[x][y] < target) {
                y++;
            }
            
            else if (matrix[x][y] > target) {
                x--;
            }
            
            else {
                count++;
                y++;
                x--;
            }
        }
        
        return count;
    }
}