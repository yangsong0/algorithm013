package com.sy.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutation {

    //给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums==null || nums.length==0){
            return lists;
        }
        permuteCore(lists,new ArrayList<>(),nums,new boolean[nums.length]);
        return lists;
    }

    private void permuteCore(List<List<Integer>> lists,List<Integer> list,int[] nums,boolean[] used) {
        //递归终止条件，将list添加到lists
        if(list.size()==nums.length){
            lists.add(new ArrayList<>(list));
        }else{
            for(int i=0;i<nums.length;i++){
                //如果没有使用过，就进行处理，如果已经使用过则寻找下一个数字
                if(!used[i]){
                    //当前层处理
                    used[i]=true;
                    list.add(nums[i]);
                    //递归至下一次层
                    permuteCore(lists,list,nums,used);
                    //状态回退
                    used[i]=false;
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[]{1, 2, 3}));
    }
}
