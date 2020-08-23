package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class BinarySearchInRotateArray {
    /**
     *
     * @param nums 4,5,6,7,0,1,2
     * @param target 0
     * @return
     */
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+high>>1;
            if(target==nums[mid]){
                return mid;
            }
            //判断mid在哪一段，若在右半段，中间值小于high值，若在左半段，中间值大于high值
            if(nums[mid]<nums[high]){
                //mid在右半段
                if(nums[mid]<target && nums[high]>=target){
                    //往右查找
                    low=mid+1;
                }else{
                    //往左查找
                    high=mid-1;
                }
            }else{
                //mid在左半段
                if(nums[mid]>target && nums[low]<=target){
                    //往左查找
                    high=mid-1;
                }else{
                    //往右查找
                    low=mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearchInRotateArray().search(new int[]{3, 1}, 1));
    }
}
