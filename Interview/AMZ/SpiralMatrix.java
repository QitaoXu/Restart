package Interview.AMZ;
import java.util.*; 

public class SpiralMatrix {
    /**
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // write your code here
        
        if (matrix == null || matrix.length == 0)
            return new ArrayList<Integer>();
        
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int direc = 0; 
        
        List<Integer> res = new ArrayList<>();
        
        while (true) {
            
            if (direc == 0) {
                
                for (int i = left; i <= right; i++) {
                    res.add(matrix[up][i]);
                }
                
                up += 1;
            }
            
            if (direc == 1) {
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                
                right -= 1;
            }
            
            if (direc == 2) {
                
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
                
                down -= 1;
            }
            
            if (direc == 3) {
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                
                left += 1;
            }
            
            if (left > right || down < up)
                return res;
                
            direc = (direc + 1) % 4;
        }
    }
}