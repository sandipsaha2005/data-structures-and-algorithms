import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    static int idx = 0;

    public static Node buildTree(int nodes[]) {
        if (idx >= nodes.length || nodes[idx] == -1) {
            idx++;  // Increment index even if we return null
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        idx++;
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
    public static void preOrder(Node root){

        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void inOrder(Node root){

        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){

        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);

        int h=Math.max(lh,rh)+1;
        return h;
    }
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int lc=count(root.left);
        int rc=count(root.right);
        int treeNodes=lc+rc+1;
        return treeNodes;
    }
    public static int sum(Node root){
        if(root==null){
            return 0;
        }
        int ls=sum(root.left);
        int rs=sum(root.right);
        int s=ls+rs+root.data;
        return s;
    }

}

public class Bin {
    public static void main(String args[]) {
//        int arr[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
//        Node root = bt.buildTree(arr);
//        bt.preOrder(root);
//        System.out.println();
//        bt.inOrder(root);
//        System.out.println();
//        bt.postOrder(root);
//        System.out.println();
//        bt.levelOrder(root);
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);
//        System.out.println(bt.height(root));
//        System.out.println(bt.count(root));
        System.out.println(bt.sum(root));
    }

}
