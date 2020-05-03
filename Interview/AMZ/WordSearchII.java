package Interview.AMZ;
import java.util.*;

public class WordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        Trie trie = new Trie();
        Set<String> wordsSet = new HashSet<>(); 
        
        for (String word : words) {
            trie.insert(word);
            wordsSet.add(word);
        }
        
       Set<String> results = new HashSet<>();
        
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (!trie.startsWith(Character.toString(board[i][j])))
                    continue;
                
                boolean[][] visited = new boolean[m][n]; 
                StringBuilder sb = new StringBuilder();
                
                visited[i][j] = true;
                dfs(board, i, j, sb.append(board[i][j]), trie, wordsSet, visited, results);
            }
        }
        
        List<String> ans = new ArrayList<>(); 
        
        for (String word : results) {
            ans.add(word);
        }
        
        return ans;
    }
    
    private void dfs(char[][] board, 
                     int x, 
                     int y, 
                     StringBuilder sb, 
                     Trie trie,
                     Set<String> wordsSet, 
                     boolean[][] visited,
                     Set<String> results) {
        
        if (wordsSet.contains(sb.toString())) {
            results.add(sb.toString());
        }  
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0}; 
        
        int m = board.length, n = board[0].length;
        
        for (int index = 0; index < 4; index++) {
            
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] == true)
                continue;
            
            char c = board[nx][ny];
            
            if (!trie.startsWith(sb.toString() + Character.toString(c)))
                continue;
                
            sb.append(c);
            visited[nx][ny] = true;
            
            dfs(board, nx, ny, sb, trie, wordsSet, visited, results);
            
            visited[nx][ny] = false;
            sb.deleteCharAt(sb.length() - 1);
                
        }
    }
}