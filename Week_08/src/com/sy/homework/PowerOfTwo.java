package com.sy.homework;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return (n & n-1) == 0;
    }
}
