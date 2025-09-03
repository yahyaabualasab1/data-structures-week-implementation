package Day2;
public class CircularLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    private Node<T> tail; // pointer to last node
    private int size;

    // Constructor
    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return size
    public int size() {
        return size;
    }

    // Add element at the end
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail; // points to itself
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove element from front
    public T remove() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        }

        Node<T> head = tail.next;
        T value = head.data;

        if (tail == head) { // only one element
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return value;
    }

    // Peek front
    public T peek() {
        if (isEmpty()) return null;
        return tail.next.data;
    }

    // Display list
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular List is empty!");
            return;
        }
        Node<T> current = tail.next;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println("(back to head)");
    }

    // Example main
    public static void main(String[] args) {
        CircularLinkedList<Integer> cl = new CircularLinkedList<>();
        cl.add(10);
        cl.add(20);
        cl.add(30);
        cl.display(); // 10 -> 20 -> 30 -> (back to head)
        System.out.println("Removed: " + cl.remove()); // 10
        cl.display(); // 20 -> 30 -> (back to head)
        System.out.println("Peek front: " + cl.peek()); // 20

    }
}
