package com.sy.homework.sort;

import java.util.Arrays;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:37
 * @Description:
 */
public class QuickSort {
    public void quickSort(int[] nums,int start,int end){
        int i=start;
        int j=end;
        if(i>=j){
            return;
        }
        boolean flag=true;
        while(i!=j){
            if(nums[i]>nums[j]){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                flag = !flag;
            }
            if(!flag){
                i++;
            }else{
                j--;
            }
        }
        quickSort(nums,start,i-1);
        quickSort(nums,j+1,end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,8,2,0,9,4};
        new QuickSort().quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
