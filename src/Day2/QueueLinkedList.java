package Day2;
public class QueueLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    private Node<T> front, rear;
    private int size;

    public QueueLinkedList() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Enqueue
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T item = front.data;
        front = front.next;
        if (front == null) rear = null; // list became empty
        size--;
        return item;
    }

    // Peek
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return front.data;
    }

    // Display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node<T> temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main example
    public static void main(String[] args) {
        QueueLinkedList<Integer> q = new QueueLinkedList<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30
        System.out.println("Dequeued: " + q.dequeue());
        q.display(); //  20  30
        System.out.println("Peek: " + q.peek()); // 20
    }
}

