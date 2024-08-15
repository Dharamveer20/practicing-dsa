package dsa;

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data= data;
    }
}
public class Main{
    public static void printList(Node head){
        if(head ==null) return;
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp =temp.next;
        }
        System.out.println();
    }
    public static Node mergeSortedList(Node a, Node b){
        if(a == null) return b;
        if(b == null)return a;

        Node newNode,head;
        if(a.data <= b.data) {
            newNode = head = a;
            a = a.next;
        }
        else {
            newNode = head = b;
            b=b.next;
        }
        while(a !=null && b!=null){
            if(a.data <= b.data) {
                newNode.next = a;
                newNode = a;
                a = a.next;
            }
            else {
                newNode.next = b;
                newNode = b;
                b = b.next;
            }
        }
        if(a==null) newNode.next = b;
        if(b==null) newNode.next = a;
        return head;
    }
    public static Node reverseList(Node head){
        Node prev =null;
        Node cur = head;
        Node cN = null;
        while(cur != null){
            cN = cur.next;
            cur.next = prev;
            prev = cur;
            cur = cN;
        }
        return prev;
    }
    public static boolean checkPal(Node head){
        Node slow = head;
        Node fast = head;
        Node cur =head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast=fast.next.next;
        }
        Node rev = reverseList(slow.next);

        while(rev !=null){
            if(rev.data != cur.data) return false;
            rev =rev.next;
            cur=cur.next;
        }
        return true;
    }

    public static boolean balParen(String str){
        if(str.length() % 2 == 1) return false;
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i=0; i<str.length(); i++){
            char x = str.charAt(i);
            if(x == '(' || x == '[' || x == '{') st.push(x);
            else {
                if(st.peek() == '(' && x != ')') return false;
                if(st.peek() == '[' && x != ']') return false;
                if(st.peek() == '{' && x != '}') return false;
                st.pop();
            }
        }
        return true;
    }
    public static void main(String [] args){
        String a = "{(([()])]}";
        // STR
        System.out.println(balParen(a));
        // Node a = new Node(6);
        // a.next = new Node(10);
        // a.next.next = new Node(10);
        // a.next.next.next = new Node(3);
        // System.out.println(checkPal(a));

        // Node b = new Node(3);
        // b.next = new Node(8);
        // printList(a);
        // printList(b);

        // Node c = mergeSortedList(a,b);
        // printList(mergeSortedList(a, b));
    }
}