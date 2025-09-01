package Day1;

public class DynamicArray {
    private int[] arr;       // underlying fixed-size array
    private int size;        // number of elements currently in array
    private int capacity;    // total capacity of the array

    // Constructor
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
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

    // Add element to the end
    public void add(int value) {
        if (size == capacity) {
            resize();
        }
        arr[size] = value;
        size++;
    }

    // Get element at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return arr[index];
    }

    // Remove last element
    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int value = arr[size - 1];
        size--;
        return value;
    }

    // Resize when array is full (double capacity)
    private void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Return current size
    public int size() {
        return size;
    }

    // Print all elements
    public void printArray() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // Main method for testing
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray(2);

        da.add(10);
        da.add(20);
        da.add(30); // triggers resize
        da.printArray();  // [ 10 20 30 ]

        System.out.println("Element at index 1: " + da.get(1)); // 20

        da.remove();
        da.printArray();  // [ 10 20 ]
    }
}