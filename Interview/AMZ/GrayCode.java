package Interview.AMZ;

import java.util.*; 

public class GrayCode {
    /**
     * @param n: a number
     * @return: Gray code
     */
    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>(); 
        
        for (int i = 0; i < (1 << n); i++) {
            
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}