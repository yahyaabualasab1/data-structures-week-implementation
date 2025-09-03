package Day2;
public class QueueArray<T> {

    private T[] arr;
    private int front, rear, size, capacity;

    public QueueArray(int cap) {
        capacity = cap;
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    // Enqueue
    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = item;
        size++;
    }

    // Dequeue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T item = arr[front];
        front = (front + 1) % capacity; // circular increment
        size--;
        return item;
    }

    // Peek
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return arr[front];
    }

    // Display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    // Main example
    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray<>(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display(); // Queue: 10 20 30
        System.out.println("Dequeued: " + q.dequeue());
        q.display(); // Queue: 20 30
        System.out.println("Peek: " + q.peek()); // 20
    }
}
