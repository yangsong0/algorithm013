package com.sy.practice;

import java.util.Arrays;

/**
 * 删除排序数组中的重复项
 * 0 1 2 1 1 2 2 3 3 4
 *
 */
public class No26_RemoveDuplicates {
    public int removeDuplicates(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(new No26_RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
