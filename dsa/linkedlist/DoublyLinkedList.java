package dsa.linkedlist;

class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        prev = null;
        next = null; // non primitive data types kokhuch assign nhi kiya to vo by default null assigned jo jaata h.to no need prec and next null initialize krne ka
    } 
}

public class DoublyLinkedList {
    public static void printLinkedListData(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    public static Node insertBegin(Node head,int data){
        Node newNode = new Node(data);
        if(head == null) return newNode;

        head.prev = newNode;
        newNode.next = head;
        return newNode;
    }
    public static Node reverseList(Node head){
        if(head ==null || head.next == null) return head;
        Node cur = head;
        Node temp = null;
        while(cur !=null){
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp; 
            cur = cur.prev;
        }
        return temp.prev;
    }
    public static void main(String [] args){
    Node head = new Node(5);
    Node temp =new Node(1);
    Node temp2 = new Node(9);

    head.next = temp;
    temp.prev = head;
    temp.next = temp2;
    temp2.prev = temp;

    head = insertBegin(head,8);
    head = reverseList(head);
    printLinkedListData(head);
}
}
