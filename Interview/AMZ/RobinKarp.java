package Interview.AMZ; 

public class RobinKarp {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
        // write your code here
        
        if (source == null || target == null)
            return -1; 
            
        if (target.length() == 0)
            return 0; 
            
        char[] sc = source.toCharArray();
        char[] tc = target.toCharArray(); 
        
        int BASE = 1000000;
        int targetCode = 0; 
        
        for (int i = 0; i < tc.length; i++) {
            targetCode = (targetCode * 31 + (tc[i] - 'a')) % BASE;
        }
        
        int power = 1; 
        
        for (int i = 0; i < tc.length; i++) {
            power = (power * 31) % BASE;
        }
        
        int hashCode = 0; 
        
        for (int i = 0; i < sc.length; i++) {
            
            hashCode = (hashCode * 31 + sc[i] - 'a') % BASE;
            
            if (i < tc.length)
                continue;
                
            else {
                hashCode = (hashCode - (sc[i - tc.length] - 'a') * power) % BASE;
                
                if (hashCode < 0) 
                    hashCode += BASE;
                    
                if (hashCode == targetCode) {
                    
                    if (source.substring(i - tc.length + 1, i + 1).equals(target))
                        return i - tc.length + 1;
                }
            }
        }
        
        return -1;
    } 
}