package com.sy.homework;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 回文子串个数
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int len;
        if(s==null || (len=s.length())==0){
            return 0;
        }
        int res=0;
        boolean[][] dp=new boolean[len][len];
        for(int j=0;j<len;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }
}
