import java.util.ArrayList;
import java.util.Collections;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int n){
            this.data=n;
        }
    }

    public static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(root.data>data){
            root.left=insert(root.left,data);
        }else{
            root.right=insert(root.right,data);
        }
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
    public static void preOrder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node createBST(int start,int end, int arr[]){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(start,mid-1,arr);
        root.right=createBST(mid+1,end,arr);
        return root;
    }
    public static Node createBST2(int start,int end,ArrayList<Integer> li){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(li.get(mid));
        root.left=createBST2(start,mid-1,li);
        root.right=createBST2(mid+1,end,li);
        return root;
    }
    public static Node bstToBalancedBST(Node root){
        ArrayList<Integer> list=new ArrayList<>();
        inSeq(root,list);
        root=createBST2(0,list.size()-1,list);
        return root;
    }
    public static void inSeq(Node root, ArrayList<Integer> li){
        if(root==null){
            return;
        }
        inSeq(root.left,li);
        li.add(root.data);
        inSeq(root.right,li);

    }
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftS=largestBST(root.left);
        Info rightS=largestBST(root.right);
        int min=Math.min(root.data, Math.min(leftS.min, rightS.min));
        int max=Math.max(root.data, Math.max(rightS.max, leftS.max));
        int size=leftS.size+rightS.size+1;
        if(root.data <= leftS.max || root.data >= rightS.min){
            return new Info(false, size,min,max);
        }
        if(leftS.isBST && rightS.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }
    public static Node mergeTwoBST(Node root1,Node root2){
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        inSeq(root1,list1);
        inSeq(root2,list2);
        list1.addAll(list2);
        Collections.sort(list1);

        return createBST2(0,list1.size()-1,list1);
    }

    // a static variable for saving count for the range sum
    static int total=0;
    public static void rangeSum(Node root,int lr,int rr){
        if(root==null){
            return ;
        }
        if(root.data>=lr && root.data<=rr){
            total+=root.data;
        }
        rangeSum(root.left,lr,rr);
        rangeSum(root.right,lr,rr);
    }





    public static void main(String args[]){
//        int arr[]={1,7,4,2,8};
//        Node root=null;
//        for (int i = 0; i < arr.length; i++) {
//            root=insert(root,arr[i]);
//        }
//        inOrder(root);
//        Node root=null;
//        int arr[]={3,5,6,8,10,11,12};
//        Node root=createBST(0,arr.length-1,arr);
//        inOrder(root);
//        preOrder(root);

//        Node root=new Node(8);
//        root.left=new Node(6);
//        root.right=new Node(10);
//        root.left.left=new Node(5);
//        root.right.right=new Node(11);
//        root.left.left.left=new Node(3);
//        root.right.right.right=new Node(12);
//        preOrder(root);
//        System.out.println();
//        Node root2=bstToBalancedBST(root);
//        preOrder(root2);

//        Node root=new Node(50);
//        root.left=new Node(30);
//        root.left.left=new Node(5);
//        root.left.right=new Node(20);
//
//        root.right=new Node(60);
//        root.right.left=new Node(45);
//        root.right.right=new Node(70);
//        root.right.right.left=new Node(65);
//        root.right.right.right=new Node(80);
//        System.out.println(largestBST(root).size);
//        System.out.println(maxBST);

        Node root1=new Node(8);
        root1.left=new Node(5);
        root1.right=new Node(11);
        root1.left.left=new Node(3);
        root1.left.right=new Node(6);
        root1.right.right=new Node(20);
        int k=11;

//        System.out.println(closestValue(root1,k));
//        int lr=7;
//        int rr=15;
//        rangeSum(root1,lr,rr);
//        System.out.println(total);


//        Node root2=new Node(9);
//        root2.left=new Node(3);
//        root2.right=new Node(12);
//        root1=mergeTwoBST(root1,root2);
//        inOrder(root1);
    }
}
