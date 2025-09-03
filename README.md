# data-structures-week-implementation
# Day 1 - Data Structures Implementations

## Implementations

### 1. Dynamic Array
- **File:** `DynamicArray.java`
- **Description:** A resizable array that grows dynamically when capacity is reached.
- **Operations:** `add`, `get`, `set`, `remove`, `size`
- **Time Complexity:**
    - Access: O(1)
    - Insert: Amortized O(1)
    - Delete: O(n)
- **Usage Example:```java
  DynamicArray arr = new DynamicArray();
  arr.add(10);
  arr.add(20);
  System.out.println(arr.get(0)); // 10**
### 2. Singly Linked List
File: SinglyLinkedList.java
Description: A list where each node points to the next node.
Operations: insertFront, insertEnd, delete, search, display
Time Complexity:
Insert/Delete at front: O(1)
Search: O(n)
Usage Example:
SinglyLinkedList list = new SinglyLinkedList();
list.insertEnd(10);
list.insertEnd(20);
list.display(); // 10 -> 20 -> NULL
### 3. Stack (Array-based)
File: StackArray.java
Description: Stack implementation using an array.
Operations: push, pop, peek, isEmpty
Time Complexity: All operations O(1)
Usage Example:
StackArray s = new StackArray(5);
s.push(10);
s.push(20);
System.out.println(s.pop()); // 20
### 4. Stack (Linked List-based)
File: StackLinkedList.java
Description: Stack implemented using linked list (LIFO).
Operations: push, pop, peek, isEmpty
Time Complexity: All operations O(1)
Usage Example:
StackLinkedList s = new StackLinkedList();
s.push(10);
s.push(20);
System.out.println(s.pop()); // 20
# Day 2 -
## Implementations
### 1. Day 2: Data Structures Implementations
Implementations
# 1. Queue
  ##  1.1 Queue using Array
Description: A queue (FIFO) implemented using a fixed-size array. Supports enqueue, dequeue, peek, isEmpty, and display operations.
Operations: enqueue, dequeue, peek, isEmpty, display
Time Complexity:
Enqueue: O(1)
Dequeue: O(1)
Peek: O(1)
Usage Example:
QueueArray<Integer> q = new QueueArray<>(5);
q.enqueue(10);
q.enqueue(20);
q.enqueue(30);
q.display();            // Queue: 10 20 30
System.out.println(q.dequeue()); // 10
q.display();            // Queue: 20 30
# 1.2 Queue using Linked List
Description: A queue (FIFO) implemented using a linked list. Dynamic size, supports the same operations as array-based queue.
Operations: enqueue, dequeue, peek, isEmpty, display
Time Complexity:
Enqueue: O(1)
Dequeue: O(1)
Peek: O(1)
Usage Example:
QueueLinkedList<Integer> q = new QueueLinkedList<>();
q.enqueue(10);
q.enqueue(20);
q.enqueue(30);
q.display();            // Queue: 10 20 30
System.out.println(q.dequeue()); // 10
q.display();            // Queue: 20 30
### 2. Doubly Linked List
File: DoublyLinkedList.java
Description: A list where each node has prev and next pointers. Supports addFront, addBack, removeFront, removeBack, find, remove, and printInReverse.
Operations: addFront, addBack, removeFront, removeBack, find, remove, printInReverse
Time Complexity:
Add/Remove at front or back: O(1)
Find/Remove specific item: O(n)
Usage Example:
DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
list.addFront(10);
list.addBack(20);
list.addBack(30);
list.display();        // 10 -> 20 -> 30
list.printInReverse(); // 30 -> 20 -> 10
### 3. Circular Linked List
File: CircularLinkedList.java
Description: A list where the last node points back to the first node, forming a circle. Supports add, remove, peek, and display.
Operations: add, remove, peek, display
Time Complexity:
Add/Remove: O(1)
Peek: O(1)
Usage Example:
CircularLinkedList<Integer> cl = new CircularLinkedList<>();
cl.add(10);
cl.add(20);
cl.display(); // 10 -> 20 -> (back to head)
System.out.println("Tail element: " + cl.tail.data);        
System.out.println("Tail.next (points to front): " + cl.tail.next.data); // 10
# Day4
## 1. Hash Table (with collision handling)
Description: List stores key-value pairs and handles collisions using Chaining, supports: put, get, remove, printTable.
كود المثال:
ht.put("Ali","12345"); ht.put("Sara","67890"); ht.put("Omar","11111"); ht.put("Zain","22222");
ht.printTable();
ht.get("Ali");
ht.remove("Omar");
ht.printTable();
Time Complexity:
put / get / remove → Avg O(1), Worst O(n)
## 2.  Min Heap
Description: Heap keeps the smallest element in the root, supports: insert, extractMin, peek, printHeap.
كود المثال:
heap.insert(20); heap.insert(5); heap.insert(15); heap.insert(22); heap.insert(9);
heap.printHeap();
heap.extractMin();
heap.printHeap();
heap.insert(3);
heap.printHeap();
Time Complexity:
insert / extractMin → O(log n)
peek → O(1)
## 3. Basic Graph (Adjacency List)
Description: Graph stores Vertices and Neighbors using Adjacency List, supports: addEdge, dfs, bfs, printGraph.
كود المثال:
g.addEdge(0,1); g.addEdge(0,4); g.addEdge(1,2); g.addEdge(1,3); g.addEdge(1,4);
g.addEdge(2,3); g.addEdge(3,4);
g.printGraph(); g.DFS(0); g.BFS(0);
Time Complexity:
addEdge → O(1)
dfs / bfs / printGraph → O(V + E)

