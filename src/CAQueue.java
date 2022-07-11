import java.util.*;
public class CAQueue{
    private int front, rear, size;
    private int[] circularArray;
    public CAQueue(int capacity){
        circularArray = new int[capacity];
        front = rear = size = 0;
    }
    public boolean enqueue(int value){
        if(size == circularArray.length)
            return false;//queue is full
        size++;
        circularArray[rear++] = value;
        if(rear == circularArray.length)
            rear = 0;
        return true;//success
    }
    public int dequeue(){
        if(size == 0)
            throw new NoSuchElementException();
        size--;
        int returnValue = circularArray[front++];
        if(front == circularArray.length)
            front = 0;
        return returnValue;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == circularArray.length;
    }
    public int getSize() {
        return circularArray.length;
    }
    public int getValue(){
        int value = 0;
        for (int i = 0; i < circularArray.length; i++) {
            value = circularArray[i];
        }
        return value;
    }
}
