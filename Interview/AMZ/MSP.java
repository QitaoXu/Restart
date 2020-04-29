package Interview.AMZ;
import java.util.*; 

public class MSP {

    class Connection {
        String city1; 
        String city2; 
        int cost; 

        public Connection (String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2; 
            this.cost = cost;
        }
    }
    
    class UnionFind {
        
        int count; 
        Map<String, String> father; 
        
        public UnionFind() {
            this.count = 0; 
            this.father = new HashMap<String, String>();
        }
        
        public boolean union(String a, String b) {
            
            String rootA = this.find(a);
            String rootB = this.find(b); 
            
            if (rootA.equals(rootB))
                return false;
                
            this.father.put(rootB, rootA);
            this.count -= 1;
            return true;
        }
        
        public String find(String point) {
            
            List<String> path = new ArrayList<String>(); 
            
            while (this.father.get(point) != point) {
                
                String p = this.father.get(point);
                path.add(p);
                point = p;
            }
            
            for (String p : path) {
                this.father.put(p, point);
            }
            
            return point;
        }
        
    }
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        
        List<Connection> results = new ArrayList<Connection>();
        
        if (connections == null || connections.size() == 0) 
            return results;
            
        Collections.sort(connections, new Comparator<Connection> () {
            
            @Override
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost)
                    return a.cost - b.cost; 
                    
                else if (!a.city1.equals(b.city1)) 
                    return a.city1.compareTo(b.city1);
                
                else 
                    return a.city2.compareTo(b.city2);
            }
        });
        
        UnionFind uf = new UnionFind();
        
        for (Connection connection : connections) {
            
            if (!uf.father.containsKey(connection.city1)) {
                uf.father.put(connection.city1, connection.city1);
                uf.count += 1;
            }
            
            if (!uf.father.containsKey(connection.city2)) {
                uf.father.put(connection.city2, connection.city2);
                uf.count += 1;
            }
        }
        
        for (Connection connection : connections) {
            
            if (uf.union(connection.city1, connection.city2))
                results.add(connection);
        }
        
        return uf.count == 1 ? results : new ArrayList<Connection>();
    }
}