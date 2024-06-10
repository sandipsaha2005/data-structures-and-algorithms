import java.io.FilterOutputStream;
import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node (int data){
            this.data=data;
        }
    }

    public static Node insert(Node root, int value) {
        // If the tree is empty, create a new node and return it
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.data) {
            // If the value is less than the current node's value,
            // insert it into the left subtree recursively
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            // If the value is greater than the current node's value,
            // insert it into the right subtree recursively
            root.right = insert(root.right, value);
        }

        // Return the unchanged node pointer
        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root, int k){
        if(root==null){
            return false;
        }
        if(root.data==k){
            return true;
        }else if(root.data<k){
            return search(root.right,k);
        }else{
            return search(root.left,k);
        }
    }
    public static Node delete(Node root,int k){
        if(root==null){
            return null;
        }
        if(root.data<k){
            root.right=delete(root.right,k);
        }else if(root.data>k){
            root.left=delete(root.left,k);
        }else {
            // Case I   ( Leaf Node )
            if(root.left==null && root.right==null){
                return null;
            }

            // Case II ( One Child )
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            // Case III ( Root of a subtree )

            Node is=findInOrderSucc(root.right);
            root.data=is.data;
            root.right=delete(root.right,is.data);
        }
        return root;
    }
    public static Node findInOrderSucc(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void printInRange(Node root, int k1,int k2){
        if(root==null){
            return;
        }
        if(k1<=root.data && k2>=root.data){
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }else if(root.data>k2){
            printInRange(root.right,k1,k2);
        }else{
            printInRange(root.left,k1,k2);
        }
    }
    public static void printF(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"-");
        }
        System.out.println("null");
    }

    public static void rootToLeaf(Node root,ArrayList<Integer> path){

        if(root==null){
            return;
        }

        path.add(root.data);
        if(root.left==null && root.right==null){
            printF(path);
        }
        rootToLeaf(root.left,path);
        rootToLeaf(root.right,path);

        path.remove(path.size()-1);
    }
    public static boolean isValid(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min !=null && min.data >=root.data){
            return false;
        }else if(max !=null && max.data>=root.data){
            return false;
        }
        return isValid(root.left,min,root) && isValid(root.right,root,max);
    } // is not working proparly
    public static Node mirror(Node root){
        if(root==null){
            return null;
        }
        Node leftS=mirror(root.left);
        Node rightS=mirror(root.right);
        root.left=rightS;
        root.right=leftS;
        return root;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]){
//        int arr[]={1,2,3,4,5,9,7};
//        Node root=null;
//        for(int i=0;i<arr.length;i++){
//            root=insert(root,arr[i]);
//        }
//
//        inOrder(root);
//        System.out.println(search(root,6));
//        root=delete(root,4);
//        System.out.println();
//        inOrder(root);
//        printInRange(root,5,12);
//        rootToLeaf(root,new ArrayList<>());

        Node root=new Node(7);
        root.left=new Node(6);
        root.right=new Node(9);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(8);
        root.right.right=new Node(10);
//        inOrder(root);
        preOrder(root);
        System.out.println();
        mirror(root);
        preOrder(root);
//        inOrder(root);
//        System.out.println(isValid(root,null,null));     // the logic is not correct

    }

}
