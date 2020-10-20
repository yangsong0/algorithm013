package com.sy.homework.sort;

import java.util.Arrays;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:44
 * @Description:
 */
public class MergeSort {
    public int[] mergeSort(int[] nums){
        return mergeSort(nums,0,nums.length-1);
    }

    private int[] mergeSort(int[] nums, int low, int high) {
        if(low>=high){
            return new int[]{nums[low]};
        }
        int mid = low+high>>1;
        int[] left = mergeSort(nums,low,mid);
        int[] right = mergeSort(nums,mid+1,high);
        int i=0,j=0,k=0;
        int[] temp = new int[left.length+right.length];
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                temp[k++]=left[i++];
            }else{
                temp[k++]=right[j++];
            }
        }
        while(i<left.length){
            temp[k++]=left[i++];
        }
        while(j<right.length){
            temp[k++]=right[j++];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,8,2,0,9,4};
        System.out.println(Arrays.toString(new MergeSort().mergeSort(nums)));
    }
}
