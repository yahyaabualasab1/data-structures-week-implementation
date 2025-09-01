package Day1;// Day 1
// 3. a.  Stack LinkedList

public class StackLinkedList<T> {

    // Node class
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    private Node<T> top; // القمة
    private int size;    // عدد العناصر

    // Constructor
    public StackLinkedList() {
        top = null;
        size = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Return size of stack
    public int size() {
        return size;
    }

    // Push element onto stack
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        size++;
    }

    // Pop element from stack
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    // Peek at top element without removing
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    // Display stack
    public void display() {
        Node<T> temp = top;
        System.out.print("Stack (top -> bottom): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method for testing
    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // Stack (top -> bottom): 30 -> 20 -> 10 -> NULL

        System.out.println("Top element: " + stack.peek()); // 30

        stack.pop();
        stack.display(); // Stack (top -> bottom): 20 -> 10 -> NULL

        System.out.println("Stack size: " + stack.size()); // 2
    }
}