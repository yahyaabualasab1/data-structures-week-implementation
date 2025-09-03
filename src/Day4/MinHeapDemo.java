package Day4;

import java.util.Arrays;

class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int cap) {
        capacity = cap;
        heap = new int[capacity];
        size = 0;
    }

    // swap helper
    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // insert عنصر جديد
    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = val;
        int current = size;
        size++;

        // heapify up
        while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    // extract min (جذر الـ heap)
    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    // heapify down
    private void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < size && heap[left] < heap[smallest])
            smallest = left;
        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // طباعة عناصر الـ heap كمصفوفة
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }
}

// ===================== MAIN =====================
public class MinHeapDemo {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);

        // إدخال عناصر
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(22);
        heap.insert(9);

        System.out.println(" Min Heap:");
        heap.printHeap();

        System.out.println("\n Extract Min: " + heap.extractMin());
        System.out.println(" Heap after extracting min:");
        heap.printHeap();

        System.out.println("\n Insert 3:");
        heap.insert(3);
        heap.printHeap();
    }
}
