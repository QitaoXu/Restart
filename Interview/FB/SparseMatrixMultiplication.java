package Interview.FB;
import java.util.*; 

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int n = A.length; 
        int m = B[0].length; 
        int t = A[0].length; 
        int[][] C = new int[n][m];
        
        List<List<Integer>> cols = new ArrayList<List<Integer>>(); 
        
        for (int i = 0; i < t; i++) {
            cols.add(new ArrayList<Integer>());
            for (int j = 0; j < m; j++) {
                
                if (B[i][j] != 0) 
                    cols.get(i).add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < t; k++) {
                
                if (A[i][k] == 0)
                    continue;
                
                for (int j : cols.get(k)) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
            
        }
        
        return C;
    }
}