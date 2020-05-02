package Interview.AMZ; 

import java.util.*; 

public class NumberOfIslandsII {
    class UnionFind {
    
        int count; 
        Map<Integer, Integer> father; 
        
        public UnionFind() {
            
            this.count = 0; 
            this.father = new HashMap<Integer, Integer>();
            
        }
        
        public void union(int a, int b) {
            
            int rootA = this.find(a);
            int rootB = this.find(b); 
            
            if (rootA == rootB)
                return;
            
            this.father.put(rootB, rootA);
            count--;
        }
        
        public int find(int point) {
        
            List<Integer> path = new ArrayList<Integer>(); 
            
            while (point != this.father.get(point)) {
                
                path.add(point); 
                point = this.father.get(point);
            }
            
            for (int p : path) {
                this.father.put(p, point);
            }
            
            return point;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        UnionFind uf = new UnionFind();
        
        List<Integer> results = new ArrayList<Integer>(); 
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Set<Integer> islands = new HashSet<Integer>();
        
        for (int[] pos : positions) {
            
            int x = pos[0];
            int y = pos[1]; 
            
            if (islands.contains(getPoint(x, y, n))) {
                results.add(uf.count);
                continue;
            }
            
            islands.add(getPoint(x, y, n));
            uf.father.put(getPoint(x, y, n), getPoint(x, y, n));
            uf.count++;
            
            for (int i = 0; i < 4; i++) {
                
                int nx = x + dx[i];
                int ny = y + dy[i]; 
                
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue; 
                
                if (islands.contains(getPoint(nx, ny, n)))
                    uf.union(getPoint(x, y, n), getPoint(nx, ny, n));
            }
            
            results.add(uf.count);
            
        }
        
        return results;
    }
    
    private int getPoint(int x, int y, int n) {
        return x * n + y;
    }
}