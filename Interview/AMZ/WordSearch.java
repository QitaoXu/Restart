package Interview.AMZ;
import java.util.*;
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length; 
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (dfs(board, word, 0, i, j, visited)) {
                    printVisited(visited);
                    return true;
                }
            }
        }
        printVisited(visited);
        return false;
    }
    
    private void printVisited(boolean[][] visited) {
        List<List<Boolean>> visitedList = new ArrayList<List<Boolean>>();
        for (int i = 0; i < visited.length; i++) {
            List<Boolean> row = new ArrayList<Boolean>();
            for (int j = 0; j < visited[0].length; j++) {
                row.add(visited[i][j]);
            }
            visitedList.add(row);
        }
        
        System.out.println(visitedList);
            
    }
    
    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        
        if (index == word.length())
            return true; 
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y])
            return false;
        
        if (word.charAt(index) != board[x][y])
            return false;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0}; 
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (dfs(board, word, index + 1, nx, ny, visited)) {
                return true;
            }
               
        }
        visited[x][y] = false;
        return false;
    }
}