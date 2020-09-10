package com.sy.homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    /**
     * 二维dp
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int rows,cols;
        if(grid==null || (rows=grid.length)==0 || (cols=grid[0].length)==0){
            return 0;
        }
        int[][] dp=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //第一个位置
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                }
                //第一行的值等于上一列dp数+当前数
                else if(i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                //第一列的值等于上一行dp数+当前数
                else if(j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                //中间位置的值等于左边和上边的dp最小值+当前数
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    /**
     * 一维dp
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int rows,cols;
        if(grid==null || (rows=grid.length)==0 || (cols=grid[0].length)==0){
            return 0;
        }
        int[] dp=new int[cols];
        boolean flag=true;
        for(int[] values:grid){
            dp[0]+=values[0];
            for(int j=1;j<cols;j++){
                if(flag){
                    dp[j]=dp[j-1]+values[j];
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+values[j];
                }
            }
            flag=false;
        }
        
        return dp[cols-1];
    }

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum1(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
