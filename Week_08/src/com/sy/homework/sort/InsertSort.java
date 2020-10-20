package com.sy.homework.sort;

import java.util.Arrays;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:28
 * @Description: 插入排序
 */
public class InsertSort {
    // 4 7 8 5 9 8 0 1 3
    public void insertSort(int[] nums){
        int len;
        if(nums==null || (len=nums.length)==0){
            return;
        }
        for(int i=1;i<len;i++){
            for(int j=i;j>0 && nums[j]<nums[j-1];j--){
                int temp = nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] nums=new int[]{4,2,6,0,9,1};
        insertSort.insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
