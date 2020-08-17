package com.sy.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        combine(n,k,1,list);
        return lists;
    }
    public void combine(int n,int k,int curNum,List<Integer> list){
        //当前list填满了，加到lists里面
        if(list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        //剪枝条件：max(i)=n-(k-list.size())+1
        for(int i=curNum;i<=n-(k-list.size())+1;i++){
            //处理当前逻辑：将元素添加到list
            list.add(i);
            //递归至下一层
            combine(n,k,i+1,list);
            //状态回退
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
