package com.sy.practice;

import java.util.Stack;

public class MinStack {
    Stack<Integer> dataStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public MinStack(){}
    public void push(int x){
        dataStack.push(x);
        minStack.push(!minStack.empty() && minStack.peek()<x ? minStack.peek():x);
    }
    public void pop(){
        if(dataStack.empty()){
            throw new NullPointerException();
        }
        dataStack.pop();
        minStack.pop();
    }
    public int top(){
        if(dataStack.empty()){
            throw new NullPointerException();
        }
        return dataStack.peek();
    }
    public int getMin(){
        if(dataStack.empty()){
            throw new NullPointerException();
        }
        return minStack.peek();
    }
}
