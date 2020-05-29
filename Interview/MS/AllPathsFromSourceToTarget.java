package Interview.MS;
import java.util.*; 

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); 
        boolean[] visited = new boolean[graph.length];
        
        path.add(0);
        visited[0] = true;
        dfs(graph, 0, graph.length - 1, path, paths, visited);
        
        return paths;
    }
    
    private void dfs(int[][] graph, 
                     int curt,
                     int target, 
                     List<Integer> path, 
                     List<List<Integer>> paths,
                     boolean[] visited) {
        
        if (curt == target) {
            paths.add(new ArrayList<Integer>(path));
            return;
        }

        for (int neighbor : graph[curt]) {
            
            if (visited[neighbor] == true)
                continue;
            
            visited[neighbor] = true;
            path.add(neighbor);
            
            dfs(graph, neighbor, target, path, paths, visited);
            
            path.remove(path.size() - 1);
            visited[neighbor] = false;
            
        }
        
    }
}