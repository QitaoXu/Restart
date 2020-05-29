package Interview.MS;

import java.util.*; 

public class RemoveComments {
    public List<String> removeComments(String[] source) {
        
        boolean inBlock = false;
        List<String> res = new ArrayList<>();
        
        StringBuilder newLine = new StringBuilder(); 
        
        for (String line : source) {
            
            if (!inBlock)
                newLine = new StringBuilder();
            int i = 0; 
            
            while (i < line.length()) {
                
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    
                    inBlock = true;
                    i++;
                }
                
                else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlock = false;
                    i++;
                }
                
                else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                }
                
                else if (!inBlock) {
                    newLine.append(line.charAt(i));
                }
                
                i++;
            }
            
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
            }
        }
        
        return res;
    }
}