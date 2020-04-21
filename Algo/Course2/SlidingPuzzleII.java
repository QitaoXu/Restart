package Algo.Course2; 

import java.util.*; 

public class SlidingPuzzleII {

    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        
        String start = matrixToString(init_state);
        String end = matrixToString(final_state); 
        
        Queue<String> queue = new LinkedList<String>(); 
        Map<String, Integer> distance = new HashMap<String, Integer>(); 
        
        queue.offer(start);
        distance.put(start, 0); 
        
        while (!queue.isEmpty()) {
            
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) {
                
                String node = queue.poll();
                if (node.equals(end)) {
                    return distance.get(end);
                }
                
                for (String neighbor : getNeighbors(node)) {
                    if (distance.keySet().contains(neighbor)) 
                        continue;
                        
                    queue.offer(neighbor);
                    distance.put(neighbor, distance.get(node) + 1);
                }
                
            }
        }
        
        return -1;
    }
    
    private String matrixToString(int[][] matrix) {
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                
                sb.append(matrix[i][j]);
            }
        }
        
        return sb.toString();
    }
    
    private List<String> getNeighbors(String node) {
        
        List<String> neighbors = new ArrayList<String>();
        
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0}; 
        
        int zeroIndex = node.indexOf('0');
        int x = zeroIndex / 3; 
        int y = zeroIndex % 3; 
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i]; 
            
            if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3)
                continue;
            
            int newZeroIndex = nx * 3 + ny;
            char[] sa = node.toCharArray();
            
            sa[zeroIndex] = sa[newZeroIndex];
            sa[newZeroIndex] = '0';
            
            neighbors.add(new String(sa));
            
        }
        
        
        return neighbors;
        
    }
}