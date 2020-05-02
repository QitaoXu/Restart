package Interview.AMZ;
import java.util.*;

public class NumberOfDistinctIslandsII {
    
    class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    List<Point> island = new ArrayList<>();
                    bfs(grid, i, j, island);
                    res.add(getUnique(island));
                }
            }
        }
        
        return res.size();
    }
    
    private void bfs(int[][]grid, int x, int y, List<Point> island) {
         
         int m = grid.length, n = grid[0].length;
         
         Queue<Point> queue = new LinkedList<Point>();
         Set<Point> set = new HashSet<Point>(); 
         
         queue.offer(new Point(x, y));
         set.add(new Point(x, y));
         grid[x][y] = 0; 
         
         int[] dx = {-1, 1, 0, 0};
         int[] dy = {0, 0, -1, 1};
         
         while (!queue.isEmpty()) {
             
             Point point = queue.poll();
             island.add(point);
             int cx = point.x;
             int cy = point.y;
             
             for (int i = 0; i < 4; i++) {
                 
                 int nx = cx + dx[i];
                 int ny = cy + dy[i]; 
                 Point neighbor = new Point(nx, ny);
                 
                 if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0)
                     continue;
                 
                 if (set.contains(neighbor))
                     continue;
                 
                 queue.offer(neighbor);
                 set.add(neighbor);
                 grid[nx][ny] = 0;
             }
         }
        
    }
    
    private String getUnique(List<Point> island) {
        List<String> sameIslands = new ArrayList<>();
        
        int[][] trans={{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        
        for (int i = 0; i < 4; ++i) {
            List<Point> l1 = new ArrayList<>(), l2 = new ArrayList<>();
            
            for (Point point : island) {
                int x = point.x, y = point.y;
                l1.add(new Point(x * trans[i][0], y * trans[i][1]));
                l2.add(new Point(y * trans[i][0], x * trans[i][1]));
            }
            sameIslands.add(getStr(l1));
            sameIslands.add(getStr(l2));
        }
        
        Collections.sort(sameIslands);
        return sameIslands.get(0);
    }
    
    private String getStr(List<Point> island) {
        
        Collections.sort(island, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                }
                return a.y - b.y;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        int x = island.get(0).x, y = island.get(0).y;
        
        for (Point point : island) {
            sb.append((point.x - x) + " " + (point.y - y) + " ");
        }
        return sb.toString();
    }
}