package com.sy.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    /**
     * 寻找和等于target的两个数字的下标
     * 1.先排序，后双指针法 O(log(n))
     * 2.用HashMap，最坏O(n)
     * 2,7,9,11   9
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                return new int[]{map.get(target-nums[i]),i};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 9, 11}, 9)));
    }
}
