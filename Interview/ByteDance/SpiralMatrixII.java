package Interview.ByteDance;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        
        int dir = 0; 
        int[][] matrix = new int[n][n]; 
        
        int up = 0, down = n - 1, left = 0, right = n - 1; 
        
        int num = 1;
        
        while (true) {
            
            if (dir == 0) {
                
                for (int j = left; j <= right; j++) {
                    matrix[up][j] = num;
                    num++;
                }
                
                up++;
            }
            
            else if (dir == 1) {
                
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = num;
                    num++;
                }
                right--;
            }
            
            else if (dir == 2) {
                
                for (int j = right; j >= left; j--) {
                    
                    matrix[down][j] = num;
                    num++;
                }
                down--;
            }
            
            else {
                
                for (int i = down; i >= up; i--) {
                    
                    matrix[i][left] = num;
                    num++;
                }
                left++;
            }
            
            if (up > down || left > right)
                break;
            
            dir = (dir + 1) % 4;
        }
        
        return matrix;
        
    }
}