package Interview.ByteDance;

public class XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int[] prefixXOR = new int[arr.length + 1]; 
        
        for (int i = 0; i < arr.length; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        
        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            
            res[i] = prefixXOR[queries[i][1] + 1] ^ prefixXOR[queries[i][0]];
        }
        
        return res;
    }
}