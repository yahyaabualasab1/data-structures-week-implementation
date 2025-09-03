package Day4;
import java.util.*;

class Graph {
    private int V; // عدد الرؤوس (Vertices)
    private LinkedList<Integer>[] adjList; // قائمة الجوار لكل رأس

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // إضافة edge بين رأسين (مباشر)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        // لو كان غير موجه، أضف السطر التالي:
        // adjList[dest].add(src);
    }

    // طباعة الـ Graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // DFS (Depth-First Search)
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS starting from vertex " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // BFS (Breadth-First Search)
    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        System.out.print("BFS starting from vertex " + start + ": ");

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int neighbor : adjList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}


public class GraphDemo {
    public static void main(String[] args) {
        Graph g = new Graph(5); // 5  0,1,2,3,4

        // إضافة الحواف
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println(" Graph adjacency list:");
        g.printGraph();

        System.out.println();
        g.DFS(0); // تجربة DFS من الرأس 0
        g.BFS(0); // تجربة BFS من الرأس 0
    }
}
