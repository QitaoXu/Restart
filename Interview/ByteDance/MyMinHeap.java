package Interview.ByteDance;

import java.util.*; 

public class MyMinHeap {

    int[] nodes; 
    int size; 

    public MyMinHeap(int capacity) {

        this.nodes = new int[capacity];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        this.size = 0;
    }

    public boolean isFull() {
        return this.size == nodes.length;
    }

    public void add(int val) {

        if (isFull())
            return; 

        nodes[size] = val; 
        size += 1;
        siftUp(size - 1);
    }

    public void siftUp(int index) {

        while (index > 0) {

            int parentIndex = (index - 1) / 2;

            if (nodes[parentIndex] <= nodes[index])
                break;

            int temp = nodes[index];
            nodes[index] = nodes[parentIndex];
            nodes[parentIndex] = temp; 

            index = parentIndex;
        }
    }

    public Integer peek() {

        if (isEmpty()) {
            return null;
        }

        return nodes[0];
    }

    public Integer poll() {

        if (isEmpty()) {
            return null;
        }

        int min = nodes[0]; 

        nodes[0] = nodes[size - 1]; 
        nodes[size - 1] = Integer.MAX_VALUE;
        size--;
        siftDown(0);
        return min;
    }

    public void siftDown(int index) {

        while (index * 2 + 1 < size) {

            int sonIndex = index * 2 + 1; 

            if (index * 2 + 2 < size && nodes[index * 2 + 2] < nodes[sonIndex]) {
                sonIndex = index * 2 + 2;
            }

            if (nodes[sonIndex] >= nodes[index]) {
                break;
            }

            int temp = nodes[index];
            nodes[index] = nodes[sonIndex]; 
            nodes[sonIndex] = temp;

            index = sonIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printMinHeap() {
        StringBuilder sb = new StringBuilder();
        for (int num : nodes) {
            sb.append(num + " ");
        }

        System.out.println(sb.toString());
    }
 

}