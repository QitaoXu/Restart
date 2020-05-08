package Interview.ByteDance;

public class SquareArray {
    /**
     * @param A: The array A.
     * @return: The array of the squares.
     */
    public int[] squareArray(int[] A) {
        // 
        
        int[] res = new int[A.length];
        
        int i = 0, j = A.length - 1; 
        
        while (i <= j) {
            
            int a = A[i] * A[i];
            int b = A[j] * A[j];
            
            res[j - i] = Math.max(a, b);
            
            if (a > b)
                i++;
                
            else 
                j--;
        }
        
        return res;
    }
}