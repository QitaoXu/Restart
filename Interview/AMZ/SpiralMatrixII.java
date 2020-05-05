package Interview.AMZ; 

public class SpiralMatrixII {
    /**
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        // write your code here
        
        int[][] res = new int[n][n];
        
        if (n == 0)
            return res;
        
        int num = 1;
        
        int direc = 0;
        int left = 0, right = n - 1, up = 0, down = n - 1;
        
        while (true) {
            
            if (direc == 0) {
                
                for (int i = left; i <= right; i++) {
                    res[up][i] = num;
                    num++;
                }
                
                up += 1;
            }
            
            if (direc == 1) {
                
                for (int i = up; i <= down; i++) {
                    res[i][right] = num;
                    num++;
                }
                
                right -= 1;
            }
            
            if (direc == 2) {
                for (int i = right; i >= left; i--) {
                    res[down][i] = num;
                    num++;
                }
                
                down -= 1;
            }
            
            if (direc == 3) {
                for (int i = down; i >= up; i--) {
                    res[i][left] = num;
                    num++;
                }
                
                left += 1;
            }
            
            if (down < up || left > right)
                return res;
            
            direc = (direc + 1) % 4;
            
        }
        
    }
}