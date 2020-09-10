package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int len,num;
        if(s==null || (len=s.length())==0){
            return 0;
        }
        int[] dp = new int[len];
        if(s.charAt(len-1)=='0'){
            dp[len-1]=0;
        }else{
            dp[len-1]=1;
        }
        for(int i=len-2;i>=0;i--){
            //当前位是0，没有办法解码
            if(s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            //两位在10-26之间
            if((num=((s.charAt(i)-'0')*10 + s.charAt(i+1)-'0'))>=10 && num<=26){
                //i==len-2 i+2会越界
                if(i==len-2){
                    dp[i]=dp[i+1]+1;
                }else{
                    dp[i]=dp[i+1]+dp[i+2];
                }
            }else{
                dp[i]=dp[i+1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("226"));
    }
}
