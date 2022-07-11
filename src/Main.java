/**
 * Kenny Shao
 * Professor: Kianoosh Boroojeni
 * This program has several methods that remove the largest values from the linked list and compares 2 queues and contrasts their time complexity.
 */
public class Main {
    // This method finds the values greater than the max number and removes them from the list.
    public static void removeValuesLargerThanMax(SinglyLinkedList list, int max){
        Node cur = list.head;
        Node prev = null;
        while(cur != null){
            System.out.println("current node is " + cur);
            if(cur.data == 7) {
                System.out.println("removing " + cur.data);
                prev.next = cur.next;
                cur = cur.next;
                continue;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new
                SinglyLinkedList(
                new Node(5,
                        new Node(6,
                                new Node(7,
                                        new Node(8))))
        );
        System.out.println(list);
        removeValuesLargerThanMax(list, 13);
        System.out.println(list);

        System.out.println("------------------------------------------");

        bobsLastPen(5, 2);
        System.out.println("--------------------------------------------");
        scenario1();
        System.out.println("-------------------------------------------");
        scenario2();
    }
    // This method returns which pen that Bob ends up with on the last day after removing all the pens using a circular linked list
    public static int bobsLastPen(int numberOfPens, int k){
        int lastPen = 1;
        int i;
        SinglyLinkedList bobsPen = new SinglyLinkedList(new Node(1));
        Node lastNode = bobsPen.head;

        for (i = 2; i <= numberOfPens; i++) {
            lastNode.next = new Node(i);
            lastNode = lastNode.next;
        }

        Node curr = bobsPen.head;
        Node prev = null;
        while (curr != curr.next && curr.next != null) {

            if (curr == lastNode || curr == null) {
                curr = bobsPen.head;
            }
            if (lastPen % k == 0) {
                System.out.println("Curr " + curr);
                System.out.println("Prev " + prev);
                curr = prev;
                curr.next = curr.next.next;
                curr = curr.next;
                if (curr == null || curr == lastNode &&  curr.next == null) {
                    curr = bobsPen.head;
                }
                System.out.println("list" + bobsPen);
                lastPen++;
            } else {
                System.out.println("else " + curr);
                prev = curr;
                curr = curr.next;
                lastPen++;
                if (curr == null || curr == lastNode || curr.next == null) {
                    curr = bobsPen.head;
                }
            }
        }
        return (Integer.parseInt(String.valueOf(curr)));
    }
    // This method prints the time it took for both queues to run
    public static void scenario1() {
        System.out.println("Scenario 1 for CAQueue");
        for(int n: new int[]{20,50,100,1000,10000,100000,1000000}){
            CAQueue queue = new CAQueue(n);

            long startTime1 = System.nanoTime();
            for(int i = 0; i < n;i++)
                queue.enqueue(n+i);
                queue.dequeue();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime1;
            System.out.println(n + ", " + totalTime);
        }
        System.out.println();
        System.out.println("Scenario 1 for SSQueue");
        for(int n: new int[]{20,50,100,1000,10000,100000,1000000}){
            SSQueue queue = new SSQueue(n);

            long startTime2 = System.nanoTime();
            for(int i = 0; i < n;i++)
                queue.enqueue(n+i);
            queue.dequeue();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime2;
            System.out.println(n + ", " + totalTime);
        }
    }
    // This method outputs the times it took for both queues to run
    public static void scenario2() {
        System.out.println("Scenario 2 for CAQueue");
        for(int n: new int[]{20,50,100,1000,10000,100000,1000000}){
            SSQueue queue = new SSQueue(n);

            long startTime1 = System.nanoTime();
            for(int i = 0; i < n;i++)
                queue.enqueue(i);
            for(int i = 0;i < n;i++)
                if(Math.random()<.5)
                    queue.enqueue(n+i);
                else
                    queue.dequeue();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime1;
            System.out.println(n + ", " + totalTime);
        }
        System.out.println();
        System.out.println("Scenario 2 for SSQueue");
        for(int n: new int[]{20,50,100,1000,10000,100000,1000000}){
            SSQueue queue = new SSQueue(n);

            long startTime2 = System.nanoTime();
            for(int i = 0; i < n;i++)
                queue.enqueue(i);
            for(int i = 0;i < n;i++)
                if(Math.random()<.5)
                    queue.enqueue(n+i);
                else
                    queue.dequeue();
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime2;
            System.out.println(n + ", " + totalTime);
        }
    }

}
