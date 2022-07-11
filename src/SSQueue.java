import java.util.*;
public class SSQueue{
    private MyStack s1, s2;
    public SSQueue(int capacity){
        s1 = new MyStack(capacity);
        s2 = new MyStack(capacity);
    }
    public boolean isEmpty(){
        return s1.size() + s2.size() == 0;
    }
    public int size(){
        return s1.size()+ s2.size();
    }
    public boolean enqueue(int value){
        return s2.push(value);
    }
    public int dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(s1.isEmpty())
            while(!s2.isEmpty())
                s1.push(s2.pop());
        return s1.pop();
    }
}
