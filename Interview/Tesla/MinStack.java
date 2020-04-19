package Interview.Tesla;
import java.util.*; 

public class MinStack {
    
    Stack<Integer> numStack;
    Stack<Integer> minNumStack;

    /** initialize your data structure here. */
    public MinStack() {
        
        this.numStack = new Stack<Integer>();
        this.minNumStack = new Stack<Integer>();
        
    }
    
    public void push(int x) {
        
        if (numStack.size() == 0) {
            numStack.push(x);
            minNumStack.push(x);
        }
        
        else {
            numStack.push(x);
            minNumStack.push(Math.min(x, minNumStack.peek()));
        }
    }
    
    public void pop() {
        numStack.pop();
        minNumStack.pop();
    }
    
    public int top() {
        return numStack.peek();
    }
    
    public int getMin() {
        return minNumStack.peek();
    }
}
