package com.sy.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        Arrays.sort(nums);
        permuteCore(lists, new ArrayList<>(), nums, new boolean[nums.length]);
        return lists;
    }

    private void permuteCore(List<List<Integer>> lists,List<Integer> list,int[] nums,boolean[] used) {
        //递归终止条件，将list添加到lists
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
        }else{
            for(int i=0;i<nums.length;i++){
                //剪枝条件，去掉前一个数字和当前数字相同的情况
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]){
                    continue;
                }
                used[i]=true;
                list.add(nums[i]);
                permuteCore(lists,list,nums,used);
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new PermutationII().permuteUnique(new int[]{1, 2, 2}));
    }
}
