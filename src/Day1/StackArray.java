package Day1;// Day 1
// 3. b.  Stack Array

public class StackArray<T> {

    private T[] st;       // Array  لتخزين العناصر
    private int t;        // مؤشر القمة
    private int capacity; // arrayالسعة القصوى لل

    // Constructor

    public StackArray(int cap) {
        capacity = cap;
        t = -1;
        st = (T[]) new Object[capacity]; // إنشاء مصفوفة Generic
    }

    public T[] getSt() {
        return st;
    }

    public void setSt(T[] st) {
        this.st = st;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return t < 0;
    }

    // Return the size of the stack
    public int size() {
        return t + 1;
    }

    // Return the top element
    public T peek() {
        if (isEmpty()) return null; // أو throw exception
        return st[t];
    }

    // Push element onto stack
    public void push(T item) {
        if (t + 1 >= capacity) return; // تجنب تجاوز السعة
        t++;
        st[t] = item;
    }

    // Pop element from stack
    public void pop() {
        if (isEmpty()) return;
        t--;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        StackArray<Integer> s = new StackArray<>(6);

        for (int i : a)
            s.push(i);

        while (!s.isEmpty()) {
            System.out.print(s.peek() + "    ");
            s.pop();
        }
        // Output: 6    5    4    3    2    1
    }
}