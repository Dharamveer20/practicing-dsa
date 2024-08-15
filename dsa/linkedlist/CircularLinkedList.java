package dsa.linkedlist;

//class Node{ // Same as singly linked list
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        next = null;
//    }
//}
public class CircularLinkedList {
    public static void traversal(Node head){
        if(head == null) return;
        // We can do while loop instead of below way.
        System.out.print(head.data + " ");
        Node cur =head.next;
        while(cur != head){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    public static Node insertBegin(Node head, int x){ // Works in O(1) time complexity. Naive soch hi lega O(n)
        Node newNode = new Node(x);
        if(head == null) {
            newNode.next =newNode;
            return newNode;
        }
        newNode.next =head.next;
        head.next = newNode;
        int data = head.data;
        head.data = newNode.data;
        newNode.data = data;  

        return head;
    }
    public static Node insertEnd(Node head, int x){ // Works in O(1) time complexity. Naive soch hi lega O(n)
        Node newNode = new Node(x);
        if(head == null) {
            newNode.next =newNode;
            return newNode;
        }
        newNode.next =head.next;
        head.next = newNode;
        int data = head.data;
        head.data = newNode.data;
        newNode.data = data;  

        return newNode;
    }
    public static Node delHead(Node head){
        if(head.next == null || head.next == head) return null;
        int temp = head.data;
        head.data  = head.next.data;
        head.next.data = temp;
        head.next = head.next.next;
        return head;
    }
    public static void main(String [] args){
        Node head =  new Node(5);
        head.next =  new Node(8);
        head.next.next =  new Node(11);
        head.next.next.next = head;

        head = insertBegin(head,13);
        head = insertEnd(head,15);
        head = delHead(head);
        traversal(head);
    }
}

