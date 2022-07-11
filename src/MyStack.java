import java.util.*;
public class MyStack{
    private int top;
    private int[] content;
    public MyStack(int capacity){
        content = new int[capacity];
        top = 0;
    }
    public int pop(){
        if(top == 0)
            throw new NoSuchElementException();
        return content[--top];
    }
    public boolean push(int value){
        if(top == content.length)
            return false;
        content[top++] = value;
        return true;
    }
    public int peek(){
        if(top == 0)
            throw new NoSuchElementException();
        return content[top-1];
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return top == 0;
    }
}
