package com.sy.homework;

import java.util.Arrays;

/**
 * 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class DistributeBiscuits {
    //时间复杂度O(n)，空间复杂度O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new DistributeBiscuits().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}
