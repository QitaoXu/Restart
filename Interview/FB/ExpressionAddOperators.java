package Interview.FB;
import java.util.*; 

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        
        int startIndex = 0;
        String curtExp = "";
        List<String> results = new ArrayList<String>();
        long sum = 0;
        long lastFactor = 0;
        
        if (num == null || num.length() == 0)
            return results;
        
        dfs(num, startIndex, curtExp, sum, lastFactor, (long)target, results);
        
        return results;
        
    }
    
    private void dfs(String num, 
                     int startIndex, 
                     String curtExp,
                     long sum, 
                     long lastFactor, 
                     long target, 
                     List<String> results) {
        
        if (startIndex == num.length()) {
            if (sum == target)
                results.add(curtExp);
            return;
        }
        
        for (int i = startIndex + 1; i < num.length() + 1; i++) {
            
            long prefixNum = Long.parseLong(num.substring(startIndex, i));
            
            if (startIndex == 0) 
                dfs(num, i, curtExp + Long.toString(prefixNum), prefixNum, prefixNum, target, results);
            else {
                dfs(num, i, curtExp + "+" + Long.toString(prefixNum), sum + prefixNum, prefixNum, target, results);
                dfs(num, i, curtExp + "-" + Long.toString(prefixNum), sum - prefixNum, -prefixNum, target, results);
                dfs(num, i, curtExp + "*" + Long.toString(prefixNum), sum - lastFactor + lastFactor * prefixNum, lastFactor * prefixNum, target, results);
            }
            
            if (prefixNum == 0)
                break;
        }
    }
}