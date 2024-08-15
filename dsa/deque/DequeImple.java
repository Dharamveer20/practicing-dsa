package dsa.deque;

import java.util.*;

public class DequeImple {
    static class NewDs {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        void insertMin(int x) {
            if (ad.isEmpty() || ad.peek() > x) ad.offerFirst(x);
            else System.out.println("Cannot add element " + x + " since it's not min");
        }

        void insertMax(int x) {
            if (ad.isEmpty() || ad.peekLast() < x) ad.offer(x);
            else System.out.println("Cannot add element " + x + " since it's not max");
        }

        int getMin() {
            return ad.peekFirst();
        }

        int getMax() {
            return ad.peekLast();
        }

        void extractMin() {
            ad.poll();
        }

        void extractMax() {
            ad.pollLast();
        }

        void print() {
            for (int el : ad) System.out.print(el + " ");
            System.out.println();
        }
    }

//    public static void maxOfSubArr(int [] arr, int k){
//        int [] a = new int[k];
//        int j=0;
//        int min = Integer.MAX_VALUE;
//        for(int i=0; i<k; i++) {
//            a[i] = arr[i];
//            min = Math.min(a[i], min);
//        }
//        System.out.print(min + " ");
//
//        for(int i=k; i<arr.length; i++){
//            a[j] = arr[i];
//            min = Math.min(a[j], min);
//            System.out.print(min + " ");
//            j = (j+1) % k;
//        }
//    }
    public static void maxOfSubArr(int [] arr, int k) {
        Deque<Integer>  dq = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && arr[i] > arr[dq.peek()]) dq.poll();
            dq.offer(i);
        }
        for (int i = k; i < arr.length; i++) {
            System.out.print(arr[dq.peek()] + " ");
            if(dq.size() == k) dq.poll();
            while(!dq.isEmpty() && arr[i] > arr[dq.peek()]) dq.poll();
            dq.offer(i);
        }
        System.out.println(arr[dq.peek()]);
    }
    public static void main(String[] args) {
        int arr [] = {10,8,5,12,15,7,6,16};
        int arr1 [] = {10,9,8,7,6,5,4,3};
        int arr2 [] = {3,4,5,6,7,8,9,10};
        int [] arr3 = {90,89,10,19,15,87,9};
        maxOfSubArr(arr,3);
        maxOfSubArr(arr1,3);
        maxOfSubArr(arr2,3);
        maxOfSubArr(arr3,2);

//        NewDs a = new NewDs();
//        a.insertMax(50);
//        a.insertMax(34);
//        a.insertMin(5);
//        a.insertMin(6);
//        a.print();
//        a.extractMax();
//        a.extractMin();
//        System.out.println(a.getMax());
//        a.print();
    }
}
