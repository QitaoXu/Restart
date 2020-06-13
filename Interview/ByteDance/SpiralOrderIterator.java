package Interview.ByteDance;

public class SpiralOrderIterator {
    
    int up;
    int down;
    int left;
    int right;
    int dir;
    int x;
    int y;
    int[][] matrix;
    
    public SpiralOrderIterator(int[][] matrix) {
        
        this.up = 0;
        this.down = matrix.length - 1;
        this.left = 0;
        this.right = matrix[0].length - 1;
        this.dir = 0;
        this.x = this.up;
        this.y = this.left;
        this.matrix = matrix;
    }
    
    public boolean hasNext() {
        
        return this.up <= this.down && this.left <= this.right;
    }
    
    public int next() {
        
        int res = this.matrix[this.x][this.y];
        
        if (this.dir == 0) {
            
            if (this.y < this.right)
                this.y += 1;
            else {
                this.up++;
                this.x = this.up;
                this.y = this.right;
                this.dir = (this.dir + 1) % 4;
            }
            
            
        }
        
        else if (this.dir == 1) {
            
            if (this.x < this.down) {
                this.x += 1;
            }
            
            else {
                
                this.right--;
                this.x = this.down;
                this.y = this.right;
                this.dir = (this.dir + 1) % 4;
            }
            
            
        }
        
        else if (this.dir == 2) {
            
            if (this.y > this.left) {
                
                this.y -= 1;
            }
            
            else {
                
                this.down--;
                this.x = this.down;
                this.y = this.left;
                this.dir = (this.dir + 1) % 4;
            }
            
            
        }
        
        else if (this.dir == 3) {
            
            if (this.x > this.up) {
                this.x -= 1;
            }
            
            else {
                
                this.left++;
                this.x = this.up;
                this.y = this.left;
                this.dir = (this.dir + 1) % 4;
            }
            
            
        }
        
        return res;
    
    }
}