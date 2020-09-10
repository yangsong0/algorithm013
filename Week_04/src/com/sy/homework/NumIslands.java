package com.sy.homework;

/**
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int rows,cols,count=0;
        if(grid==null || (rows=grid.length)==0 || (cols=grid[0].length)==0){
            return 0;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j,rows,cols);

                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(grid,i+1,j,rows,cols);
            dfs(grid,i,j+1,rows,cols);
            dfs(grid,i-1,j,rows,cols);
            dfs(grid,i,j-1,rows,cols);
        }

    }
}
