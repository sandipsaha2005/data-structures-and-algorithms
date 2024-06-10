public class AVL {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1; // Initialize height to 1 for a new node
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    private static Node getLeft(Node x) {
        if (x == null) {
            return null;
        }
        Node y = x.right;
        Node t2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = t2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private static Node getRight(Node y) {
        if (y == null) {
            return null;
        }
        Node x = y.left;
        Node t2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = t2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else if (root.data < key) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        // Update height of current node
        root.height = 1 + max(height(root.left), height(root.right));

        // Get balance factor
        int bf = getBalanceFactor(root);

        // Perform rotations if necessary
        // Left Left Case
        if (bf > 1 && key < root.left.data) {
            return getRight(root);
        }
        // Right Right Case
        if (bf < -1 && key > root.right.data) {
            return getLeft(root);
        }
        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = getLeft(root.left);
            return getRight(root);
        }
        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = getRight(root.right);
            return getLeft(root);
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        preOrder(root);
    }
}
