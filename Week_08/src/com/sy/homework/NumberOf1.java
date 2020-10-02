package com.sy.homework;

public class NumberOf1 {
    public int hammingWeight(int n){
        int count = 0;
        while(n!=0){
            n &= n-1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().hammingWeight(9));
    }
}
