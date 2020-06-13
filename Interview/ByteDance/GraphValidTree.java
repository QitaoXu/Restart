package Interview.ByteDance;

import java.util.*; 

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        
        if (edges.length != n - 1)
            return false;
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            
            uf.union(edge[0], edge[1]);
        }
        
        return uf.count == 1;
    }

    class UnionFind {
    
        int count; 
        Map<Integer, Integer> father;
        
        public UnionFind(int n) {
            this.count = n;
            this.father = new HashMap<Integer, Integer>(); 
            
            for (int node = 0; node < n; node++) {
                this.father.put(node, node);
            }
        }
        
        public void union(int a, int b) {
            
            int aFather = this.find(a);
            int bFather = this.find(b);
            
            if (aFather == bFather)
                return;
            
            this.father.put(bFather, aFather);
            this.count--;
        }
        
        public int find(int point) {
            
            List<Integer> path = new ArrayList<Integer>(); 
            
            while (this.father.get(point) != point) {
                
                path.add(point);
                point = this.father.get(point);
            }
            
            for (int p : path) {
                this.father.put(p, point);
            }
            
            return point;
        }
    }
    
    
    
}