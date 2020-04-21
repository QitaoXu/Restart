from collections import deque
DIRECTIONS = [(1, 2), (1, -2), (-1, 2), (-1, -2), (2, 1), (2, -1), (-2, 1), (-2, -1)]

class Solution:
    """
    @param grid: a chessboard included 0 (false) and 1 (true)
    @param source: a point
    @param destination: a point
    @return: the shortest path 
    """
    def shortestPath(self, grid, source, destination):
        # write your code here
        
        source = (source.x, source.y)
        end = (destination.x, destination.y)
        
        queue = deque()
        queue.append(source)
        distance = {}
        distance[source] = 0 
        
        while len(queue) > 0:
            
            size = len(queue)
            
            for _ in range(size):
                
                x, y = queue.popleft()
                
                if (x, y) == end:
                    
                    return distance[end]
                
                for dx, dy in DIRECTIONS:
                    nx = x + dx
                    ny = y + dy 
                    
                    if nx < 0 or nx >= len(grid) or ny < 0 or ny >= len(grid[0]) or grid[nx][ny] == 1:
                        continue
                    
                    if (nx, ny) in distance:
                        continue
                    
                    queue.append((nx, ny))
                    distance[(nx, ny)] = distance[(x, y)] + 1
                    
        return -1