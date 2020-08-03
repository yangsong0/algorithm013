package com.sy.practice;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */
public class No66_PlusOne {
    public int[] plusOne(int[] digits){
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            digits[i]++;
            if(digits[i]%10 != 0){
                return digits;
            }
            digits[i]=0;
        }
        int[] res=new int[len+1];
        res[0]=1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new No66_PlusOne().plusOne(new int[]{9,9,9})));
    }
}
