package Interview.MS;

import java.util.*; 

public class MaxLengthOfCancatenatedStringWithUniqueChars {

    public int maxLength(List<String> arr) {
        
        int total = 1 << arr.size(), res = 0; 
        
        for (int i = 1; i < total; i++) {
            
            Set<Character> set = new HashSet<Character>();
            int curtLength = 0; 
            
            for (int j = 0; j < arr.size(); j++) {
                
                boolean dupExists = false;
                
                if (((1 << j) & i) > 0) {
                    
                    if (curtLength + arr.get(j).length() > 26)
                        continue; 
                    
                    for (int k = 0; k < arr.get(j).length(); k++) {
                        
                        if (set.contains(arr.get(j).charAt(k))) {
                            
                            dupExists = true;
                            break;
                        }
                        
                        set.add(arr.get(j).charAt(k));
                    }
                    
                    if (!dupExists) {
                        
                        res = Math.max(res, curtLength + arr.get(j).length());
                        curtLength += arr.get(j).length();
                    }
                    
                    if (res == 26)
                        return res;
                }
            }
        }
        
        return res;
    }
}