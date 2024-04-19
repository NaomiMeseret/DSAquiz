public class CircularQueue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public CircularQueue(int size) {
        maxSize = size + 1; // One extra space to differentiate between full and empty
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize; // Wrap around rear pointer
        queueArray[rear] = value;
        nItems++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue");
            return -1;
        }
        int temp = queueArray[front];
        front = (front + 1) % maxSize; // Wrap around front pointer
        nItems--;
        return temp;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot peek");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize - 1); // maxSize - 1 to differentiate between full and empty
    }

    public int size() {
        return nItems;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.enqueue(60); // This will print "Queue is full, cannot enqueue 60"

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        queue.enqueue(60);

        System.out.println("Size of the queue: " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        queue.dequeue(); // This will print "Queue is empty, cannot dequeue"
    }
}
