package Interview.AMZ;
import java.util.*;

class Cell {
    
    int x;
    int y;
    int height; 
    
    public Cell(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

class CellComparator implements Comparator<Cell> {
    @Override 
    public int compare(Cell c1, Cell c2) {
        return c1.height - c2.height;
    }
}

public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(new CellComparator());
        boolean[][] visited = new boolean[m][n]; 
        
        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j])); 
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0])); 
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        
        int water = 0; 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!minHeap.isEmpty()) {
            
            Cell cell = minHeap.poll(); 
            
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
                    continue;
                
                visited[nx][ny] = true;
                water += Math.max(cell.height - heightMap[nx][ny], 0);
                minHeap.offer(new Cell(nx, ny, Math.max(cell.height, heightMap[nx][ny])));
            }
        }
        
        return water;
        
    }
}