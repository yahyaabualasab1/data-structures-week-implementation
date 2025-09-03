package Day2;

public class DoublyLinkedList<T> {

    // Node class
    private static class DNode<T> {
        T data;
        DNode<T> prev, next;

        DNode(T value) {
            data = value;
            prev = next = null;
        }
    }

    private DNode<T> header, trailer;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        header = new DNode<>(null); // sentinel node
        trailer = new DNode<>(null); // sentinel node
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    public DNode<T> getHeader() {
        return header;
    }

    public void setHeader(DNode<T> header) {
        this.header = header;
    }

    public DNode<T> getTrailer() {
        return trailer;
    }

    public void setTrailer(DNode<T> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return header.next == trailer;
    }

    // Return size
    public int size() {
        return size;
    }

    // Add element to front
    public void addFront(T item) {
        DNode<T> newNode = new DNode<>(item);
        newNode.next = header.next;
        newNode.prev = header;
        header.next.prev = newNode;
        header.next = newNode;
        size++;
    }

    // Add element to back
    public void addBack(T item) {
        DNode<T> newNode = new DNode<>(item);
        newNode.next = trailer;
        newNode.prev = trailer.prev;
        trailer.prev.next = newNode;
        trailer.prev = newNode;
        size++;
    }

    // Remove front
    public boolean removeFront() {
        if (isEmpty()) return false;
        DNode<T> p = header.next;
        header.next = p.next;
        p.next.prev = header;
        size--;
        return true;
    }

    // Find node by value
    private DNode<T> find(T item) {
        if (isEmpty()) return null;
        DNode<T> p = header.next;
        while (p != trailer && !p.data.equals(item)) {
            p = p.next;
        }
        return (p == trailer) ? null : p;
    }

    // Remove node by value
    public boolean remove(T item) {
        DNode<T> p = find(item);
        if (p == null) return false;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        return true;
    }

    // Get front value
    public T front() {
        return isEmpty() ? null : header.next.data;
    }

    // Get back value
    public T back() {
        return isEmpty() ? null : trailer.prev.data;
    }

    // Print list in reverse
    public void printInReverse() {
        if (isEmpty()) return;
        DNode<T> p = trailer.prev;
        while (p != header) {
            System.out.print(p.data + "\t");
            p = p.prev;
        }
        System.out.println();
    }

    // Display list from front to back
    public void display() {
        DNode<T> p = header.next;
        while (p != trailer) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.println("NULL");
    }

    // Example main
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addBack(10);
        list.addBack(20);
        list.addFront(5);
        list.display(); // 5 -> 10 -> 20 -> NULL

        list.remove(10);
        list.display(); // 5 -> 20 -> NULL

        list.printInReverse(); // 20    5
        System.out.println("Front: " + list.front()); // 5
        System.out.println("Back: " + list.back());   // 20
    }
}
