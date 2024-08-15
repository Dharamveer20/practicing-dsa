package dsa.bst;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int key){
        data = key;
    }
}
public class BST {
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static Node insert(Node root, int key){
        if(root == null) return new Node(key);
        else if(key < root.data) root.left = insert(root.left,key);
        else if(key > root.data) root.right = insert(root.right, key);
        return root;
    }
    // insert Iterative (my way)
    static Node insertIter(Node root, int key){
        Node cur = root;
        if(cur == null) return new Node(key);
        while(cur != null){
            if(cur.left == null && key < cur.data) {
                cur.left = new Node(key);
                return root;
            }
            else if(cur.right == null && key > cur.data) {
                cur.right = new Node(key);
                return root;
            }
            else if(key < cur.data) cur = cur.left;
            else if(key > cur.data) cur = cur.right;
            else return root;
        }
        return root;
    }
    static Node successorNode(Node root){
        Node cur = root.right;
        while(root.left != null) cur = cur.left;
        return cur;
    }
    static Node delete(Node root, int key){
        if (root == null) return null;
        if(key < root.data) root.left = delete(root.left, key);
        else if(key > root.data) root.right = delete(root.right, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                Node suc = successorNode(root);
                root.data = suc.data;
                root.right = delete(root.right,key);
            }
        }
        return root;
    }
    static Node closestFloor(Node root, int k) {
        Node res = null;
        while (root != null) {
            if (root.data == k) return root;
            else if (root.data > k) root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }
    static Node closestCeil(Node root, int k){
        Node res = null;
        while(root != null){
            if(root.data == k) return root;
            else if(root.data < k) root = root.right;
            else{
                res = root;
                root = root.left;
            }
        }
        return res;
    }
    static void printCeiling(int [] arr){
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(arr[0]);
        System.out.print(-1 + " ");
        for(int i=1; i<arr.length; i++){
            if(ts.ceiling(arr[i]) != null) System.out.print(ts.ceiling(arr[i]) + " ");
            else System.out.print(-1 + " ");
            ts.add(arr[i]);
        }
    }
    static boolean checkBst(Node root, int lR, int rR){
        if(root == null) return true;
        return((root.data >lR && root.data < rR ) && checkBst(root.left,lR,root.data) && checkBst(root.right,root.data,rR));
    }
    static boolean pairSum(Node root, Set<Integer>hs, int sum){
        if(root == null) return false;
        if(pairSum(root.left,hs,sum)) return true;
        if(hs.contains(sum-root.data)) return true;
        else hs.add(root.data);
        return pairSum(root.right,hs,sum);
    }
    static void vSum(Node root, TreeMap<Integer,Integer> tm, int hd){
        if(root == null) return;
        vSum(root.left,tm, hd-1);
//        if(tm.containsKey(hd)) tm.put(hd, tm.get(hd)+root.data);
//        else tm.put(hd,root.data);
        int pSum = tm.get(hd) == null ? 0 : tm.get(hd);
        tm.put(hd, pSum+root.data);
        vSum(root.right,tm,hd+1);
    }
    static void vLine(Node root, TreeMap<Integer,Queue<Integer>> tm, int hd){
        if(root == null) return;
//        int pSum = tm.get(hd) == null ? 0 : tm.get(hd);
        tm.put(hd, q.offer(root.data));
        vLine(root.left,tm, hd-1);
//        if(tm.containsKey(hd)) tm.put(hd, tm.get(hd)+root.data);
//        else tm.put(hd,root.data);

        vLine(root.right,tm,hd+1);
    }
    static void printVsum(Node root){
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        vSum(root,tm,0);
        for(Map.Entry x: tm.entrySet()) System.out.print(x.getValue() + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
//        root.right.left = new Node(12);
//        root.right.right = new Node(19);
//        inOrder(root);
//        System.out.println();
////        inOrder(insert(root, 55));
//        System.out.println();
////        inOrder(insertIter(root,14));
//        System.out.println();
//        inOrder(insertIter(root,1));
//        System.out.println();
//        inOrder(insertIter(root,6));
//        System.out.println();
//        inOrder(insertIter(root,7));
//        System.out.println();
//        delete(root,1);
//        inOrder(root);
//        System.out.println();
//        System.out.println("Closest floor : " + closestFloor(root, 11).data);
//        System.out.println("Closest ceil : " + closestCeil(root, 11).data);
//        int [] arr = {5,2,6,8,3,6};
//        printCeiling(arr);
//        System.out.println();
//        System.out.println(checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//        HashSet<Integer> hs = new HashSet<>();
//        System.out.println(pairSum(root,hs,188));
        printVsum(root);
    }
}
