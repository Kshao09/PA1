public class Node{
    public int data;
    public Node next;
    @Override
    public String toString() {
        return data + "";
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(int data) {
        this.data = data;
    }
}
