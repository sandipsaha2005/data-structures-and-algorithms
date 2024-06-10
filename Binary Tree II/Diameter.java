import com.sun.source.tree.IfTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class Diameter {
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int lD=diameter(root.left);
        int lh=height(root.left);
        int Rd=diameter(root.right);
        int rh=height(root.right);
        int selfDim=lD+Rd+1;
        return Math.max(selfDim, Math.max(lD,Rd));
    }
    static class Info{
        int d;
        int h;
        public Info(int d,int h){
            this.d=d;
            this.h=h;
        }
    }
    public static Info optimizedDiameter(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info li=optimizedDiameter(root.left);
        Info ri=optimizedDiameter(root.right);
        int diameter=Math.max(li.h+ri.h, Math.max(li.d,ri.d));
        int height=Math.max(li.h,ri.h)+1;

        return new Info(diameter,height);
    }

    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public static boolean isIdentical(Node root,Node subRoot){

        if(root==null && subRoot==null){
            return true;
        } else if(root==null || subRoot==null || root.data!=subRoot.data){
            return false;
        }

        if(!isIdentical(root.left,subRoot.left)){
            return false;
        } else if (!isIdentical(root.right,subRoot.right)) {
            return false;
        }
        return true;
    }
    static class NodeDet{
        Node node;
        int hd;
        public NodeDet(int hd,Node node){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void topViewTraversal(Node root){
        Queue<NodeDet> q =new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        q.add(new NodeDet(0,root));
        q.add(null);
        int max=0;
        int min=0;
        while (!q.isEmpty()){
            NodeDet curr=q.remove();

            if(curr==null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){

                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new NodeDet(curr.hd-1,curr.node.left));
                    min=Math.min(curr.hd-1,min);
                }
                if(curr.node.right!=null){
                    q.add(new NodeDet(curr.hd+1,curr.node.right));
                    max=Math.max(curr.hd+1,max);
                }
            }

        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
//    public static void topView(Node root){
//        Queue<NodeDet> q=new LinkedList<>();
//        HashMap<Integer,Node> map=new HashMap<>();
//        int min=0;
//        int max=0;
//        q.add(new NodeDet(root,0));
//        q.add(null);
//        while (!q.isEmpty()){
//            NodeDet curr=q.remove();
//            if(curr==null){
//                if(q.isEmpty()){
//                    break;
//                }else{
//                    q.add(null);
//                }
//            }
//            if(!map.containsKey(curr.hd)){
//                map.put(curr.hd,curr.node);
//            }
//            if(curr.node.left!=null){
//                q.add(new NodeDet(curr.node.left,curr.hd-1));
//                min=Math.min(min,curr.hd-1);
//            }
//            if(curr.node.right!=null){
//                q.add(new NodeDet(curr.node.right,curr.hd+1));
//                max=Math.max(max,curr.hd+1);
//            }
//        }
//        for (int i = min; i < max; i++) {
//            System.out.print(map.get(i).data+" ");
//        }
//        System.out.println();
//    }

    public static void kthlevel(Node root,int k,int lev){

        if(root==null){
            return;
        }
        if(lev==k){
            System.out.print(root.data+" ");
        }
        kthlevel(root.left,k, lev+1);
        kthlevel(root.right,k,lev+1);
    }
    public static boolean getPath(Node root,int k, ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==k){
            return true;
        }
        boolean left=getPath(root.left,k,path);
        boolean right=getPath(root.right,k,path);
        if(left==true || right==true){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static int lca(Node root,int k1,int k2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getPath(root,k1,path1);
        getPath(root,k2,path2);
        int i;
        for (i=0; i < path1.size() && i< path2.size(); i++) {
            if(path2.get(i)!=path1.get(i)){
                break;
            }
        }

        Node lcs=path1.get(i-1);
        return lcs.data;
    }
    public static Node lca2(Node root,int k1,int k2){
        if(root==null || root.data==k2 || root.data==k1){
            return root;
        }
        Node left=lca2(root.left,k1,k2);
        Node right=lca2(root.right,k1,k2);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
    public static Node lowEnc(Node root,int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node left=lowEnc(root.left,n1,n2);
        Node right=lowEnc(root.right,n1,n2);

        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }
    public static int dist(Node root,int k){
        if(root==null){
            return -1;
        }
        if(root.data==k){
            return 0;
        }
        int left=dist(root.left,k);
        int right=dist(root.right,k);
        if(left==-1 && right== -1){
            return -1;
        }else if(left==-1){
            return right+1;
        }else{
            return left+1;
        }
    }
    public static int distOfTwoNodes(Node root,int n1,int n2){
        Node newRoot=lowEnc(root,n1,n2);
        int leftD=dist(root,n1);
        int rightD=dist(root,n2);

        return leftD+rightD;
    }
    public static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{

                    q.add(null);
                }
            }else {
                System.out.print(curr.data +" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static int kthAncestor(Node root, int n,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDis=kthAncestor(root.left,n,k);
        int rightDis=kthAncestor(root.right,n,k);
        if(leftDis ==-1 && rightDis==-1){
            return -1;
        }
        int max=Math.max(leftDis,rightDis);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;

    }
    public static int transformIntoSumTree(Node root){
        if(root==null){
            return 0;
        }
        int leftChild=transformIntoSumTree(root.left);
        int rightChild=transformIntoSumTree(root.right);
        int data=root.data;
        int newLeft= root.left==null ? 0: root.left.data;
        int newRight=root.right==null ? 0: root.right.data;

        root.data=newLeft+leftChild+newRight+rightChild;
        return data;
    }
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static boolean check(Node root){
        return  checkHelp(root,root.data);
    }
    public static boolean checkHelp(Node root, int k){
        if(root==null){
            return true;
        }
        if(root.data!=k){
            return false;
        }
        return checkHelp(root.left,k) && checkHelp(root.right,k);
    }
    public static void main(String args[]){
//        Node root=new Node(10);
//        root.left=new Node(12);
//        root.right=new Node(13);
//        root.left.left=new Node(21);
//        root.left.right=new Node(22);
//        root.right.left=new Node(23);
//        root.right.right=new Node(24);

        int n=23, k=2;
//        kthAncestor(root,n,k);
//        transformIntoSumTree(root);
//        preOrder(root);
//        Node subRoot=new Node(12);
//        subRoot.left=new Node(21);
//        subRoot.right=new Node(22);

//        levelOrderTraversal(root);
//        topViewTraversal(root);
//        kthlevel(root,2,1);
//        System.out.println(lca2(root,21,22).data);
//        System.out.println(distOfTwoNodes(root,12,23));
//        inOrder(root);
//        System.out.println(diameter(root));
//        System.out.println(optimizedDiameter(root).d);

//        System.out.println(isSubtree(root,subRoot));
//        topView(root);
//        final int a=1;
        Node root=new Node(5);
        root.left=new Node(5);
        root.right=new Node(5);
        System.out.println(check(root));
    }
}
