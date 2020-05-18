package Interview.ByteDance; 

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0, visited, memo);
        
    }
    
    private boolean dfs(char[] s,
                        int i, 
                        char[] p, 
                        int j, 
                        boolean[][] visited, 
                        boolean[][] memo) {
        
        if (j == p.length) {
            return i == s.length;
        }
        
        if (i == s.length) {
            for (int index = j; index < p.length; index++) {
                if (p[index] != '*')
                    return false;
            }
            
            return true;
        }
        
        if (visited[i][j] == true)
            return memo[i][j];
        
        boolean isMatched = false;
        
        if (p[j] != '*') {
            
            isMatched = isMatchChar(s[i], p[j]) && dfs(s, i + 1, p, j + 1, visited, memo);
        }
        
        else {
            
            isMatched = dfs(s, i + 1, p, j, visited, memo) || dfs(s, i, p, j + 1, visited, memo);
        }
        
        visited[i][j] = true;
        memo[i][j] = isMatched;
        return isMatched;
    }
    
    private boolean isMatchChar(char s, char p) {
        return s == p || p == '?';
    }
}