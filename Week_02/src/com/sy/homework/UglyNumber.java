package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class UglyNumber {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 动态规划，每次得到含2，含3，含5的3个数中的最小的数
     * 1，2，3，4，5，6，8...
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n<=6){
            return n;
        }
        int[] dp=new int[n];
        int i2=0,i3=0,i5=0;
        dp[0]=1;
        for(int i=1;i<n;i++){
            //得到三个丑数，在第一层循环分别是2，3，5
            int next2=dp[i2]*2,next3=dp[i3]*3,next5=dp[i5]*5;
            //找出三个数中最小的作为第i+1个丑数
            dp[i]=Math.min(next2,Math.min(next3,next5));
            //对应的索引增加
            if(dp[i]==next2){
                i2++;
            }
            if(dp[i]==next3){
                i3++;
            }
            if(dp[i]==next5){
                i5++;
            }
        }
        return dp[n-1];
    }
}
