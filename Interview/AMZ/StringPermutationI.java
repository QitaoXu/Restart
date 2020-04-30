package Interview.AMZ;
import java.util.*; 

public class StringPermutationI {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        
        HashMap<Character, Integer> sourceHash = getHash(A);
        HashMap<Character, Integer> targetHash = getHash(B);
        
        return sourceHash.equals(targetHash);
    }
    
    private HashMap<Character, Integer> getHash(String s) {
        
        HashMap<Character, Integer> hash = new HashMap<>(); 
        
        if (s == null || s.length() == 0) 
            return hash;
            
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        
        return hash;
    }
}