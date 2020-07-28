package com.sy.practice;

import java.util.Arrays;

/**
 * 旋转数组
 * 1,2,3,4,5,6,7  k=3  -->5,6,7,1,2,3,4
 */
public class No189_RotateArray {
    /**
     * 翻转数组，-->  7,6,5,4,3,2,1  ，再以k为界分别翻转  -->5,6,7,1,2,3,4
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums,int k){
        int len;
        if(nums==null || (len=nums.length)==0){
            return;
        }
        k %= len;
        reverseArray(nums,0,len-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,len-1);
    }

    private void reverseArray(int[] nums, int i, int j) {
        while(i<j){
            nums[i]^=nums[j];
            nums[j]^=nums[i];
            nums[i]^=nums[j];
            i++;
            j--;
        }
    }

    //1,2,3,4,5,6,7
    public void rotate2(int[] nums,int k){
        int len;
        if(nums==null || (len=nums.length)==0){
            return;
        }
        k %= len;
        int temp,pre;
        for(int i=0;i<k;i++){
            pre=nums[len-1];
            for(int j=0;j<len;j++){
                temp=nums[j];
                nums[j]=pre;
                pre=temp;
            }
        }
    }

    public void rotate3(int[] nums,int k){
        int len;
        if(nums==null || (len=nums.length)==0){
            return ;
        }
        k %= len;
        int count=0;
        for(int start=0;count<len;start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current+k) % len;
                int temp=nums[next];
                nums[next]=prev;
                prev=temp;
                current=next;
                count++;
            }while(start!=current);
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6};
        new No189_RotateArray().rotate3(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
