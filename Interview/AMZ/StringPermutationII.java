package Interview.AMZ; 

import java.util.*; 

public class StringPermutationII {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        
        List<String> results = new ArrayList<String>();
        
        if (str == null) {
            return results;
        }
        
        char[] sa = str.toCharArray();
        Arrays.sort(sa);
        
        str = new String(sa);
        
        StringBuilder sb = new StringBuilder(); 
        boolean[] visited = new boolean[sa.length];
        
        dfs(str, sb, results, visited);
        
        return results;
    }
    
    private void dfs(String str, 
                     StringBuilder sb, 
                     List<String> results, 
                     boolean[] visited) {
        
        if (sb.length() == str.length()) {
            
            results.add(sb.toString());
            
            return;
        }      
        
        for (int i = 0; i < str.length(); i++) {
            
            if (visited[i] == true)
                continue;
            
            if (i > 0 && str.charAt(i) == str.charAt(i - 1) && visited[i - 1] == false)
                continue;
                
            visited[i] = true;
            sb.append(str.charAt(i));
            
            dfs(str, sb, results, visited);
            
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        
    }
}