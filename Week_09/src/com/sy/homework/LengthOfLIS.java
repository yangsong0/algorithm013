package com.sy.homework;

/**
 * @Author: sy
 * @Date: 2020/10/11 19:10
 * @Description:
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }

}
