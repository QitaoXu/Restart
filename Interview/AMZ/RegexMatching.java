package Interview.AMZ;

public class RegexMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        
        if (s == null || p == null)
            return false;
        
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, int i, String p, int j, boolean[][] memo, boolean[][] visited) {
        
        if (j == p.length()) {       
            return i == s.length();	
        }
        
        if (i == s.length()) {		
            return isEmpty(p.substring(j, p.length()));
        }
        
        if (visited[i][j] == true)
            return memo[i][j];
            
        boolean isMatch = false;
            
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            
            isMatch = isMatchChar(s.charAt(i), p.charAt(j)) && isMatchHelper(s, i + 1, p, j, memo, visited) 
                        || isMatchHelper(s, i, p, j + 2, memo, visited);
        }
        
        else {
            
            isMatch = isMatchChar(s.charAt(i), p.charAt(j)) && isMatchHelper(s, i + 1, p, j + 1, memo, visited);
        }
        
        visited[i][j] = true;
        memo[i][j] = isMatch;
        
        return isMatch;
            
    } 
    
    private boolean isMatchChar(char s, char p) {
        
        return s == p || p == '.';
    }
    
    private boolean isEmpty(String p) {
        
        if (p.length() % 2 == 1)
            return false; 
            
        for (int i = 0; i < p.length() / 2; i++) {
            
            if (p.charAt(2 * i + 1) != '*')
                return false;
        }
        
        return true;
    }
    
    
}