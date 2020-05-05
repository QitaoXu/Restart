package Interview.AMZ; 
import java.util.*;

public class SparseMatrixMultiplication {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        
        List<List<Integer>> cols = new ArrayList<>(); 
        
        for (int k = 0; k < B.length; k++) {
            
            List<Integer> col = new ArrayList<Integer>();
            for (int j = 0; j < B[0].length; j++) {
                
                if (B[k][j] != 0) {
                    col.add(j);
                }
            }
            
            cols.add(col);
        }
        
        int[][] C = new int[A.length][B[0].length];
        
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                
                if (A[i][k] == 0) {
                    continue;
                }
                
                for (int j : cols.get(k)) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }
}