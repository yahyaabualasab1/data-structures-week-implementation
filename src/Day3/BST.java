package Day3;

public class BST<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left, right, parent;

        Node(T data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }

    private Node root;
    private int n;

    public BST() {
        root = null;
        n = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return n;
    }

    public boolean isLeaf(Node p) {
        return p != null && p.left == null && p.right == null;
    }

    public boolean hasUniChild(Node p) {
        return p != null && ((p.left != null && p.right == null) || (p.left == null && p.right != null));
    }

    public boolean isRoot(Node p) {
        return p != null && p.parent == null;
    }

    public Node getParent(Node p) {
        if (p == null || isRoot(p)) return null;
        return p.parent;
    }

    public T getSibling(Node p) {
        if (p == null || isRoot(p)) return null;
        if (p.parent.left == p && p.parent.right != null) return p.parent.right.data;
        if (p.parent.right == p && p.parent.left != null) return p.parent.left.data;
        return null;
    }

    public void insert(T key) {
        Node newNode = new Node(key);
        if (isEmpty()) {
            root = newNode;
            n++;
            return;
        }

        Node cur = root, prev = null;
        while (cur != null) {
            prev = cur;
            if (key.compareTo(cur.data) > 0) cur = cur.right;
            else cur = cur.left;
        }

        if (key.compareTo(prev.data) > 0) prev.right = newNode;
        else prev.left = newNode;

        newNode.parent = prev;
        n++;
    }

    public Node find(T key) {
        Node cur = root;
        while (cur != null && !cur.data.equals(key)) {
            if (key.compareTo(cur.data) > 0) cur = cur.right;
            else cur = cur.left;
        }
        return cur;
    }

    private void printLNR(Node p) {
        if (p == null) return;
        printLNR(p.left);
        System.out.print(p.data + " ");
        printLNR(p.right);
    }

    public void printAsc() {
        printLNR(root);
        System.out.println();
    }

    private void printRNL(Node p) {
        if (p == null) return;
        printRNL(p.right);
        System.out.print(p.data + " ");
        printRNL(p.left);
    }

    public void printDesc() {
        printRNL(root);
        System.out.println();
    }

    public boolean remove(T key) {
        Node p = find(key);
        if (p == null) return false;

        // Case 1: Leaf node
        if (isLeaf(p)) {
            if (p.parent.left == p) p.parent.left = null;
            else p.parent.right = null;
            n--;
            return true;
        }

        // Case 2: Uni-child
        if (hasUniChild(p)) {
            Node child = (p.left != null) ? p.left : p.right;
            if (p.parent.left == p) p.parent.left = child;
            else p.parent.right = child;
            child.parent = p.parent;
            n--;
            return true;
        }

        // Case 3: Two children
        Node succ = getSuccessor(p);
        if (succ != null) {
            p.data = succ.data;
            if (isLeaf(succ)) {
                if (succ.parent.left == succ) succ.parent.left = null;
                else succ.parent.right = null;
            } else { // successor has uni-child (right only)
                Node child = succ.right;
                if (succ.parent.left == succ) succ.parent.left = child;
                else succ.parent.right = child;
                if (child != null) child.parent = succ.parent;
            }
            n--;
            return true;
        }
        return false;
    }

    private Node getSuccessor(Node p) {
        if (p == null || p.right == null) return null;
        Node s = p.right;
        while (s.left != null) s = s.left;
        return s;
    }

    // Test the BST
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Ascending: ");
        bst.printAsc();

        System.out.print("Descending: ");
        bst.printDesc();

        System.out.println("Remove 20: " + bst.remove(20));
        bst.printAsc();

        System.out.println("Remove 30: " + bst.remove(30));
        bst.printAsc();

        System.out.println("Remove 50: " + bst.remove(50));
        bst.printAsc();
    }
}
