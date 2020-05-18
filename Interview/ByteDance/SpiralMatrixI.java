package Interview.ByteDance; 
import java.util.*; 

public class SpiralMatrixI {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> results = new ArrayList<>(); 
        
        if (matrix == null || matrix.length == 0)
            return results; 
        
        int dir = 0; 
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1; 
        
        while (up <= down && left <= right) {
            
            if (dir == 0) {
                
                for (int j = left; j <= right; j++) {
                    results.add(matrix[up][j]);
                }
                up++;
            }
            
            else if (dir == 1) {
                
                for (int i = up; i <= down; i++) {
                    results.add(matrix[i][right]);
                } 
                
                right--;
            }
            
            else if (dir == 2) {
                
                for (int j = right; j >= left; j--) {
                    results.add(matrix[down][j]);
                }
                
                down--;
            }
            
            else {
                for (int i = down; i >= up; i--) {
                    results.add(matrix[i][left]);
                }
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
        
        return results;
        
    }
}