package com.sy.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    /**
     * 前k个高频元素
     * 把每个数字出现的次数放入map中，建立排序规则为出现次数的小顶堆
     * 维护这个大小为K的小顶堆，每次弹出最小值，最后堆内剩下的就是高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((o1, o2) -> map.get(o1)-map.get(o2));
        for(int n:map.keySet()){
            minHeap.offer(n);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            res[i++]=minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent().topKFrequent(new int[]{3,0,1,0}, 1)));
    }
}
