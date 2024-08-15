package dsa.tree;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        data = x;
    }
}
public class TreeImple {

    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static int height(Node root){
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
//        int count=0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            System.out.print(cur.data + " ");
//            count++;
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
//        return count;
    }
    public static void lineTraversalWithSout(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            Node cur = q.poll();
            if(cur == null) {
                q.add(null);
                System.out.println();
                continue;
            }
            System.out.print(cur.data + " ");
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
    }
    static int getSize(Node root){
        if(root ==null) return 0;
        return 1+getSize(root.left)+getSize(root.right);
    }
    static int getMax(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(Math.max(getMax(root.left),getMax(root.right)), root.data);
    }
    static boolean childrenSub(Node root){
        if(root == null || (root.left  == null && root.right == null)) return true;
        int sum = 0;
        if(root.left != null ) sum += root.left.data;
        if(root.right != null) sum += root.right.data;
        return (root.data == sum && childrenSub(root.left) && childrenSub(root.right));
    }
    static int checkBalanced(Node root){
        if(root == null) return 0;
        int lh = checkBalanced(root.left);
        if(lh == -1) return lh;
        int rh = checkBalanced(root.right);
        if(rh == -1) return rh;
        if (Math.abs(lh-rh) > 1) return -1;
        else return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(11);
        root.right = new Node(9);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left.right = new Node(45);
        root.right.left = new Node(2);
        root.right.right = new Node(7);
//        root.right.right.right =  new Node(7);
//        root.right.right.right.right = new Node(7);

//        root.right.left.right = new Node(76);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        System.out.println("Height of the Tree: " + height(root));
        bfs(root);
        System.out.println();
        System.out.println("size of the dsa.tree : " + getSize(root));
        System.out.println(getMax(root));
        System.out.println(childrenSub(root));
        System.out.println(checkBalanced(root));
//        lineTraversalWithSout(root);
    }
}
