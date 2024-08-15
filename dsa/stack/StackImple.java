package dsa.stack;
import java.util.*;
class Stack {
    int n;
    int arr[]; // Array to store the elements of the dsa.stack
    int top; // Index of the top element of the dsa.stack

    Stack(int n) { // Constructor to create an empty dsa.stack with a specified size(n)
        this.n = n;
        this.arr = new int[n];
        this.top = -1; // The dsa.stack is initially empty, so top is set to -1
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (n - 1 == top);
    }

    // Pushes an element onto the top of the dsa.stack
    public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
//            System.out.println("Pushed element:" + pushedElement);
        } else {
            System.out.println("Stack is full !"); // Overflow
        }
    }

    // Removes and returns the element at the top of the dsa.stack
    public int pop() {
        if (!isEmpty()) {
            int poppedElement = top;
            top--;
//            System.out.println("Popped element :" + arr[poppedElement]);
            return arr[poppedElement];

        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    // Returns the element at the top of the dsa.stack without removing it
    public int peek() {
        if (!this.isEmpty())
            return arr[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }
}
//class Stack{
//    int arr[];
//    int top1;
//    int top2;
//    int cap;
//    Stack(int cap){
//        top1=-1;
//        top2=cap;
//        arr = new int[cap];
//    }
//    boolean push1(int x){
//        if(top1 == top2-1) return false;
//        top1++;
//        arr[top1] = x;
//        return true;
//    }
//    boolean push2(int x){
//        if(top1 == top2-1) return false;
//        top2--;
//        arr[top2] = x;
//        return true;
//    }
//    Integer pop1(){
//        if(top1 == -1) return null;
//        int pop = arr[top1];
//        top1--;
//        return pop;
//    }
//    Integer pop2(){
//        if(top2 == cap) return null;
//        int pop = arr[top2];
//        top2++;
//        return pop;
//    }
//    boolean isEmpty1(){
//        if(top1 == -1) return true;
//        return false;
//    }
//    boolean isEmpty2(){
//        if(top2 == cap) return true;
//        return false;
//    }
//    int size1(){
//        return top1+1;
//    }
//    int size2(){
//        return cap-top2;
//    }
//}

public class StackImple {
    // Stack with getMin()function
     static class MyStack{
        Stack ms;
        Stack auxS;
        int min = Integer.MIN_VALUE;
        MyStack(int n){
            ms = new Stack(n);
            auxS = new Stack(n);
        }

        void push(int x){
            ms.push(x);
            if(auxS.isEmpty() || auxS.peek() > x) auxS.push(x);
        }
        int pop(){
            int pop = ms.pop();
            if(pop == auxS.peek()) auxS.pop();
            return pop;
        }
        int getMin(){
            return auxS.peek();
        }
    }
    public static void stockSpan(int [] arr, int n){
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);
        System.out.print(1 + " ");

        for(int i=1; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) st.pop();
            if(st.isEmpty()) System.out.print(i+1 + " ");
            else System.out.print(i-st.peek() + " ");
            st.push(i);
        }
    }
    public static void prevGreat(int [] arr, int n){
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(arr[0]);
        System.out.print(-1 + " ");

        for(int i=1; i<n; i++){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(st.isEmpty()) System.out.print(-1 + " ");
            else System.out.print(st.peek() + " ");
            st.push(arr[i]);
        }
    }
    public static int [] pS(int arr []) {
        int n = arr.length;
        int [] pS = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);
        pS[0] = -1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) pS[i] = -1;
            else pS[i] = st.peek();
            st.push(i);
        }
        return pS;
    }
    public static int [] nS(int arr []) {
        int n = arr.length;
        int [] nS= new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) nS[i] = n;
            else nS[i] = st.peek();
            st.push(i);
        }
        System.out.println();
        System.out.println(n);
        nS[n-1] = n;
        System.out.println(nS[n-1]);

        return nS;
    }
    public static void largeRecArea(int arr[], int n){
        int [] pS = pS(arr);
        int [] nS = nS(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(pS[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nS[i] + " ");
        }
//    ret
    }
     public static void main(String[] args) {
        MyStack st = new MyStack(10);
        st.push(45);
         st.push(95);
         st.push(10);
         st.push(5);
         st.push(6);
         st.pop(); st.pop();
         System.out.println(st.getMin());

        int[] arr = {60,10,20,15,35,50};
//        largeRecArea(arr,6);
//        stockSpan(arr,6);
//        prevGreat(arr,6);
//        Stack st = new Stack(5);
//        st.push1(1);
//        st.push2(5);
//        st.push1(1);
//        st.push2(5);
//        st.push1(1);
//        st.push2(5);
//        st.push1(1);
//        st.push2(5);
//        st.push1(1);
//        System.out.println(st.pop1());
//        System.out.println(st.push2(5));
//        System.out.println(st.push1(5));
//        System.out.println(st.size1());
//        System.out.println(st.size2());
    }
}