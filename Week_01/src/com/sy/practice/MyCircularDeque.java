package com.sy.practice;

public class MyCircularDeque {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        if(k<0){
            throw new IllegalArgumentException("Initial size is less than 0!");
        }
        this.array=new int[k];
        this.front=0;
        this.rear=0;
        this.size=0;
        this.capacity=k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        // 0 0 0 0 0
        if(size==capacity){
            return false;
        }
        front=(front-1+capacity)%capacity;
        array[front]=value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size==capacity){
            return false;
        }
        array[rear]=value;
        rear=(rear+1)%capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        front=(front+1)%capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        rear=(rear-1+capacity)%capacity;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0){
//            throw new RuntimeException("queue is empty");
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0){
//            throw new RuntimeException("queue is empty");
            return -1;
        }
        return array[(rear-1+capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==capacity;
    }

    public static void main(String[] args) {
        //1 2 3
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }
}
