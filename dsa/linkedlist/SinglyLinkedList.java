package dsa.linkedlist;

//class Node{
//    int data;
//    Node next;
//    Node(int data){
//        this.data = data;
//        next = null; // Optional hai ye line bina assigned object null hi hota h
//    }
//}
public class SinglyLinkedList{
    public static void printLinkedListData(Node head){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
    public static Node insertHead(Node head,int x){
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
    public static Node insertAtEnd(Node head,int x){
        Node newNode = new Node(x);
        if(head == null) return newNode;
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static Node insertAtPos(Node head,int data, int pos){
        Node newNode = new Node(data);
        if(pos==1){
            newNode.next = head;
            return newNode;
        }
        Node cur = head;
        for(int i=1; i<pos-1; i++){
            cur =cur.next;
        }
        if(cur == head) return null;
        newNode.next =cur.next;
        cur.next = newNode;
        return head;
    }
    public static Node delHead(Node head){
        if (head == null) return null;
        return head.next;
    }
    public static Node delTail(Node head){
        if (head == null || head.next == null) return null;
        Node cur = head;
        while(cur.next.next != null) cur = cur.next;
        cur.next = null;
        return head;
    }
    
    public static void main(String[] args) {
        Node head = null;
        head = insertHead(head,10);
        head = insertHead(head,3);
        head = insertHead(head, 30);
        Node endInsertion = insertAtEnd(head,40);
        Node midIns = insertAtPos(head,5,3);
        Node headDel = delHead(head);
        Node tailDel =delTail(head);
        // temp.next = temp2;

        printLinkedListData(tailDel); // upar ka print method dekh

        // printLinkedListData(headDel); // upar ka print method dekh

        // printLinkedListData(midIns); // upar ka print method dekh

        // printLinkedListData(endInsertion); // upar ka print method dekh
    }
}