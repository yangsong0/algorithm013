package com.sy.homework;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public int[] heapSort(int[] nums){
        int len;
        if(nums==null || (len=nums.length)==0){
            return new int[0];
        }
        //建堆阶段
        //从最后一个非叶子节点开始调整结构，把大的元素放到根节点，形成大顶堆
        for(int i=len/2-1;i>=0;i--){
            adjustHeap(nums,i,len);
        }
        //排序阶段，每次取第一个元素放在末尾，长度减一再次调整堆，直到长度为0
        //循环条件j>0，若要写成j>=0，则交换方法不能用异或，因为最后会出现自己和自己交换的情况，用异或会出现0
        for(int j=len-1;j>0;j--){
            swap(nums,0,j);
            adjustHeap(nums,0,j);
        }
        return nums;
    }

    private void adjustHeap(int[] nums, int i, int len) {
        //比较左右儿子，选取较大的与根节点交换
        for(int k=i*2+1;k<len;k=k*2+1){
            if(k+1<len && nums[k]<nums[k+1]){
                k++;
            }
            if(nums[k]>nums[i]){
                swap(nums,i,k);
                //继续作根节点往下交换
                i=k;
            }
        }
    }
    public void swap(int[] nums,int i,int k){
        nums[i]^=nums[k];
        nums[k]^=nums[i];
        nums[i]^=nums[k];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new HeapSort().heapSort(new int[]{3, 2,1,6,9,4})));
    }
}
