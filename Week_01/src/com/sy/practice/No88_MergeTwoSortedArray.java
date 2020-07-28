package com.sy.practice;

import java.util.Arrays;

public class No88_MergeTwoSortedArray {
    public void merge(int[] nums1,int m,int[] nums2,int n){
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while(p2 >= 0){
            if(p1>=0 && nums1[p1]<nums2[p2]){
                nums1[p--]=nums2[p2--];
            }else{
                nums1[p--]=nums1[p1--];
            }
        }

    }

    public static void main(String[] args) {
        int[] a1=new int[]{1,3,4,0,0,0};
        int[] a2=new int[]{3,4,5};
        new No88_MergeTwoSortedArray().merge(a1,3,a2,3);
        System.out.println(Arrays.toString(a1));
    }
}
