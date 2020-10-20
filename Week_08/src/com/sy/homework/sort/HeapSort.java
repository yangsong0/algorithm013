package com.sy.homework.sort;

import java.util.Arrays;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:54
 * @Description:
 */
public class HeapSort {
    public int[] heapSort(int [] nums){
        int len;
        if(nums==null || (len=nums.length)==0){
            return null;
        }
        for(int i=len/2-1;i>=0;i--){
            adjustHeap(nums,i,len);
        }
        for(int i=len-1;i>=0;i--){
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
        return nums;
    }

    private void adjustHeap(int[] nums, int i, int len) {
        for(int k=i*2+1;k<len;k=k*2+1){
            if(k+1<len && nums[k]<nums[k+1]){
                k++;
            }
            if(nums[i]<nums[k]){
                swap(nums, i, k);
                i=k;
            }
        }
    }
    private void swap(int[] nums,int i,int k){
        int temp=nums[i];
        nums[i]=nums[k];
        nums[k]=temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,8,2,0,9,4};
        System.out.println(Arrays.toString(new HeapSort().heapSort(nums)));
    }
}
