package Interview.ByteDance;

import java.util.*; 

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        
        Map<Integer, List<int[]>> rowToServers = new HashMap<>();
        Map<Integer, List<int[]>> colToServers = new HashMap<>(); 
        Set<int[]> servers = new HashSet<>(); 
        
        int m = grid.length, n = grid[0].length; 
        
        for (int i = 0; i < m; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (grid[i][j] == 1) {
                    
                    int[] server = {i, j};
                    
                    if (!rowToServers.containsKey(i))
                        rowToServers.put(i, new ArrayList<int[]>());
                    
                    rowToServers.get(i).add(server);
                    
                    if (!colToServers.containsKey(j)) 
                        colToServers.put(j, new ArrayList<int[]>());
                    
                    colToServers.get(j).add(server);
                    
                    servers.add(server);
                }
            }
        }
        
        int count = 0; 
        
        for (int[] server : servers) {
            
            int row = server[0];
            int col = server[1]; 
            
            if (rowToServers.get(row).size() == 1 && 
                colToServers.get(col).size() == 1)
                count++;
        }
        
        return servers.size() - count;
    }
}