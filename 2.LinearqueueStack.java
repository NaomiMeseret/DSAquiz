import java.util.Stack;

class LinearQueue {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public LinearQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
        System.out.println("Enqueued item: " + item);
    }

    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue item.");
                return -1;
            }

            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        int item = dequeueStack.pop();
        System.out.println("Dequeued item: " + item);
        return item;
    }

    public int peek() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                System.out.println("Queue is empty. Cannot peek item.");
                return -1;
            }

            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();

        System.out.println("Front item: " + queue.peek());
    }
}
