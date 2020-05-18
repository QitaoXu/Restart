package Interview.ByteDance;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        
        if (s == null || p == null)
            return false;
        
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
        
        
        if (j == p.length)
            return i == s.length;
        
        if (i == s.length) 
            return isEmpty(p, j);
        
        if (visited[i][j] == true)
            return memo[i][j];
        
        boolean isMatched = false;
        
        if (j + 1 < p.length && p[j + 1] == '*') {
            
            isMatched = dfs(s, i, p, j + 2, visited, memo) || 
                        isCharMatch(s[i], p[j]) && dfs(s, i + 1, p, j, visited, memo);
        }
        
        else {
            isMatched = isCharMatch(s[i], p[j]) && dfs(s, i + 1, p, j + 1, visited, memo);
        }
        
        visited[i][j] = true;
        memo[i][j] = isMatched;
        
        return isMatched;
    }
    
    private boolean isCharMatch(char s, char p) {
        return s == p || p == '.';
    }
    
    private boolean isEmpty(char[] p, int j) {
        
        int n = p.length - 1 - j + 1;
        if (n % 2 == 1)
            return false;
        
        for (int i = j; i + 1 < p.length; i += 2) {
            if (p[i + 1] != '*') {   
                return false;
            }
        }
        
        return true;
    }
}