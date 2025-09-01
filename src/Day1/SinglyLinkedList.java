package Day1;

// Day 1
// 2. Singly LinkedList
public class SinglyLinkedList<T> {

    // Node class
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T value) {
            data = value;
            next = null;
        }
    }

    private Node<T> head;
    private int size;

    // Constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }

    // Get size
    public int size() {
        return size;
    }

    // Add to front
    public void addFront(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    // Add to back
    public void addBack(T value) {
        Node<T> node = new Node<>(value);
        if (isEmpty()) {
            head = node;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    // Remove from front
    public boolean removeFront() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }

    // Remove from back
    public boolean removeBack() {
        if (isEmpty()) return false;
        if (head.next == null) {
            head = null;
            size--;
            return true;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
        return true;
    }

    // Get front value
    public T getFront() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return head.data;
    }

    // Get back value
    public T getBack() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Node<T> temp = head;
        while (temp.next != null) temp = temp.next;
        return temp.data;
    }

    // Display list
    public void display() {
        Node<T> temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Insert before a given node
    public void insertBefore(Node<T> node, T value) {
        if (node == head) {
            addFront(value);
            return;
        }
        Node<T> temp = head;
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }
        if (temp.next == null) return; // node not found
        Node<T> newNode = new Node<>(value);
        newNode.next = node;
        temp.next = newNode;
        size++;
    }

    // Insert after a given node
    public void insertAfter(Node<T> node, T value) {
        if (node == null) return;
        Node<T> newNode = new Node<>(value);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    // Main for testing
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFront(20);
        list.addBack(80);
        list.addBack(90);
        list.display(); // 20 -> 80 ->90 ->  NULL

        System.out.println("Front: " + list.getFront()); // Front: 20
        System.out.println("Back: " + list.getBack());  // Back: 90

        list.removeFront();
        list.display(); //List: 80 -> 90 -> NULL

        list.addBack(55);
        list.display();// List: 80 -> 90 -> 55 -> NULL


        list.removeBack();
        list.display();// List: 80 -> 90 -> NULL


        // Insert before second node
        list.insertBefore(list.head.next, 11);
        list.display();// List: 80 -> 11 -> 90 -> NULL


        // Insert after second node
        list.insertAfter(list.head.next, 44);
        list.display(); // List: 80 -> 11 -> 44 -> 90 -> NULL

    }
}