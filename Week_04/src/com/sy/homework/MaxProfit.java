package com.sy.homework;
/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 买卖股票的最佳时机
 */
public class MaxProfit {
    //贪心算法，时间复杂度：O(n)，空间复杂度O(1)
    public int maxProfit(int[] prices) {
        int maxDiff=0;
        for(int i=1;i<prices.length;i++){
            //只要之后的价值比之前的大都可以卖出股票
            if(prices[i]>prices[i-1]){
                maxDiff+=prices[i]-prices[i-1];
            }
        }
        return maxDiff;
    }
}
