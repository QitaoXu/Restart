package Interview.ByteDance; 

public class MyStack {

    int[] stack; 
    int bottom; 
    int top; 
    int capacity;

    public MyStack(int capacity) {
        this.stack = new int[capacity];
        this.bottom = 0; 
        this.top = 0; 
        this.capacity = capacity;
    }

    public boolean isEmpty() {

        return top == bottom;
    }

    public boolean isFull() {
        return top == capacity;
    }

    public Integer peek() {
        if (isEmpty())
            return null;

        return stack[top - 1];
    }

    public void push(int val) {

        if (isFull())
            return;

        stack[top++] = val;
    }

    public Integer pop() {
        if (isEmpty())
            return null; 

        int res = stack[top - 1];
        top--;
        return res;
    }

    public void printStack() {
        for (int num : stack) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
}