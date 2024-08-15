package dsa.queue;

import java.util.*;

public class QueueDS {
//    static class QueueImple{
//        int front,cap,size,rear;
//        int [] arr;
//        QueueImple(int s){
//            front = -1;
//            rear = -1;
//            cap = s;
//            size = 0;
//            arr = new int[cap];
//        }
//        boolean isFull() {
//            return size == cap;
//        }
//        boolean isEmpty(){
//            return size == 0;
//        }
//
//        void enque(int x) {
//            if (!isFull()) {
//                rear++;
//                if(rear == cap) rear = 0;
//                arr[rear] = x;
//                size++;
//                if(front == -1) front = 0;
//            }
//        }
//        void dsa.deque(){
//            if(!isEmpty()){
//                front++;
//                if(front == cap) front = 0;
//                size--;
//            }
//        }
//    }
// Reverse a Queue (Iterative)
    static Queue<Integer> reverseQueue(Queue<Integer> q){
        ArrayDeque<Integer> st = new ArrayDeque<>();
        while(!q.isEmpty()) st.push(q.remove());
        while(!st.isEmpty()) q.add(st.pop());
        return q;
    }
// Generate
    static void printCombo(int n){
        Queue<String> q = new ArrayDeque<>();
        q.add("5");
        q.add("6");
        int count = 0;
        while(count <= n) {
            String cur = q.remove();
            System.out.println(cur);
            q.add(cur + "5");
            q.add(cur + "6");
            count++;
        }
    }
    public static void main(String[] args) {
        printCombo(10);
//        QueueImple q = new QueueImple(5);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(5);
        q.add(6);
        q.add(8);
//        System.out.println(q);
//        System.out.println(reverseQueue(q));
    }
}
