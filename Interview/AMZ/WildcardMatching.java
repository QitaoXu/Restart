package Interview.AMZ;

public class WildcardMatching {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        
        if (s == null || p == null)
            return false;
            
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    
    private boolean isMatchHelper(String s, 
                                  int i, 
                                  String p, 
                                  int j, 
                                  boolean[][] memo, 
                                  boolean[][] visited) {
        
        if (j == p.length()) 
            return i == s.length();
            
        if (i == s.length()) {
            
            for (int index = j; index < p.length(); index++) {
                
                if (p.charAt(index) != '*')
                    return false;
            }
            
            return true;
        }
        
        if (visited[i][j] == true)
            return memo[i][j];
            
        boolean isMatched = false;
            
        if (p.charAt(j) != '*') {
            
            isMatched = isMatchChar(s.charAt(i), p.charAt(j)) && isMatchHelper(s, i + 1, p, j + 1, memo, visited);
            
        }
        
        else {
            
            isMatched = isMatchHelper(s, i, p, j + 1, memo, visited) || isMatchHelper(s, i + 1, p, j, memo, visited);
        }
        
        visited[i][j] = true;
        memo[i][j] = isMatched;
        
        return isMatched;
        
    }
    
    private boolean isMatchChar(char s, char p) {
        
        return s == p || p == '?';
    }
}