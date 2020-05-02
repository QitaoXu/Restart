package Interview.AMZ;

public class RotateFunction {
    /**
     * @param A: an array
     * @return: the maximum value of F(0), F(1), ..., F(n-1)
     */
    public int maxRotateFunction(int[] A) {
        // Write your code here
        
        int n = A.length; 
        
        int sum = 0;
        int f = 0; 
        
        for (int i = 0; i < n; i++) {
            
            sum += A[i];
            f += i * A[i];
        }
        
        int res = f;
        
        for (int i = 1; i < n; i++) {
            
            f = f + sum - n * A[n - i];
            res = Math.max(res, f);
        }
        
        return res;
    }
}