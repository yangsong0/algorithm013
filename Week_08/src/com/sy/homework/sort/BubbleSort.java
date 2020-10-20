package com.sy.homework.sort;

import java.util.Arrays;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:54
 * @Description:
 */
public class BubbleSort {
    public void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,8,2,0,9,4};
        new BubbleSort().bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
