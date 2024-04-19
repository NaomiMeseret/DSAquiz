public class LinearQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;

    public LinearQueue(int size) {
        maxSize = size;
        front = -1;
        rear = -1;
        queue = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue item.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        queue[rear] = item;
        System.out.println("Enqueued item: " + item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue item.");
            return -1;
        }

        int item = queue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        System.out.println("Dequeued item: " + item);
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek item.");
            return -1;
        }

        return queue[front];
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();

        System.out.println("Front item: " + queue.peek());
    }
}
